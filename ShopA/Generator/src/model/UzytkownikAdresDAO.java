package model;

import Util.DBUtils;

import java.sql.SQLException;

public class UzytkownikAdresDAO {
    public static void fillRandomData(int amount) {
        for (int i = 1; i <= amount; i++) {
            String stmt = String.format("INSERT INTO UZYTKOWNIK_ADRES (UZYTKOWNIK_ID, ADRES_ID) values " +
                            "(%d, %d)", i, i);
            if(i % 1000 == 0)
                System.out.println("Assigning addresses to users -> " + i + " so far.");
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
