package model;

import Util.DBUtils;

import java.sql.SQLException;
import java.util.Random;

public class UzytkownikZamowienieDAO {
    public static void fillRandomData(int iloscUzytkownikow, int iloscZamowien) {
        Random rand = new Random();
        for (int zamowienie = 1; zamowienie <= iloscZamowien; zamowienie++) {
            String stmt = String.format("INSERT INTO UZYTKOWNIK_ZAMOWIENIE (UZYTKOWNIK_ID, ZAMOWIENIE_ID) values " +
                            "(%d, %d)",
                    rand.nextInt(iloscUzytkownikow) + 1, zamowienie);
            if(zamowienie % 5000 == 0)
                System.out.println("Assigning UZYTKOWNIK to Zamowienie -> " + zamowienie + " so far.");
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
