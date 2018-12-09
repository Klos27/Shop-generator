-- BEGIN SCRIPT
BEGIN
   -- COPY USERS FROM HURTOWNIA
INSERT INTO
warehouse.uzytkownik(uzytkownik_id, plec, kod_pocztowy, miasto, wojewodztwo)
SELECT h.uzytkownik_id, h.plec, a.kod_pocztowy, a.miasto, a.wojewodztwo 
FROM hurtownia.uzytkownik h left join hurtownia.uzytkownik_adres ua on h.uzytkownik_id = ua.uzytkownik_id left join hurtownia.adres a on ua.adres_id = a.adres_id;
   
   -- COPY ZAMOWNIENIE FROM HURTOWNIA
INSERT INTO
warehouse.zamowienie(zamowienie_id, uzytkownik_id, DATA_ZAM, kwota, typ_platnosci)
SELECT z.zamowienie_id, uz.uzytkownik_id, z.DATA_ZAM, z.kwota, p.typ
FROM hurtownia.zamowienie z left join hurtownia.uzytkownik_zamowienie uz on z.zamowienie_id = uz.zamowienie_id left join hurtownia.zamowienie_platnosc zp on z.zamowienie_id = zp.zamowienie_id left join hurtownia.platnosc p on zp.platnosc_id = p.platnosc_id;  
   
     -- COPY PRODUKT FROM HURTOWNIA
INSERT INTO
warehouse.produkt(produkt_id, zamowienie_id, nazwa, cena, kategoria)
SELECT p.produkt_id, zp.zamowienie_id, p.nazwa, zp.cena, k.nazwa 
FROM hurtownia.zamowienie_produkt zp left join hurtownia.produkt p on zp.produkt_id = p.produkt_id left join hurtownia.kategoria k on p.kategoria_id = k.kategoria_id;
   
END;
/