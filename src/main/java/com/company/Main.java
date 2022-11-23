package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

     static String url="jdbc:mysql://localhost:3306/sudent_ms";
     static String user="root";
     static String password="Kali123!@#";

     public static Connection connect ()throws SQLException {
         return DriverManager.getConnection(url,user,password);
     }

     public static void main(String[] args) {

         FirstForm f=new FirstForm();
     }
}



