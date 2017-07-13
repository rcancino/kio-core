databaseChangeLog = {

	changeSet(author: "rcancino (generated)", id: "1473087110335-1") {
		createTable(tableName: "abono") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "aplicado", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "cliente_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "comentario", type: "VARCHAR(300)")

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "disponible", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "fecha", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "importe", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "impuesto_tasa", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "impuestos", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "nombre", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "total", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-2") {
		createTable(tableName: "acces_back") {
			column(defaultValueNumeric: "0", name: "id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "activo", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "nombre", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "numero", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "replicado", type: "DATETIME")

			column(name: "tarjeta", type: "VARCHAR(255)")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-3") {
		createTable(tableName: "access_log") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "activo", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "info", type: "VARCHAR(255)")

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "lectora1", type: "DATETIME")

			column(name: "lectora2", type: "DATETIME")

			column(name: "lectora3", type: "DATETIME")

			column(name: "nombre", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "numero", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "tarjeta", type: "VARCHAR(255)")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-4") {
		createTable(tableName: "aplicacion") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "abono_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "comentario", type: "VARCHAR(255)")

			column(name: "documento", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "documento_fecha", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "documento_tipo", type: "VARCHAR(5)") {
				constraints(nullable: "false")
			}

			column(name: "fecha", type: "DATE") {
				constraints(nullable: "false")
			}

			column(name: "importe", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "pago_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "aplicaciones_idx", type: "INT")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-5") {
		createTable(tableName: "aplicacion_de_nota") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "comentario", type: "VARCHAR(255)")

			column(name: "fecha", type: "DATE") {
				constraints(nullable: "false")
			}

			column(name: "importe", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "nota_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "venta_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-6") {
		createTable(tableName: "aplicacion_de_pago") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "comentario", type: "VARCHAR(255)")

			column(name: "fecha", type: "DATE") {
				constraints(nullable: "false")
			}

			column(name: "importe", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "pago_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "venta_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-7") {
		createTable(tableName: "bitacora_de_clases") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-8") {
		createTable(tableName: "caja") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-9") {
		createTable(tableName: "cancelacion_de_cfdi") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "aka", type: "MEDIUMBLOB") {
				constraints(nullable: "false")
			}

			column(name: "cfdi_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "comentario", type: "VARCHAR(255)")

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-10") {
		createTable(tableName: "cfdi") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "cadena_original", type: "LONGTEXT")

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "emisor", type: "VARCHAR(600)") {
				constraints(nullable: "false")
			}

			column(name: "fecha", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "folio", type: "VARCHAR(20)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "origen", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "receptor", type: "VARCHAR(600)") {
				constraints(nullable: "false")
			}

			column(name: "receptor_rfc", type: "VARCHAR(13)") {
				constraints(nullable: "false")
			}

			column(name: "serie", type: "VARCHAR(15)") {
				constraints(nullable: "false")
			}

			column(name: "timbrado", type: "DATETIME")

			column(name: "tipo", type: "VARCHAR(12)") {
				constraints(nullable: "false")
			}

			column(name: "total", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "VARCHAR(300)")

			column(name: "xml", type: "MEDIUMBLOB") {
				constraints(nullable: "false")
			}

			column(name: "xml_name", type: "VARCHAR(200)")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-11") {
		createTable(tableName: "cfdi_folio") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "folio", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "serie", type: "VARCHAR(10)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-12") {
		createTable(tableName: "clase") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-13") {
		createTable(tableName: "cliente") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "direccion_calle", type: "VARCHAR(200)")

			column(name: "direccion_codigo_postal", type: "VARCHAR(255)")

			column(name: "direccion_colonia", type: "VARCHAR(255)")

			column(name: "direccion_estado", type: "VARCHAR(255)")

			column(name: "direccion_municipio", type: "VARCHAR(255)")

			column(name: "direccion_numero_exterior", type: "VARCHAR(50)")

			column(name: "direccion_numero_interior", type: "VARCHAR(50)")

			column(name: "direccion_pais", type: "VARCHAR(100)")

			column(name: "email_cfdi", type: "VARCHAR(255)")

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "nombre", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "origen", type: "BIGINT")

			column(name: "rfc", type: "VARCHAR(13)") {
				constraints(nullable: "false")
			}

			column(name: "tipo_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-14") {
		createTable(tableName: "cobro") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "cambio", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "cliente_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME")

			column(name: "fecha", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "forma_de_pago", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "importe", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME")

			column(name: "pago_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "recibe", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "referencia", type: "VARCHAR(50)")

			column(name: "venta_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-15") {
		createTable(tableName: "corte_de_caja") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "cajero", type: "VARCHAR(50)") {
				constraints(nullable: "false")
			}

			column(name: "creado_por", type: "VARCHAR(255)")

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "fecha_hora", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "total", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-16") {
		createTable(tableName: "corte_de_caja_det") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "acumulado", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "cobrado", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "corte_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "forma_de_pago", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "importe_corte", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-17") {
		createTable(tableName: "empresa") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "certificado_digital", type: "MEDIUMBLOB")

			column(name: "certificado_digital_pfx", type: "MEDIUMBLOB")

			column(name: "clave", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "direccion_calle", type: "VARCHAR(200)")

			column(name: "direccion_codigo_postal", type: "VARCHAR(255)")

			column(name: "direccion_colonia", type: "VARCHAR(255)")

			column(name: "direccion_estado", type: "VARCHAR(255)")

			column(name: "direccion_municipio", type: "VARCHAR(255)")

			column(name: "direccion_numero_exterior", type: "VARCHAR(50)")

			column(name: "direccion_numero_interior", type: "VARCHAR(50)")

			column(name: "direccion_pais", type: "VARCHAR(100)")

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "llave_privada", type: "MEDIUMBLOB")

			column(name: "nombre", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "numero_de_certificado", type: "VARCHAR(20)")

			column(name: "password_pac", type: "VARCHAR(255)")

			column(name: "password_pfx", type: "VARCHAR(255)")

			column(name: "regimen", type: "VARCHAR(300)") {
				constraints(nullable: "false")
			}

			column(name: "rfc", type: "VARCHAR(13)") {
				constraints(nullable: "false")
			}

			column(name: "timbrado_de_prueba", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "usuario_pac", type: "VARCHAR(255)")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-18") {
		createTable(tableName: "instructor") {
			column(name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "nivel", type: "VARCHAR(1)")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-19") {
		createTable(tableName: "luxor_session") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "ip", type: "VARCHAR(20)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "login", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "logout", type: "DATETIME")

			column(name: "session", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "timeout", type: "DATETIME")

			column(name: "tipo", type: "VARCHAR(20)") {
				constraints(nullable: "false")
			}

			column(name: "usuario", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-20") {
		createTable(tableName: "medio_de_contacto") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "clave", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "descripcion", type: "VARCHAR(255)")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-21") {
		createTable(tableName: "nota_de_credito") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "cfdi_id", type: "BIGINT")

			column(name: "cliente_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "comentario", type: "VARCHAR(300)")

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "fecha", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "impuesto", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "impuesto_tasa", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "sub_total", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "tipo", type: "VARCHAR(12)") {
				constraints(nullable: "false")
			}

			column(name: "total", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "usuario", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-22") {
		createTable(tableName: "nota_de_credito_det") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "cantidad", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "concepto", type: "VARCHAR(12)") {
				constraints(nullable: "false")
			}

			column(name: "descripcion", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "importe", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "nota_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "unidad", type: "VARCHAR(8)") {
				constraints(nullable: "false")
			}

			column(name: "valor_unitario", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "venta", type: "VARCHAR(20)")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-23") {
		createTable(tableName: "pago") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "aplicado", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "banco", type: "VARCHAR(30)")

			column(name: "cliente_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "comentario", type: "VARCHAR(300)")

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "fecha", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "forma_de_pago", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "importe", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "referencia_bancaria", type: "VARCHAR(20)")

			column(name: "usuario", type: "VARCHAR(255)")

			column(name: "anticipo", type: "BIT")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-24") {
		createTable(tableName: "pago_de_membresia") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-25") {
		createTable(tableName: "pago_de_membresia_log") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "activo", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "aplicacion_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "dia_de_corte", type: "INT") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "membresia_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "proximo_pago", type: "DATETIME")

			column(name: "servicio_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "ultimo_pago", type: "DATETIME")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-26") {
		createTable(tableName: "persona") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "apellido_materno", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "apellido_paterno", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "nombres", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-27") {
		createTable(tableName: "producto") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "clave", type: "VARCHAR(40)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "descripcion", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "descripcion2", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "descuento", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "duracion", type: "INT")

			column(name: "inventariable", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "periodicidad", type: "VARCHAR(10)")

			column(name: "precio_bruto", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "precio_neto", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "suspendido", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "tipo_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "unidad", type: "VARCHAR(15)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-28") {
		createTable(tableName: "profesor") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-29") {
		createTable(tableName: "role") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-30") {
		createTable(tableName: "socio") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "activo", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "apellido_materno", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "apellido_paterno", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "celular", type: "VARCHAR(30)")

			column(name: "cfdi_email", type: "VARCHAR(50)")

			column(name: "cliente_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "direccion_calle", type: "VARCHAR(200)")

			column(name: "direccion_codigo_postal", type: "VARCHAR(255)")

			column(name: "direccion_colonia", type: "VARCHAR(255)")

			column(name: "direccion_estado", type: "VARCHAR(255)")

			column(name: "direccion_municipio", type: "VARCHAR(255)")

			column(name: "direccion_numero_exterior", type: "VARCHAR(50)")

			column(name: "direccion_numero_interior", type: "VARCHAR(50)")

			column(name: "direccion_pais", type: "VARCHAR(100)")

			column(name: "email", type: "VARCHAR(50)")

			column(name: "email2", type: "VARCHAR(50)")

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "nombre", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "nombres", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "numero_de_socio", type: "VARCHAR(255)")

			column(name: "origen", type: "VARCHAR(255)")

			column(name: "sexo", type: "VARCHAR(9)") {
				constraints(nullable: "false")
			}

			column(name: "tarjeta", type: "VARCHAR(50)")

			column(name: "telefono_casa", type: "VARCHAR(30)")

			column(name: "telefono_trabajo", type: "VARCHAR(30)")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-31") {
		createTable(tableName: "socio_foto") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "imagen", type: "MEDIUMBLOB")

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "socio_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-32") {
		createTable(tableName: "socio_membresia") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "comentario", type: "VARCHAR(255)")

			column(name: "proximo_pago", type: "DATE")

			column(name: "servicio_id", type: "BIGINT")

			column(name: "socio_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "tolerancia_en_dias", type: "INT") {
				constraints(nullable: "false")
			}

			column(name: "ultimo_pago", type: "DATE")

			column(name: "inscripcion", type: "DATETIME")

			column(name: "dia_de_corte", type: "INT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-33") {
		createTable(tableName: "socio_perfil") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "area_de_interes", type: "VARCHAR(6)") {
				constraints(nullable: "false")
			}

			column(name: "estado_civil", type: "VARCHAR(11)") {
				constraints(nullable: "false")
			}

			column(name: "face_book", type: "VARCHAR(100)")

			column(name: "fecha_de_nacimiento", type: "DATE")

			column(name: "hijos", type: "INT") {
				constraints(nullable: "false")
			}

			column(name: "instructor_id", type: "BIGINT")

			column(name: "medio_de_contacto_id", type: "BIGINT")

			column(name: "peso", type: "DECIMAL(19,2)")

			column(name: "skype", type: "VARCHAR(100)")

			column(name: "socio_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "tipo_de_corporativo_id", type: "BIGINT")

			column(name: "tipo_de_socio_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "twitter", type: "VARCHAR(100)")

			column(name: "whats_app", type: "VARCHAR(100)")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-34") {
		createTable(tableName: "tipo_de_cliente") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "clave", type: "VARCHAR(20)") {
				constraints(nullable: "false")
			}

			column(name: "descripcion", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-35") {
		createTable(tableName: "tipo_de_corporativo") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "clave", type: "VARCHAR(20)") {
				constraints(nullable: "false")
			}

			column(name: "descripcion", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "activo", type: "BIT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-36") {
		createTable(tableName: "tipo_de_producto") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "clave", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "descripcion", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-37") {
		createTable(tableName: "tipo_de_socio") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "clave", type: "VARCHAR(20)") {
				constraints(nullable: "false")
			}

			column(name: "descripcion", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-38") {
		createTable(tableName: "tipo_de_venta") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "clave", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "descripcion", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-39") {
		createTable(tableName: "tipo_de_venta_formulas") {
			column(name: "tipo_de_venta_id", type: "BIGINT")

			column(name: "formulas_string", type: "VARCHAR(255)")

			column(name: "formulas_idx", type: "VARCHAR(255)")

			column(name: "formulas_elt", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-40") {
		createTable(tableName: "usuario") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "apellido_materno", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "apellido_paterno", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "VARCHAR(255)")

			column(name: "enabled", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "nombre", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "nombres", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "tarjeta", type: "VARCHAR(255)")

			column(name: "numero_de_empleado", type: "INT")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-41") {
		createTable(tableName: "usuario_role") {
			column(name: "role_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "usuario_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-42") {
		createTable(tableName: "venta") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "cancelada", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "cfdi_id", type: "BIGINT")

			column(name: "cliente_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "comentario", type: "VARCHAR(255)")

			column(name: "creado_por", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "descuento", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "fecha", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "forma_de_pago", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "importe", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "impuesto", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "impuesto_tasa", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "moneda", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "pagos", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "status", type: "VARCHAR(10)") {
				constraints(nullable: "false")
			}

			column(name: "sub_total", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "tipo_id", type: "BIGINT")

			column(name: "total", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "abonos", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "modificado_por", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-43") {
		createTable(tableName: "venta_det") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "cantidad", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "comentario", type: "VARCHAR(255)")

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(defaultValueNumeric: "0.0000", name: "descuento", type: "DECIMAL(19,4)") {
				constraints(nullable: "false")
			}

			column(defaultValueNumeric: "0.0000", name: "descuento_tasa", type: "DECIMAL(19,4)") {
				constraints(nullable: "false")
			}

			column(name: "importe_bruto", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "importe_neto", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "precio", type: "DECIMAL(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "producto_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "socio_id", type: "BIGINT")

			column(name: "venta_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "partidas_idx", type: "INT")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-44") {
		addPrimaryKey(columnNames: "role_id, usuario_id", tableName: "usuario_role")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-84") {
		createIndex(indexName: "UK_7nmch6c0klcv5tjdw37rm20mk", tableName: "cliente", unique: "true") {
			column(name: "nombre")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-85") {
		createIndex(indexName: "UK_2fqlxbcs4h827hio1qam0dhd3", tableName: "empresa", unique: "true") {
			column(name: "nombre")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-86") {
		createIndex(indexName: "UK_8etnkd6qpkkr0ce5ktwdualdf", tableName: "medio_de_contacto", unique: "true") {
			column(name: "clave")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-87") {
		createIndex(indexName: "UK_iac48enn17bc50wqa3p5ld46b", tableName: "producto", unique: "true") {
			column(name: "clave")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-88") {
		createIndex(indexName: "UK_irsamgnera6angm0prq1kemt2", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-89") {
		createIndex(indexName: "unique_apellido_paterno", tableName: "socio", unique: "true") {
			column(name: "nombres")

			column(name: "apellido_materno")

			column(name: "apellido_paterno")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-90") {
		createIndex(indexName: "UK_d5age78mow9ui0qy0duwi617q", tableName: "tipo_de_cliente", unique: "true") {
			column(name: "clave")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-91") {
		createIndex(indexName: "UK_81mfbcauel0udcjmlblbimc61", tableName: "tipo_de_corporativo", unique: "true") {
			column(name: "clave")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-92") {
		createIndex(indexName: "UK_gl6fc2rlu2vuji9s6wxan1fmf", tableName: "tipo_de_producto", unique: "true") {
			column(name: "clave")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-93") {
		createIndex(indexName: "UK_djjysmxb7mu4ht74g2qkxvn8j", tableName: "tipo_de_socio", unique: "true") {
			column(name: "clave")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-94") {
		createIndex(indexName: "UK_13rcwm1aoeq41iq4iotse84tb", tableName: "tipo_de_venta", unique: "true") {
			column(name: "clave")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-95") {
		createIndex(indexName: "UK_863n1y3x0jalatoir4325ehal", tableName: "usuario", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-45") {
		addForeignKeyConstraint(baseColumnNames: "cliente_id", baseTableName: "abono", baseTableSchemaName: "kyo", constraintName: "FK_btpnkuarhemarlbh7hby46oyq", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "cliente", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-46") {
		addForeignKeyConstraint(baseColumnNames: "abono_id", baseTableName: "aplicacion", baseTableSchemaName: "kyo", constraintName: "FK_dug3ghs50dfqfn9on4rgg97me", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "abono", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-47") {
		addForeignKeyConstraint(baseColumnNames: "pago_id", baseTableName: "aplicacion", baseTableSchemaName: "kyo", constraintName: "FK_jwrigroso3etphxdwa9tdlt2e", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "pago", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-48") {
		addForeignKeyConstraint(baseColumnNames: "nota_id", baseTableName: "aplicacion_de_nota", baseTableSchemaName: "kyo", constraintName: "FK_rrkov80yrw5k5rt5fndps2bt5", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "nota_de_credito", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-49") {
		addForeignKeyConstraint(baseColumnNames: "venta_id", baseTableName: "aplicacion_de_nota", baseTableSchemaName: "kyo", constraintName: "FK_fdol3hwr3499r94u7yptrkk5i", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "venta", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-50") {
		addForeignKeyConstraint(baseColumnNames: "pago_id", baseTableName: "aplicacion_de_pago", baseTableSchemaName: "kyo", constraintName: "FK_dln4nkbr14lb3wercwo35nfg9", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "pago", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-51") {
		addForeignKeyConstraint(baseColumnNames: "venta_id", baseTableName: "aplicacion_de_pago", baseTableSchemaName: "kyo", constraintName: "FK_ax4b6kih8lrjjpe3wpemipu3k", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "venta", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-52") {
		addForeignKeyConstraint(baseColumnNames: "cfdi_id", baseTableName: "cancelacion_de_cfdi", baseTableSchemaName: "kyo", constraintName: "FK_alib7rwpbtqfnrrkov7gg4rab", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "cfdi", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-53") {
		addForeignKeyConstraint(baseColumnNames: "tipo_id", baseTableName: "cliente", baseTableSchemaName: "kyo", constraintName: "FK_i6hc5o8tx230i71ucm3feqvq0", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "tipo_de_cliente", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-54") {
		addForeignKeyConstraint(baseColumnNames: "cliente_id", baseTableName: "cobro", baseTableSchemaName: "kyo", constraintName: "FK_htse5ou6xw96aok2100arwug6", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "cliente", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-55") {
		addForeignKeyConstraint(baseColumnNames: "pago_id", baseTableName: "cobro", baseTableSchemaName: "kyo", constraintName: "FK_k3o5lq7nre2b23dnytedaafvj", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "pago", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-56") {
		addForeignKeyConstraint(baseColumnNames: "venta_id", baseTableName: "cobro", baseTableSchemaName: "kyo", constraintName: "FK_t36ka8rgowh7fgcond84x3239", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "venta", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-57") {
		addForeignKeyConstraint(baseColumnNames: "corte_id", baseTableName: "corte_de_caja_det", baseTableSchemaName: "kyo", constraintName: "FK_27il880tbdmh2c46y1i6gqgyc", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "corte_de_caja", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-58") {
		addForeignKeyConstraint(baseColumnNames: "id", baseTableName: "instructor", baseTableSchemaName: "kyo", constraintName: "FK_e1x11nika7f1f7ojk3llj5oxg", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "persona", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-59") {
		addForeignKeyConstraint(baseColumnNames: "cfdi_id", baseTableName: "nota_de_credito", baseTableSchemaName: "kyo", constraintName: "FK_n5iiie9arepqr3d1ah4nqc1s9", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "cfdi", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-60") {
		addForeignKeyConstraint(baseColumnNames: "cliente_id", baseTableName: "nota_de_credito", baseTableSchemaName: "kyo", constraintName: "FK_df5mmgrns649o26y5iwvsfw2l", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "cliente", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-61") {
		addForeignKeyConstraint(baseColumnNames: "nota_id", baseTableName: "nota_de_credito_det", baseTableSchemaName: "kyo", constraintName: "FK_j337j9ysv6xr21sd3msa60yra", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "nota_de_credito", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-62") {
		addForeignKeyConstraint(baseColumnNames: "cliente_id", baseTableName: "pago", baseTableSchemaName: "kyo", constraintName: "FK_q8t4ei5njm1i7ky20b7fxvgs4", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "cliente", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-63") {
		addForeignKeyConstraint(baseColumnNames: "aplicacion_id", baseTableName: "pago_de_membresia_log", baseTableSchemaName: "kyo", constraintName: "FK_25eu2eq89y2q6yqtd09wu4e7t", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "aplicacion_de_pago", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-64") {
		addForeignKeyConstraint(baseColumnNames: "membresia_id", baseTableName: "pago_de_membresia_log", baseTableSchemaName: "kyo", constraintName: "FK_aeuwbo06u18546v84qwy9723c", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "socio_membresia", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-65") {
		addForeignKeyConstraint(baseColumnNames: "servicio_id", baseTableName: "pago_de_membresia_log", baseTableSchemaName: "kyo", constraintName: "FK_b4joywarewyfb601h24h00b89", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "producto", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-66") {
		addForeignKeyConstraint(baseColumnNames: "tipo_id", baseTableName: "producto", baseTableSchemaName: "kyo", constraintName: "FK_6rm5pf8c1wxjk65ierck93kmx", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "tipo_de_producto", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-67") {
		addForeignKeyConstraint(baseColumnNames: "cliente_id", baseTableName: "socio", baseTableSchemaName: "kyo", constraintName: "FK_pbi8a5wox1bcmu9b3pw1unway", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "cliente", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-68") {
		addForeignKeyConstraint(baseColumnNames: "socio_id", baseTableName: "socio_foto", baseTableSchemaName: "kyo", constraintName: "FK_kcufc73bmjwytjhmk5djljrnx", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "socio", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-69") {
		addForeignKeyConstraint(baseColumnNames: "servicio_id", baseTableName: "socio_membresia", baseTableSchemaName: "kyo", constraintName: "FK_f7hoksq5974ok716bv4hbtqh7", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "producto", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-70") {
		addForeignKeyConstraint(baseColumnNames: "socio_id", baseTableName: "socio_membresia", baseTableSchemaName: "kyo", constraintName: "FK_2ogdvs30y0u91xeklxgn54gvy", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "socio", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-71") {
		addForeignKeyConstraint(baseColumnNames: "instructor_id", baseTableName: "socio_perfil", baseTableSchemaName: "kyo", constraintName: "FK_7n0bsn89vqs8x6ixfp770y89w", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "instructor", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-72") {
		addForeignKeyConstraint(baseColumnNames: "medio_de_contacto_id", baseTableName: "socio_perfil", baseTableSchemaName: "kyo", constraintName: "FK_t97n6o7w233wyw01eo1hjyhe5", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "medio_de_contacto", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-73") {
		addForeignKeyConstraint(baseColumnNames: "socio_id", baseTableName: "socio_perfil", baseTableSchemaName: "kyo", constraintName: "FK_7v1o0w9on2xj3mbolcombwbyf", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "socio", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-74") {
		addForeignKeyConstraint(baseColumnNames: "tipo_de_corporativo_id", baseTableName: "socio_perfil", baseTableSchemaName: "kyo", constraintName: "FK_55gwddrvniy43rwm1igmhwqbw", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "tipo_de_corporativo", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-75") {
		addForeignKeyConstraint(baseColumnNames: "tipo_de_socio_id", baseTableName: "socio_perfil", baseTableSchemaName: "kyo", constraintName: "FK_s75jcojwwag3ence1j6rsudkp", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "tipo_de_socio", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-76") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "usuario_role", baseTableSchemaName: "kyo", constraintName: "FK_qpqh5on1cqa0ktsitg2vhmirv", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "role", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-77") {
		addForeignKeyConstraint(baseColumnNames: "usuario_id", baseTableName: "usuario_role", baseTableSchemaName: "kyo", constraintName: "FK_55sbft3wldu0yr078kdq6hwxe", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "usuario", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-78") {
		addForeignKeyConstraint(baseColumnNames: "cfdi_id", baseTableName: "venta", baseTableSchemaName: "kyo", constraintName: "FK_djj7v2yd0m3eqhkupws77328r", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "cfdi", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-79") {
		addForeignKeyConstraint(baseColumnNames: "cliente_id", baseTableName: "venta", baseTableSchemaName: "kyo", constraintName: "FK_ga1c0oyebvdlmcw6s46875ura", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "cliente", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-80") {
		addForeignKeyConstraint(baseColumnNames: "tipo_id", baseTableName: "venta", baseTableSchemaName: "kyo", constraintName: "FK_9rqw4a9p80koa71srdki29vu0", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "tipo_de_venta", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-81") {
		addForeignKeyConstraint(baseColumnNames: "producto_id", baseTableName: "venta_det", baseTableSchemaName: "kyo", constraintName: "FK_ky077dqo04bpiu84fjub7h6yo", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "producto", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-82") {
		addForeignKeyConstraint(baseColumnNames: "socio_id", baseTableName: "venta_det", baseTableSchemaName: "kyo", constraintName: "FK_k6768xjwgowbpf1orj46hyhgv", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "socio", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	changeSet(author: "rcancino (generated)", id: "1473087110335-83") {
		addForeignKeyConstraint(baseColumnNames: "venta_id", baseTableName: "venta_det", baseTableSchemaName: "kyo", constraintName: "FK_ct6vsk3aaug4ooeschvi2tymv", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "venta", referencedTableSchemaName: "kyo", referencesUniqueColumn: "false")
	}

	include file: 'tasa-iva-productos.groovy'
}
