package model;

import Util.DBUtils;

import java.sql.SQLException;
import java.util.Random;

public class ZgodyMarketingoweDao {

    private static final Random random = new Random();

    public static void fillRandomData(int ilosc_klientow) {
        for (int i = 1; i <= ilosc_klientow; i++) {
            String stmt = String.format("INSERT INTO ZGODY_MARKETINGOWE (ID, ZGODA_SMS, ZGODA_TEL, ZGODA_EMAIL) values " +
                            "(%d, \'%d\', '%d', '%d')",
                    i, generateBool(), generateBool(), generateBool());
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static int generateBool(){

        return (random.nextBoolean()) ? 1 : 0;
    }


}
