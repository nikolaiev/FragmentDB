CREATE TABLE public."University"
(
  id bigserial,
  title text,
  country text NOT NULL DEFAULT 'Ukraine'::text,
  CONSTRAINT univ_id_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);


CREATE TABLE public."Group"
(
  id bigserial,
  title text,
  univ_id bigint,
  CONSTRAINT id_pk_group PRIMARY KEY (id),
  CONSTRAINT univ_id_fk FOREIGN KEY (univ_id)
      REFERENCES public."University" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);



CREATE TABLE public."User"
(
  id bigserial,
  name text,
  soname text,
  birthdate timestamp without time zone DEFAULT now(),
  gid bigint,
  CONSTRAINT id_pk_user PRIMARY KEY (id),
  CONSTRAINT user_gid_fk FOREIGN KEY (gid)
      REFERENCES public."Group" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE public."GenTables"
(
  id bigserial,
  title text,
  author_name text,
  view_name text NOT NULL,
  query text,
  CONSTRAINT gen_table_id_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);



INSERT INTO public."University"(
             title, country)
    VALUES ( 'KPI', 'Ukraine');
INSERT INTO public."Group"(
             title, univ_id)
    VALUES ( 'DK-15', 1);
INSERT INTO public."Group"(
             title, univ_id)
    VALUES ( 'DK-16', 1);
INSERT INTO public."Group"(
             title, univ_id)
    VALUES ( 'DM-1', 1);
INSERT INTO public."User"(
             name, soname, gid)
    VALUES ( 'Fedor', 'Fedorov', 1);
INSERT INTO public."User"(
             name, soname, gid)
    VALUES ( 'Fedor2', 'Fedorov2', 2);
INSERT INTO public."User"(
             name, soname, gid)
    VALUES ( 'Fedor3', 'Fedorov3', 3);
INSERT INTO public."User"(
             name, soname, gid)
    VALUES ( 'Fedor35', 'Fedorov35', 3);