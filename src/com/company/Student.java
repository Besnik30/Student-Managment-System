package com.company;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student {
 private String studentID;
 private String name;
 private String surname;
 private Date birthday;
 private String courseId;
 private int year;

 public Student(String studentId,String e,String mb,Date d,String de,int v){
  this.studentID =studentId;
  this.name =e;
  this.surname =mb;
  this.birthday =d;
  this.courseId =de;
  this.year =v;
 }
 public Student(){ }

 public String getName(){
  return name;
 }
 public String getSurname(){
  return surname;
 }
 public Date getBirthday(){
  return birthday;
 }
 public String getCourseId(){
  return courseId;
 }
 public int getYear(){
  return year;
 }
 public String getStudentID(){ return studentID; }

 public void addStudent(Student stu){
  String insert = "INSERT INTO Student(Student_ID,Student_Emer,Student_Mbiemer,Student_Datelindja,Dega_ID,viti) VALUES(?,?,?,?,?,?) ";

  try{
   Connection connection=Main.connect();
   PreparedStatement p;
   p = connection.prepareStatement(insert);
   p.setString(1, stu.getStudentID());
   p.setString(2, stu.getName());
   p.setString(3, stu.getSurname());
   p.setDate(4, stu.getBirthday());
   p.setString(5, stu.getCourseId());
   p.setInt(6, stu.getYear());
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




