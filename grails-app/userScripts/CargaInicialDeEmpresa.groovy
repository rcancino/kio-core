import java.util.Date;

import com.luxsoft.cfdi.Empresa
import com.luxsoft.kio.Direccion

def empresa=Empresa.first()

if(empresa==null){
	  empresa=new Empresa(nombre:'OPERADORA Y ADMINISTRADOR GASOC S.A. DE C.V.',
			rfc:'OAG100209GN8',
			regimen:'REGIMEN GENERAL DE LEY PERSONAS MORALE',
			registroPatronal:'0')
		empresa.direccion=new Direccion(
			calle:'AVENIDA CUAUHTEMOC',
			numeroExterior:'1461',
			colonia:'SANTA CRUZ ATOYAC',
			municipio:'BENITO JUAREZ',
			codigoPostal:'03310',
			estado:'DISTRITO FEDERAL',
			pais:'MEXICO',
			usuarioPac:'PAP830101CR3',
			passwordPac:'yqjvqfofb'
		)
  
		  empresa.numeroDeCertificado='00001000000201478375'
	empresa.certificadoDigital=grailsApplication.mainContext
		  .getResource("/WEB-INF/sat/00001000000201478375.cer").file.readBytes()
	  empresa.llavePrivada=grailsApplication.mainContext
		  .getResource("/WEB-INF/sat/gasoc.key").file.readBytes()
		empresa.save(failOnError:true)
  
  
  println 'Alta de Empresa:'+empresa
  
}else{
  empresa.delete flush:true
}





