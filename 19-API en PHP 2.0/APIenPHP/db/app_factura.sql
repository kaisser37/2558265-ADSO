DROP DATABASE IF EXISTS app_factura;

CREATE DATABASE app_factura CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE app_factura;

CREATE TABLE personas (
  cedula INT UNSIGNED NOT NULL PRIMARY KEY,
  nombres VARCHAR(30) DEFAULT NULL,
  apellidos VARCHAR(30) DEFAULT NULL,
  telefono VARCHAR(20) DEFAULT NULL,
  direccion VARCHAR(100) DEFAULT NULL,
  email VARCHAR(100) DEFAULT NULL,
  rol ENUM('Vendedor', 'Cliente') DEFAULT 'Cliente',
  estado TINYINT(1) DEFAULT 1,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE factura (
  id_factura INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  id_cliente INT UNSIGNED NOT NULL,
  id_vendedor INT UNSIGNED NOT NULL,
  total FLOAT,  -- Cambiado a DECIMAL para valores monetarios
  estado TINYINT(1) DEFAULT 1,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (id_cliente) REFERENCES personas (cedula),
  FOREIGN KEY (id_vendedor) REFERENCES personas (cedula)
);

CREATE TABLE producto (
  id_producto INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nom_producto VARCHAR(30),
  descripcion_producto VARCHAR(100),
  stock INT UNSIGNED,
  precio_und FLOAT,  -- Cambiado a DECIMAL para valores monetarios
  estado TINYINT(1) DEFAULT 1,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE item_factura(
  id_item INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  id_factura INT UNSIGNED,
  id_producto INT UNSIGNED,
  cantidad INT UNSIGNED,
  FOREIGN KEY (id_factura) REFERENCES factura (id_factura),
  FOREIGN KEY (id_producto) REFERENCES producto (id_producto),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
