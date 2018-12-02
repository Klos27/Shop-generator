package model;

import Util.DBUtils;

import java.sql.SQLException;

public class AdresDAO {
    public static void fillRandomData(int amount) {

        for (int i = 1; i <= amount; i++) {
            Adres adres = Adres.generateAdres();

            String stmt = String.format("INSERT INTO ADRES (ADRES_ID, ULICA, NR_DOMU, NR_MIESZKANIA, KOD_POCZTOWY, MIASTO, WOJEWODZTWO) values " +
                            "(%d, \'%s\', %s, %s, %s, \'%s\', \'%s\')",
                    i, adres.ulica, adres.nr_domu, adres.nr_mieszkania, adres.kod_pocztowy, adres.miasto, adres.wojewodztwo);
            if(i % 1000 == 0)
                System.out.println("Generatin addresses -> " + i + " so far.");
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
