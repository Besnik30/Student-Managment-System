package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame{
    JPanel panel=new JPanel();
    JLabel acountID2=new JLabel("Acount ID");
    JLabel password=new JLabel("Password");
    JTextField textField=new JTextField(10);
    JPasswordField passwordField=new JPasswordField(20);
    JButton button=new JButton("Submit");
    JButton button2=new JButton("Cancel");

    public LoginForm(){
        setSize(500, 400);
        setLocation(400, 280);
        panel.setLayout(null);
        acountID2.setBounds(100, 30, 100, 20);
        password.setBounds(100, 50, 120, 40);
        textField.setBounds(180, 30, 150, 20);
        passwordField.setBounds(180, 60, 150, 20);
        button.setBounds(180, 100, 100, 30);
        button2.setBounds(180,140,100,30);
        Border blackline = BorderFactory.createLineBorder(Color.BLACK);

        panel.add(acountID2);
        panel.add(password);
        panel.add(textField);
        panel.add(passwordField);
        panel.add(button);
        panel.add(button2);
        panel.setBorder(blackline);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setVisible(true);

        actionLogIn();
        Cancel();
    }
    public void actionLogIn(){

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String accID2=textField.getText();
                char[] pass=passwordField.getPassword();
                String pass2=String.valueOf(pass);
                Account acc=new Account(accID2,pass2);

                try{
                    if(acc.logIn(acc) && accID2.startsWith("S")){
                        StudentForm s=new StudentForm();
                        StudentForm.accID=accID2;
                        s.setVisible(true);
                        dispose();
                    }
                    else if(acc.logIn(acc) && accID2.startsWith("P")){
                        ProfessorForm p=new ProfessorForm();
                        p.accID=accID2;
                        p.setVisible(true);
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Wrong AcountID/Password");
                        textField.setText("");
                        passwordField.setText("");
                        textField.requestFocus();
                    }
                }catch (NumberFormatException e1){
                    JOptionPane.showMessageDialog(null,"Nuk jane plotesuar te gjitha fushat ose format i gabuar");
                    textField.requestFocus();
                }

            }
        });
    }
    public void Cancel(){
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstForm f=new FirstForm();
                f.setVisible(true);
                dispose();
            }
        });
    }

}
