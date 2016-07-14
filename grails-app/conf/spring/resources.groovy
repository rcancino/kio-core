// Place your Spring DSL code here
import org.springframework.web.servlet.i18n.FixedLocaleResolver

import com.luxsoft.cfdi.CfdiCadenaBuilder
import com.luxsoft.cfdi.CfdiSellador
import com.luxsoft.cfdi.CfdiTimbrador
import com.luxsoft.sec.LuxorSecurityEventListener
import com.luxsoft.sec.LuxorSecurityLogoutHandler

import grails.util.Environment

beans = {
	
	
	
	cfdiCadenaBuilder(CfdiCadenaBuilder){}

	cfdiSellador(CfdiSellador){
		cadenaBuilder=ref("cfdiCadenaBuilder")
	}

	switch(Environment.current){
		
		case Environment.PRODUCTION:
			cfdiTimbrador(CfdiTimbrador){
				timbradoDePrueba=false
			}
			break
		case Environment.DEVELOPMENT:
			cfdiTimbrador(CfdiTimbrador){
				timbradoDePrueba=true
			}
			break
		case Environment.TEST:
			cfdiTimbrador(CfdiTimbrador){
				timbradoDePrueba=true
			}
		
	}
	//cfdiTimbrador(CfdiTimbrador){}
	
	localeResolver(FixedLocaleResolver,Locale.US)

	luxorSecurityEventListener(LuxorSecurityEventListener){}
	luxorSecurityLogoutHandler(LuxorSecurityLogoutHandler){}
}
