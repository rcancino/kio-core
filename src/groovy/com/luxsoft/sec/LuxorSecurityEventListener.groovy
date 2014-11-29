package com.luxsoft.sec

import org.springframework.context.ApplicationListener
import org.springframework.security.authentication.event.AuthenticationSuccessEvent
import org.springframework.security.core.session.SessionDestroyedEvent

class LuxorSecurityEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

   void onApplicationEvent(AuthenticationSuccessEvent event) {
      //println 'Authentication success: '+event.source.class
      try {
      	//println 'Principal: '+event.getAuthentication().principal.username
      	def details=event.getAuthentication().details
      	//println 'Details: '+details
      	// println 'IP: '+details.getRemoteAddress()
      	// println 'SessionId: '+details.getSessionId()
      	// println 'Time: '+new Date(event.getTimestamp())
      	def session=new LuxorSession(
      		usuario:event.getAuthentication().principal.username
      		,login:new Date(event.getTimestamp())
      		,tipo:'LOGIN'
      		,ip:details.getRemoteAddress()
      		,session:details.getSessionId()
      		)
      	session.save failOnError:true
      	log.info 'Session: '+session
      }
      catch(Exception e) {
      	println 'Error: '+e.message
      }
      
   }

   public void onApplicationEvent(SessionDestroyedEvent event){
      println 'Detectando session timeout.... desde session destroied...'
   }
}