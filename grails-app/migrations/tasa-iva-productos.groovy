databaseChangeLog = {

	changeSet(author: "rcancino (generated)", id: "1473087866644-1") {
		createIndex(indexName: "cfdi_id_uniq_1473087866284", tableName: "cancelacion_de_cfdi", unique: "true") {
			column(name: "cfdi_id")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087866644-2") {
		createIndex(indexName: "socio_id_uniq_1473087866319", tableName: "socio_foto", unique: "true") {
			column(name: "socio_id")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087866644-3") {
		createIndex(indexName: "socio_id_uniq_1473087866320", tableName: "socio_membresia", unique: "true") {
			column(name: "socio_id")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087866644-4") {
		createIndex(indexName: "socio_id_uniq_1473087866321", tableName: "socio_perfil", unique: "true") {
			column(name: "socio_id")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087866644-5") {
		createIndex(indexName: "FK_qpqh5on1cqa0ktsitg2vhmirv", tableName: "usuario_role") {
			column(name: "role_id")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087866644-6") {
		dropTable(tableName: "acces_back")
	}
}
