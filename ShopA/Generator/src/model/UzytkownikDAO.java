package model;

import Util.DBUtils;

import java.sql.SQLException;

public class UzytkownikDAO {
    public static void fillRandomData(int amount) {

        for (int i = 1; i <= amount; i++) {
            Uzytkownik uzytkownik = Uzytkownik.generateUzytkownik();

            String stmt = String.format("INSERT INTO UZYTKOWNIK (UZYTKOWNIK_ID, IMIE, NAZWISKO, EMAIL, TELEFON, PLEC, TYP) values " +
                    "(\'%d\', \'%s\', \'%s\', \'%s\', \'%s\', \'%s\', \'%d\')",
                    i, uzytkownik.imie, uzytkownik.nazwisko, uzytkownik.email, uzytkownik.telefon, uzytkownik.plec, uzytkownik.typ);
            if(i % 1000 == 0)
                System.out.println("Generating users -> " + i + " so far.");
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
