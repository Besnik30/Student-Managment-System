package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Frekuentime {

    public static boolean ktheFrekuentimin(String Student_ID,Object lenda){
        String query="SELECT Statusi\n" +
                "FROM Frekuentime AS f\n" +
                "JOIN Lenda AS l\n" +
                "  ON f.Lenda_ID=l.Lenda_ID\n" +
                "WHERE Student_ID=? AND l.Lenda_ID=?";

        try {
            Connection connection=Main.connect();
            PreparedStatement p=connection.prepareStatement(query);
            p.setString(1,Student_ID);
            p.setObject(2,lenda);
            p.executeQuery();
            ResultSet rs=p.getResultSet();

            while(rs.next()){
                if(rs.getString("Statusi").equals("Ngeles")){
                    return  true;
                }
            }
            rs.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
