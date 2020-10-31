package com.example.wcf;
import android.os.StrictMode;

import java.sql.*;
public class DBConnection {
    Connection con;
    Statement st;
    ResultSet rs;

    public String url = "jdbc:mysql://192.168.64.2//WCF";
   // public String dbName = "WCF?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //public String driver = "com.mysql.jdbc.Driver";
    public String userName = "lauren";


    public Connection loadDB() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, userName,"12345");
            System.out.println("Connected to the database");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }
}
