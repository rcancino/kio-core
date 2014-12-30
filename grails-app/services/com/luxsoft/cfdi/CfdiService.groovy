package com.luxsoft.cfdi

import com.luxsoft.kio.Venta
import grails.transaction.Transactional

import mx.gob.sat.cfd.x3.ComprobanteDocument
import mx.gob.sat.cfd.x3.ComprobanteDocument.Comprobante;
import mx.gob.sat.cfd.x3.ComprobanteDocument.Comprobante.Conceptos;
import mx.gob.sat.cfd.x3.ComprobanteDocument.Comprobante.Conceptos.Concepto;
import mx.gob.sat.cfd.x3.ComprobanteDocument.Comprobante.Conceptos.Concepto.CuentaPredial;
import mx.gob.sat.cfd.x3.ComprobanteDocument.Comprobante.Emisor;
import mx.gob.sat.cfd.x3.ComprobanteDocument.Comprobante.Impuestos;
import mx.gob.sat.cfd.x3.ComprobanteDocument.Comprobante.Impuestos.Traslados;
import mx.gob.sat.cfd.x3.ComprobanteDocument.Comprobante.Impuestos.Traslados.Traslado;
import mx.gob.sat.cfd.x3.ComprobanteDocument.Comprobante.Receptor;
import mx.gob.sat.cfd.x3.ComprobanteDocument.Comprobante.TipoDeComprobante;


import org.apache.xmlbeans.XmlObject
import org.apache.xmlbeans.XmlOptions
import org.apache.xmlbeans.XmlValidationError

import org.apache.commons.lang.StringUtils
import org.bouncycastle.util.encoders.Base64
import com.luxsoft.kio.MonedaUtils

import com.edicom.ediwinws.cfdi.client.CfdiClient
import org.bouncycastle.util.encoders.Base64
import com.edicom.ediwinws.service.cfdi.CancelaResponse

@Transactional
class CfdiService {
	
	def grailsApplication
	
	def cfdiSellador
	def cfdiTimbrador
	
	def empresa

	//def static VALID_STATUS=['VENTA','PAGADA']

    def Cfdi generar(Venta venta) {

		assert (venta.status=='VENTA' || venta.status=='PAGADA'),"La venta debe tener status VENTA o PAGADA status actual: $venta.status"
		
		if(empresa==null){
			empresa=Empresa.first();
			assert empresa,"La empresa debe estar definida"
		}
		def serie=grailsApplication.config.luxsoft.cfdi.serie.venta
		assert serie,"Debe registrar la serie para cfdi de ventas 'luxsoft.cfdi.serie.venta'"
		def cfdiFolio=CfdiFolio.findBySerie(serie)
		assert cfdiFolio,"Debe exister folios para la serie: "+serie
		              
		def folio=cfdiFolio.next()
		
		log.info "Generando CFDI folio:$folio  Serie:$serie y rfc:$empresa.rfc  Para venta $venta.id"
		
		ComprobanteDocument document=ComprobanteDocument.Factory.newInstance()
		Comprobante comprobante=document.addNewComprobante()
		comprobante.serie=serie
		comprobante.folio=folio
		CfdiUtils.depurar(document)
		def fecha=new Date()
		
		comprobante.setVersion("3.2")
		comprobante.setFecha(CfdiUtils.toXmlDate(fecha).getCalendarValue())
		comprobante.setFormaDePago("PAGO EN UNA SOLA EXHIBICION")
		comprobante.setMetodoDePago('NO APLICA')
		comprobante.setMoneda(venta.moneda.getCurrencyCode())
		comprobante.setTipoCambio("1.0")
		
		comprobante.setTipoDeComprobante(TipoDeComprobante.INGRESO)
		comprobante.setLugarExpedicion(empresa.direccion.municipio)
		comprobante.setNoCertificado(empresa.numeroDeCertificado)
		
		Emisor emisor=CfdiUtils.registrarEmisor(comprobante, empresa)
		Receptor receptor=CfdiUtils.registrarReceptor(comprobante, venta.cliente)
		
		comprobante.setSubTotal(venta.subTotal)
		comprobante.setDescuento(venta.descuentoSinIva)
		comprobante.setTotal(venta.total)
		
		Impuestos impuestos=comprobante.addNewImpuestos()
		String rfc=comprobante.getReceptor().getRfc()
		
		//Facturacion a clientes extranjero
		if(rfc=="XEXX010101000"){
			comprobante.setSubTotal(venta.total)
			comprobante.setTotal(venta.total)
		}else if(rfc=="XAXX010101000"){
			comprobante.setSubTotal(venta.total)
			//comprobante.setDescuento(venta.descuento)
			comprobante.setTotal(venta.total)
		}else{
			impuestos.setTotalImpuestosTrasladados(venta.impuesto)
			Traslados traslados=impuestos.addNewTraslados()
			Traslado traslado=traslados.addNewTraslado()
			traslado.setImpuesto(Traslado.Impuesto.IVA)
			traslado.setImporte(venta.impuesto)
			traslado.setTasa(venta.impuestoTasa)
		}
		
		Conceptos conceptos=comprobante.addNewConceptos()
		
		venta.partidas.each {det->
			
			Concepto c=conceptos.addNewConcepto()
			c.setCantidad(det.cantidad)
			//c.setUnidad(det.producto.unidad)
			c.setUnidad('NO APLICA')
			c.setNoIdentificacion(det.producto.clave)
			String desc = det.producto.descripcion
			if(det.socio){
				//desc = (new StringBuilder(String.valueOf(desc))).append(StringUtils.stripToEmpty(det.comentario)).toString()
				desc+=" Socio:$det.socio.numeroDeSocio"
			}
			desc = StringUtils.abbreviate(desc, 250)
			c.setDescripcion(desc)
			if(rfc=="XEXX010101000" || rfc=="XAXX010101000"){
				c.setValorUnitario(det.precio)
				c.setImporte(det.importeNeto)
			} else{
				c.setValorUnitario(MonedaUtils.calcularImporteDelTotal(det.precio))
				//c.setImporte(det.importeNetoSinIva)
				c.setImporte(det.importeBrutoSinIva)
			}
			
			
		}
		
		byte[] encodedCert=Base64.encode(empresa.getCertificado().getEncoded())
		comprobante.setCertificado(new String(encodedCert))
		comprobante.setSello(cfdiSellador.sellar(empresa.privateKey,document))
		
		XmlOptions options = new XmlOptions()
		options.setCharacterEncoding("UTF-8")
		options.put( XmlOptions.SAVE_INNER )
		options.put( XmlOptions.SAVE_PRETTY_PRINT )
		options.put( XmlOptions.SAVE_AGGRESSIVE_NAMESPACES )
		options.put( XmlOptions.SAVE_USE_DEFAULT_NAMESPACE )
		options.put(XmlOptions.SAVE_NAMESPACES_FIRST)
		ByteArrayOutputStream os=new ByteArrayOutputStream()
		document.save(os, options)
		
		
		validarDocumento(document)
		log.debug 'ComprobanteDocument generado y validado: '+document
		
		def cfdi=new Cfdi(comprobante)
		cfdi.tipo="FACTURA"
		cfdi.origen=venta.id.toString()
		cfdi.xml=os.toByteArray()
		cfdi.setXmlName("$cfdi.receptorRfc-$cfdi.serie-$cfdi.folio"+".xml")
		//cfdi.cadenaOriginal
		
		log.debug 'ComprobanteDocument generado y validado: '+document
		cfdi.save(failOnError:true)
		cfdi=cfdiTimbrador.timbrar(cfdi,empresa)
		venta.status='FACTURADA'
		venta.cfdi=cfdi
		log.debug 'Documento timbrado: '+cfdi
		return cfdi
		
    }
	
	void validarDocumento(ComprobanteDocument document) {
		List<XmlValidationError> errores=findErrors(document);
		if(errores.size()>0){
			StringBuffer buff=new StringBuffer();
			for(XmlValidationError e:errores){
				buff.append(e.getMessage()+"\n");
			}
			throw new CfdiException(message:"Datos para generar el comprobante fiscal (CFDI) incorrectos "+buff.toString());
		}
	}
	
	List findErrors(final XmlObject node){
		final XmlOptions options=new XmlOptions();
		final List errors=new ArrayList();
		options.setErrorListener(errors);
		node.validate(options);
		return errors;
		
	}

	@Transactional
	def CancelacionDeCfdi cancelar(Cfdi cfdi,String comentario){
		
		

		CancelacionDeCfdi cancel=new CancelacionDeCfdi()
		cancel.cfdi=cfdi
		

		def empresa=Empresa.first()
		//byte[] pfxData=empresa.certificadoDigitalPfx
		byte[] pfxData=grailsApplication.mainContext.getResource("/WEB-INF/sat/gasoc.pfx").file.readBytes()
		String[] uuids=[cfdi.uuid]
		def client=new CfdiClient()
		CancelaResponse res=client.cancelCfdi(
				empresa.usuarioPac
				, empresa.passwordPac
				, empresa.getRfc()
				, uuids
				, pfxData
				, "pfxfilegasoc");
		String msg=res.getText()
		println 'Message: '+ msg
		//cancel.message=Base64.decode(msg)
		String aka=res.getAck()
		println 'Aka:'+aka

		cancel.aka=Base64.decode(aka.getBytes())
		cancel.save failOnError:true

		def venta=Venta.findByCfdi(cfdi)
		venta?.cfdi=null
		venta?.save()
		return cancel

	}
	/*
	public void cancelar(String[] uuidList,Periodo periodo) throws Exception{
		String dirPath="Z:\\CFDI\\cancelaciones";
		File dir=new File(dirPath);
		Assert.isTrue(dir.exists(),"No existe el directorio para cancelaciones: "+dirPath);
		Assert.isTrue(dir.isDirectory(),"La ruta para las cancelaciones no es un directorio "+dirPath);
		
		Resource pfx=ServiceLocator2.instance().getContext().getResource("sat/PAPEL_CFDI_CERT.pfx");
		//Resource pfx=ServiceLocator2.instance().getContext().getResource("sat/papelsacfdikey.pfx");
		Assert.isTrue(pfx.exists(),"No existe el archivo pfx");
		
		byte[] pfxData=new byte[(int)pfx.getFile().length()];
		pfx.getInputStream().read(pfxData);
		client=new CfdiClient();
		
		CancelaResponse res=client.cancelCfdi(
				"PAP830101CR3"
				,"yqjvqfofb"
				, empresa.getRfc()
				, uuidList
				, pfxData
				, pfxPassword);
		String msg=res.getText();
		String aka=res.getAck();
			
		//String msg=new String(Base64.encode("Prueba de cancelacion".getBytes()));
		//String aka=new String(Base64.encode("Prueba de cancelacion".getBytes()));
		try {
			
			String xmlFile=empresa.getClave()+"_CANCELACIONES_"+periodo.toString2();
			//String xmlFile="QUERETARO"+"_CANCELACIONES_"+periodo.toString2();
			File msgFile=new File(dir,xmlFile+"_MSG.xml");
			
			FileOutputStream out1=new FileOutputStream(msgFile);
			out1.write(Base64.decode(msg));
			out1.close();
			
			
			File akaFile=new File(dir,xmlFile+"_AKA.xml");
			FileOutputStream out2=new FileOutputStream(akaFile);
			out2.write(Base64.decode(aka.getBytes()));
			out2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error salvando archivos de cancelacion: "+ExceptionUtils.getRootCauseMessage(e));
		}
	}
	*/
	
	
	
}
