package com.company;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student {
 private String stuID;
 private String emri;
 private String mbiemri;
 private Date datelindja;
 private String degaId;
 private int viti;

 public Student(String studentId,String e,String mb,Date d,String de,int v){
  this.stuID=studentId;
  this.emri=e;
  this.mbiemri=mb;
  this.datelindja=d;
  this.degaId=de;
  this.viti=v;
 }
 public Student(){ }

 public String getEmri(){
  return emri;
 }
 public String getMbiemri(){
  return mbiemri;
 }
 public Date getDatelindja(){
  return datelindja;
 }
 public String getDegaId(){
  return degaId;
 }
 public int getViti(){
  return viti;
 }
 public String getStuID(){ return stuID; }

 public void  shtoStudent(Student stu){
  String insert = "INSERT INTO Student(Student_ID,Student_Emer,Student_Mbiemer,Student_Datelindja,Dega_ID,viti) VALUES(?,?,?,?,?,?) ";

  try{
   Connection connection=Main.connect();
   PreparedStatement p;
   p = connection.prepareStatement(insert);
   p.setString(1, stu.getStuID());
   p.setString(2, stu.getEmri());
   p.setString(3, stu.getMbiemri());
   p.setDate(4, stu.getDatelindja());
   p.setString(5, stu.getDegaId());
   p.setInt(6, stu.getViti());
   p.executeUpdate();
  } catch (Exception e) {
   e.printStackTrace();
    }
 }

   public static Student StudentInfo(String id){
     String querry="SELECT* FROM Student WHERE Student_ID=?";
    Student s=new Student();
    String sId,sE,sM,de;
    Date d;
    int v;
     try{
      Connection connection=Main.connect();
      PreparedStatement p;
      p=connection.prepareStatement(querry);
      p.setString(1,id);
      p.executeQuery();
      ResultSet rs;
      rs=p.getResultSet();

      while(rs.next()){
        sId=rs.getString("Student_ID");
        sE=rs.getString("Student_Emer");
        sM=rs.getString("Student_Mbiemer");
        d=rs.getDate("Student_Datelindja");
        de=rs.getString("Dega_ID");
        v=rs.getInt("viti");

        s=new Student(sId,sE,sM,d,de,v);
      }
      rs.close();
      connection.close();
     }catch (Exception e){
      e.printStackTrace();
     }
     return s;
   }

 }




