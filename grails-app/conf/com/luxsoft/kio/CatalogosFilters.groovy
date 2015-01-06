package com.luxsoft.kio

class CatalogosFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                if(!session.periodo){
                    session.periodo=Periodo.getCurrentMonthToday()
                }
                if(!session.searchPeriodo){
                    session.searchPeriodo=Periodo.getCurrentMonthToday()
                }
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
		
    }
}
