-- BEGIN SCRIPT
BEGIN
   -- COPY USERS FROM SHOP A
INSERT INTO
hurtownia.uzytkownik(uzytkownik_id, email, plec)
SELECT (s1.uzytkownik_id + 10000000000), s1.email, s1.plec
FROM sklep.uzytkownik s1; -- tylko dla klienta

   -- COPY ADRES FROM SHOP A
INSERT INTO
hurtownia.adres(adres_id, kod_pocztowy, miasto, wojewodztwo)
SELECT (s1.adres_id + 10000000000), s1.kod_pocztowy, s1.miasto, s1.wojewodztwo
FROM sklep.adres s1;  

   -- COPY UZYTKOWNIK_ADRES FROM SHOP A
INSERT INTO
hurtownia.uzytkownik_adres(uzytkownik_id, adres_id)
SELECT (s1.uzytkownik_id + 10000000000), (adres_id + 10000000000)
FROM sklep.uzytkownik_adres s1;
   
   -- COPY KATEGORIA FROM SHOP A
INSERT INTO
hurtownia.kategoria(kategoria_id, nazwa)
SELECT (s1.kategoria_id + 10000000000), s1.nazwa
FROM sklep.kategoria s1;

    -- COPY PLATNOSC FROM SHOP A
INSERT INTO
hurtownia.platnosc(platnosc_id, typ, kwota)
SELECT (s1.platnosc_id + 10000000000), s1.typ, s1.kwota
FROM sklep.platnosc s1;  

     -- COPY PRODUKT FROM SHOP A
INSERT INTO
hurtownia.produkt(produkt_id, nazwa, cena, opis, kategoria_id)
SELECT (s1.produkt_id + 10000000000), s1.nazwa, s1.cena, s1.opis, (s1.kategoria_id + 10000000000)
FROM sklep.produkt s1; 

     -- COPY ZAMOWNIENIE FROM SHOP A
INSERT INTO
hurtownia.zamowienie(zamowienie_id, DATA_ZAM, kwota)
SELECT (s1.zamowienie_id + 10000000000), s1.DATA_ZAM, SUM(zp1.cena * zp1.ilosc) as "KWOTA"
FROM sklep.zamowienie s1 left join sklep.zamowienie_produkt zp1 on s1.zamowienie_id = zp1.zamowienie_id group by (s1.zamowienie_id + 10000000000), s1.DATA_ZAM; 

    -- COPY ZAMOWIENIE_PRODUKT FROM SHOP A
INSERT INTO
hurtownia.zamowienie_produkt(zamowienie_id, produkt_id, cena)
SELECT (s1.zamowienie_id + 10000000000), (s1.produkt_id + 10000000000), (s1.cena * s1.ilosc)
FROM sklep.zamowienie_produkt s1; 

	-- UPDATE ZAMOWNIENIE

-- BEGIN
   FOR cur_rec IN (SELECT s1.zamowienie_id, s1.cena FROM hurtownia.zamowienie_produkt s1 where s1.zamowienie_id > 10000000000)
   LOOP
		UPDATE hurtownia.zamowienie h1 set h1.kwota = cur_rec.cena where h1.zamowienie_id = cur_rec.zamowienie_id;
   END LOOP;
-- END;
-- /

   -- COPY ZAMOWIENIE_PLATNOSC FROM SHOP A
INSERT INTO
hurtownia.zamowienie_platnosc(zamowienie_id, platnosc_id)
SELECT (s1.zamowienie_id + 10000000000), (s1.platnosc_id + 10000000000)
FROM sklep.zamowienie_platnosc s1;

     -- COPY UZYTKOWNIK_ZAMOWIENIE FROM SHOP A
INSERT INTO
hurtownia.uzytkownik_zamowienie(uzytkownik_id, zamowienie_id)
SELECT (s1.uzytkownik_id + 10000000000), (s1.zamowienie_id + 10000000000)
FROM sklep.uzytkownik_zamowienie s1; 
   
END;
/