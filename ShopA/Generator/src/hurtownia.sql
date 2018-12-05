CREATE TABLE `Produkt` (
  `id`                     int(10) NOT NULL AUTO_INCREMENT, 
  `kategoria_producent_id` int(10) NOT NULL, 
  `opis`                   varchar(1024), 
  `nazwa`                  varchar(255), 
  `cena`                   int(10), 
  PRIMARY KEY (`id`)) type=InnoDB;
CREATE TABLE `Klient` (
  `id`            int(10) NOT NULL AUTO_INCREMENT, 
  `adres_id`      int(10) NOT NULL, 
  `kontakt_id`    int(10) NOT NULL UNIQUE, 
  `rodzaj`        varchar(255) NOT NULL, 
  `zgody_id`      int(10) NOT NULL, 
  `NIP`           varchar(10), 
  `płec`          varchar(1), 
  `rok urodzenia` int(10), 
  PRIMARY KEY (`id`)) type=InnoDB;
CREATE TABLE `Kategoria` (
  `id`    int(10) NOT NULL AUTO_INCREMENT, 
  `nazwa` varchar(255) NOT NULL, 
  `opis`  varchar(255), 
  PRIMARY KEY (`id`)) type=InnoDB;
CREATE TABLE `Producent` (
  `id`    int(10) NOT NULL AUTO_INCREMENT, 
  `nazwa` varchar(255) NOT NULL, 
  `opis`  varchar(255), 
  PRIMARY KEY (`id`)) type=InnoDB;
CREATE TABLE `Adres` (
  `id`           int(10) NOT NULL AUTO_INCREMENT, 
  `ulica`        varchar(255) NOT NULL, 
  `nr_domu`      varchar(10) NOT NULL, 
  `miejscowosc`  varchar(255) NOT NULL, 
  `kod_pocztowy` varchar(8) NOT NULL, 
  `wojewodztwo`  varchar(255) NOT NULL, 
  `kraj`         varchar(255) NOT NULL, 
  PRIMARY KEY (`id`)) type=InnoDB;
CREATE TABLE `Kontakt` (
  `id`       int(10) NOT NULL AUTO_INCREMENT, 
  `email`    varchar(255), 
  `telefon1` varchar(255), 
  `telefon2` varchar(255), 
  PRIMARY KEY (`id`)) type=InnoDB;
CREATE TABLE `Zgody_marketingowe` (
  `id`          int(10) NOT NULL AUTO_INCREMENT, 
  `zgoda_sms`   tinyint(1) NOT NULL, 
  `zgoda_tel`   tinyint(1) NOT NULL, 
  `zgoda_email` tinyint(1) NOT NULL, 
  PRIMARY KEY (`id`)) type=InnoDB;
CREATE TABLE `Zamowienie` (
  `id`           int(10) NOT NULL AUTO_INCREMENT, 
  `data_godzina` timestamp NOT NULL, 
  `klient_id`    int(10) NOT NULL, 
  `platnosc_id`  int(10) NOT NULL, 
  `przesylka_id` int(10) NOT NULL, 
  `kwota`        int(10) NOT NULL, 
  PRIMARY KEY (`id`)) type=InnoDB;
CREATE TABLE `Pracownik` (
  `id`         int(10) NOT NULL AUTO_INCREMENT, 
  `adres_id`   int(10) NOT NULL, 
  `kontakt_id` int(10) NOT NULL, 
  `pensja`     int(10), 
  PRIMARY KEY (`id`)) type=InnoDB;
CREATE TABLE `Przesylka` (
  `id`     int(10) NOT NULL AUTO_INCREMENT, 
  `rodzaj` varchar(255), 
  `cena`   int(10), 
  PRIMARY KEY (`id`)) type=InnoDB;
CREATE TABLE `Pozycja` (
  `id`            int(10) NOT NULL AUTO_INCREMENT, 
  `produkt_id`    int(10) NOT NULL, 
  `zamowienie_id` int(10) NOT NULL, 
  `cena_zakupu`   int(10) NOT NULL, 
  `podatek VAT`   int(10) NOT NULL, 
  PRIMARY KEY (`id`)) type=InnoDB;
CREATE TABLE `Platnosc` (
  `id`           int(10) NOT NULL AUTO_INCREMENT, 
  `data_godzina` timestamp NOT NULL, 
  `rodzaj`       varchar(255) NOT NULL, 
  `kwota`        int(10) NOT NULL, 
  PRIMARY KEY (`id`)) type=InnoDB;
CREATE TABLE `Reklamacja` (
  `id`         int(10) NOT NULL AUTO_INCREMENT, 
  `klient_id`  int(10) NOT NULL, 
  `produkt_id` int(10) NOT NULL, 
  `data`       int(10) NOT NULL, 
  `opis`       int(10) NOT NULL, 
  PRIMARY KEY (`id`)) type=InnoDB;
CREATE TABLE `Promocja` (
  `id`             int(10) NOT NULL AUTO_INCREMENT, 
  `od`             date NOT NULL, 
  `do`             date NOT NULL, 
  `produkt_id`     int(10) NOT NULL, 
  `procent_znizki` int(2) NOT NULL, 
  PRIMARY KEY (`id`)) type=InnoDB;
CREATE TABLE `Kategoria_producent` (
  `id`           int(10) NOT NULL AUTO_INCREMENT, 
  `kategoria_id` int(10) NOT NULL, 
  `producent_id` int(10) NOT NULL, 
  PRIMARY KEY (`id`)) type=InnoDB;
ALTER TABLE `Klient` ADD INDEX `FKKlient765827` (`adres_id`), ADD CONSTRAINT `FKKlient765827` FOREIGN KEY (`adres_id`) REFERENCES `Adres` (`id`);
ALTER TABLE `Klient` ADD INDEX `FKKlient592247` (`kontakt_id`), ADD CONSTRAINT `FKKlient592247` FOREIGN KEY (`kontakt_id`) REFERENCES `Kontakt` (`id`);
ALTER TABLE `Klient` ADD INDEX `FKKlient93750` (`zgody_id`), ADD CONSTRAINT `FKKlient93750` FOREIGN KEY (`zgody_id`) REFERENCES `Zgody_marketingowe` (`id`);
ALTER TABLE `Produkt` ADD INDEX `FKProdukt619681` (`kategoria_producent_id`), ADD CONSTRAINT `FKProdukt619681` FOREIGN KEY (`kategoria_producent_id`) REFERENCES `Kategoria_producent` (`id`);
ALTER TABLE `Kategoria_producent` ADD INDEX `FKKategoria_532776` (`kategoria_id`), ADD CONSTRAINT `FKKategoria_532776` FOREIGN KEY (`kategoria_id`) REFERENCES `Kategoria` (`id`);
ALTER TABLE `Kategoria_producent` ADD INDEX `FKKategoria_953431` (`producent_id`), ADD CONSTRAINT `FKKategoria_953431` FOREIGN KEY (`producent_id`) REFERENCES `Producent` (`id`);
ALTER TABLE `Promocja` ADD INDEX `FKPromocja374238` (`produkt_id`), ADD CONSTRAINT `FKPromocja374238` FOREIGN KEY (`produkt_id`) REFERENCES `Produkt` (`id`);
ALTER TABLE `Pozycja` ADD INDEX `FKPozycja671541` (`produkt_id`), ADD CONSTRAINT `FKPozycja671541` FOREIGN KEY (`produkt_id`) REFERENCES `Produkt` (`id`);
ALTER TABLE `Pozycja` ADD INDEX `FKPozycja651478` (`zamowienie_id`), ADD CONSTRAINT `FKPozycja651478` FOREIGN KEY (`zamowienie_id`) REFERENCES `Zamowienie` (`id`);
ALTER TABLE `Zamowienie` ADD INDEX `FKZamowienie20279` (`klient_id`), ADD CONSTRAINT `FKZamowienie20279` FOREIGN KEY (`klient_id`) REFERENCES `Klient` (`id`);
ALTER TABLE `Zamowienie` ADD INDEX `FKZamowienie892571` (`platnosc_id`), ADD CONSTRAINT `FKZamowienie892571` FOREIGN KEY (`platnosc_id`) REFERENCES `Platnosc` (`id`);
ALTER TABLE `Zamowienie` ADD INDEX `FKZamowienie655771` (`przesylka_id`), ADD CONSTRAINT `FKZamowienie655771` FOREIGN KEY (`przesylka_id`) REFERENCES `Przesylka` (`id`);
ALTER TABLE `Pracownik` ADD INDEX `FKPracownik18141` (`adres_id`), ADD CONSTRAINT `FKPracownik18141` FOREIGN KEY (`adres_id`) REFERENCES `Adres` (`id`);
ALTER TABLE `Pracownik` ADD INDEX `FKPracownik844560` (`kontakt_id`), ADD CONSTRAINT `FKPracownik844560` FOREIGN KEY (`kontakt_id`) REFERENCES `Kontakt` (`id`);
ALTER TABLE `Reklamacja` ADD INDEX `FKReklamacja236409` (`klient_id`), ADD CONSTRAINT `FKReklamacja236409` FOREIGN KEY (`klient_id`) REFERENCES `Klient` (`id`);
ALTER TABLE `Reklamacja` ADD INDEX `FKReklamacja959111` (`produkt_id`), ADD CONSTRAINT `FKReklamacja959111` FOREIGN KEY (`produkt_id`) REFERENCES `Produkt` (`id`);
