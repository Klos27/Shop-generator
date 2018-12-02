import Util.DBUtils;
import model.*;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        try{
            DBUtils.dbConnect();

            // WYGENERUJ UZYTKOWNIKOW
            final int iloscUzytkownikow = 100000;
            System.out.println("Generating users = " + iloscUzytkownikow);
            UzytkownikDAO.fillRandomData(iloscUzytkownikow);
            System.out.println("Generating addresses = " + iloscUzytkownikow);
            AdresDAO.fillRandomData(iloscUzytkownikow);
            System.out.println("Assigning addresses to users");
            UzytkownikAdresDAO.fillRandomData(iloscUzytkownikow);

            // WYGENERUJ PRODUKTY
            final int iloscKategorii = KategoriaDao.kategorie.length;
            final int iloscProduktow = 3000;
            System.out.println("Generating Kategoria = " + iloscKategorii);
            KategoriaDao.fillRandomData();
            System.out.println("Generating Produkt = " + iloscProduktow);
            ProduktDAO.fillRandomData(iloscProduktow, iloscKategorii);

            // WYGENERUJ ZAMOWIENIA
            final int iloscZamowien = 10000;
            System.out.println("Generating Zamowienie = " + iloscZamowien);
            ZamowienieDAO.fillRandomData(iloscZamowien);
            System.out.println("Assigning Produkt to Zamowienie");
            ZamowienieProduktDAO.fillRandomData(iloscZamowien, iloscProduktow);
            System.out.println("Assigning UZYTKOWNIK to Zamowienie");
            UzytkownikZamowienieDAO.fillRandomData(iloscUzytkownikow, iloscZamowien);

            //WYGENERUJ PLATNOSCI
            System.out.println("Generating Platnosci = " + iloscZamowien);
            PlatnoscDao.fillRandomData(iloscZamowien);
            System.out.println("Assigning Platnosci to Zamowienie = " + iloscZamowien);
            ZamowieniePlatnoscDAO.fillRandomData(iloscZamowien);

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
