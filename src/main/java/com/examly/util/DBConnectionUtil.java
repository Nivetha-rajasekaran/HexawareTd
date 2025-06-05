package com.examly.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
    
    private static final String url = "jdbc:mysql://localhost:3306/appdb?useSSL=false&serverTimezone=UTC";
    private static final String name="root";
    private static final String password="Nivi@13";

    public static Connection getConnection() throws SQLException{
         try {
        Class.forName("com.mysql.cj.jdbc.Driver");  // Explicitly load MySQL driver
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        throw new SQLException("MySQL JDBC Driver not found");
    }
        try{
            return DriverManager.getConnection(url,name,password);
        }
        catch(Exception e){
           throw new SQLException(e);
        }
    }
}
