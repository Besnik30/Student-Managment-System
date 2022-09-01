package com.company;

import java.sql.*;

public class Professor {
   private String professorID;
    private String P_Name;
    private String P_LastName;
    private Date P_Birthday;

    public Professor(String professorID, String name, String lastName, Date bDay ){
        this.professorID = professorID;
        this.P_Name=name;
        this.P_LastName =lastName;
        this.P_Birthday =bDay;
    }
    public Professor(){}
    public String getProfessorID(){return professorID;}
    public String getP_Name(){return  P_Name;}
    public String getMbiemri(){return P_LastName;}
    public Date getP_Birthday(){return P_Birthday;}

    public void addProfessor(Professor a){
        String insertPedagog="INSERT INTO Pedagog(Pedagog_ID,Pedagog_Emer,Pedagog_Mbiemer,Pedagog_Datelindja) VALUES(?,?,?,?)";
        try {
            Connection connection = Main.connect();
            PreparedStatement p;
            PreparedStatement p1;
            p = connection.prepareStatement(insertPedagog);
            p.setString(1, a.getProfessorID());
            p.setString(2, a.getP_Name());
            p.setString(3, a.getMbiemri());
            p.setDate(4, a.getP_Birthday());
            p.executeUpdate();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static Professor ProfessorInfo(String pedagogID){
        String query="SELECT* FROM Pedagog WHERE Pedagog_ID=?";
        String pId,pErmi,pMbiemri;
        Date ditl;
        Professor professor =new Professor();
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
                professor =new Professor(pId,pErmi,pMbiemri,ditl);
            }rs.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return professor;
    }
}
