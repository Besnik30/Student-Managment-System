package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstForm extends JFrame {
    JPanel panel=new JPanel();
    JButton signUp=new JButton("SignUp");
    JButton logIn=new JButton("LogIn");

    public FirstForm(){
        setSize(300, 200);
        setLocation(500, 280);
        panel.setLayout(null);
        signUp.setBounds(100, 100, 100, 30);
        logIn.setBounds(100, 60, 100, 30);
        Border blackline = BorderFactory.createLineBorder(Color.BLACK);

        panel.add(signUp);
        panel.add(logIn);
        panel.setBorder(blackline);
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        actionSignUp();
        actionLogIn();
    }

    public void actionLogIn(){
        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginForm logIN=new LoginForm();
                logIN.setVisible(true);
                dispose();
            }
        });
    }

    public void actionSignUp(){
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpForm sf=new SignUpForm();
                sf.setVisible(true);
                dispose();
            }
        });
    }
}
