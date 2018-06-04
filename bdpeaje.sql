
DROP DATABASE IF EXISTS `bdpeaje`;
CREATE DATABASE IF NOT EXISTS `bdpeaje`;
USE `bdpeaje`;

CREATE TABLE `usuarios` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(9) NOT NULL DEFAULT '71000111A',
  `nombre` VARCHAR(16) NOT NULL DEFAULT 'Empleado',
  `apellido1` VARCHAR(16) NOT NULL DEFAULT 'Por',
  `apellido2` VARCHAR(16) NOT NULL DEFAULT 'Defecto',
  `email` VARCHAR(30) NOT NULL DEFAULT 'usuario@peaje.es',
  `usuario` VARCHAR(16) NOT NULL DEFAULT 'admin',
  `password` VARCHAR(16) NOT NULL DEFAULT 'root',
  `rol` VARCHAR(1) NOT NULL DEFAULT 'E',
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `DNI_UNIQUE` (`dni`),
  UNIQUE INDEX `USUARIO_UNIQUE` (`usuario`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `vehiculos` (
  `idVehiculo` INT(11) NOT NULL AUTO_INCREMENT,
  `matricula` VARCHAR(8) NOT NULL DEFAULT '0000XXX',
  `tipoVehiculo` VARCHAR(12) NOT NULL DEFAULT 'Coche',
  `marca` VARCHAR(16) NOT NULL DEFAULT 'Fiat',
  `modelo` VARCHAR(16) NOT NULL DEFAULT 'Idea',
  `color` VARCHAR(16) NOT NULL DEFAULT 'Azul' COLLATE 'latin1_swedish_ci',
  `pago` VARCHAR(10) NOT NULL DEFAULT 'Efectivo',
  `fechaRegistro` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idUsuario` INT(11) NOT NULL,
  PRIMARY KEY (`idVehiculo`, `idUsuario`),
  INDEX `FK_idUsuario` (`idUsuario`),
  UNIQUE INDEX `MATRICULA_UNIQUE` (`matricula`),
  CONSTRAINT `FK_idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

INSERT INTO usuarios VALUES (0, '12345678A', 'Pepe', 'Perez', 'Perez', 'admin@peaje.es', 'admin', 'superadmin1', 'A');  
