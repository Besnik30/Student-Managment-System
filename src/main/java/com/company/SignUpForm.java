package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;


public class SignUpForm extends JFrame {
    JPanel panel1=new JPanel();
    JPanel studentSignUp=new JPanel();
    JPanel pedagogSignUp=new JPanel();
    String sid,pass,emr,mb,dat,vit,pId;
    Object deg1;

    JButton btn = new JButton("Next");
    JButton btn2=new JButton("Submit");
    JButton btn3=new JButton("Submit");
    JButton btn4=new JButton("Cancel");
    JButton btn5=new JButton("Cancel");

    JRadioButton student=new JRadioButton("Student");
    JRadioButton pedagog=new JRadioButton("Pedagog");

    JLabel studentId=new JLabel("StudentID: ");
    JLabel pedagogId=new JLabel("PedagogID: ");
    JLabel pasword=new JLabel("Password: ");
    JLabel pasword2=new JLabel("Password: ");
    JLabel emri=new JLabel("Emri: ");
    JLabel emri2=new JLabel("Emri: ");
    JLabel mbiemri=new JLabel("Mbiemri: ");
    JLabel mbiemri2=new JLabel("Mbiemri: ");
    JLabel datelindja=new JLabel("Datelindja: ");
    JLabel datelindja2=new JLabel("Datelindja: ");
    JLabel viti=new JLabel("Viti: ");
    JLabel dega=new JLabel("Dega: ");

    String[] deget= Course.getCourseID();
    JComboBox comboBox=new JComboBox(deget);

    JTextField textField1=new JTextField(20);
    JTextField textField2=new JTextField(20);
    JTextField textField3=new JTextField(20);
    JTextField textField4=new JTextField(20);
    JTextField textField5=new JTextField(20);
    JTextField textField7=new JTextField(20);
    JTextField textField8=new JTextField(20);
    JTextField textField9=new JTextField(20);
    JTextField textField10=new JTextField(20);
    JTextField textField11=new JTextField(20);
    JTextField textField12=new JTextField(20);


    public SignUpForm(){

        setSize(800,550);
        setLocation(200, 100);
        studentSignUp.setLayout(null);
        pedagogSignUp.setLayout(null);

        Border blackline = BorderFactory.createLineBorder(Color.BLACK);

        student.setBounds(10,800,400,200);
        pedagog.setBounds(20,840,400,200);

        studentId.setBounds(260,30,140,30);
        textField1.setBounds(340,30,140, 30);

        emri.setBounds(260,70,140, 30);
        textField2.setBounds(340,70,140, 30);

        mbiemri.setBounds(260,110,140, 30);
        textField3.setBounds(340,110,140, 30);

        datelindja.setBounds(260,150,140, 30);
        textField4.setBounds(340,150,140, 30);

        viti.setBounds(260,190,140, 30);
        textField5.setBounds(340,190,140, 30);

        dega.setBounds(260,230,140, 30);
        comboBox.setBounds(340,230,140,30);

        pasword.setBounds(260,270,140,30);
        textField7.setBounds(340,270,140,30);

        pedagogId.setBounds(260,30,140,30);
        textField9.setBounds(340,30,140,30);

        emri2.setBounds(260,70,140, 30);
        textField10.setBounds(340,70,140, 30);

        mbiemri2.setBounds(260,110,140, 30);
        textField11.setBounds(340,110,140, 30);

        datelindja2.setBounds(260,150,140, 30);
        textField12.setBounds(340,150,140, 30);

        pasword2.setBounds(260,190,140,30);
        textField8.setBounds(340,190,140,30);

        btn2.setBounds(350,320,100, 30);
        btn3.setBounds(350,260,100, 30);
        btn4.setBounds(350,360,100,30);
        btn5.setBounds(350,300,100,30);

        textField1.setText("S_ _ _ _ _");
        textField4.setText("YYYY-MM-DD");
        textField12.setText("YYYY-MM-DD");
        textField9.setText("P_ _ _ _ _");

        studentSignUp.add(studentId);
        studentSignUp.add(textField1);
        studentSignUp.add(emri);
        studentSignUp.add(textField2);
        studentSignUp.add(mbiemri);
        studentSignUp.add(textField3);
        studentSignUp.add(datelindja);
        studentSignUp.add(textField4);
        studentSignUp.add(viti);
        studentSignUp.add(textField5);
        studentSignUp.add(dega);
        studentSignUp.add(comboBox);
        studentSignUp.add(pasword);
        studentSignUp.add(textField7);
        studentSignUp.add(btn2);
        studentSignUp.add(btn4);
        studentSignUp.setBorder(blackline);

        pedagogSignUp.add(pedagogId);
        pedagogSignUp.add(textField8);
        pedagogSignUp.add(emri2);
        pedagogSignUp.add(textField9);
        pedagogSignUp.add(mbiemri2);
        pedagogSignUp.add(textField10);
        pedagogSignUp.add(datelindja2);
        pedagogSignUp.add(textField11);
        pedagogSignUp.add(pasword2);
        pedagogSignUp.add(textField12);
        pedagogSignUp.add(btn3);
        pedagogSignUp.add(btn5);
        pedagogSignUp.setBorder(blackline);

        panel1.add(student);
        panel1.add(pedagog);
        panel1.add(btn);

        ButtonGroup bg = new ButtonGroup();
        bg.add(student);
        bg.add(pedagog);

        getContentPane().add(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        actionCheck();
        submit();
        submit2();
        Cancel();
        Cancel2();
    }

      public void actionCheck(){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(student.isSelected()){
                   panel1.setVisible(false);
                   getContentPane().add(studentSignUp);
                   studentSignUp.setVisible(true);
                }
                if(pedagog.isSelected()){
                    panel1.setVisible(false);
                    studentSignUp.setVisible(false);
                    getContentPane().add(pedagogSignUp);
                    pedagogSignUp.setVisible(true);
                }
            }
        });
    }

    public void submit(){
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {

               try{
                   if(studentSignUp.isVisible()){
                    sid=textField1.getText();
                    emr=textField2.getText();
                    mb=textField3.getText();
                    dat=textField4.getText();
                    vit=textField5.getText();
                    int vit2=Integer.parseInt(vit);
                    deg1=comboBox.getSelectedItem();
                    String deg2=String.valueOf(deg1);
                    pass=textField7.getText();
                    Date dat2=Date.valueOf(dat);

                    if(sid.startsWith("S")){
                        Student s=new Student(sid,emr,mb,dat2,deg2,vit2);
                        Account a=new Account(sid,pass);
                        s.addStudent(s);
                        a.addStudentAccount(a);
                        FirstForm f=new FirstForm();
                        f.setVisible(true);
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,"StudentID duhet te filloj me shkronjes S");
                        textField1.requestFocus();
                    }
                }
            }catch (RuntimeException e1){
                   JOptionPane.showMessageDialog(null,"Nuk jane plotesuar te gjitha fushat ose formati i dates i gabuar");
                   textField2.setText("");
                   textField3.setText("");
                   textField5.setText("");
                   textField7.setText("");
                   textField1.setText("S_ _ _ _ _");
                   textField4.setText("YYYY-MM-DD");
                   textField1.requestFocus();
               }
            }
        });
    }
    public void submit2(){
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {

                try{
                    if(pedagogSignUp.isVisible()){
                        pId=textField9.getText();
                        emr=textField10.getText();
                        mb=textField11.getText();
                        dat=textField12.getText();
                        pass=textField8.getText();
                        Date dat2=Date.valueOf(dat);

                        if(pId.startsWith("P")){
                            Professor p=new Professor(pId,emr,mb,dat2);
                            Account a=new Account(pId,pass);
                            p.addProfessor(p);
                            a.addProfessorAccount(a);
                            FirstForm f=new FirstForm();
                            f.setVisible(true);
                            dispose();
                        }else{
                            JOptionPane.showMessageDialog(null,"PedagogID duhet te filloj me shkronjes P");
                            textField8.requestFocus();
                        }
                    }
                }catch (RuntimeException e1){
                    JOptionPane.showMessageDialog(null,"Nuk jane plotesuar te gjitha fushat ose formati i dates i gabuar");

                    textField8.setText("");
                    textField10.setText("");
                    textField11.setText("");
                    textField12.setText("YYYY-MM-DD");
                    textField9.setText("P_ _ _ _ _");
                    textField9.requestFocus();
                }
            }
        });
    }
    public void Cancel(){
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstForm f=new FirstForm();
                f.setVisible(true);
                dispose();
            }
        });
    }
    public void Cancel2(){
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstForm f=new FirstForm();
                f.setVisible(true);
                dispose();
            }
        });
    }
}


