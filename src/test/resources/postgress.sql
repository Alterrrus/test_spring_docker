
CREATE SEQUENCE IF NOT EXISTS public.accounts_user_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

CREATE TABLE IF NOT EXISTS public.accounts
(
    user_id integer NOT NULL DEFAULT nextval('accounts_user_id_seq'::regclass),
    username character varying(50) COLLATE pg_catalog."default",
    password character varying(50) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    created_on timestamp without time zone,
    last_login timestamp without time zone,
    version bigint,
    CONSTRAINT accounts_pkey PRIMARY KEY (user_id)
)
    TABLESPACE pg_default;


