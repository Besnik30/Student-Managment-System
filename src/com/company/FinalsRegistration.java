package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FinalsRegistration {

    public static void addRegistration(Student s, Object subject) {
        String query="INSERT INTO Regjistrime(Dega_ID,Viti,Student_ID,Lenda_ID)VALUES(?,?,?,?)";

        try{
            Connection connection=Main.connect();
            PreparedStatement p=connection.prepareStatement(query);
            p.setString(1,s.getCourseId());
            p.setInt(2,s.getYear());
            p.setString(3,s.getStudentID());
            p.setObject(4,subject);
            p.executeUpdate();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static boolean getRegistration(String StudentID, Object subjectID){
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
                if(list.get(i).equals(subjectID))
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


