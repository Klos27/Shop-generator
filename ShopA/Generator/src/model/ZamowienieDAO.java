package model;

import Util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class ZamowienieDAO {
    private static final Random random = new Random();
    public static void fillRandomData(int amount, int klientow) {
        for (int i = 1; i <= amount; i++) {

            String stmt = String.format("INSERT INTO ZAMOWIENIE (ID, data_godzina, klient_id, platnosc_id, przesylka_id, kwota) values " +
                            "(%d, '%s', %d, %d, %d, %d)",
                    i, generateDate(), random.nextInt(klientow) + 1, i, random.nextInt(3) + 1, getAmount(i));
            if(i % 5000 == 0)
                System.out.println("Generating Zamowienie -> " + i + "/" + amount + " so far. ");
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getAmount(int zamowienieId){
        int kwota = 1;

        String stmt = String.format("select SUM(CENA_ZAKUPU) as suma from (select CENA_ZAKUPU from POZYCJA where ZAMOWIENIE_ID=%d) a", zamowienieId);
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

    public static String generateDate(){
        StringBuilder sb = new StringBuilder();

        // generate day
        sb.append(random.nextInt(9) + 2010);
        sb.append("-");
        int month = random.nextInt(12) + 1;
        if(month < 10){
            sb.append("0");
            sb.append(month);
        }
        else
            sb.append(month);
        sb.append("-");
        int day;
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = random.nextInt(31) + 1;
                break;
            case 2:
                day = random.nextInt(28) + 1;
                break;
            default:
                day = random.nextInt(30) + 1;
                break;
        }
        if(day < 10){
            sb.append("0");
            sb.append(day);
        }
        else
            sb.append(day);
        sb.append(" ");

        // generate hour
        int n = random.nextInt(24);
        if( n == 0)
            sb.append("00");
        else if(n < 10){
            sb.append("0");
            sb.append(n);
        }
        else
            sb.append(n);
        sb.append(":");

        // generate minute
        n = random.nextInt(60);
        if( n == 0)
            sb.append("00");
        else if(n < 10){
            sb.append("0");
            sb.append(n);
        }
        else
            sb.append(n);
        sb.append(":");

        // generate sec
        n = random.nextInt(60);
        if( n == 0)
            sb.append("00");
        else if(n < 10){
            sb.append("0");
            sb.append(n);
        }
        else
            sb.append(n);

        return sb.toString();
    }
}
