package model;

import Util.DBUtils;

import java.sql.SQLException;
import java.util.Random;

public class PlatnoscDao {
    private static final String[] kategorie = {"karta", "gotowka", "przelew"};

    public static void fillRandomData(int iloscZamowien) {


        for (int i = 1; i <= iloscZamowien; i++) {
            Random rand = new Random();
            String stmt = String.format("INSERT INTO PLATNOSC (ID, rodzaj) values " +
                            "(%d, '%s')",
                    i, kategorie[rand.nextInt(kategorie.length)]);
            if(i % 5000 == 0)
                System.out.println("Generating Platnosci -> " + i + " so far.");
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



//    public static int getKwota(int zamowienieId){
//        int kwota = 1;
//
//        String stmt = String.format("select SUM(CENA_ZAKUPU) as suma from(select CENA_ZAKUPU from POZYCJA where ZAMOWIENIE_ID=%d)", zamowienieId);
//        try {
//            ResultSet rs = DBUtils.dbExecuteQuery(stmt);
//            if (rs.next()) {
//                kwota = rs.getInt("suma");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return kwota;
//    }
}
