create table admin(
id SERIAL primary key,
nombres VARCHAR(50) not null,
apellidos VARCHAR(50) not null
);



create table espacio(
id SERIAL primary key,
nombre VARCHAR(25) not null,
tipo varchar(50) not null,
capacidad_maxima int not null,
disponibilidad varchar(50) not null,
id_Admin int not null,
foreign key(id_Admin) references admin(id) on delete cascade
);

create table cliente(
id SERIAL primary key,
nombres VARCHAR(50) not null,
apellidos VARCHAR(50) not null,
dni int not null,
telefono varchar(50) not null,
email varchar(50) not null
);


create table reservafecha(
id SERIAL primary key,
year int not null,
mes int not null,
dia int not null,
hora_inicio time not null,
hora_final time not null
);

create table reserva(
id SERIAL primary key,
estado VARCHAR(25) not null,
id_Cliente int not null,
id_Espacio int not null,
id_ReservaFecha int not null,
foreign key(id_Cliente) references cliente(id) on delete cascade,
foreign key(id_Espacio) references espacio(id) on delete cascade,
foreign key(id_ReservaFecha) references reservafecha(id) on delete cascade
);
ALTER TABLE reserva 
ADD CONSTRAINT unique_reserva UNIQUE (id_Cliente, id_ReservaFecha, id_Espacio);


INSERT into admin(nombres, apellidos)  VALUES 
('Maria','Lopez'),
('Leornado','Gonzalez'),
('Juan','Conde'),
('Gean', 'Jacome'),
('Carlos','Rueda'),
('Joan','Ruiz'),
('Joan','Santos'),
('Laura','Sandoval'),
('Laura','Amaya'),
('Victor','Marimon');

insert into espacio (nombre,tipo, capacidad_maxima, disponibilidad,id_admin) values
('Sala Azul', 'sala de reuniones', 25, 'activo',1),
('Oficina 3A', 'oficina privada', 10, 'activo', 2),
('Escritorio 1B', 'escritorio compartido', 5, 'activo', 3),
('Sala Negra', 'sala de reuniones', 15, 'inactivo',4),
('Sala Rosa', 'sala de reuniones', 40, 'activo',5),
('Oficina 5X', 'oficina privada', 20, 'inactivo', 6),
('Oficina 8G', 'oficina privada', 30, 'activo', 7),
('Escritorio 7M', 'escritorio compartido', 15, 'inactivo', 8),
('Escritorio 6L', 'escritorio compartido', 15, 'activo', 9),
('Escritorio 9K', 'escritorio compartido', 12, 'activo', 10);

insert into cliente (nombres,apellidos,dni,telefono,email) VALUES
('Javier','Acevedo',1093292710,'3163730470','javi@gmail.com'),
('Arley','Mantilla',1093292711,'3163730471','arly@gmail.com'),
('Luis','Mendez',1093292712,'3163730472','luis@gmail.com'),
('Alexis','Toloza',1093292713,'3163730473','alexis@gmail.com'),
('Jose','Becerra',1093292714,'3163730474','jose@gmail.com'),
('Juan','Acevedo',1093292715,'3163730475','juan@gmail.com'),
('Alvaro','Buendia',1093292716,'3163730476','alva@gmail.com'),
('Kevin','Rodriguez',1093292717,'3163730477','kev@gmail.com'),
('Haider','Mendez',1093292718,'3163730478','hai@gmail.com'),
('Maicol','Laguado',1093292719,'3163730479','mai@gmail.com');

insert into reservafecha (year, mes, dia, hora_inicio,hora_final) values
(2024,05,26,'08:00:00','10:00:00'),
(2025,06,27,'09:00:00','11:00:00'),
(2026,07,28,'10:00:00','12:00:00'),
(2027,08,29,'11:00:00','13:00:00'),
(2028,09,30,'12:00:00','14:00:00'),
(2029,10,31,'13:00:00','15:00:00'),
(2030,11,01,'14:00:00','16:00:00'),
(2031,12,02,'15:00:00','17:00:00'),
(2032,01,03,'16:00:00','18:00:00'),
(2023,02,04,'17:00:00','19:00:00');


