
   -- COPY Users FROM SHOP B

INSERT INTO
hurtownia.uzytkownik(uzytkownik_id, plec)
SELECT id,
CASE płec
    WHEN 'M' THEN 'male'
   WHEN 'F' THEN 'female'
END plec
FROM sklepb_klient;

   -- COPY ADRES FROM SHOP B
INSERT INTO
hurtownia.adres(adres_id, kod_pocztowy, miasto, wojewodztwo)
SELECT id, kod_pocztowy, miejscowosc, wojewodztwo
FROM sklepb_adres; 

   -- COPY UZYTKOWNIK_ADRES FROM SHOP B
INSERT INTO
hurtownia.uzytkownik_adres(uzytkownik_id, adres_id)
SELECT id, adres_id
FROM sklepb_klient;

   -- COPY KATEGORIA FROM SHOP B
INSERT INTO
hurtownia.kategoria(kategoria_id, nazwa)
SELECT id, nazwa
FROM sklepb_kategoria;

    -- COPY PLATNOSC FROM SHOP B
INSERT INTO
hurtownia.platnosc(platnosc_id, typ, kwota)
SELECT id, rodzaj, 0
FROM sklepb_platnosc;

     -- COPY PRODUKT FROM SHOP B
INSERT INTO
hurtownia.produkt(produkt_id, nazwa, cena, kategoria_id)
SELECT id, nazwa, cena, (SELECT kategoria_id FROM sklepb_produkt p JOIN sklepb_kategoria_producent kp ON p.KATEGORIA_PRODUCENT_ID = kp.ID WHERE p.id = curr.id)
FROM sklepb_produkt curr; 

     -- COPY ZAMOWNIENIE FROM SHOP B
INSERT INTO
hurtownia.zamowienie(zamowienie_id, DATA_ZAM, kwota)
SELECT id, data_godzina, kwota
from SKLEPB_ZAMOWIENIE;

    -- COPY ZAMOWIENIE_PRODUKT FROM SHOP B
INSERT INTO
hurtownia.zamowienie_produkt(zamowienie_id, produkt_id, cena)
SELECT z.id, p.PRODUKT_ID, kwota
FROM SKLEPB_POZYCJA p JOIN SKLEPB_ZAMOWIENIE z ON p.ZAMOWIENIE_ID = z.id; 


   -- COPY ZAMOWIENIE_PLATNOSC FROM SHOP B
INSERT INTO
hurtownia.zamowienie_platnosc(zamowienie_id, platnosc_id)
SELECT id, platnosc_id
FROM SKLEPB_ZAMOWIENIE;

     -- COPY UZYTKOWNIK_ZAMOWIENIE FROM SHOP B
INSERT INTO
hurtownia.uzytkownik_zamowienie(uzytkownik_id, zamowienie_id)
SELECT klient_id, id
FROM sklepb_zamowienie; 


