package model;

import Util.DBUtils;

import java.sql.SQLException;
import java.util.Random;

public class ReklamacjaDao {
    private static final Random random = new Random();
    public static void fillRandomData(int amount, int ilosc_klientow, int ilosc_preduktow) {

        for (int i = 1; i <= amount; i++) {

            String stmt = String.format("INSERT INTO REKLAMACJA (ID, KLIENT_ID, PRODUKT_ID, DATA, OPIS) values " +
                    "(%d, %d, %d, '%s', '%s')",
                    i, random.nextInt(ilosc_klientow) +1, random.nextInt(ilosc_preduktow)+1, generateDate(), generateOpis());
            if(i % 1000 == 0)
                System.out.println("Generating users -> " + i + " so far.");
            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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

    public static String generateOpis() {
        int length2 = random.nextInt(100) + 10;
        int start = random.nextInt(length2);
        int end = length2 + random.nextInt(length2);

        return randomOpis.substring(start,end);
    }
    public static String randomOpis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis varius, ipsum sed suscipit sollicitudin, leo nisl semper lacus, volutpat varius metus ipsum quis nunc. Integer turpis turpis, sodales ac metus in, pharetra ullamcorper quam. Aliquam quis lectus dictum, elementum est ac, ornare urna. Suspendisse vehicula egestas ligula, vitae sodales sapien sagittis quis. Suspendisse potenti. Etiam vel lobortis elit, vitae facilisis arcu. Sed at congue augue. Vivamus sem magna, varius eu magna sed, mattis semper nisi. Donec a velit fermentum, aliquet odio quis, semper libero. Nullam dictum arcu in tellus pretium, vitae mattis nisl hendrerit. Proin fringilla dignissim orci, id eleifend urna laoreet id. Nulla condimentum tortor sapien, eu ullamcorper nisi maximus eu. Proin rhoncus pretium facilisis. Vivamus diam libero, viverra eu congue ut, finibus quis nisi. Suspendisse vitae pellentesque massa. Curabitur molestie erat a erat eleifend, ac molestie dolor sodales." +
            "In rhoncus ipsum at elit scelerisque, sit amet egestas libero lacinia. Duis dolor arcu, ornare at ligula sit amet, tempor maximus quam. Nulla rhoncus purus vel arcu tempor tempus. Duis a interdum mi, ac aliquam purus. Morbi ac metus porttitor, feugiat massa eget, ultrices elit. In ullamcorper sed justo vitae condimentum. Vestibulum turpis leo, ultricies malesuada nulla eu, vehicula ullamcorper dui. Phasellus sodales augue eros, quis sollicitudin turpis bibendum sed." +
            "Morbi non dolor pharetra, dignissim nisi nec, convallis purus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vivamus dignissim turpis vel neque eleifend hendrerit. Praesent mi leo, sollicitudin et fermentum at, luctus ac ipsum. Cras vestibulum purus eu felis pharetra, eu rutrum nunc pretium. Aliquam tellus purus, vehicula ac eleifend ut, pharetra sit amet purus.";

}
