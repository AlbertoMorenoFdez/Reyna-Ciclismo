CREATE DATABASE IF NOT EXISTS reynaciclismo;
use reynaciclismo;

CREATE TABLE usuarios (
    correo_electronico VARCHAR(100) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    direccion VARCHAR(255),
    contraseña VARCHAR(30) NOT NULL,
    DNI VARCHAR(9),
    numero_telefono INT(15)
);

INSERT INTO usuarios (correo_electronico, nombre, direccion, contraseña, DNI, numero_telefono) VALUES
('admin@admin', 'Administrador','calle del administrador','admin','12345678a',666000666);

CREATE TABLE proveedores (
    cif VARCHAR(9) not null,
    nombre VARCHAR(100) PRIMARY KEY,
    direccion VARCHAR(255) NOT NULL,
    numero_telefono INT(15),
    correo_electronico VARCHAR(100) NOT NULL
);

INSERT INTO proveedores (cif, nombre, direccion, numero_telefono,correo_electronico) VALUES
('CIF1','KTM', 'direccion KTM',100000000,'ktm@ktm'),
('CIF2','BH', 'direccion BH',200000000,'BH@BH'),
('CIF3','FACTOR', 'direccion FACTOR',300000000,'BH@BH'),
('CIF4','RIDLEY', 'direccion RIDLEY',400000000,'RIDLEY@RIDLEY'),
('CIF5','FOCUS', 'direccion FOCUS',500000000,'FOCUS@FOCUS'),
('CIF6','EOVOLT', 'direccion EOVOLT',600000000,'EOVOLT@EOVOLT'),
('CIF7','BROMPTON', 'direccion BROMPTON',700000000,'BROMPTON@BROMPTON'),
('CIF8','OAKLEY', 'direccion OAKLEY',800000000,'OAKLEY@OAKLEY'),
('CIF9','SHIMANO', 'direccion SHIMANO',900000000,'SHIMANO@SHIMANO'),
('CIF10','CAMELBACK', 'direccion CAMELBACK',100000000,'CAMELBACK@CAMELBACK'),
('CIF11','BLACKBURN', 'direccion BLACKBURN',110000000,'BLACKBURN@BLACKBURN'),
('CIF12','GOBIK', 'direccion GOBIK',120000000,'GOBIK@GOBIK'),
('CIF13','NUTRINOVEX', 'direccion NUTRINOVEX',130000000,'NUTRINOVEX@NUTRINOVEX'),
('CIF14','INFISPORT', 'direccion INFISPORT',140000000,'INFISPORT@INFISPORT'),
('CIF15','226ers', 'direccion 226ers',150000000,'226ers@226ers');

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

INSERT INTO bicicleta (marca, modelo, ean, color, descripcion,precio,modalidad,talla_bicicleta,nombre_proveedor) VALUES 
('KTM','Scarp',1,'naranja','bicicleta doble de montaña',3699,'MTB','M','KTM'),
('BH','Lynx 6.5',2,'burdeos','bicicleta doble de montaña',3499,'MTB','M','BH'),
('FACTOR','Ostro Van',3,'blanca','bicicleta aero de carretera',11499,'CARRETERA','S','FACTOR'),
('RIDLEY','Noah Disc',4,'plata','bicicleta de carretera gran fondo',5675,'CARRETERA','L','RIDLEY'),
('FOCUS','Jam2',5,'azul electrico','bicicleta electrica montaña',6599,'EBIKE','M','FOCUS'),
('BH','ILynx Trail',6,'azzul','bicicleta electrica doble de montaña',6999,'EBIKE','XL','BH'),
('EOVOLT','Afternoon',7,'arena','bicicleta plegable',2450,'URBAN','M','EOVOLT'),
('BROMPTON','C Line Explore',8,'verde','bicicleta plegable',1999.99,'URBAN','XS','BROMPTON');

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

INSERT INTO alimentacion (marca,modelo, ean, color, descripcion,precio,calorias,nombre_proveedor) VALUES
('NUTRINOVEX','Glucobar',17,'','barrita energetica sabor fresa',2.49,'175 cal', 'NUTRINOVEX'),
('NUTRINOVEX','Longovit',12,'','gel energetico sabor kiwi',2.99,'250 cal', 'NUTRINOVEX'),
('INFISPORT','ND4',13,'','polvos con hidratos de carbono',22.99,'999 cal', 'INFISPORT'),
('INFISPORT','Magnesio',14,'','sobres individuales de Mg',1.99,'n/d', 'INFISPORT'),
('226ers','Race Day Bar',15,'','barrita energetica sabor chocolate blanco',22.99,'120cal', '226ers'),
('NUTRINOVEX','Suproplex Recovery 3.1',16,'','Recuperador',37.95,'750 cal', 'NUTRINOVEX');



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

INSERT INTO accesorio (marca,modelo, ean, color, descripcion,precio,talla_accesorio,nombre_proveedor) VALUES
('OAKLEY','Sutro S Lite',21,'black','gafas de ciclismo con cristales Prizm',150,'s/t','OAKLEY'),
('SHIMANO','XC90',22,'azul','zapatillas de ciclismo de montaña',329.99,'43','SHIMANO'),
('CAMELBACK','Podium',23,'blanco/negro','bidón con hidroválvula',17.50,'s/t','CAMELBACK'),
('BLACKBURN','Multiherramientas',24,'plata','estuche multiherramientas',29.99,'s/t','BLACKBURN'),
('GOBIK','CX Pro 2',25,'blanco y azul','maillot de ciclismo',150,'S','GOBIK'),
('GOBIK','Matt Nove Coli',26,'negro','culotte de ciclismo',325,'M','GOBIK');

CREATE TABLE productos_Comprados (
    usuario VARCHAR(100),
    producto INT,
    cantidad NUMERIC(3),
    fecha TIMESTAMP,
    PRIMARY KEY (fecha, cantidad, producto, usuario),
    FOREIGN KEY (usuario) REFERENCES usuarios (correo_electronico),
    FOREIGN KEY (producto) REFERENCES productos (ean)
);


