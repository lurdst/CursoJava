-- public.superheroes definition

-- Drop table

-- DROP TABLE public.superheroes;

CREATE TABLE public.superheroes (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	nombre varchar NOT NULL,
	estado varchar NOT NULL,
	CONSTRAINT superheroes_pk PRIMARY KEY (id)
);
