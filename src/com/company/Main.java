package com.company;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

     static String url="-------";
     static String user="---";
     static String password="-----";

     public static Connection connect ()throws SQLException {
         return DriverManager.getConnection(url,user,password);
     }

     public static void main(String[] args) {

         FirstForm f=new FirstForm();


}



