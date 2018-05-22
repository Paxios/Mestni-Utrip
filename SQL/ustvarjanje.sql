/* Ustvarjanje tabel */
 
CREATE TABLE Uporabnik(
Id_uporabnik INTEGER NOT NULL,
Uporabnisko_ime VARCHAR(45) NOT NULL,
Geslo VARCHAR(45) NOT NULL,
Ime VARCHAR(45) NOT NULL,
Priimek VARCHAR(45) NOT NULL,
Mail VARCHAR(45) NOT NULL,
Fk_id_tip_uporabnika INTEGER NOT NULL,
Fk_id_objekt INTEGER NOT NULL);
 
ALTER TABLE Uporabnik
ADD CONSTRAINT Pk_Uporabnik PRIMARY KEY (Id_uporabnik);
 
ALTER TABLE Uporabnik
MODIFY COLUMN Id_uporabnik INTEGER AUTO_INCREMENT;
 
CREATE TABLE Tip_uporabnika(
Id_tip_uporabnika INTEGER NOT NULL,
Naziv VARCHAR(45) NOT NULL);
 
ALTER TABLE Tip_uporabnika
ADD CONSTRAINT Pk_tip_uporabnika PRIMARY KEY (Id_tip_uporabnika);
 
ALTER TABLE Tip_uporabnika
MODIFY COLUMN Id_tip_uporabnika INTEGER AUTO_INCREMENT;
 
CREATE TABLE Objekt(
Id_objekt INTEGER NOT NULL,
Naziv VARCHAR(45) NOT NULL,
Fk_id_naslov INTEGER NOT NULL default 0
);
 
ALTER TABLE Objekt
ADD CONSTRAINT Pk_Objekt PRIMARY KEY (Id_objekt);
 
ALTER TABLE Objekt
MODIFY COLUMN Id_objekt INTEGER AUTO_INCREMENT;
 
CREATE TABLE Dogodek(
Id_dogodek INTEGER NOT NULL,
Naziv VARCHAR(45) NOT NULL,
vstopnina DECIMAL,
Kapaciteta INTEGER NOT NULL,
Opis VARCHAR(500),
Fk_id_objekt INTEGER NOT NULL,
Fk_id_tip_dogodka INTEGER NOT NULL,
Fk_id_datum_dogodka INTEGER NOT NULL);
 
ALTER TABLE Dogodek
ADD CONSTRAINT Pk_Dogodek PRIMARY KEY (Id_dogodek);
 
ALTER TABLE Dogodek
MODIFY COLUMN Id_dogodek INTEGER AUTO_INCREMENT;
 
CREATE TABLE Tip_dogodka(
Id_tip_dogodka INTEGER NOT NULL,
Naziv VARCHAR(45) NOT NULL);
 
ALTER TABLE Tip_dogodka
ADD CONSTRAINT Pk_Tip_dogodka PRIMARY KEY (Id_tip_dogodka);
 
ALTER TABLE Tip_dogodka
MODIFY COLUMN Id_tip_dogodka INTEGER AUTO_INCREMENT;
 
CREATE TABLE Datum_dogodka(
Id_datum_dogodka INTEGER NOT NULL,
Datum_zacetka DATETIME NOT NULL,
Datum_konca DATETIME NOT NULL);
 
ALTER TABLE Datum_dogodka
ADD CONSTRAINT Pk_Datum_dogodka PRIMARY KEY (Id_datum_dogodka);
 
ALTER TABLE Datum_dogodka
MODIFY COLUMN Id_datum_dogodka INTEGER AUTO_INCREMENT;
 
CREATE TABLE Naslov(
Id_naslov INTEGER NOT NULL,
Ulica VARCHAR(45) NOT NULL,
Hisna_stevilka VARCHAR(45) NOT NULL,
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

/* Odpiralni cas */

CREATE TABLE Odpiralni_cas(
Id_odpiralniCas INTEGER NOT NULL,
Odpiralni_cas TIME NOT NULL,
Zapiralni_cas TIME NOT NULL,
Veljavnost_od TIME NOT NULL,
Veljavnost_do TIME NOT NULL,
Fk_tip_odpiralnega_casa INTEGER NOT NULL,
Fk_objekt INTEGER NOT NULL
);
ALTER TABLE Odpiralni_cas
ADD CONSTRAINT Pk_Odpiralni_cas PRIMARY KEY (Id_odpiralnicas);

ALTER TABLE Odpiralni_cas
MODIFY COLUMN Id_odpiralniCas INTEGER AUTO_INCREMENT;

/* Tip odpiralnega casa */
 
CREATE TABLE Tip_odpiralnega_casa(
Id_tip_oc INTEGER NOT NULL,
Tip VARCHAR(45) NOT NULL
);
ALTER TABLE Tip_odpiralnega_casa
ADD CONSTRAINT Pk_odpiralni_cas PRIMARY KEY (Id_tip_oc);

ALTER TABLE Tip_odpiralnega_casa
MODIFY COLUMN Id_tip_oc INTEGER auto_increment;
 
 
/* Foreign keys */
 
/* Uporabnik */
ALTER TABLE Uporabnik
ADD CONSTRAINT Fk_uporabnik_id_tip_uporabnika FOREIGN KEY
(Fk_id_tip_uporabnika) REFERENCES Tip_prodajalca(Id_tip_prodajalca);
 
ALTER TABLE Uporabnik
ADD CONSTRAINT Fk_uporabnik_id_objekt FOREIGN KEY
(Fk_id_objekt) REFERENCES Objekt(Id_objekt);
 
/* Objekt */
ALTER TABLE Objekt
ADD CONSTRAINT Fk_objekt_id_naslov FOREIGN KEY
(Fk_id_naslov) REFERENCES Naslov(Id_naslov);
 
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
 
ALTER TABLE Dogodek
ADD CONSTRAINT Fk_dogodek_datum_dogodka FOREIGN KEY
(Fk_id_datum_dogodka) REFERENCES Dogodek(Id_dogodek);

/* Odpiralni cas */

ALTER TABLE Odpiralni_cas
ADD CONSTRAINT Fk_odpiralni_cas_tip FOREIGN KEY
(Fk_tip_odpiralnega_casa) REFERENCES Tip_OdpiralnegaCasa(Id_tip_oc);

ALTER TABLE Odpiralni_cas
ADD CONSTRAINT Fk_odpiralni_cas_objekt FOREIGN KEY
(Fk_objekt) REFERENCES Objekt(Id_objekt);