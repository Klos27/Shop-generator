package model;

import Util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class PozycjaDAO {
    private static final Random random = new Random();
    public static void fillRandomData(int amount, int produktow, int zamowien ) {
        int prod_id;
        for (int i = 1; i <= amount; i++) {
            prod_id = random.nextInt(produktow) +1;
            String stmt = String.format("INSERT INTO POZYCJA (ID, produkt_id, zamowienie_id, cena_zakupu, `podatek VAT`) values " +
                            "(%d, %s, %d, %d, %d)",
                    i, prod_id, random.nextInt(zamowien) + 1, getProduktCena(prod_id), getPodatek());
            if(i % 5000 == 0)
                System.out.println("Generating Zamowienie -> " + i + " so far.");
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getPodatek(){
        return random.nextBoolean() ? 23 : 8;
    }

    public static int getProduktCena(int ProduktId){
        String stmt = String.format("select CENA from PRODUKT where ID=%d", ProduktId);
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
