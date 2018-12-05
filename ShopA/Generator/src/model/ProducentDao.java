package model;

import Util.DBUtils;

import java.sql.SQLException;

public class ProducentDao {

    public static String[] procudenci = {
            "Asus",
            "Sapphire ",
            "Intel",
            "AMD",
            "Gigabyte",
            "Palit",
            "Zalman",
            "HP",
            "Xiaomi",
            "Klawiatury",
            "LG",
            "Samsung",
            "Apple",
            "Dell",
            "Lenovo",
            "Acer",
            "Philips",
            "Iiyama",
            "Benq",
            "JBL",
            "Inne"
    };

    public static void fillRandomData() {
        for (int i = 1; i <= procudenci.length; i++) {
            String stmt = String.format("INSERT INTO PRODUCENT (ID, NAZWA, OPIS) values " +
                            "(%d, \'%s\', '%s')",
                    i, procudenci[i-1], String.format("Opis producenta: %s",procudenci[i-1] ));
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
