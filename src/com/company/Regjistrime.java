package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Regjistrime {

    public static void shtoRegjistrim(Student s,Object lenda) {
        String query="INSERT INTO Regjistrime(Dega_ID,Viti,Student_ID,Lenda_ID)VALUES(?,?,?,?)";

        try{
            Connection connection=Main.connect();
            PreparedStatement p=connection.prepareStatement(query);
            p.setString(1,s.getDegaId());
            p.setInt(2,s.getViti());
            p.setString(3,s.getStuID());
            p.setObject(4,lenda);
            p.executeUpdate();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static boolean ktheRegjistrime(String StudentID,Object lendaID){
        String query="SELECT Lenda_ID FROM Regjistrime WHERE Student_ID=?";
        ArrayList<String>list=new ArrayList<>();

        try{
            Connection connection=Main.connect();
            PreparedStatement p=connection.prepareStatement(query);
            p.setString(1,StudentID);
            p.executeQuery();
            ResultSet rs=p.getResultSet();

            while (rs.next()){
                list.add(rs.getString("Lenda_ID"));
            }
            for(int i=0;i<list.size();i++){
                if(list.get(i).equals(lendaID))
                    return true;
            }
            rs.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}


