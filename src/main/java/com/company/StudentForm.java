package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentForm extends JFrame {
    JPanel emptyPanel=new JPanel();
    JPanel panel=new JPanel();
    JPanel passChange=new JPanel();
    JPanel orariPanel=new JPanel();
    JPanel transkriptPanel=new JPanel();

    JButton profili=new JButton("Profili");
    JButton orariButon=new JButton("Orari");
    JButton transkript=new JButton("Transkripti");
    JButton regjistrim=new JButton("Regjistrohu");
    JButton logOut=new JButton("LogOut");
    JButton changeP=new JButton("Ndrysho Password");
    JButton submitButton=new JButton("Submit");
    JButton cancel=new JButton("Cancel");
    JButton back=new JButton("Back");
    JButton shfaq=new JButton("Shfaq provimet");

    JLabel menu=new JLabel("MENU");
    JLabel acountId=new JLabel("AcountID");
    JLabel password=new JLabel("Password");
    JLabel emri=new JLabel("Emri");
    JLabel mbiemri=new JLabel("Mbiemri");
    JLabel datelindja=new JLabel("Datelindja");
    JLabel dega=new JLabel("Dega");
    JLabel viti=new JLabel("Viti");
    JLabel oldPassLabel=new JLabel("Password i vjeter");
    JLabel newPassLabel=new JLabel("Password i ri");

    JTextField oldPassTf=new JTextField();
    JTextField newPassTf=new JTextField();

    Border blackline = BorderFactory.createLineBorder(Color.BLACK);
    Border raisedbevel=BorderFactory.createRaisedBevelBorder();
    Border loweredbevel=BorderFactory.createLoweredBevelBorder();
    Border border=BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);

    static String accID;

    public StudentForm(){
        setSize(800,550);
        setLocation(200, 100);
        //Panelet
        panel.setLayout(null);
        emptyPanel.setLayout(null);
        passChange.setLayout(null);
        orariPanel.setLayout(new BoxLayout(orariPanel,BoxLayout.PAGE_AXIS));
        transkriptPanel.setLayout(new BoxLayout(transkriptPanel,BoxLayout.PAGE_AXIS));
        panel.setSize(200,550);
        panel.setLocation(0,0);
        passChange.setSize(600,550);
        passChange.setLocation(600,0);
        emptyPanel.setSize(150,400);
        emptyPanel.setLocation(100,0);
        orariPanel.setSize(800,550);
        orariPanel.setLocation(200, 100);
        panel.setBorder(border);
        passChange.setBorder(border);
        emptyPanel.setBorder(border);
        orariPanel.setBorder(border);
        transkriptPanel.setBorder(border);
        //Panel1
        profili.setBounds(30,160,140, 30);
        orariButon.setBounds(30,200,140, 30);
        transkript.setBounds(30,240,140, 30);
        regjistrim.setBounds(30,280,140, 30);
        shfaq.setBounds(30,320,140, 30);
        logOut.setBounds(30,360,140, 30);
        menu.setBounds(80,100,100,80);
        //Personal
        acountId.setBounds(400,70,140,30);
        password.setBounds(400,100,140,30);
        emri.setBounds(400,130,140,30);
        mbiemri.setBounds(400,160,140,30);
        datelindja.setBounds(400,190,140,30);
        dega.setBounds(400,220,140,30);
        viti.setBounds(400,250,140,30);
        changeP.setBounds(390,300,160,30);
        //ChangePass
        oldPassLabel.setBounds(330,190,140,30);
        newPassLabel.setBounds(340,240,140,30);
        oldPassTf.setBounds(440,190,140,30);
        newPassTf.setBounds(440,240,140,30);
        submitButton.setBounds(390,280,100,30);
        cancel.setBounds(520,280,100,30);

        panel.add(profili);
        panel.add(orariButon);
        panel.add(transkript);
        panel.add(regjistrim);
        panel.add(logOut);
        panel.add(menu);
        panel.add(shfaq);

        getContentPane().add(panel);
        getContentPane().add(emptyPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        LogOut();
        Personale();
        changePass();
        Submit();
        Cancel();
        showTimetable();
        showTranskript();
        Back();
        Regjistro();
        shfqaRegjistrimet();
    }
    public void LogOut(){
        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstForm f=new FirstForm();
                f.setVisible(true);
                dispose();
            }
        });
    }
    public void Personale(){
        profili.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student s=Student.StudentInfo(accID);
                Account a= Account.getPass(accID);
                String pass=a.getPassword();

                emptyPanel.add(changeP);
                changeP.setBorder(blackline);
                emptyPanel.add(acountId);
                acountId.setText("AcountID :"+accID);
                acountId.setBorder(blackline);
                emptyPanel.add(password);
                password.setBorder(blackline);
                password.setText("Password :"+pass);
                emptyPanel.add(emri);
                emri.setBorder(blackline);
                emri.setText("Emri :"+s.getName());
                emptyPanel.add(mbiemri);
                mbiemri.setBorder(blackline);
                mbiemri.setText("Mbiemri :"+s.getSurname());
                emptyPanel.add(datelindja);
                datelindja.setBorder(blackline);
                datelindja.setText("Datelindja :"+s.getBirthday());
                emptyPanel.add(dega);
                dega.setBorder(blackline);
                dega.setText("Dega :"+s.getCourseId());
                emptyPanel.add(viti);
                viti.setBorder(blackline);
                viti.setText("Viti :"+s.getYear());
                passChange.setVisible(false);
                orariPanel.setVisible(false);
                getContentPane().add(emptyPanel);
                emptyPanel.setVisible(true);
            }
        });
    }
    public void changePass(){
        changeP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passChange.add(oldPassLabel);
                passChange.add(oldPassTf);
                passChange.add(newPassLabel);
                passChange.add(newPassTf);
                passChange.add(submitButton);
                passChange.add(cancel);
                emptyPanel.setVisible(false);
                orariPanel.setVisible(false);
                getContentPane().add(passChange);
                passChange.setVisible(true);
            }
        });
    }
    public void Submit(){
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldPass=oldPassTf.getText();
                String newPass=newPassTf.getText();

                Account acc=new Account(accID,oldPass);

                if(acc.changePassword(acc,newPass) && !oldPass.equals(newPass)){
                    JOptionPane.showMessageDialog(null,"Passwordi u nderua me sukses");
                    oldPassTf.setText("");
                    newPassTf.setText("");
                    passChange.setVisible(false);
                    orariPanel.setVisible(false);
                    emptyPanel.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Password i vjeter nuk eshte i sakte ose password i ri eshte i njejte me te vjetrin");
                    oldPassTf.setText("");
                    newPassTf.setText("");
                    oldPassTf.requestFocus();
                }
            }
        });
    }
    public void Cancel(){
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passChange.setVisible(false);
                emptyPanel.setVisible(false);
            }
        });
    }
    public void showTimetable(){
        final int[] r1 = {0};
        orariButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student s1=Student.StudentInfo(accID);
                String[] columnName1={"Lenda","P.Emri","P.Mbiemri","MesimDhenia","Dita","Ora","Salla"};
                Object[][] data1= Timetable.getTimetable(s1.getYear(),s1.getCourseId());
                JTable orariTabela = new JTable(data1,columnName1);
                orariTabela.getColumnModel().getColumn(0).setPreferredWidth(150);
                orariTabela.getColumnModel().getColumn(3).setPreferredWidth(150);
                orariTabela.setFillsViewportHeight(true);
                JScrollPane scrollpane = new JScrollPane(orariTabela);

                if(r1[0] ==0){
                    orariPanel.add(orariTabela.getTableHeader());
                    orariPanel.add(orariTabela);
                    orariPanel.add(scrollpane);
                    r1[0]++;
                }
                orariPanel.add(back);
                emptyPanel.setVisible(false);
                panel.setVisible(false);
                passChange.setVisible(false);
                getContentPane().add(orariPanel);
                orariPanel.setVisible(true);
            }
        });
    }

    public void showTranskript(){
        final int[] r2 = {0};
        transkript.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[]columnName2={"Sezoni","Emri i Lendes","Nota"};
                Object[][]data2=Transkript.getTranscript(accID);
                JTable transkript=new JTable(data2,columnName2);
                transkript.setFillsViewportHeight(true);
                JScrollPane scrollpane = new JScrollPane(transkript);
                if(r2[0] ==0){
                    transkriptPanel.add(transkript.getTableHeader());
                    transkriptPanel.add(transkript);
                    transkriptPanel.add(scrollpane);
                   r2[0]++;
                }
                transkriptPanel.add(back);
                emptyPanel.setVisible(false);
                panel.setVisible(false);
                passChange.setVisible(false);
                orariPanel.setVisible(false);
                getContentPane().add(transkriptPanel);
                transkriptPanel.setVisible(true);
            }
        });
    }
    public void Regjistro(){
        regjistrim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentRegistrationForm sr=new StudentRegistrationForm();
                sr.setVisible(true);
            }
        });
    }
    public void shfqaRegjistrimet(){
        shfaq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FinalsTableForm finalsTableForm =new FinalsTableForm();
                finalsTableForm.setVisible(true);
            }
        });
    }
    public void Back(){
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orariPanel.setVisible(false);
                transkriptPanel.setVisible(false);
                panel.setVisible(true);
                emptyPanel.setVisible(false);
            }
        });
    }
}

