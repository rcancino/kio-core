package com.luxsoft.sec

import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.logout.LogoutHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class LuxorSecurityLogoutHandler implements LogoutHandler {

   void logout(HttpServletRequest request,HttpServletResponse response,Authentication authentication){
            //println 'Principal: '+authentication.principal.username
            if(authentication){
               def details=authentication.details

               //println 'IP: '+details.getRemoteAddress()
               //println 'SessionId: '+details.getSessionId()
               
               def session=LuxorSession.findBySession(details.getSessionId())
               if(session){
                     session.logout=new Date()
                     session.delete flush:true
                     
               }else{
                     println 'No session  found'
               }
            }
            
            
   }
}