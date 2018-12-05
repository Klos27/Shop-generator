package model;

import Util.DBUtils;

import java.sql.SQLException;
import java.util.Random;

public class KategoriaProducentDAO {
    private static final Random random = new Random();
    public static void fillRandomData(int amount, int caregories, int producers) {
        for (int i = 1; i <= amount; i++) {
            String stmt = String.format("INSERT INTO KATEGORIA_PRODUCENT (ID, KATEGORIA_ID, PRODUCENT_ID) values " +
                            "(%d, %d, %d)", i, random.nextInt(caregories) + 1, random.nextInt(producers) + 1);
            if(i % 1000 == 0)
                System.out.println("Assigning categories to producers -> " + i + " so far.");
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
