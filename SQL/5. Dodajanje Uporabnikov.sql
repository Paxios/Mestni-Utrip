insert into uporabnik (Uporabnisko_ime, geslo, lastnik, mail, Fk_id_objekt)
values ('McPekarna', 'McPekarna123!', 'Kulturno društvo Mladinski center IndiJanez', '', 2);

insert into uporabnik (Uporabnisko_ime, geslo, lastnik, mail, Fk_id_objekt)
values ('Klub Mariborskih Studentov', 'KmariborskihS123!', 'Tim Gumilar' , 'info@klub-kms.si', 3);

insert into uporabnik (Uporabnisko_ime, geslo, lastnik, mail, Fk_id_objekt)
values ('stuk', 'Stuk123!', 'Miroslav Sarkicevic', 'tehnika@stuk.si', 4);

insert into uporabnik (Uporabnisko_ime, geslo, lastnik, mail, Fk_id_objekt)
values ('TakosLent', 'Takoslent123!', 'Ivan Dobaj', 'info@takos.si', 5);

/*5*/
insert into uporabnik (Uporabnisko_ime, geslo, lastnik, mail, Fk_id_objekt)
values ('lacantina', 'lacantina123!', 'Domen Fatur', 'info@la-cantina.si', 1),
/*6*/
('sngmb','sngmb123!','Danilo Rošker','danilo.rosker@sng-mb.si',33),
/*7*/
('Mestnimaribor','Mestnimaribor123!','Andrej Fištravec','mestna.obcina@maribor.si',23),
/*8*/
('rozmarin','rozmarin123!','Saša Arsenovič','rozmarin@rozmarin.si',17),

('lentmaribor','lentmaribor123!','Andrej Fištravec','mestna.obcina@maribor.si',43),
/*10*/
('Pohorjemaribor','pohorjemaribor123!','Andrej Fištravec','mestna.obcina@maribor.si',51),

('stukeljmaribor','stukeljmaribor123!','Andrej Fištravec','mestna.obcina@maribor.si',49),

('trust','trust123!','neznan','info@trust.si',6),

('ljudskivrt','ljudskivrt123!','Občina Maribor','INFO@SOMB.SI',46);

insert into users values 
('mcpekarna','mcpekarna123!',1),
('lacantina','lacantina123!',1),
('stuk','stuk123!',1),
('sngmb','sngmb123!',1),
('Klub Mariborskih Studentov','KmariborskihS123',1),
('TakosLent','Takoslent123!',1),
('Mestnimaribor','Mestnimaribor123!',1),
('rozmarin','rozmarin123!',1),
('lentmaribor','pohorjemaribor123!',1),
('Pohorjemaribor','pohorjemaribor123!',1),
('stukeljmaribor','stukeljmaribor123!',1),
('trust','trust123!',1),
('ljudskivrt','ljudskivrt123!',1)
;

insert into authorities values 
('mcpekarna','ROLE_ADMIN'),
('lacantina','ROLE_ADMIN'),
('stuk','ROLE_ADMIN'),
('sngmb','ROLE_ADMIN'),
('Klub Mariborskih Studentov','ROLE_ADMIN'),
('TakosLent','ROLE_ADMIN'),
('Mestnimaribor','ROLE_ADMIN'),
('rozmarin','ROLE_ADMIN'),
('Pohorjemaribor','ROLE_ADMIN'),
('stukeljmaribor','ROLE_ADMIN'),
('lentmaribor','ROLE_ADMIN'),
('trust','ROLE_ADMIN'),
('ljudskivrt','ROLE_ADMIN');