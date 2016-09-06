CREATE TABLE ROL(
    idRol INTEGER NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
     PRIMARY KEY(idRol)
);

INSERT INTO `rol` VALUES (1, 'ADMINISTRADOR');
INSERT INTO `rol` VALUES (2, 'PRESTAMISTA');
INSERT INTO `rol` VALUES (3, 'DOCENTE');

CREATE TABLE PERSONA(
    idPersona INTEGER NOT NULL AUTO_INCREMENT,
    idRol INTEGER NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    apellidos VARCHAR(45) NOT NULL,
    dni INTEGER(8) NOT NULL,
    celular INTEGER(11) NOT NULL,
    correo VARCHAR(45) NOT NULL,
    sexo CHAR( 1 ) NOT NULL,
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
    marca VARCHAR(30) NOT NULL,
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
    idPersona INTEGER NOT NULL,
    fechaPrestamo DATE NOT NULL,
    fechaDevolucion DATE NULL,
    fechaLimite DATE NOT NULL,
    lugar VARCHAR(45) NOT NULL,
    comentariop VARCHAR(120) ,
    comentariod VARCHAR(120) ,
    estado CHAR(1) NOT NULL, 
    PRIMARY KEY(idPrestamo),
    FOREIGN KEY(idUsuario) REFERENCES USUARIO(idUsuario),
    FOREIGN KEY(idPersona) REFERENCES PERSONA(idPersona)
);
CREATE TABLE DET_PRESTAMO(
    idPrestamo INTEGER NOT NULL,
    idDet_Equipo INTEGER(6) NOT NULL,    
    FOREIGN KEY(idDet_Equipo) REFERENCES DET_EQUIPO(idDet_Equipo),
    FOREIGN KEY(idPrestamo) REFERENCES PRESTAMO(idPrestamo)
);

CREATE TABLE reserva (
    id_reserva int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_usuario int(11) NOT NULL,
    id_docente int(11) NOT NULL,
    id_detequipo int(11) NOT NULL,
    fecha_reserva date ,
    fecha_inicio date ,
    fecha_fin date ,
    dia varchar(7) ,    
    FOREIGN KEY(id_usuario) REFERENCES USUARIO(idUsuario),
    FOREIGN KEY(id_docente) REFERENCES PERSONA(idPersona),
    FOREIGN KEY(id_detequipo) REFERENCES DET_EQUIPO(idDet_Equipo)
);

DELIMITER $$
CREATE PROCEDURE REG_PRESTAMO 
(USERi INTEGER,PERSONAi INTEGER,FECHAi VARCHAR(10),LUGARi VARCHAR(255))
BEGIN
START TRANSACTION;
INSERT INTO PRESTAMO (idPrestamo,idUsuario,idPersona,fechaPrestamo,fechaDevolucion,lugar,estado) 
VALUES (null,USERi,PERSONAi,(SELECT SYSDATE()),FECHAi,LUGARi,"1");
COMMIT;
SELECT MAX(idPRESTAMO) AS idPRESTAMO FROM PRESTAMO;
END$$

DELIMITER $$
CREATE PROCEDURE REG_PERSONA
(NOMBREi VARCHAR(45),APELLIDOSi VARCHAR(45),DNIi INTEGER,IDROLi INTEGER,CELULARi INTEGER,CORREOi VARCHAR(25),SEXOi CHAR(1))
BEGIN
START TRANSACTION;
INSERT INTO PERSONA(NOMBRE,APELLIDOS,DNI,IDROL,CELULAR,CORREO,SEXO) VALUES(NOMBREi,APELLIDOSi,DNIi,IDROLi,CELULARi,CORREOi,SEXOi);
COMMIT;
SELECT MAX(idPERSONA) AS idPERSONA FROM PERSONA;
END$$

DELIMITER $$
--
-- Eventos
--
CREATE DEFINER=`root`@`localhost` EVENT revisionreservas ON SCHEDULE EVERY 1 MINUTE STARTS NOW() + INTERVAL 1 SECOND ON COMPLETION NOT PRESERVE ENABLE DO UPDATE det_equipo SET estado=2 where  det_equipo.estado=1 AND det_equipo.idDet_Equipo=(SELECT id_detequipo from reserva where reserva.fecha_fin >= (SELECT CURRENT_DATE()) AND reserva.dia=(SELECT DATE_FORMAT((SELECT CURRENT_DATE()),'%W')))$$

CREATE DEFINER=`root`@`localhost` EVENT revisionreservas2 ON SCHEDULE EVERY 1 MINUTE STARTS NOW() + INTERVAL 1 SECOND ON COMPLETION NOT PRESERVE ENABLE DO UPDATE det_equipo SET estado=1 where det_equipo.estado=2 AND det_equipo.idDet_Equipo=(SELECT id_detequipo from reserva where reserva.fecha_fin >= (SELECT CURRENT_DATE()) AND reserva.dia!=(SELECT DATE_FORMAT((SELECT CURRENT_DATE()),'%W')))$$

DELIMITER ;


