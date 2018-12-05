package model;

import Util.DBUtils;

import java.sql.SQLException;

public class PrzesylkaDao {


    public static void fillRandomData() {
        String stmt = "INSERT INTO PRZESYLKA (ID, RODZAJ, CENA) values (1, 'ODBIOR_OSOBISTY', 0)," +
                " (2, 'KURIER', 15)," +
                "(3, 'POCZTA', 10); ";


            try {
                DBUtils.dbExecuteUpdate(stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
