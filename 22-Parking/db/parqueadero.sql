DROP DATABASE IF EXISTS parqueadero;
CREATE DATABASE parqueadero;
USE parqueadero;

CREATE TABLE usuarios(
    documento INT UNSIGNED PRIMARY KEY,
    nombre VARCHAR(60),
    correo VARCHAR(70) UNIQUE,
    contrasenia VARCHAR(255),
    rol ENUM('admin','vendedor'),
    estado TINYINT(1) DEFAULT '1'
);

CREATE TABLE parqueadero (
    id_parqueadero INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    direccion VARCHAR(100),
    carro FLOAT DEFAULT '0',
    moto FLOAT DEFAULT '0',
    camioneta FLOAT DEFAULT '0',
    camiones FLOAT DEFAULT '0',
    estado TINYINT(1) DEFAULT '1'
);

CREATE TABLE parqueadero_vendedores(
    id_usuario INT UNSIGNED,
    id_parqueadero INT UNSIGNED,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(documento),
    FOREIGN KEY (id_parqueadero) REFERENCES parqueadero(id_parqueadero)
);

CREATE TABLE vehiculo_registrados(
    placa CHAR(6) PRIMARY KEY,
    propietario VARCHAR(50),
    tipo ENUM('carro','moto','camioneta','camion')
);

CREATE TABLE tickets(
    id_tickets INT  UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    hora_ingreso TIME DEFAULT CURRENT_TIME, 
    hora_salida TIME,
    placa CHAR(6),
    estado_pago TINYINT(1) DEFAULT '0',
    total_pago FLOAT,
    parqueadero INT UNSIGNED,
    FOREIGN KEY (placa) REFERENCES vehiculo_registrados(placa),
    FOREIGN KEY (parqueadero) REFERENCES parqueadero(id_parqueadero)
);
 
INSERT INTO usuarios (documento, nombre, correo, contrasenia, rol, estado)
VALUES
  (009, 'root', 'admin@root.com', '123', 'vendedor', 1);


 


-- Empresas
INSERT INTO parqueadero (nombre, direccion, carro, moto, camioneta, camiones)
VALUES
  ('SENA', 'CRA 8 - 26', 50.0, 30.0, 40.0, 20.0);

-- Asignando usuarios a parqueaderos

INSERT INTO parqueadero_vendedores (id_usuario, id_parqueadero)
VALUES (009, 1);
 

-- Insertar datos en la tabla vehiculo_registrados
INSERT INTO vehiculo_registrados (placa, propietario, tipo)
VALUES
  ('ASD234', 'Juan Jose', 'carro'),
  ('QWE123', 'Santiago Franco', 'moto'),
  ('QWE124', 'Santiago Vergara', 'carro'),
  ('QWE125', 'Santiago Garca', 'carro'),
  ('QWE126', 'Santiago Gales', 'camion'),
  ('QWE127', 'Santiago Suarez', 'camioneta'),
  ('QWE128', 'Santiago Manrique', 'moto'),
  ('AZE987', 'Mario Alberto', 'camioneta'),
  ('PQR789', 'Leidy Perez', 'camion');


