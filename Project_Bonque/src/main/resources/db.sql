PGDMP         *                y            postgres    13.1    13.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    13442    postgres    DATABASE     m   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United Kingdom.1252';
    DROP DATABASE postgres;
                postgres    false            �           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3030                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false            �           0    0 
   SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    4            �            1259    16516    acount    TABLE     }   CREATE TABLE public.acount (
    acount_id integer NOT NULL,
    acount_numero numeric,
    acount_solde double precision
);
    DROP TABLE public.acount;
       public         heap    postgres    false    4            �            1259    16514    acount_acount_id_seq    SEQUENCE     �   CREATE SEQUENCE public.acount_acount_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.acount_acount_id_seq;
       public          postgres    false    209    4            �           0    0    acount_acount_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.acount_acount_id_seq OWNED BY public.acount.acount_id;
          public          postgres    false    208            �            1259    16525    entr    TABLE     �   CREATE TABLE public.entr (
    entreprise_id integer NOT NULL,
    entreprise_type character varying(50),
    entreprise_nom character varying(50)
)
INHERITS (public.acount);
    DROP TABLE public.entreprise;
       public         heap    postgres    false    209    4            �            1259    16523    entr_entr_id_seq    SEQUENCE     �   CREATE SEQUENCE public.entr_entr_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.entr_entr_id_seq;
       public          postgres    false    4    211            �           0    0    entr_entr_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.entr_entr_id_seq OWNED BY public.entr.entr_id;
          public          postgres    false    210            �            1259    16535    pers    TABLE     �   CREATE TABLE public.pers (
    Persone_id integer NOT NULL,
    Persone_type character varying(50) DEFAULT 'Persone'::character varying,
    Persone_nom character varying(50),
    Persone_prenom character varying(50)
)
INHERITS (public.acount);
    DROP TABLE public.Persone;
       public         heap    postgres    false    4    209            �            1259    16533    pers_pers_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pers_pers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.pers_pers_id_seq;
       public          postgres    false    213    4            �           0    0    pers_pers_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.pers_pers_id_seq OWNED BY public.pers.pers_id;
          public          postgres    false    212            C           2604    16519    acount acount_id    DEFAULT     t   ALTER TABLE ONLY public.acount ALTER COLUMN acount_id SET DEFAULT nextval('public.acount_acount_id_seq'::regclass);
 ?   ALTER TABLE public.acount ALTER COLUMN acount_id DROP DEFAULT;
       public          postgres    false    208    209    209            D           2604    16528    entr acount_id    DEFAULT     r   ALTER TABLE ONLY public.entr ALTER COLUMN acount_id SET DEFAULT nextval('public.acount_acount_id_seq'::regclass);
 =   ALTER TABLE public.entr ALTER COLUMN acount_id DROP DEFAULT;
       public          postgres    false    208    211            E           2604    16529    entr entr_id    DEFAULT     l   ALTER TABLE ONLY public.entr ALTER COLUMN entr_id SET DEFAULT nextval('public.entr_entr_id_seq'::regclass);
 ;   ALTER TABLE public.entr ALTER COLUMN entr_id DROP DEFAULT;
       public          postgres    false    210    211    211            F           2604    16538    pers acount_id    DEFAULT     r   ALTER TABLE ONLY public.pers ALTER COLUMN acount_id SET DEFAULT nextval('public.acount_acount_id_seq'::regclass);
 =   ALTER TABLE public.pers ALTER COLUMN acount_id DROP DEFAULT;
       public          postgres    false    213    208            G           2604    16539    pers pers_id    DEFAULT     l   ALTER TABLE ONLY public.pers ALTER COLUMN pers_id SET DEFAULT nextval('public.pers_pers_id_seq'::regclass);
 ;   ALTER TABLE public.pers ALTER COLUMN pers_id DROP DEFAULT;
       public          postgres    false    213    212    213            �          0    16516    acount 
   TABLE DATA           H   COPY public.acount (acount_id, acount_numero, acount_solde) FROM stdin;
    public          postgres    false    209   �       �          0    16525    entr 
   TABLE DATA           d   COPY public.entr (acount_id, acount_numero, acount_solde, entr_id, entr_type, entr_nom) FROM stdin;
    public          postgres    false    211   �       �          0    16535    pers 
   TABLE DATA           q   COPY public.pers (acount_id, acount_numero, acount_solde, pers_id, pers_type, pers_nom, pers_prenom) FROM stdin;
    public          postgres    false    213   �       �           0    0    acount_acount_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.acount_acount_id_seq', 7, true);
          public          postgres    false    208            �           0    0    entr_entr_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.entr_entr_id_seq', 3, true);
          public          postgres    false    210            �           0    0    pers_pers_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.pers_pers_id_seq', 4, true);
          public          postgres    false    212            �   
   x������ � �      �   *   x�3�4153����zf�Ɯ1~�.��!�>F�\1z\\\ ��      �   6   x�3�46153�0735�2���9M8R����R9�32S29�s3��b���� 6�     