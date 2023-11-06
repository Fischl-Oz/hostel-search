--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: maindb-schema; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA "maindb-schema";


ALTER SCHEMA "maindb-schema" OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.account (
    user_id bigint NOT NULL,
    date_signup date NOT NULL,
    full_name character varying(50) NOT NULL,
    user_name character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    phone character varying(11),
    email character varying(150),
    user_type character varying(20) NOT NULL,
    user_image character varying(250),
    CONSTRAINT user_id_constraint CHECK (((user_id >= 80000000) AND (user_id <= 89999999)))
);


ALTER TABLE public.account OWNER TO postgres;

--
-- Name: account_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.account_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.account_user_id_seq OWNER TO postgres;

--
-- Name: account_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.account_user_id_seq OWNED BY public.account.user_id;


--
-- Name: admin; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.admin (
    user_id bigint NOT NULL
);


ALTER TABLE public.admin OWNER TO postgres;

--
-- Name: city; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.city (
    city_id character varying(7) NOT NULL,
    city_name character varying(30) NOT NULL,
    CONSTRAINT city_id_constraint CHECK (((city_id)::text ~ similar_to_escape('CT-[0-9]{4}'::text)))
);


ALTER TABLE public.city OWNER TO postgres;

--
-- Name: district; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.district (
    district_id character varying(7) NOT NULL,
    district_name character varying(30) NOT NULL,
    city_id character varying(7) NOT NULL,
    CONSTRAINT district_id_constraint CHECK (((district_id)::text ~ similar_to_escape('DT-[0-9]{4}'::text)))
);


ALTER TABLE public.district OWNER TO postgres;

--
-- Name: hostel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hostel (
    hostel_id bigint NOT NULL,
    hostel_name character varying(150) NOT NULL,
    hostel_addr character varying(300) NOT NULL,
    hostel_desc character varying(2000),
    price integer NOT NULL,
    area real NOT NULL,
    total_room smallint,
    available_room smallint,
    district_id character varying(7) NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT hostel_id_constraint CHECK (((hostel_id >= 70000000) AND (hostel_id <= 79999999)))
);


ALTER TABLE public.hostel OWNER TO postgres;

--
-- Name: hostel_hostel_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hostel_hostel_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.hostel_hostel_id_seq OWNER TO postgres;

--
-- Name: hostel_hostel_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.hostel_hostel_id_seq OWNED BY public.hostel.hostel_id;


--
-- Name: hostelmaster; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hostelmaster (
    user_id bigint NOT NULL,
    hm_addr character varying(300) NOT NULL,
    cccd_front character varying(200) NOT NULL,
    cccd_back character varying(200) NOT NULL,
    hbc character varying(200) NOT NULL,
    status character varying(50)
);


ALTER TABLE public.hostelmaster OWNER TO postgres;

--
-- Name: img; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.img (
    img_id bigint NOT NULL,
    img_name character varying(250) NOT NULL,
    img_uri character varying(200) NOT NULL,
    img_desc character varying(350),
    user_id bigint NOT NULL,
    hostel_id bigint,
    CONSTRAINT img_id_constraint CHECK (((img_id >= 10000000) AND (img_id <= 29999999)))
);


ALTER TABLE public.img OWNER TO postgres;

--
-- Name: imginventory_img_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.imginventory_img_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.imginventory_img_id_seq OWNER TO postgres;

--
-- Name: imginventory_img_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.imginventory_img_id_seq OWNED BY public.img.img_id;


--
-- Name: post; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.post (
    post_id bigint NOT NULL,
    post_title character varying(100) NOT NULL,
    post_date timestamp without time zone NOT NULL,
    post_content text NOT NULL,
    post_status character varying(20) DEFAULT 'pending'::character varying,
    hostel_id bigint NOT NULL,
    CONSTRAINT post_id_constraint CHECK (((post_id >= 60000000) AND (post_id <= 69999999)))
);


ALTER TABLE public.post OWNER TO postgres;

--
-- Name: posttag; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.posttag (
    tag_id character varying(7) NOT NULL,
    post_id bigint NOT NULL
);


ALTER TABLE public.posttag OWNER TO postgres;

--
-- Name: tag; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tag (
    tag_id character varying(7) NOT NULL,
    tag_txt character varying(50) NOT NULL,
    CONSTRAINT tag_id_constraint CHECK (((tag_id)::text ~ similar_to_escape('TAG-[0-9]{3}'::text)))
);


ALTER TABLE public.tag OWNER TO postgres;

--
-- Name: account user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account ALTER COLUMN user_id SET DEFAULT nextval('public.account_user_id_seq'::regclass);


--
-- Name: hostel hostel_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hostel ALTER COLUMN hostel_id SET DEFAULT nextval('public.hostel_hostel_id_seq'::regclass);


--
-- Name: img img_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.img ALTER COLUMN img_id SET DEFAULT nextval('public.imginventory_img_id_seq'::regclass);


--
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.account (user_id, date_signup, full_name, user_name, password, phone, email, user_type, user_image) FROM 'account_data.txt' DELIMITER E'\t';



--
-- Data for Name: admin; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.admin (user_id) FROM 'admin_data.txt' DELIMITER E'\t';


--
-- Data for Name: city; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.city (city_id, city_name) FROM 'city_data.txt' DELIMITER E'\t';



--
-- Data for Name: district; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.district (district_id, district_name, city_id) FROM 'district_data.txt' DELIMITER E'\t';



--
-- Data for Name: hostel; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hostel (hostel_id, hostel_name, hostel_addr, hostel_desc, price, area, total_room, available_room, district_id, user_id) FROM 'hostel_data.txt' DELIMITER E'\t';



--
-- Data for Name: hostelmaster; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hostelmaster (user_id, hm_addr, cccd_front, cccd_back, hbc, status) FROM 'hostelmaster_data.txt' DELIMITER E'\t';



--
-- Data for Name: img; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.img (img_id, img_name, img_uri, img_desc, user_id, hostel_id) FROM 'img_data.txt' DELIMITER E'\t';



--
-- Data for Name: post; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.post (post_id, post_title, post_date, post_content, post_status, hostel_id) FROM 'post_data.txt' DELIMITER E'\t';



--
-- Data for Name: posttag; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.posttag (tag_id, post_id) FROM 'posttag_data.txt' DELIMITER E'\t';



--
-- Data for Name: tag; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tag (tag_id, tag_txt) FROM 'tag_data.txt' DELIMITER E'\t';



--
-- Name: account_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.account_user_id_seq', 80000001, true);


--
-- Name: hostel_hostel_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hostel_hostel_id_seq', 1, true);


--
-- Name: imginventory_img_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.imginventory_img_id_seq', 10000000, false);


--
-- Name: account account_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_email_key UNIQUE (email);


--
-- Name: account account_phone_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_phone_key UNIQUE (phone);


--
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (user_id);


--
-- Name: account account_user_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_user_name_key UNIQUE (user_name);


--
-- Name: city city_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.city
    ADD CONSTRAINT city_pkey PRIMARY KEY (city_id);


--
-- Name: district district_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.district
    ADD CONSTRAINT district_pkey PRIMARY KEY (district_id);

ALTER TABLE public.district CLUSTER ON district_pkey;


--
-- Name: hostel hostel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hostel
    ADD CONSTRAINT hostel_pkey PRIMARY KEY (hostel_id);


--
-- Name: img imginventory_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.img
    ADD CONSTRAINT imginventory_pkey PRIMARY KEY (img_id);


--
-- Name: post post_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post
    ADD CONSTRAINT post_pkey PRIMARY KEY (post_id);


--
-- Name: tag taglibary_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tag
    ADD CONSTRAINT taglibary_pkey PRIMARY KEY (tag_id);


--
-- Name: hostelmaster_user_id_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX hostelmaster_user_id_idx ON public.hostelmaster USING btree (user_id);


--
-- Name: admin admin_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.account(user_id);


--
-- Name: district district_city_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.district
    ADD CONSTRAINT district_city_id_fkey FOREIGN KEY (city_id) REFERENCES public.city(city_id);


--
-- Name: hostel hostel_district_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hostel
    ADD CONSTRAINT hostel_district_id_fkey FOREIGN KEY (district_id) REFERENCES public.district(district_id);


--
-- Name: hostel hostel_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hostel
    ADD CONSTRAINT hostel_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.hostelmaster(user_id);


--
-- Name: hostelmaster hostelmaster_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hostelmaster
    ADD CONSTRAINT hostelmaster_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.account(user_id);


--
-- Name: img img_hostel_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.img
    ADD CONSTRAINT img_hostel_id_fkey FOREIGN KEY (hostel_id) REFERENCES public.hostel(hostel_id);


--
-- Name: img img_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.img
    ADD CONSTRAINT img_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.account(user_id);


--
-- Name: post post_hostel_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post
    ADD CONSTRAINT post_hostel_id_fkey FOREIGN KEY (hostel_id) REFERENCES public.hostel(hostel_id);


--
-- Name: posttag posttag_post_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.posttag
    ADD CONSTRAINT posttag_post_id_fkey FOREIGN KEY (post_id) REFERENCES public.post(post_id);


--
-- Name: posttag posttag_tag_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.posttag
    ADD CONSTRAINT posttag_tag_id_fkey FOREIGN KEY (tag_id) REFERENCES public.tag(tag_id);


--
-- Name: TABLE hostelmaster; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.hostelmaster TO "TrThanh";


--
-- Name: DEFAULT PRIVILEGES FOR TABLES; Type: DEFAULT ACL; Schema: -; Owner: postgres
--

ALTER DEFAULT PRIVILEGES FOR ROLE postgres GRANT ALL ON TABLES TO "TrThanh";


--
-- PostgreSQL database dump complete
--

