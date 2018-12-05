package model;

import Util.DBUtils;

import java.sql.SQLException;

public class KategoriaDao {
    public static String[] kategorie = {
            "Procesory",
            "Karty_Graficzne",
            "Pamiec_ram",
            "Pamieci masowe",
            "Obudowy",
            "Zasilacze",
            "Laptopy",
            "Monitory",
            "Myszki",
            "Klawiatury",
            "Audio",
            "Płyty_główne",
            "Chłodzenie",
            "Napędy",
            "Inne"
    };

    public static void fillRandomData() {
        for (int i = 1; i <= kategorie.length; i++) {
            String stmt = String.format("INSERT INTO KATEGORIA (ID, NAZWA, OPIS) values " +
                            "(%d, \'%s\', '%s')",
                    i, kategorie[i-1], String.format("Opis kategorii: %s",kategorie[i-1] ));
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
