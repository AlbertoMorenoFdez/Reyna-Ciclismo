

CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR (50) NOT NULL,
    direccion VARCHAR(255),
    correo_electronico VARCHAR(100) NOT NULL,
    contraseña VARCHAR(30) NOT NULL,
    DNI VARCHAR(9),
    numero_telefono int (15)
    
);

CREATE TABLE productos (
  id INT PRIMARY KEY AUTO_INCREMENT,
  marca VARCHAR(100) NOT NULL,
  modelo VARCHAR(100) NOT NULL,  
  EAN INT (12) NOT NULL,
  color VARCHAR(50),
  descripcion VARCHAR (255),
  precio DECIMAL(10, 2),
  modalidad VARCHAR (50),
  talla_bicicleta VARCHAR(20),
  calorias INT (10),
  talla_accesorio VARCHAR(10),
  proveedor_id INT,
  FOREIGN KEY (proveedor_id) REFERENCES proveedores(id)
  
  
);

CREATE TABLE proveedores (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  direccion VARCHAR(255) NOT NULL,
  CIF VARCHAR(9) NOT NULL,
  numero_telefono int (15),
  correo_electronico VARCHAR(100) NOT NULL
  
);
 
create table productos_Comprados(
	cliente int(150),
    producto int,
    cantidad numeric(3),
    fecha timestamp,
    primary key(fecha,cantidad,producto,cliente),
    foreign key (cliente) references clientes (id),
    foreign key (producto) references productos (id)
);