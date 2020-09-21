DROP TABLE Tulkkaus;
DROP TABLE Tulkkaustyyppi;
DROP TABLE Tulkkauskieli;

CREATE TABLE Tulkkaus
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
tilaaja VARCHAR(200) NOT NULL,
aihe VARCHAR(400) NOT NULL,
tulkkauspaikka VARCHAR(200) NOT NULL,
osoite VARCHAR(100) NOT NULL,
tulkkauskieli_id BIGINT,
tulkkaustyyppi_id BIGINT,
pvm VARCHAR(20));

CREATE TABLE Tulkkaustyyppi
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
tulkkaustyyppi VARCHAR(100) NOT NULL);


CREATE TABLE Tulkkauskieli
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
tulkkauskieli VARCHAR(80) NOT NULL);

INSERT INTO Tulkkaus (tilaaja, aihe, osoite, tulkkauskieli_id, tulkkaustyyppi_is, pvm)
VALUES ('Malmin neuvola', 'lapsen 3v-tarkastus', 'Talvelantie 4, 00700 Helsinki', 2, 1, '25.09.2020 kello 12:00');

SELECT * FROM Tulkkaus;
SELECT * FROM Tulkkauskieli;
SELECT * FROM Tulkkaustyyppi;
