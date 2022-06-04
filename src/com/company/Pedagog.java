package com.company;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pedagog {
    String pedagogID;
    String emri;
    String mbiemri;
    Date pedagogDatelindja;

    public Pedagog(String pedagogID,String emri,String mbiemri,Date dtl ){
        this.pedagogID=pedagogID;
        this.emri=emri;
        this.mbiemri=mbiemri;
        this.pedagogDatelindja=dtl;
    }
    public String getPedagogID(){return pedagogID;}
    public String getEmri(){return  emri;}
    public String getMbiemri(){return mbiemri;}
    public Date getPedagogDatelindja(){return pedagogDatelindja;}

    public void shtoPedagog(Pedagog a){
        String insertPedagog="INSERT INTO Pedagog(Pedagog_ID,Pedagog_Emer,Pedagog_Mbiemer,Pedagog_Datelindja) VALUES(?,?,?,?)";
        try {
            Connection connection = Main.connect();
            PreparedStatement p;
            PreparedStatement p1;
            p = connection.prepareStatement(insertPedagog);
            p.setString(1, a.getPedagogID());
            p.setString(2, a.getEmri());
            p.setString(3, a.getMbiemri());
            p.setDate(4, a.getPedagogDatelindja());
            p.executeUpdate();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
