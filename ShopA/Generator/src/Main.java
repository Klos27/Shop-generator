import Util.DBUtils;
import model.*;

import java.sql.SQLException;

public class Main {
    private static final int iloscUzytkownikow = 100000;
    private static final int iloscPracownikow = 100;
    private static final int iloscZamowien = 300000;
    private static final int iloscSprzedanychPrzedmiotow = 1000000;
    private static final int iloscKategorii = KategoriaDao.kategorie.length;
    private static final int iloscProducentow = ProducentDao.procudenci.length;
    private static final int iloscProducentowiKategorii = 50;
    private static final int iloscProduktow = 10000;
    private static final int iloscReklamacji = 2000;
    private static final int iloscPromocji = 1000;



    public static void main(String[] args){
        try{
            DBUtils.dbConnect();

            // WYGENERUJ UZYTKOWNIKOW


            System.out.println("Generating zgody = " + iloscUzytkownikow);
            ZgodyMarketingoweDao.fillRandomData(iloscUzytkownikow);
            System.out.println("Generating Kontakty = " + (iloscUzytkownikow + iloscPracownikow));
            KontaktDao.fillRandomData(iloscUzytkownikow + iloscPracownikow);
            System.out.println("Generating addresses = " + (iloscUzytkownikow + iloscPracownikow));
            AdresDAO.fillRandomData(iloscUzytkownikow + iloscPracownikow);
            System.out.println("Generating users = " + iloscUzytkownikow);
            UzytkownikDao.fillRandomData(iloscUzytkownikow);


//            System.out.println("Assigning addresses to users");
//            UzytkownikAdresDAO.fillRandomData(iloscUzytkownikow);
//
            // WYGENERUJ PRODUKTY

            System.out.println("Generating Kategoria = " + iloscKategorii);
            KategoriaDao.fillRandomData();
            System.out.println("Generating Producent = " + iloscKategorii);
            ProducentDao.fillRandomData();
            System.out.println("Assigning Producent and Kategoria = " + iloscKategorii);
            KategoriaProducentDAO.fillRandomData(iloscProducentowiKategorii, iloscKategorii, iloscProducentow);
            System.out.println("Generating Produkt = " + iloscProduktow);
            ProduktDAO.fillRandomData(iloscProduktow, iloscProducentowiKategorii);




//            // WYGENERUJ ZAMOWIENIA

            System.out.println("Generating Przesylka");
            PrzesylkaDao.fillRandomData();
            System.out.println("Generating Platnosci = " + iloscZamowien);
            PlatnoscDao.fillRandomData(iloscZamowien);
            System.out.println("Generating Zamowienie = " + iloscZamowien);
            ZamowienieDAO.fillRandomData(iloscZamowien, iloscUzytkownikow);
            System.out.println("Generating Pozycja = " + iloscZamowien);
            PozycjaDAO.fillRandomData(iloscSprzedanychPrzedmiotow, iloscProduktow, iloscZamowien);

            // WYGENERUJ PRACOWNIKOW
            System.out.println("Generating Pracownicy = " + iloscPracownikow);
            PracownikDao.fillRandomData(iloscPracownikow, iloscUzytkownikow, iloscUzytkownikow);

            // WYGENERUJ REKLAMACJE
            System.out.println("Generating REKLAMACJE = " + iloscReklamacji);
            ReklamacjaDao.fillRandomData(iloscReklamacji, iloscUzytkownikow, iloscProduktow);


            // WYGENERUJ PROMOCJE
            System.out.println("Generating PROMOCJE = " + iloscPromocji);
            PromocjaDao.fillRandomData(iloscPromocji, iloscProduktow);




// System.out.println("Assigning Produkt to Zamowienie");
//            ZamowienieProduktDAO.fillRandomData(iloscZamowien, iloscProduktow);
//            System.out.println("Assigning UZYTKOWNIK to Zamowienie");
//            UzytkownikZamowienieDAO.fillRandomData(iloscUzytkownikow, iloscZamowien);
//
//            //WYGENERUJ PLATNOSCI
//            System.out.println("Generating Platnosci = " + iloscZamowien);
//            PlatnoscDao.fillRandomData(iloscZamowien);
//            System.out.println("Assigning Platnosci to Zamowienie = " + iloscZamowien);
//            ZamowieniePlatnoscDAO.fillRandomData(iloscZamowien);

            System.out.println("DONE!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                DBUtils.dbDisconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
