CREATE DATABASE IF NOT EXISTS reynaciclismo;

CREATE TABLE usuarios (
    email VARCHAR(100) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    direccion VARCHAR(255),
    contraseña VARCHAR(30) NOT NULL,
    DNI VARCHAR(9),
    numero_telefono INT(15)
);



CREATE TABLE productos (
    
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    ean INT(12) PRIMARY KEY,
    color VARCHAR(50),
    descripcion VARCHAR(255),
    precio DECIMAL(10, 2),
    modalidad VARCHAR(50),
    talla_bicicleta VARCHAR(20),
    calorias VARCHAR(20),
    talla_accesorio VARCHAR(10),
    nombre_proveedor VARCHAR(100),
    FOREIGN KEY (nombre_proveedor) REFERENCES proveedores(nombre)
);

CREATE TABLE bicicleta (
    
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    ean INT(12) PRIMARY KEY,
    color VARCHAR(50),
    descripcion VARCHAR(255),
    precio DECIMAL(10, 2),
    modalidad VARCHAR(50),
    talla_bicicleta VARCHAR(20),
    nombre_proveedor VARCHAR(100),
    FOREIGN KEY (nombre_proveedor) REFERENCES proveedores(nombre)
);

CREATE TABLE alimentacion (
    
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    ean INT(12) PRIMARY KEY,
    color VARCHAR(50),
    descripcion VARCHAR(255),
    precio DECIMAL(10, 2),
    calorias VARCHAR(20),
    nombre_proveedor VARCHAR(100),
    FOREIGN KEY (nombre_proveedor) REFERENCES proveedores(nombre)
);

CREATE TABLE accesorio (
    
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    ean INT(12) PRIMARY KEY,
    color VARCHAR(50),
    descripcion VARCHAR(255),
    precio DECIMAL(10, 2),
    talla_accesorio VARCHAR(10),
    nombre_proveedor VARCHAR(100),
    FOREIGN KEY (nombre_proveedor) REFERENCES proveedores(nombre)
);

CREATE TABLE proveedores (
    cif VARCHAR(9) not null,
    nombre VARCHAR(100) PRIMARY KEY,
    direccion VARCHAR(255) NOT NULL,
    numero_telefono INT(15),
    correo_electronico VARCHAR(100) NOT NULL
);

CREATE TABLE productos_Comprados (
    usuario VARCHAR(100),
    producto INT,
    cantidad NUMERIC(3),
    fecha TIMESTAMP,
    PRIMARY KEY (fecha, cantidad, producto, usuario),
    FOREIGN KEY (usuario) REFERENCES usuarios (correo_electronico),
    FOREIGN KEY (producto) REFERENCES productos (ean)
);
