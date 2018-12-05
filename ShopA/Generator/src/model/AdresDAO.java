package model;

import Util.DBUtils;

import java.sql.SQLException;

public class AdresDAO {
    public static void fillRandomData(int amount) {

        for (int i = 1; i <= amount; i++) {
            Adres adres = Adres.generateAdres();

            String stmt = String.format("INSERT INTO ADRES (ID, ULICA, NR_DOMU, MIEJSCOWOSC, KOD_POCZTOWY, WOJEWODZTWO, KRAJ) values " +
                            "(%d, \'%s\', %s, \'%s\', \'%s\', \'%s\', \'%s\')",
                    i, adres.ulica, adres.nr_domu, adres.miejscowosc, adres.kod_pocztowy, adres.wojewodztwo, adres.kraj);
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
