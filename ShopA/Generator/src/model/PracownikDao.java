package model;

import Util.DBUtils;

import java.sql.SQLException;
import java.util.Random;

public class PracownikDao {
    private static final Random random = new Random();
    public static void fillRandomData(int amount, int adres_start_id, int kontakt_start_id) {

        for (int i = 1; i <= amount; i++) {

            String stmt = String.format("INSERT INTO PRACOWNIK (ID, ADRES_ID, KONTAKT_ID, PENSJA) values " +
                    "(%d, %d, %d, %d)",
                    i,adres_start_id + i, kontakt_start_id + i, random.nextInt(2500) + 1500);
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
