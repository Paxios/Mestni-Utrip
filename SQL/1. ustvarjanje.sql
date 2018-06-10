/* Brisanje tabel */
 
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS uporabnik;
DROP TABLE IF EXISTS Objekt;
-- DROP TABLE IF EXISTS Objekt_oc;
-- DROP TABLE IF EXISTS Veljavnost;
DROP TABLE IF EXISTS Dogodek;
DROP TABLE IF EXISTS Tip_objekta;
DROP TABLE IF EXISTS Tip_dogodka;
DROP TABLE IF EXISTS Tip_uporabnika;
DROP TABLE IF EXISTS Naslov;
DROP TABLE IF EXISTS Kraj;
-- DROP TABLE IF EXISTS Odpiralni_cas;
-- DROP TABLE IF EXISTS Tip_odpiralnega_casa;
DROP TABLE IF EXISTS Slika;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authorities;
/* Ustvarjanje tabel */

CREATE TABLE Slika (
Id_slika INTEGER NOT NULL,
Slika BLOB,
Fk_id_dogodek INTEGER NOT NULL);

ALTER TABLE Slika
ADD CONSTRAINT Pk_Slika PRIMARY KEY (Id_slika);

ALTER TABLE Slika
MODIFY COLUMN Id_slika INTEGER AUTO_INCREMENT;
 
CREATE TABLE Uporabnik(
Id_uporabnik INTEGER NOT NULL,
Uporabnisko_ime VARCHAR(45) NOT NULL,
Geslo VARCHAR(45) NOT NULL,
Lastnik VARCHAR(45) DEFAULT 0,
Mail VARCHAR(45) NOT NULL,
Fk_id_objekt INTEGER NOT NULL);
 
ALTER TABLE Uporabnik
ADD CONSTRAINT Pk_Uporabnik PRIMARY KEY (Id_uporabnik);
 
ALTER TABLE Uporabnik
MODIFY COLUMN Id_uporabnik INTEGER AUTO_INCREMENT;
 
-- CREATE TABLE Tip_uporabnika(
-- Id_tip_uporabnika INTEGER NOT NULL,
-- Naziv VARCHAR(45) NOT NULL);
--  
-- ALTER TABLE Tip_uporabnika
-- ADD CONSTRAINT Pk_tip_uporabnika PRIMARY KEY (Id_tip_uporabnika);
--  
-- ALTER TABLE Tip_uporabnika
-- MODIFY COLUMN Id_tip_uporabnika INTEGER AUTO_INCREMENT;
 
CREATE TABLE Objekt(
Id_objekt INTEGER NOT NULL,
Naziv VARCHAR(45) NOT NULL,
Fk_id_naslov INTEGER NOT NULL default 0,
Fk_id_tip_objekta INTEGER NOT NULL);
 
ALTER TABLE Objekt
ADD CONSTRAINT Pk_Objekt PRIMARY KEY (Id_objekt);
 
ALTER TABLE Objekt
MODIFY COLUMN Id_objekt INTEGER AUTO_INCREMENT;
 
CREATE TABLE Dogodek(
Id_dogodek INTEGER NOT NULL,
Naziv VARCHAR(45) NOT NULL,
vstopnina DOUBLE,
Kapaciteta INTEGER NOT NULL,
Opis VARCHAR(500) not null,
Datum_zacetka DATETIME NOT NULL,
Datum_konca DATETIME default 0,
Fk_id_objekt INTEGER NOT NULL,
Fk_id_tip_dogodka INTEGER NOT NULL,
fk_id_uporabnik INTEGER NOT NULL);
 
ALTER TABLE Dogodek
ADD CONSTRAINT Pk_Dogodek PRIMARY KEY (Id_dogodek);
 
ALTER TABLE Dogodek
MODIFY COLUMN Id_dogodek INTEGER AUTO_INCREMENT;
 
CREATE TABLE Tip_objekta(
Id_tip_objekta INTEGER NOT NULL,
Naziv VARCHAR(45) NOT NULL);
 
ALTER TABLE Tip_objekta
ADD CONSTRAINT Pk_Tip_objekta PRIMARY KEY (Id_tip_objekta);
 
ALTER TABLE Tip_objekta
MODIFY COLUMN Id_tip_objekta INTEGER AUTO_INCREMENT;
 
CREATE TABLE Tip_dogodka(
Id_tip_dogodka INTEGER NOT NULL,
Naziv VARCHAR(45) NOT NULL);
 
ALTER TABLE Tip_dogodka
ADD CONSTRAINT Pk_Tip_dogodka PRIMARY KEY (Id_tip_dogodka);
 
ALTER TABLE Tip_dogodka
MODIFY COLUMN Id_tip_dogodka INTEGER AUTO_INCREMENT;
 
 
CREATE TABLE Naslov(
Id_naslov INTEGER NOT NULL,
Z_sirina DOUBLE default 0,
Z_dolzina DOUBLE default 0,
Opis VARCHAR (100) default '',
Fk_id_kraj INTEGER NOT NULL);
 
ALTER TABLE Naslov
ADD CONSTRAINT Pk_Naslov PRIMARY KEY (Id_naslov);
 
ALTER TABLE Naslov
MODIFY COLUMN Id_naslov INTEGER AUTO_INCREMENT;
 
CREATE TABLE Kraj(
Id_kraj INTEGER NOT NULL,
Posta VARCHAR(45) NOT NULL,
Postna_stevilka INTEGER NOT NULL);
 
ALTER TABLE Kraj
ADD CONSTRAINT Pk_Kraj PRIMARY KEY (Id_kraj);
 
ALTER TABLE Kraj
MODIFY COLUMN Id_kraj INTEGER AUTO_INCREMENT;
 
-- /* Odpiralni cas */
-- 
-- CREATE TABLE Odpiralni_cas(
-- Id_odpiralniCas INTEGER NOT NULL,
-- Odpiralni_cas TIME NOT NULL,
-- Zapiralni_cas TIME NOT NULL,
-- Fk_tip_odpiralnega_casa INTEGER NOT NULL,
-- fk_veljavnost integer not null
-- );
-- ALTER TABLE Odpiralni_cas
-- ADD CONSTRAINT Pk_Odpiralni_cas PRIMARY KEY (Id_odpiralnicas);
-- 
-- ALTER TABLE Odpiralni_cas
-- MODIFY COLUMN Id_odpiralniCas INTEGER AUTO_INCREMENT;
-- 
-- 
-- /* Tip odpiralnega casa */
--  
-- CREATE TABLE Tip_odpiralnega_casa(
-- Id_tip_oc INTEGER NOT NULL,
-- Tip VARCHAR(45) NOT NULL
-- );
-- ALTER TABLE Tip_odpiralnega_casa
-- ADD CONSTRAINT Pk_odpiralni_cas PRIMARY KEY (Id_tip_oc);
--  
-- ALTER TABLE Tip_odpiralnega_casa
-- MODIFY COLUMN Id_tip_oc INTEGER auto_increment;
-- 
-- /* Veljavnost */
-- 
-- create table veljavnost (
-- id_veljavnost INTEGER NOT NULL,
-- VeljavnostOd date,
-- VeljavnostDo date 
-- );
-- alter table veljavnost
-- add constraint pk_veljavnost primary key (id_veljavnost);
-- 
-- alter table veljavnost
-- modify column id_veljavnost integer auto_increment;
--  
--  
 /* Users*/
create table users (
username varchar(50) not null,
password varchar(50) not null,
enabled boolean not null default true,
primary key (username) );
 
/*authorities*/
 create table authorities (
 username varchar(50) not null,
 authority varchar(50) not null default 'ROLE_ADMIN'
 );

 
 
 
 
 
 
/* Foreign keys */
 
/* Uporabnik */

ALTER TABLE Uporabnik
ADD CONSTRAINT Fk_uporabnik_id_objekt FOREIGN KEY
(Fk_id_objekt) REFERENCES Objekt(Id_objekt);

/* Objekt */

ALTER TABLE Objekt
ADD CONSTRAINT Fk_objekt_id_naslov FOREIGN KEY
(Fk_id_naslov) REFERENCES Naslov(Id_naslov);
 
ALTER TABLE Objekt
ADD CONSTRAINT Fk_objekt_id_tip_objekta FOREIGN KEY
(Fk_id_tip_objekta) REFERENCES Tip_objekta(Id_tip_objekta);
 
/* Naslov */
ALTER TABLE Naslov
ADD CONSTRAINT Fk_naslov_id_kraj FOREIGN KEY
(Fk_id_kraj) REFERENCES Kraj(Id_kraj);
 
/* Dogodek */
ALTER TABLE Dogodek
ADD CONSTRAINT Fk_dogodek_id_objekt FOREIGN KEY
(Fk_id_objekt) REFERENCES Objekt(Id_objekt);
 
ALTER TABLE Dogodek
ADD CONSTRAINT Fk_dogodek_id_tip_dogodka FOREIGN KEY
(Fk_id_tip_dogodka) REFERENCES Tip_dogodka(Id_tip_dogodka);
 
 
/* Slika */
 ALTER TABLE Slika
 ADD CONSTRAINT Fk_slika_id_dogodek FOREIGN KEY
 (Fk_id_dogodek) REFERENCES Dogodek(Id_dogodek);
 -- 
-- /* Odpiralni cas */
-- 
-- ALTER TABLE Odpiralni_cas
-- ADD CONSTRAINT Fk_odpiralni_cas_tip FOREIGN KEY
-- (Fk_tip_odpiralnega_casa) REFERENCES Tip_OdpiralnegaCasa(Id_tip_oc);
-- 
-- ALTER TABLE odpiralni_cas
-- ADD CONSTRAINT fk_odpiralni_cas_veljavnost FOREIGN KEY
-- (fk_veljavnost) REFERENCES veljavnost(id_veljavnost);
-- 
/*FK_id_uporabnik pri Dogodku*/
Alter table Dogodek
add constraint fk_uprabnik_dogodek foreign key
(fk_id_uporabnik) references uporabnik(id_uporabnik);

/*Authories*/
ALTER TABLE authorities add constraint user_role 
foreign key  (username) references users(username);