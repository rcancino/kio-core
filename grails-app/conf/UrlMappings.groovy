class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        //"/"(view:"/index")
         "/"(controller:"home")
		 "/info"(view:"/index")
        "500"(view:'/error')
	}
}
