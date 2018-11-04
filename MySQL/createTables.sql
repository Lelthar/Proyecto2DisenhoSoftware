
create table Provincia (

	codigoProvincia int PRIMARY KEY,
	nombreProvincia varchar(30)

	)

create table Canton (

	codigoCanton int PRIMARY KEY,
	nombreCanton varchar(100)

)


create table Anho(

	codigoAnho int PRIMARY KEY,
	nombreAnho varchar(20)
)

create table Mes (

	codigoMes int PRIMARY KEY,
	nombreMes varchar(20)

)

create table Distrito (

	codigoDistrito int PRIMARY KEY,
	nombreDistrito varchar(100)
)

create table Localizacion (

	codigoLocalizacion int PRIMARY KEY,
	codigoProvincia int, 
	codigoCanton int, 
	codigoDistrito int, 
	FOREIGN KEY (codigoProvincia) references Provincia(codigoProvincia),
	FOREIGN KEY (codigoCanton) references Canton(codigoCanton),
	FOREIGN KEY (codigoDistrito) references Distrito(codigoDistrito)


)

create table Dia (

	codigoDia int PRIMARY KEY,
	nombreDia varchar(20)

)

create table FechaIncidente (

	codigoFechaIncidente int AUTO INCREMENT PRIMARY KEY, 
	codigoAnho int, 
	codigoMes int, 
	codigoDia int,
	FOREIGN KEY codigoAnho references Anho(codigoAnho),
	FOREIGN KEY codigoMes references Mes(codigoMes),
	FOREIGN KEY codigoDia references Dia(codigoDia)
)

create table Sexo(
	codigoSexo int PRIMARY Key, 
	nombreSexo varchar(20)
)

create table Lesion (
	codigoLesion int PRIMARY KEY, 
	nombreLesion varchar(100)
)

create table Rol(
	codigoRol int PRIMARY KEY, 
	nombreRol varchar(100)
)

create table Afectado(

	codigoAfectado int AUTO INCREMENT PRIMARY KEY, 
	codigoRol int, 
	codigoSexo int, 
	codigoLesion int, 
	edad int, 
	edadQuinquenal varchar(100),

	FOREIGN KEY codigoRol references Rol(codigoRol),
	FOREIGN KEY codigoSexo references Sexo(codigoSexo),
	FOREIGN KEY codigoLesion references Lesion(codigoLesion)
)


create table Incidente (

	codigoRegistro int PRIMARY KEY, 
	codigoLocalizacion int, 
	codigoFecha int, 
	codigoAfectado int, 
	FOREIGN KEY codigoLocalizacion references Localizacion(codigoLocalizacion),
	FOREIGN KEY codigoFecha references FechaIncidente(codigoFecha),
	FOREIGN KEY codigoAfectado references Afectado(codigoAfectado)

)