DELIMITER $$
CREATE PROCEDURE REG_PRESTAMO 
(USERi INTEGER,PERSONAi INTEGER,FECHAi VARCHAR(10),LUGARi VARCHAR(255))
BEGIN
START TRANSACTION;
INSERT INTO PRESTAMO (idPrestamo,idUsuario,PersonaRes,fechaPrestamo,fechaDevolucion,lugar,estado) 
VALUES (null,USERi,PERSONAi,(SELECT SYSDATE()),FECHAi,LUGARi,"1");
COMMIT;
SELECT MAX(idPRESTAMO) AS idPRESTAMO FROM PRESTAMO;
END$$