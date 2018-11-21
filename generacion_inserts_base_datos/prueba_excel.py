import pandas as pd
import pickle



def parser_datos(archivo,columna,tabla,atributos):
	excel_prueba = pd.read_excel(archivo+".xlsx")
	diccionario = {}
	largo_archivo = len(excel_prueba.index)

	file_guardar= open(archivo+".txt","w+")

	for i in range(largo_archivo):
		provincia_texto = excel_prueba.loc[[i]][columna][i]
		diccionario[provincia_texto] = i

		file_guardar.write("INSERT INTO  %s(%s) VALUES(%d,\"%s\");\n" % (tabla,atributos,i,provincia_texto))

	f = open(archivo+".pkl","wb")
	pickle.dump(diccionario,f)
	f.close()
	file_guardar.close() 
	#print(diccionario_distritos)

def abrir_diccionario(archivo):
	file = open(archivo+".pkl", 'rb')
	diccionario_distritos = pickle.load(file)
	#print(diccionario_distritos)
	return diccionario_distritos

def parser_datos_totales(archivo):
	diccionario_distrito = abrir_diccionario("distritos")
	diccionario_provincia = abrir_diccionario("provincias")
	diccionario_canton = abrir_diccionario("cantones")
	diccionario_anho = abrir_diccionario("anhos")
	diccionario_mes = abrir_diccionario("meses")
	diccionario_dia = abrir_diccionario("dias")
	diccionario_rol = abrir_diccionario("roles")
	diccionario_sexo = abrir_diccionario("sexos")
	diccionario_lesion = abrir_diccionario("lesiones")

	excel_leer = pd.read_excel(archivo+".xlsx")
	largo_archivo = len(excel_leer.index)

	fecha_incidente_guardar= open("fecha_incidente.txt","w+")
	localizacion_guardar= open("localizacion.txt","w+")
	incidente_guardar= open("incidente.txt","w+")
	afectado_guardar= open("afectado.txt","w+")

	for i in range(largo_archivo):
		dia_excel = excel_leer.loc[[i]]["Día"][i]
		mes_excel = excel_leer.loc[[i]]["Mes"][i]
		anho_excel = excel_leer.loc[[i]]["Año"][i]

		dia_numero_tabla = diccionario_dia[dia_excel]
		mes_numero_tabla = diccionario_mes[mes_excel]
		anho_numero_tabla = diccionario_anho[anho_excel]

		insercion_fecha_incidente = "INSERT INTO FechaIncidente(codigoFechaIncidente,codigoAnho,codigoMes,codigoDia) VALUES(%d,%d,%d,%d);\n"%(i,anho_numero_tabla,mes_numero_tabla,dia_numero_tabla)

		fecha_incidente_guardar.write(insercion_fecha_incidente)

		provincia_excel = excel_leer.loc[[i]]["Provincia"][i]
		canton_excel = excel_leer.loc[[i]]["Cantón"][i]
		distrito_excel = excel_leer.loc[[i]]["Distrito"][i]

		provincia_numero_tabla = diccionario_provincia[provincia_excel]
		canton_numero_tabla = diccionario_canton[canton_excel]
		distrito_numero_tabla = diccionario_distrito[distrito_excel]

		insercion_localizacion = "INSERT INTO Localizacion(codigoLocalizacion,codigoProvincia,codigoCanton,codigoDistrito) VALUES(%d,%d,%d,%d);\n"%(i,provincia_numero_tabla,canton_numero_tabla,distrito_numero_tabla)

		localizacion_guardar.write(insercion_localizacion)

		rol_excel = excel_leer.loc[[i]]["Rol"][i]
		sexo_excel = excel_leer.loc[[i]]["Sexo"][i]
		lesion_excel = excel_leer.loc[[i]]["Tipo de Lesión"][i]
		edad_excel = excel_leer.loc[[i]]["Edad"][i]
		edad_quinquenal_excel = excel_leer.loc[[i]]["Edadquinquenal"][i]

		rol_numero_tabla = diccionario_rol[rol_excel]
		sexo_numero_tabla = diccionario_sexo[sexo_excel]
		lesion_numero_tabla = diccionario_lesion[lesion_excel]

		insercion_afectado = "INSERT INTO Afectado(codigoAfectado,codigoRol,codigoSexo,codigoLesion,edad,edadQuinquenal) VALUES(%d,%d,%d,%d,\"%s\",\"%s\");\n"%(i,rol_numero_tabla,sexo_numero_tabla,lesion_numero_tabla,edad_excel,edad_quinquenal_excel)

		afectado_guardar.write(insercion_afectado)

		insercion_incidente = "INSERT INTO Incidente(codigoRegistro,codigoLocalizacion,codigoFecha,codigoAfectado) VALUES(%d,%d,%d,%d);\n"%((i+1),i,i,i)

		incidente_guardar.write(insercion_incidente)

	fecha_incidente_guardar.close()
	localizacion_guardar.close()
	incidente_guardar.close()
	afectado_guardar.close()

def parser_datos_totales_forma2(archivo):
	diccionario_distrito = abrir_diccionario("distritos")
	diccionario_provincia = abrir_diccionario("provincias")
	diccionario_canton = abrir_diccionario("cantones")
	diccionario_anho = abrir_diccionario("anhos")
	diccionario_mes = abrir_diccionario("meses")
	diccionario_dia = abrir_diccionario("dias")
	diccionario_rol = abrir_diccionario("roles")
	diccionario_sexo = abrir_diccionario("sexos")
	diccionario_lesion = abrir_diccionario("lesiones")

	excel_leer = pd.read_excel(archivo+".xlsx")
	largo_archivo = len(excel_leer.index)

	fecha_incidente_guardar= open("fecha_incidente.txt","w+")
	localizacion_guardar= open("localizacion.txt","w+")
	incidente_guardar= open("incidente.txt","w+")
	afectado_guardar= open("afectado.txt","w+")

	primer_linea_fecha_incidente = "INSERT INTO FechaIncidente(codigoFechaIncidente,codigoAnho,codigoMes,codigoDia) VALUES"
	fecha_incidente_guardar.write(primer_linea_fecha_incidente)

	primer_linea_localizacion = "INSERT INTO Localizacion(codigoLocalizacion,codigoProvincia,codigoCanton,codigoDistrito) VALUES"
	localizacion_guardar.write(primer_linea_localizacion)

	primer_linea_afectado = "INSERT INTO Afectado(codigoAfectado,codigoRol,codigoSexo,codigoLesion,edad,edadQuinquenal) VALUES"
	afectado_guardar.write(primer_linea_afectado)

	primer_linea_incidente = "INSERT INTO Incidente(codigoRegistro,codigoLocalizacion,codigoFechaIncidente,codigoAfectado) VALUES"
	incidente_guardar.write(primer_linea_incidente)
	for i in range(largo_archivo):
		dia_excel = excel_leer.loc[[i]]["Día"][i]
		mes_excel = excel_leer.loc[[i]]["Mes"][i]
		anho_excel = excel_leer.loc[[i]]["Año"][i]

		dia_numero_tabla = diccionario_dia[dia_excel]
		mes_numero_tabla = diccionario_mes[mes_excel]
		anho_numero_tabla = diccionario_anho[anho_excel]

		if (i+1 == largo_archivo):
			insercion_fecha_incidente = "(%d,%d,%d,%d);\n"%(i,anho_numero_tabla,mes_numero_tabla,dia_numero_tabla)
		else:
			insercion_fecha_incidente = "(%d,%d,%d,%d),\n"%(i,anho_numero_tabla,mes_numero_tabla,dia_numero_tabla)

		fecha_incidente_guardar.write(insercion_fecha_incidente)

		provincia_excel = excel_leer.loc[[i]]["Provincia"][i]
		canton_excel = excel_leer.loc[[i]]["Cantón"][i]
		distrito_excel = excel_leer.loc[[i]]["Distrito"][i]

		provincia_numero_tabla = diccionario_provincia[provincia_excel]
		canton_numero_tabla = diccionario_canton[canton_excel]
		distrito_numero_tabla = diccionario_distrito[distrito_excel]

		if (i+1 == largo_archivo):
			insercion_localizacion = "(%d,%d,%d,%d);\n"%(i,provincia_numero_tabla,canton_numero_tabla,distrito_numero_tabla)
		else:
			insercion_localizacion = "(%d,%d,%d,%d),\n"%(i,provincia_numero_tabla,canton_numero_tabla,distrito_numero_tabla)

		localizacion_guardar.write(insercion_localizacion)

		rol_excel = excel_leer.loc[[i]]["Rol"][i]
		sexo_excel = excel_leer.loc[[i]]["Sexo"][i]
		lesion_excel = excel_leer.loc[[i]]["Tipo de Lesión"][i]
		edad_excel = excel_leer.loc[[i]]["Edad"][i]
		edad_quinquenal_excel = excel_leer.loc[[i]]["Edadquinquenal"][i]

		rol_numero_tabla = diccionario_rol[rol_excel]
		sexo_numero_tabla = diccionario_sexo[sexo_excel]
		lesion_numero_tabla = diccionario_lesion[lesion_excel]

		if (i+1 == largo_archivo):
			insercion_afectado = "(%d,%d,%d,%d,\"%s\",\"%s\");\n"%(i,rol_numero_tabla,sexo_numero_tabla,lesion_numero_tabla,edad_excel,edad_quinquenal_excel)
		else:
			insercion_afectado = "(%d,%d,%d,%d,\"%s\",\"%s\"),\n"%(i,rol_numero_tabla,sexo_numero_tabla,lesion_numero_tabla,edad_excel,edad_quinquenal_excel)

		afectado_guardar.write(insercion_afectado)	

		if (i+1 == largo_archivo):
			insercion_incidente = "(%d,%d,%d,%d);\n"%((i+1),i,i,i)
		else:
			insercion_incidente = "(%d,%d,%d,%d),\n"%((i+1),i,i,i)

		incidente_guardar.write(insercion_incidente)

	fecha_incidente_guardar.close()
	localizacion_guardar.close()
	incidente_guardar.close()
	afectado_guardar.close()



#INSERT INTO Dia(codigoDia,nombreDia) VALUES(3,"PRUEBA")

#print(excel_prueba[0])
#abrir_diccionario("diccionario_distritos")

#parser_datos("distritos","Distritos","Distrito","codigoDistrito,nombreDistrito")
#parser_datos("cantones","Canton","Canton","codigoCanton,nombreCanton")
#parser_datos("dias","Dia","Dia","codigoDia,nombreDia")
#parser_datos("meses","Mes","Mes","codigoMes,nombreMes")
#parser_datos("anhos","Anho","Anho","codigoAnho,nombreAnho")
#parser_datos("roles","Rol","Rol","codigoRol,nombreRol")
#parser_datos("lesiones","Lesion","Lesion","codigoLesion,nombreLesion")
#parser_datos("sexos","Sexo","Sexo","codigoSexo,nombreSexo")
#parser_datos("provincias","Provincia","Provincia","codigoProvincia,nombreProvincia")

#parser_datos_totales("acc1")
parser_datos_totales_forma2("acc1")
#print("Column headings:")
#print(excel_prueba.columns)