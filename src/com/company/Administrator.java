package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Administrator {

    public static Object[][] ktheProvimet(String DegaID,String StudentID){
        String query=new String("SELECT p.Dega_ID,p.Viti,p.Lenda_ID,l.Lenda_Emri,p.Sezon_ID,p.Data_Provimit,p.Ora,p.Salla\n" +
                "FROM Provime AS p\n" +
                "JOIN regjistrime AS r\n" +
                "  ON p.Lenda_ID=r.Lenda_ID\n" +
                "JOIN lenda AS l\n" +
                "  ON p.Lenda_ID=l.Lenda_ID\n" +
                "WHERE p.Dega_ID=? AND r.Student_ID=?");
        ArrayList<ArrayList<Object>> liste=new ArrayList<ArrayList<Object>>();

        try{
            Connection connection=Main.connect();
            PreparedStatement p=connection.prepareStatement(query);
            p.setString(1,DegaID);
            p.setString(2,StudentID);
            p.executeQuery();
            ResultSet rs=p.getResultSet();
            int i=0;

            while(rs.next()){
                liste.add(new ArrayList<Object>());
                liste.get(i).add(rs.getString("Sezon_ID"));
                liste.add(new ArrayList<Object>());
                liste.get(i).add(rs.getString("Lenda_ID"));
                liste.add(new ArrayList<Object>());
                liste.get(i).add(rs.getString("Lenda_Emri"));
                liste.add(new ArrayList<Object>());
                liste.get(i).add(rs.getDate("Data_Provimit"));
                liste.add(new ArrayList<Object>());
                liste.get(i).add(rs.getString("Ora"));
                liste.add(new ArrayList<Object>());
                liste.get(i).add(rs.getString("Salla"));
                i++;
            }
            rs.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        Object[][] provime=new Object[liste.size()/6][6];

        for(int i=0;i<provime.length;i++){
            for(int j=0;j<provime[i].length;j++){
                provime[i][j]=liste.get(i).get(j);
            }
        }
        return provime;
    }

    public static String[] ktheProvimeID(String degaID,int viti){
        String query="SELECT Lenda_ID\n" +
                "FROM Provime \n" +
                "WHERE Dega_ID=? AND viti=?";
        ArrayList<String> list=new ArrayList<>();

        try {
            Connection connection = Main.connect();
            PreparedStatement p = connection.prepareStatement(query);
            p.setString(1, degaID);
            p.setInt(2, viti);
            p.executeQuery();
            ResultSet rs = p.getResultSet();

            while(rs.next()){
                list.add(rs.getString("Lenda_ID"));
            }
            rs.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        String[]list2=new String[list.size()];

        for(int i=0;i<list.size();i++){
                list2[i]=list.get(i);
            }
            return list2;
    }
}
