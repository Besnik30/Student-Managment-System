package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorForm extends JFrame {
     JPanel panel1=new JPanel();
     JPanel personal=new JPanel();

     JLabel menu=new JLabel("MENU");
     JLabel acountID=new JLabel();
     JLabel password=new JLabel();
     JLabel name =new JLabel();
     JLabel lastName =new JLabel();
     JLabel bDay =new JLabel();

     JButton changeP=new JButton("Ndrysho Password");
     JButton profile =new JButton("Pofili");
     JButton timeTableButon =new JButton("Orari");
     JButton attendance =new JButton("Frekuentime");
     JButton grades =new JButton("Vleresime");
     JButton logout=new JButton("LogOut");

     Border blackline = BorderFactory.createLineBorder(Color.BLACK);
     Border raisedbevel=BorderFactory.createRaisedBevelBorder();
     Border loweredbevel=BorderFactory.createLoweredBevelBorder();
     Border border=BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);

     String accID;
     public ProfessorForm(){
          setSize(800,550);
          setLocation(200, 100);
          panel1.setLayout(null);
          personal.setLayout(null);
          //Panel1
          panel1.setSize(200,550);
          panel1.setLocation(0,0);
          menu.setBounds(80,100,100,80);
          profile.setBounds(30,160,140, 30);
          timeTableButon.setBounds(30,200,140, 30);
          attendance.setBounds(30,240,140,30);
          grades.setBounds(30,280,140,30);
          logout.setBounds(30,320,140, 30);
          //Personale
          personal.setSize(600,550);
          personal.setLocation(600,0);
          personal.setBorder(border);
          acountID.setBounds(400,70,140,30);
          password.setBounds(400,100,140,30);
          name.setBounds(400,130,140,30);
          lastName.setBounds(400,160,140,30);
          bDay.setBounds(400,190,140,30);
          changeP.setBounds(390,240,160,30);

          panel1.add(menu);
          panel1.add(profile);
          panel1.add(timeTableButon);
          panel1.add(attendance);
          panel1.add(grades);
          panel1.add(logout);
          panel1.setBorder(border);
          getContentPane().add(panel1);
          getContentPane().add(personal);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setVisible(true);

          Personale();
          LogOut();
     }
     public void Personale(){
          profile.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    Professor professor = Professor.ProfessorInfo(accID);
                    Account a= Account.getPass(accID);
                    String pass=a.getPassword();
                    personal.add(acountID);
                    acountID.setText("AcountID :"+ professor.getProfessorID());
                    acountID.setBorder(blackline);
                    personal.add(password);
                    password.setText("Password: "+pass);
                    password.setBorder(blackline);
                    personal.add(name);
                    name.setText("Emri: "+ professor.getP_Name());
                    name.setBorder(blackline);
                    personal.add(lastName);
                    lastName.setText("Mbiemri: "+ professor.getMbiemri());
                    lastName.setBorder(blackline);
                    personal.add(bDay);
                    bDay.setText("Datelindja: "+ professor.getP_Birthday());
                    bDay.setBorder(blackline);
                    personal.add(changeP);
                    getContentPane().add(personal);
                    personal.setVisible(true);
               }
          });
     }



     public void LogOut(){
          logout.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    FirstForm f=new FirstForm();
                    f.setVisible(true);
                    dispose();
               }
          });
     }
}
