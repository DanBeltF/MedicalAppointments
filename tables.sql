CREATE TABLE CM_EPS (
`nombre` varchar(100)  NOT NULL,
`nit` varchar(20)  NOT NULL PRIMARY KEY
);


CREATE TABLE `CM_PACIENTES` (
  `id` int(11) NOT NULL,
  `tipo_id` varchar(2) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `EPS_nit` varchar(20) NOT NULL,
  PRIMARY KEY (`id`,`tipo_id`)
);


CREATE TABLE `CM_CONSULTAS` (
  `idCONSULTAS` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_y_hora` datetime NOT NULL,
  `resumen` varchar(200) NOT NULL,  
  `costo` int(11) NOT NULL,
  `PACIENTES_id` int(11) NOT NULL DEFAULT '0',
  `PACIENTES_tipo_id` varchar(2) NOT NULL DEFAULT 'cc',
  PRIMARY KEY (`idCONSULTAS`)
  )
  
  insert into `CM_EPS` values('Compensar',8456981);
  insert into `CM_EPS` values('Sanitas',8456982);
  insert into `CM_EPS` values('Sura',8456983);
  insert into `CM_EPS` values('Coomeva',8456984);
  insert into `CM_EPS` values('Medimas',8456985);
  insert into `CM_EPS` values('SaludTotal',8456986);
  insert into `CM_PACIENTES` values (12313,'CC','Albert Einstein','2017-03-02',8456981);
  insert into `CM_PACIENTES` values (1231233333,'CC','Albert Einstein 2','1887-03-02',8456984);