package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegjistrimForm extends JFrame {
    JPanel panel=new JPanel();
    JButton regjistro=new JButton("Regjistrohu");
    JLabel zgjidh=new JLabel("Zgjidh Lendet: ");
    Border raisedbevel=BorderFactory.createRaisedBevelBorder();
    Border loweredbevel=BorderFactory.createLoweredBevelBorder();
    Border border=BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);

    Student student=Student.StudentInfo(StudentForm.accID);
    String[]lendet=Administrator.ktheProvimeID(student.getDegaId(),student.getViti());
    JComboBox comboBox=new JComboBox(lendet);

    public StudentRegjistrimForm(){
        setSize(600,300);
        setLocation(350, 280);
        panel.setLayout(null);
        panel.setBorder(border);
        zgjidh.setBounds(90,100,100,30);
        comboBox.setBounds(200,100,110,30);
        regjistro.setBounds(330,100,100,30);
        panel.add(zgjidh);
        panel.add(regjistro);
        panel.add(comboBox);
        getContentPane().add(panel);
        setVisible(true);
        Regjistrim();

    }
    public void Regjistrim(){
        regjistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object lendaID=comboBox.getSelectedItem();
                if (Frekuentime.ktheFrekuentimin(student.getStuID(),lendaID))
                    JOptionPane.showMessageDialog(null, "NUk regjistrohesh dot ne kte lende per shkak frekuentimi");

                else if(Regjistrime.ktheRegjistrime(student.getStuID(),lendaID))
                    JOptionPane.showMessageDialog(null, "Je rregjistuar njehere ne kte lende");

                else {
                    Regjistrime.shtoRegjistrim(student, lendaID);
                    JOptionPane.showMessageDialog(null, "Regjistrimi u krye me sukses");
                }
            }
        });
    }
}
