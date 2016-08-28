CREATE TABLE ROL(
    idRol INTEGER NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
     PRIMARY KEY(idRol)
);
CREATE TABLE PERSONA(
    idPersona INTEGER NOT NULL AUTO_INCREMENT,
    idRol INTEGER NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    apellidos VARCHAR(45) NOT NULL,
    dni INTEGER(8) NOT NULL,
    celular INTEGER(11) NOT NULL,
    correo VARCHAR(45) NOT NULL,
    PRIMARY KEY(idPersona),
    FOREIGN KEY(idRol) REFERENCES ROL(idRol)
);
CREATE TABLE USUARIO(
    idUsuario INTEGER NOT NULL AUTO_INCREMENT,
    idPersona INTEGER NOT NULL,
    usuario VARCHAR(20) NOT NULL,
    clave VARCHAR(20) NOT NULL,
    PRIMARY KEY(idUsuario),
    FOREIGN KEY(idPersona) REFERENCES PERSONA(idPersona)
);
CREATE TABLE EQUIPO(
    idEquipo INTEGER NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    serie VARCHAR(30) NOT NULL,
    tipo VARCHAR(120) NOT NULL,
    PRIMARY KEY(idEquipo)
);
CREATE TABLE DET_EQUIPO(
    idDet_Equipo INTEGER NOT NULL AUTO_INCREMENT,
    idEquipo INTEGER NOT NULL,
    codigo VARCHAR(30) NOT NULL,
    descripcion VARCHAR(120) NOT NULL,
    estado CHAR(1) NOT NULL,
    FOREIGN KEY(idEquipo) REFERENCES EQUIPO(idEquipo),
    PRIMARY KEY(idDet_Equipo)
);
CREATE TABLE PRESTAMO(
    idPrestamo INTEGER NOT NULL AUTO_INCREMENT,
    idUsuario INTEGER NOT NULL,
    PersonaRes INT NOT NULL,
    fechaPrestamo DATE NOT NULL,
    fechaDevolucion DATE NOT NULL,
    lugar VARCHAR(45) NOT NULL,
    comentariop VARCHAR(120) ,
    comentariod VARCHAR(120) ,
    estado CHAR(1) NOT NULL, 
    PRIMARY KEY(idPrestamo),
    FOREIGN KEY(idUsuario) REFERENCES USUARIO(idUsuario)
);
CREATE TABLE DET_PRESTAMO(
    idPrestamo INTEGER NOT NULL,
    idDet_Equipo INTEGER(6) NOT NULL,    
    FOREIGN KEY(idDet_Equipo) REFERENCES DET_EQUIPO(idDet_Equipo),
    FOREIGN KEY(idPrestamo) REFERENCES PRESTAMO(idPrestamo)
);



