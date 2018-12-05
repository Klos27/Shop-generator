package model;

import Util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProduktDAO {
    public static void fillRandomData(int iloscProduktow, int iloscKategorii) {
        for (int i = 1; i <= iloscProduktow; i++) {
            Produkt produkt = Produkt.generateProdukt(iloscKategorii);
            String stmt = String.format("INSERT INTO PRODUKT (ID, KATEGORIA_PRODUCENT_ID, OPIS, NAZWA, CENA) values " +
                            "(%d, %d, \'%s\', '%s', %d)",
                    i, produkt.kategoria_producent_id, produkt.opis, produkt.nazwa, produkt.cena);
            if(i % 1000 == 0)
                System.out.println("Generating Produkt -> " + i + " so far.");
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static int getProduktCena(int ProduktId){
        String stmt = String.format("select CENA from PRODUKT where PRODUKT_ID=%d", ProduktId);
        int cena = 1;
        try {
            ResultSet rs = DBUtils.dbExecuteQuery(stmt);
            if (rs.next()) {
                cena = rs.getInt("CENA");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cena;
    }
}
