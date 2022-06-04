package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Transkript {

    public static Object[][] ktheTranskript(String id){
        String querry="SELECT Sezon_ID,Lenda_Emri,Nota\n" +
                "FROM Transkript AS t\n" +
                "JOIN Dega AS d\n" +
                "  ON t.Dega_ID=d.Dega_ID\n" +
                "JOIN Lenda AS l\n" +
                "  ON t.Lenda_ID=l.Lenda_ID\n" +
                "WHERE t.Student_ID=?";
        ArrayList<ArrayList<Object>> l=new ArrayList<ArrayList<Object>>();
        try{
            Connection connection=Main.connect();
            PreparedStatement p;
            p=connection.prepareStatement(querry);
            p.setString(1,id);
            p.executeQuery();
            ResultSet rs=p.getResultSet();
            int i=0;
            while (rs.next()){
                l.add(new ArrayList<Object>());
                l.get(i).add(rs.getString("Sezon_ID"));
                l.add(new ArrayList<Object>());
                l.get(i).add(rs.getString("Lenda_Emri"));
                l.add(new ArrayList<Object>());
                l.get(i).add(rs.getString("Nota"));
                i++;
            }
            rs.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        Object[][]res=new Object[l.size()/3][3];

        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[i].length;j++){
                res[i][j]=l.get(i).get(j);
            }
        }
        return res;
    }
}
