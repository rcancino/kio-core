package com.luxsoft.kio

class CatalogosFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                if(!session.periodo){
                    session.periodo=Periodo.getCurrentMonthToday()
                }
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
		
    }
}
