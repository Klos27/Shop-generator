package model;

import Util.DBUtils;

import java.sql.SQLException;
import java.util.Random;

public class UzytkownikDao {
    private static final Random random = new Random();
    public static void fillRandomData(int amount) {

        for (int i = 1; i <= amount; i++) {

            String stmt = String.format("INSERT INTO KLIENT (ID, ADRES_ID, KONTAKT_ID, RODZAJ, ZGODY_ID, NIP, PłEC, `ROK URODZENIA`) values " +
                    "('%d\', \'%d\', \'%d\', \'%s\', \'%d\', \'%s\', \'%s\', '%d')",
                    i, i, i, getRodzaj(), i, getNIP(), getPlec(), getRokUR());
            if(i % 1000 == 0)
                System.out.println("Generating users -> " + i + " so far.");
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static int getRokUR() {
        return random.nextInt(60) + 1941;
    }

    private static String getRodzaj() {
        return random.nextBoolean() ? "OS_FIZYCZNA" : "FIRMA";
    }

    private static String getPlec() {
        return random.nextBoolean() ? "M" : "F";
    }

    public static String getNIP(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(rand.nextInt(9) + 1);
        for(int i = 0; i < 9; i++)
            sb.append(rand.nextInt(10));
        return sb.toString();
    }
}
