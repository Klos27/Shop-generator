package model;

import Util.DBUtils;

import java.sql.SQLException;
import java.util.Random;

public class PlatnoscDao {
    private static final String[] kategorie = {"karta", "gotowka", "przelew"};
    private static final Random rand = new Random();

    public static void fillRandomData(int iloscZamowien) {

        for (int i = 1; i <= iloscZamowien; i++) {

            String stmt = String.format("INSERT INTO PLATNOSC (ID, rodzaj) values " +
                            "(%d, '%s')",
                    i, kategorie[rand.nextInt(kategorie.length)]);
            if(i % 5000 == 0)
                System.out.println("Generating Platnosci -> " + i + " so far.");
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
