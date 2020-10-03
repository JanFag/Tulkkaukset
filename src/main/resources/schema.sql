DROP TABLE tulkkaus;
DROP TABLE tulkkaustyyppi;
DROP TABLE tulkkauskieli;
DROP TABLE user;

CREATE TABLE tulkkaustyyppi
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
tulkkaustyypinnimi VARCHAR(100) NOT NULL);


CREATE TABLE tulkkauskieli
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
tulkkauskielennimi VARCHAR(80) NOT NULL);

CREATE TABLE tulkkaus
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
tilaaja VARCHAR(200) NOT NULL,
aihe VARCHAR(400) NOT NULL,
tulkkauspaikka VARCHAR(200) NOT NULL,
osoite VARCHAR(100) NOT NULL,
pvm VARCHAR(30) NOT NULL,
tulkkauskieli_id BIGINT,
tulkkaustyyppi_id BIGINT

);


CREATE TABLE user
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
username VARCHAR(250) NOT NULL,
password VARCHAR(250) NOT NULL,
role VARCHAR(30) NOT NULL
);


INSERT INTO tulkkauskieli (tulkkauskielennimi)
VALUES ("italia"), ("englanti"), ("venäjä"), ("ranska"), ("ruotsi"), ("saksa");

INSERT INTO tulkkaustyyppi (tulkkaustyypinnimi)
VALUES ("Paikan päällä"), ("Puhelintulkkaus"), ("Videotulkkaus");

INSERT INTO tulkkaus (tilaaja, aihe, tulkkauspaikka, osoite, tulkkauskieli_id, tulkkaustyyppi_id, pvm)
VALUES ("Malmin neuvola", "lapsen 3v-tarkastus", "2.kerros, huone 3", "Talvelantie 4, 00700 Helsinki", 2, 1, "25.09.2020 kello 12:00");

INSERT INTO user (username, password, role) VALUES ("admin", "$2y$10$AxzWWo5GTqQdUMR5TN1/uOF2cvu3egzUvMlPoNIrtjwSSt1o8uZWK", "ADMIN");
INSERT INTO user (username, password, role) VALUES ("tulkki", "$2y$10$3paLnb6OMgPET27HzKyCZe/GjvgIUWPt4ezVhbcm9H0HGlAtDSBL.", "TULKKI");

SELECT * FROM tulkkaus;
SELECT * FROM tulkkauskieli;
SELECT * FROM tulkkaustyyppi;
SELECT * FROM user;
