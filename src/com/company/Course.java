package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Course {

    public static String[] getCourseID(){
        ArrayList<String>l=new ArrayList<String>();
        String querry="SELECT* FROM DEGA";
        try {
            Connection connection=Main.connect();
            PreparedStatement p;
            p=connection.prepareStatement(querry);
            p.executeQuery();
            ResultSet rs;
            rs= p.getResultSet();

            while (rs.next()){
                l.add(rs.getString("Dega_ID"));
            }rs.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        String[] s=new String[l.size()];
        for(int i=0;i< s.length;i++){
            s[i]=l.get(i);
        }
        return s;
    }
}
