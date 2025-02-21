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

