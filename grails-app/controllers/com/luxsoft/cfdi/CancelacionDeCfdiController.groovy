package com.luxsoft.cfdi

import org.springframework.security.access.annotation.Secured

@Secured(["hasAnyRole('ADMINISTRACION','CAJERO','MOSTRADOR')"])
class CancelacionDeCfdiController {

    def index() { }
}
