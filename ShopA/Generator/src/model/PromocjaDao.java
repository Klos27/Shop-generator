package model;

import Util.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class PromocjaDao {
    private static final Random random = new Random();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static Calendar c = Calendar.getInstance();
    public static void fillRandomData(int amount, int produktow ) {

        for (int i = 1; i <= amount; i++) {
            String dateStr = generateDate();
            try {
                c.setTime(sdf.parse(dateStr));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            c.add(Calendar.DATE, 14);  // number of days to add
            String dateStr2 = sdf.format(c.getTime());  // dt is now the new date


            String stmt = String.format("INSERT INTO PROMOCJA (ID, od, do, produkt_id, procent_znizki) values " +
                            "(%d, '%s' , '%s', %d, %d)",
                   i, dateStr, dateStr2, random.nextInt(produktow) + 1, random.nextInt(50) +1);
            if(i % 5000 == 0)
                System.out.println("Generating Zamowienie -> " + i + " so far.");
            try {
                DBUtils.dbExecuteWhatever(stmt);
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
        return sb.toString();
    }




}
