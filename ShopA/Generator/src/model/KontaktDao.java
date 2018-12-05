package model;

import Util.DBUtils;
import Util.RandomString;

import java.sql.SQLException;
import java.util.Random;

public class KontaktDao {

    public static void fillRandomData(int ilosc_klientow) {
        for (int i = 1; i <= ilosc_klientow; i++) {
            String stmt = String.format("INSERT INTO KONTAKT (ID, EMAIL, telefon1, telefon2) values " +
                            "(%d, \'%s\', '%s', '%s')",
                    i, generateEmail((i % 10) + 1), generateTelefon(), generateTelefon());
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static String generateEmail(int i){
        return new RandomString(i).nextString() + "@email.com";
    }

    public static String generateTelefon(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("48");
        sb.append(rand.nextInt(9) + 1);
        for(int i = 0; i < 7; i++)
            sb.append(rand.nextInt(10));
        return sb.toString();
    }
}
