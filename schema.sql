-- public.admin definition

-- Drop table

-- DROP TABLE public.admin;

CREATE TABLE public.admin (
	id int4 NOT NULL,
	nombres varchar NOT NULL,
	apellidos varchar NOT NULL,
	CONSTRAINT admin_pk PRIMARY KEY (id)
);

-- public.reservafecha definition

-- Drop table

-- DROP TABLE public.reservafecha;

CREATE TABLE public.reservafecha (
	id int4 NOT NULL,
	año int4 NOT NULL,
	mes int4 NOT NULL,
	dia int4 NOT NULL,
	hora_inicio time NOT NULL,
	hora_fin time NOT NULL,
	CONSTRAINT reservafecha_pk PRIMARY KEY (id)
);

-- public.clientes definition

-- Drop table

-- DROP TABLE public.clientes;

CREATE TABLE public.clientes (
	id int4 NOT NULL,
	nombres varchar NOT NULL,
	apellidos varchar NOT NULL,
	dni int4 NULL,
	telefono varchar NULL,
	email varchar NOT NULL,
	CONSTRAINT clientes_pk PRIMARY KEY (id)
);


-- public.espacio definition

-- Drop table

-- DROP TABLE public.espacio;

CREATE TABLE public.espacio (
	id int4 NOT NULL,
	nombre varchar NOT NULL,
	tipo varchar NOT NULL,
	capacidad_maxima int4 NOT NULL,
	disponibilidad varchar NULL,
	CONSTRAINT espacio_pk PRIMARY KEY (id),
	CONSTRAINT espacio_admin_fk FOREIGN KEY (id) REFERENCES public.admin(id)
);

-- public.reserva definition

-- Drop table

-- DROP TABLE public.reserva;

CREATE TABLE public.reserva (
	id int4 NOT NULL,
	estado varchar NOT NULL,
	CONSTRAINT reserva_pk PRIMARY KEY (id),
	CONSTRAINT reserva_clientes_fk FOREIGN KEY (id) REFERENCES public.clientes(id),
	CONSTRAINT reserva_espacio_fk FOREIGN KEY (id) REFERENCES public.espacio(id),
	CONSTRAINT reserva_reservafecha_fk FOREIGN KEY (id) REFERENCES public.reservafecha(id)
);

