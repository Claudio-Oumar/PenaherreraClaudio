-- SQLBook: Code
.DATABASE;
DROP TABLE SP_CP_COORDENADAS;
DROP TABLE SP_CP_USUARIOS;

-- Tabla Coordenadas
CREATE TABLE SP_CP_COORDENADAS
(
    IdUsuario     INTEGER         NOT NULL,
    Geoposicion   VARCHAR         NOT NULL,
    Lunes         VARCHAR(5)      NOT NULL,
    Martes        VARCHAR(5)      NOT NULL,
    Miercoles     VARCHAR(5)      NOT NULL,
    Jueves        VARCHAR(5)      NOT NULL,
    Viernes       VARCHAR(5)      NOT NULL,
    TipoCordenada         VARCHAR(255)    NOT NULL
);

-- Tabla Usuarios
CREATE TABLE SP_CP_USUARIOS
(
    userName      VARCHAR(255)    NOT NULL,
    password      VARCHAR(255)    NOT NULL
);
SELECT * FROM SP_CP_USUARIOS;

-- Datos Registrados
INSERT INTO SP_CP_USUARIOS (userName, password) VALUES ('Patmic', '12345'),('Ramiro', '1752192086'), ('Claudio', '1755501044');


