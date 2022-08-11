package com.company;

import java.sql.*;

public class Pedagog {
   private String pedagogID;
    private String emri;
    private String mbiemri;
    private Date pedagogDatelindja;

    public Pedagog(String pedagogID,String emri,String mbiemri,Date dtl ){
        this.pedagogID=pedagogID;
        this.emri=emri;
        this.mbiemri=mbiemri;
        this.pedagogDatelindja=dtl;
    }
    public Pedagog(){}
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
    public static Pedagog PedagogInfo(String pedagogID){
        String query="SELECT* FROM Pedagog WHERE Pedagog_ID=?";
        String pId,pErmi,pMbiemri;
        Date ditl;
        Pedagog pedagog=new Pedagog();
        try {
          Connection connection=Main.connect();
          PreparedStatement p= connection.prepareStatement(query);
          p.setString(1,pedagogID);
          p.executeQuery();
            ResultSet rs=p.getResultSet();
            while(rs.next()){
                pId=rs.getString("Pedagog_ID");
                pErmi=rs.getString("Pedagog_Emer");
                pMbiemri=rs.getString("Pedagog_Mbiemer");
                ditl=rs.getDate("Pedagog_Datelindja");
                pedagog=new Pedagog(pId,pErmi,pMbiemri,ditl);
            }rs.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return pedagog;
    }
}
