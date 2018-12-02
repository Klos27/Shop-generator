package model;

import Util.DBUtils;

import java.sql.SQLException;

public class KategoriaDao {
    public static String[] kategorie = {
            "Procesory",
            "Karty_Graficzne",
            "Pamiec_ram",
            "Pendrive",
            "Obudowy",
            "Zasilacze",
            "Laptopy",
            "Monitory",
            "Myszki",
            "Klawiatury",
            "Głośniki",
            "Przewody",
            "Płyty_główne",
            "Chłodzenie",
            "Napędy",
            "Konsole",
            "Gry",
            "Chemia",
            "Słuchawki",
            "Inne"
    };

    public static void fillRandomData() {
        for (int i = 1; i <= kategorie.length; i++) {
            String stmt = String.format("INSERT INTO KATEGORIA (KATEGORIA_ID, NAZWA) values " +
                            "(%d, \'%s\')",
                    i, kategorie[i-1]);
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
