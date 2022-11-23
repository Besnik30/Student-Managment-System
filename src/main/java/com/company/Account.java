package com.company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Account {
     private String accountId;
     private String password;

    public Account(){ }
    public Account (String aId,String pass){
        this.accountId =aId;
        this.password=pass;
    }
    public  String getAccountId(){
        return accountId;
    }
    public String getPassword(){
        return password;
    }

    public void addStudentAccount(Account a){
        String insertAccS="INSERT INTO Acount(Acount_ID,Student_ID,Pasword) VALUES(?,?,?)";
        try{
            Connection connection=Main.connect();
            PreparedStatement p;
            p = connection.prepareStatement(insertAccS);
            p.setString(1, getAccountId());
            p.setString(2, getAccountId());
            p.setString(3,getPassword());
            p.executeUpdate();
            connection.close();
        } catch (Exception e) {
                e.printStackTrace();
            }
    }
        public void addProfessorAccount(Account a){
            String insertAccP="INSERT INTO Acount(Acount_ID,Pedagog_ID,Pasword) VALUES(?,?,?)";
            try{
                Connection connection=Main.connect();
                PreparedStatement p;
                p = connection.prepareStatement(insertAccP);
                p.setString(1, getAccountId());
                p.setString(2, getAccountId());
                p.setString(3,getPassword());
                p.executeUpdate();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public  boolean logIn(Account a){
        String pass=a.password;
        String accID=a.accountId;
        String findAcc="SELECT Acount_ID,Pasword FROM Acount WHERE Acount_ID=? AND Pasword=?";
        try{
            Connection connection=Main.connect();
            PreparedStatement p;
            p=connection.prepareStatement(findAcc);
            p.setString(1,accID);
            p.setString(2,pass);
            p.executeQuery();
            ResultSet rs;
            rs=p.getResultSet();

              if(rs.next()){
                 return true;
              }
            rs.close();
              connection.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public  boolean changePassword(Account a,String neew){
        String id=a.accountId;
        String old=a.password;
        String updatePass="UPDATE acount SET PAsword=? WHERE Acount_ID=? AND Pasword=?;";
        try{
            Connection connection=Main.connect();
            PreparedStatement p;
            p =connection.prepareStatement(updatePass);
            p.setString(1,neew);
            p.setString(2,id);
            p.setString(3,old);

            if(p.executeUpdate()==0)
                return false;
            connection.close();
            }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public static Account getPass(String id){
        Account a=new Account();
        String querry="SELECT Pasword FROM Acount WHERE Acount_ID=?";
        String p1;
        try{
            Connection connection=Main.connect();
            PreparedStatement p;
            p=connection.prepareStatement(querry);
            p.setString(1,id);
            p.executeQuery();
            ResultSet rs;
            rs=p.getResultSet();

            while(rs.next()){
                p1=rs.getString("Pasword");
                 a=new Account(id,p1);
            }
            rs.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return a;
    }
}



