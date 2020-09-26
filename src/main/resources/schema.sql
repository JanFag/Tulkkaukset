DROP TABLE tulkkaus;
DROP TABLE tulkkaustyyppi;
DROP TABLE tulkkauskieli;

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
pvm VARCHAR(30) NOT NULL

);



INSERT INTO tulkkauskieli (tulkkauskielennimi)
VALUES ("suomi"), ("englanti"), ("venäjä"), ("ranska"), ("ruotsi"), ("saksa");

INSERT INTO tulkkaustyyppi (tulkkaustyypinnimi)
VALUES ("Paikan päällä"), ("Puhelintulkkaus"), ("Videotulkkaus");

INSERT INTO tulkkaus (tilaaja, aihe, tulkkauspaikka, osoite, tulkkauskieli_id, tulkkaustyyppi_id, pvm)
VALUES ("Malmin neuvola", "lapsen 3v-tarkastus", "2.kerros, huone 3", "Talvelantie 4, 00700 Helsinki", 2, 1, "25.09.2020 kello 12:00");

SELECT * FROM tulkkaus;
SELECT * FROM tulkkauskieli;
SELECT * FROM tulkkaustyyppi;
