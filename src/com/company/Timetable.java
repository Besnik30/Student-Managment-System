package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Timetable {

    public static String[][] getTimetable(int year, String cID){
        String querry="SELECT Lenda_Emri,Pedagog_Emer,Pedagog_Mbiemer,Mesimdhenia,Dita,ora,salla\n" +
                "FROM orari AS o\n" +
                "JOIN lenda AS l\n" +
                "  ON o.lenda_ID=l.Lenda_ID\n" +
                "JOIN pedagog AS p\n" +
                "  ON o.Pedagog_ID=p.Pedagog_ID\n" +
                "WHERE o.viti=? AND Dega_ID=?";

        ArrayList<ArrayList<String>> list1=new ArrayList<ArrayList<String>>();

        try {
            Connection connection=Main.connect();
            PreparedStatement p;
            p=connection.prepareStatement(querry);
            p.setInt(1,year);
            p.setString(2,cID);
            p.executeQuery();
            ResultSet rs;
            rs=p.getResultSet();
            int n=0;

            while(rs.next()){
                list1.add(new ArrayList<String>());
                list1.get(n).add(rs.getString("Lenda_Emri"));
                list1.add(new ArrayList<String>());
                list1.get(n).add(rs.getString("Pedagog_Emer"));
                list1.add(new ArrayList<String>());
                list1.get(n).add(rs.getString("Pedagog_Mbiemer"));
                list1.add(new ArrayList<String>());
                list1.get(n).add(rs.getString("Mesimdhenia"));
                list1.add(new ArrayList<String>());
                list1.get(n).add(rs.getString("Dita"));
                list1.add(new ArrayList<String>());
                list1.get(n).add(rs.getString("Ora"));
                list1.add(new ArrayList<String>());
                list1.get(n).add(rs.getString("Salla"));
                n++;
            }
            rs.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        String[][]tmt=new String[list1.size()/7][7];
        for(int i=0;i<list1.size()/7;i++){
            for(int j=0;j<7;j++){
                tmt[i][j]=list1.get(i).get(j);
            }
        }
        return tmt;
    }
}
