--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-06-22 09:58:13

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning
;
SET row_security = off;

SET default_table_access_method = heap;

--
-- TOC entry 213 (class 1259 OID 18733)
-- Name: apicultores; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.apicultores (
    id_apicultor character varying(50) NOT NULL,
    id_usuario integer NOT NULL,
    id_asociacion character varying(50) NOT NULL,
    nombre_apicultor character varying(100) NOT NULL,
    numero_apiarios integer NOT NULL,
    numero_empleados integer NOT NULL,
    correo_electronico character varying(50) NOT NULL,
    actualizacion timestamp without time zone DEFAULT now()
);


--
-- TOC entry 200 (class 1259 OID 18593)
-- Name: archivos_posts; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.archivos_posts (
    id_archivos integer NOT NULL,
    posts_id_post integer NOT NULL,
    url character varying(500) NOT NULL,
    tipo_archivo character varying(50) NOT NULL,
    actualizacion timestamp without time zone DEFAULT now()
);


--
-- TOC entry 201 (class 1259 OID 18599)
-- Name: archivos_posts_id_archivos_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.archivos_posts_id_archivos_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3093 (class 0 OID 0)
-- Dependencies: 201
-- Name: archivos_posts_id_archivos_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.archivos_posts_id_archivos_seq OWNED BY public.archivos_posts.id_archivos;


--
-- TOC entry 202 (class 1259 OID 18601)
-- Name: areas_floracion; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.areas_floracion (
    id_areas_floracion integer NOT NULL,
    nombre_finca character varying(50) NOT NULL,
    region_estado character varying(50) NOT NULL,
    familia_flores character varying(50) NOT NULL,
    especie_flores character varying(50) NOT NULL,
    nombre_comun character varying(50) NOT NULL,
    nombre_cientifico character varying(50) NOT NULL,
    periodo_floracion character varying(50) NOT NULL,
    latitud numeric(10,6),
    longitud numeric(10,6),
    actualizacion timestamp without time zone DEFAULT now()
);


--
-- TOC entry 203 (class 1259 OID 18604)
-- Name: areas_floracion_id_areas_floracion_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.areas_floracion_id_areas_floracion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3094 (class 0 OID 0)
-- Dependencies: 203
-- Name: areas_floracion_id_areas_floracion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.areas_floracion_id_areas_floracion_seq OWNED BY public.areas_floracion.id_areas_floracion;


--
-- TOC entry 204 (class 1259 OID 18606)
-- Name: asociaciones; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.asociaciones (
    id_asociacion character varying(50) NOT NULL,
    nombre_asociacion character varying(50) NOT NULL,
    descripcion character varying(255) NOT NULL,
    ciudad character varying(50) NOT NULL,
    codigo_postal character varying(20) NOT NULL,
    direccion character varying(255) NOT NULL,
    correo_electronico character varying(50) NOT NULL,
    telefono character varying(15) NOT NULL,
    actualizacion timestamp with time zone DEFAULT now()
);


--
-- TOC entry 205 (class 1259 OID 18612)
-- Name: categorias_posts; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.categorias_posts (
    id_categoria integer NOT NULL,
    nombre_categoria character varying(50) NOT NULL,
    descripcion character varying(255) NOT NULL,
    actualizacion timestamp without time zone DEFAULT now()
);


--
-- TOC entry 206 (class 1259 OID 18615)
-- Name: categorias_posts_id_categoria_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.categorias_posts_id_categoria_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3095 (class 0 OID 0)
-- Dependencies: 206
-- Name: categorias_posts_id_categoria_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.categorias_posts_id_categoria_seq OWNED BY public.categorias_posts.id_categoria;


--
-- TOC entry 216 (class 1259 OID 18813)
-- Name: detalle_produccion; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.detalle_produccion (
    id_apicultor character varying(50) NOT NULL,
    id_producto character varying(50) NOT NULL,
    id_detalle_produccion integer NOT NULL,
    cantidad numeric(10,2) NOT NULL,
    fecha date NOT NULL,
    precio numeric(10,2)
);


--
-- TOC entry 215 (class 1259 OID 18811)
-- Name: detalle_produccion_id_detalle_produccion_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.detalle_produccion_id_detalle_produccion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3096 (class 0 OID 0)
-- Dependencies: 215
-- Name: detalle_produccion_id_detalle_produccion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.detalle_produccion_id_detalle_produccion_seq OWNED BY public.detalle_produccion.id_detalle_produccion;


--
-- TOC entry 207 (class 1259 OID 18617)
-- Name: posts; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.posts (
    id_post integer NOT NULL,
    id_categoria integer NOT NULL,
    id_usuario integer NOT NULL,
    contenido text NOT NULL,
    fecha_creacion date NOT NULL,
    fecha_modificacion date NOT NULL
);


--
-- TOC entry 208 (class 1259 OID 18623)
-- Name: posts_id_post_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.posts_id_post_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3097 (class 0 OID 0)
-- Dependencies: 208
-- Name: posts_id_post_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.posts_id_post_seq OWNED BY public.posts.id_post;


--
-- TOC entry 214 (class 1259 OID 18765)
-- Name: productos; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.productos (
    id_producto character varying(50) NOT NULL,
    nombre_producto character varying(50) NOT NULL,
    descripcion character varying(255) NOT NULL,
    unidad_medida character varying(20) NOT NULL,
    actualizacion timestamp without time zone DEFAULT now()
);


--
-- TOC entry 209 (class 1259 OID 18630)
-- Name: roles_usuario; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.roles_usuario (
    id_rol integer NOT NULL,
    nombre_rol character varying(50) NOT NULL
);


--
-- TOC entry 210 (class 1259 OID 18633)
-- Name: roles_usuario_id_rol_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.roles_usuario_id_rol_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3098 (class 0 OID 0)
-- Dependencies: 210
-- Name: roles_usuario_id_rol_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.roles_usuario_id_rol_seq OWNED BY public.roles_usuario.id_rol;


--
-- TOC entry 211 (class 1259 OID 18635)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.usuarios (
    id_usuario integer NOT NULL,
    id_rol integer NOT NULL,
    nombre_usuario character varying(50) NOT NULL,
    correo_electronico character varying(50) NOT NULL,
    contrasenia character varying(256) NOT NULL
);


--
-- TOC entry 212 (class 1259 OID 18638)
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.usuarios_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3099 (class 0 OID 0)
-- Dependencies: 212
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.usuarios_id_usuario_seq OWNED BY public.usuarios.id_usuario;


--
-- TOC entry 2901 (class 2604 OID 18641)
-- Name: archivos_posts id_archivos; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.archivos_posts ALTER COLUMN id_archivos SET DEFAULT nextval('public.archivos_posts_id_archivos_seq'::regclass);


--
-- TOC entry 2903 (class 2604 OID 18642)
-- Name: areas_floracion id_areas_floracion; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.areas_floracion ALTER COLUMN id_areas_floracion SET DEFAULT nextval('public.areas_floracion_id_areas_floracion_seq'::regclass);


--
-- TOC entry 2906 (class 2604 OID 18643)
-- Name: categorias_posts id_categoria; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.categorias_posts ALTER COLUMN id_categoria SET DEFAULT nextval('public.categorias_posts_id_categoria_seq'::regclass);


--
-- TOC entry 2913 (class 2604 OID 18816)
-- Name: detalle_produccion id_detalle_produccion; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.detalle_produccion ALTER COLUMN id_detalle_produccion SET DEFAULT nextval('public.detalle_produccion_id_detalle_produccion_seq'::regclass);


--
-- TOC entry 2908 (class 2604 OID 18644)
-- Name: posts id_post; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.posts ALTER COLUMN id_post SET DEFAULT nextval('public.posts_id_post_seq'::regclass);


--
-- TOC entry 2909 (class 2604 OID 18646)
-- Name: roles_usuario id_rol; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.roles_usuario ALTER COLUMN id_rol SET DEFAULT nextval('public.roles_usuario_id_rol_seq'::regclass);


--
-- TOC entry 2910 (class 2604 OID 18647)
-- Name: usuarios id_usuario; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usuarios ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuarios_id_usuario_seq'::regclass);


--
-- TOC entry 2939 (class 2606 OID 18737)
-- Name: apicultores apicultores_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.apicultores
    ADD CONSTRAINT apicultores_pkey PRIMARY KEY (id_apicultor);


--
-- TOC entry 2916 (class 2606 OID 18651)
-- Name: archivos_posts archivos_posts_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.archivos_posts
    ADD CONSTRAINT archivos_posts_pkey PRIMARY KEY (id_archivos);


--
-- TOC entry 2919 (class 2606 OID 18653)
-- Name: areas_floracion areas_floracion_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.areas_floracion
    ADD CONSTRAINT areas_floracion_pkey PRIMARY KEY (id_areas_floracion);


--
-- TOC entry 2921 (class 2606 OID 18655)
-- Name: asociaciones asociaciones_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.asociaciones
    ADD CONSTRAINT asociaciones_pkey PRIMARY KEY (id_asociacion);


--
-- TOC entry 2923 (class 2606 OID 18657)
-- Name: categorias_posts categorias_posts_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.categorias_posts
    ADD CONSTRAINT categorias_posts_pkey PRIMARY KEY (id_categoria);


--
-- TOC entry 2947 (class 2606 OID 18818)
-- Name: detalle_produccion detalle_produccion_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.detalle_produccion
    ADD CONSTRAINT detalle_produccion_pkey PRIMARY KEY (id_apicultor, id_producto, id_detalle_produccion);


--
-- TOC entry 2929 (class 2606 OID 18659)
-- Name: posts posts_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.posts
    ADD CONSTRAINT posts_pkey PRIMARY KEY (id_post);


--
-- TOC entry 2943 (class 2606 OID 18769)
-- Name: productos productos_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_pkey PRIMARY KEY (id_producto);


--
-- TOC entry 2931 (class 2606 OID 18663)
-- Name: roles_usuario roles_usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.roles_usuario
    ADD CONSTRAINT roles_usuario_pkey PRIMARY KEY (id_rol);


--
-- TOC entry 2935 (class 2606 OID 18665)
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 2936 (class 1259 OID 18748)
-- Name: apicultores_fkindex1; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX apicultores_fkindex1 ON public.apicultores USING btree (id_asociacion);


--
-- TOC entry 2937 (class 1259 OID 18749)
-- Name: apicultores_fkindex2; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX apicultores_fkindex2 ON public.apicultores USING btree (id_usuario);


--
-- TOC entry 2914 (class 1259 OID 18667)
-- Name: archivos_posts_fkindex1; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX archivos_posts_fkindex1 ON public.archivos_posts USING btree (posts_id_post);


--
-- TOC entry 2944 (class 1259 OID 18829)
-- Name: detalle_produccion_fkindex1; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX detalle_produccion_fkindex1 ON public.detalle_produccion USING btree (id_apicultor);


--
-- TOC entry 2945 (class 1259 OID 18830)
-- Name: detalle_produccion_fkindex2; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX detalle_produccion_fkindex2 ON public.detalle_produccion USING btree (id_producto);


--
-- TOC entry 2940 (class 1259 OID 18751)
-- Name: ifk_rel_06; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX ifk_rel_06 ON public.apicultores USING btree (id_usuario);


--
-- TOC entry 2932 (class 1259 OID 18668)
-- Name: ifk_rel_07; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX ifk_rel_07 ON public.usuarios USING btree (id_rol);


--
-- TOC entry 2948 (class 1259 OID 18832)
-- Name: ifk_rel_08; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX ifk_rel_08 ON public.detalle_produccion USING btree (id_producto);


--
-- TOC entry 2924 (class 1259 OID 18669)
-- Name: ifk_rel_09; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX ifk_rel_09 ON public.posts USING btree (id_usuario);


--
-- TOC entry 2925 (class 1259 OID 18670)
-- Name: ifk_rel_10; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX ifk_rel_10 ON public.posts USING btree (id_categoria);


--
-- TOC entry 2917 (class 1259 OID 18671)
-- Name: ifk_rel_11; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX ifk_rel_11 ON public.archivos_posts USING btree (posts_id_post);


--
-- TOC entry 2941 (class 1259 OID 18750)
-- Name: ifk_rel_12; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX ifk_rel_12 ON public.apicultores USING btree (id_asociacion);


--
-- TOC entry 2949 (class 1259 OID 18831)
-- Name: ifk_rel_19; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX ifk_rel_19 ON public.detalle_produccion USING btree (id_apicultor);


--
-- TOC entry 2926 (class 1259 OID 18673)
-- Name: posts_fkindex2; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX posts_fkindex2 ON public.posts USING btree (id_usuario);


--
-- TOC entry 2927 (class 1259 OID 18674)
-- Name: posts_fkindex3; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX posts_fkindex3 ON public.posts USING btree (id_categoria);


--
-- TOC entry 2933 (class 1259 OID 18675)
-- Name: usuarios_fkindex1; Type: INDEX; Schema: public; Owner: -
--

CREATE INDEX usuarios_fkindex1 ON public.usuarios USING btree (id_rol);


--
-- TOC entry 2954 (class 2606 OID 18738)
-- Name: apicultores apicultores_id_asociacion_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.apicultores
    ADD CONSTRAINT apicultores_id_asociacion_fkey FOREIGN KEY (id_asociacion) REFERENCES public.asociaciones(id_asociacion);


--
-- TOC entry 2955 (class 2606 OID 18743)
-- Name: apicultores apicultores_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.apicultores
    ADD CONSTRAINT apicultores_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuarios(id_usuario);


--
-- TOC entry 2950 (class 2606 OID 18681)
-- Name: archivos_posts archivos_posts_posts_id_post_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.archivos_posts
    ADD CONSTRAINT archivos_posts_posts_id_post_fkey FOREIGN KEY (posts_id_post) REFERENCES public.posts(id_post);


--
-- TOC entry 2956 (class 2606 OID 18819)
-- Name: detalle_produccion detalle_produccion_id_apicultor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.detalle_produccion
    ADD CONSTRAINT detalle_produccion_id_apicultor_fkey FOREIGN KEY (id_apicultor) REFERENCES public.apicultores(id_apicultor);


--
-- TOC entry 2957 (class 2606 OID 18824)
-- Name: detalle_produccion detalle_produccion_id_producto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.detalle_produccion
    ADD CONSTRAINT detalle_produccion_id_producto_fkey FOREIGN KEY (id_producto) REFERENCES public.productos(id_producto);


--
-- TOC entry 2951 (class 2606 OID 18686)
-- Name: posts posts_id_categoria_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.posts
    ADD CONSTRAINT posts_id_categoria_fkey FOREIGN KEY (id_categoria) REFERENCES public.categorias_posts(id_categoria);


--
-- TOC entry 2952 (class 2606 OID 18691)
-- Name: posts posts_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.posts
    ADD CONSTRAINT posts_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuarios(id_usuario);


--
-- TOC entry 2953 (class 2606 OID 18696)
-- Name: usuarios usuarios_id_rol_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_id_rol_fkey FOREIGN KEY (id_rol) REFERENCES public.roles_usuario(id_rol);


-- Completed on 2021-06-22 09:58:13

--
-- PostgreSQL database dump complete
--

