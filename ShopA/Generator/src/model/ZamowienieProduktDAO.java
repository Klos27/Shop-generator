package model;

import Util.DBUtils;

import java.sql.SQLException;
import java.util.Random;

public class ZamowienieProduktDAO {
    public static void fillRandomData(int iloscZamowien, int iloscProduktow) {
        Random rand = new Random();
        for (int i = 1; i <= iloscZamowien; i++) {
            for (int j = 0; j < rand.nextInt(5); j++) {
                int produktId = rand.nextInt(iloscProduktow) + 1;
                int ilosc =  rand.nextInt(10) + 1;
                String stmt = String.format("INSERT INTO ZAMOWIENIE_PRODUKT (ZAMOWIENIE_ID, PRODUKT_ID, ILOSC, CENA) values " +
                                "(%d, %d, %d, %d)",
                        i, produktId, ilosc, ProduktDAO.getProduktCena(produktId));
                if(i % 5000 == 0)
                    System.out.println("Assigning Produkt to Zamowienie -> " + i + " so far.");
                try {
                    DBUtils.dbExecuteUpdate(stmt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
