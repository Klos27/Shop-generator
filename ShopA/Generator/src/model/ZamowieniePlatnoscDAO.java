package model;

import Util.DBUtils;

import java.sql.SQLException;
import java.util.Random;

public class ZamowieniePlatnoscDAO {
    public static void fillRandomData(int iloscZamowien) {
        for (int i = 1; i <= iloscZamowien; i++) {
            String stmt = String.format("INSERT INTO ZAMOWIENIE_PLATNOSC (ZAMOWIENIE_ID, PLATNOSC_ID) values " +
                            "(%d, %d)",
                    i, i);
            if(i % 5000 == 0)
                System.out.println("Assigning Platnosci to Zamowienie -> " + i + " so far.");
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
