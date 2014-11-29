package com.luxsoft.kio
import org.springframework.security.access.annotation.Secured

@Secured(["hasAnyRole('ADMINISTRACION')"])
class TipoDeCorporativoController {

	static allowedMethods = [save: "POST", update: "PUT", delete: "GET"]

    static scaffold = true
}
