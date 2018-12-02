package model;

import Util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class PlatnoscDao {

    public static void fillRandomData(int iloscZamowien) {
        /*
        typ:
        1 - gotówka
        2 - karta
        3 - przelew

        Status:
        1 - rozpoczęta
        2 - zakończona
         */

        for (int i = 1; i <= iloscZamowien; i++) {
            Random rand = new Random();
            String stmt = String.format("INSERT INTO PLATNOSC (PLATNOSC_ID, TYP, KWOTA, STATUS) values " +
                            "(%d, %d, %d, %d)",
                    i, rand.nextInt(3) + 1, getKwota(i), getStatus());
            if(i % 5000 == 0)
                System.out.println("Generating Platnosci -> " + i + " so far.");
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getStatus(){
        Random rand = new Random();
        // 10% chance to return 1, 90% to return 2
        return (rand.nextInt(10)) < 1 ? 1 : 2;
    }


    public static int getKwota(int zamowienieId){
        int kwota = 1;

        String stmt = String.format("select SUM(CENA) as suma from(select cena from ZAMOWIENIE_PRODUKT where ZAMOWIENIE_ID=%d)", zamowienieId);
        try {
            ResultSet rs = DBUtils.dbExecuteQuery(stmt);
            if (rs.next()) {
                kwota = rs.getInt("suma");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kwota;
    }
}
