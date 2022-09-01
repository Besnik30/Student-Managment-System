package com.company;

import javax.swing.*;
import javax.swing.border.Border;

public class FinalsTableForm extends JFrame {
    JPanel panel=new JPanel();
    Border raisedbevel=BorderFactory.createRaisedBevelBorder();
    Border loweredbevel=BorderFactory.createLoweredBevelBorder();
    Border border=BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);

    public FinalsTableForm(){
        setSize(600,450);
        setLocation(300, 150);
        panel.setBorder(border);
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        getContentPane().add(panel);
        setVisible(true);
        showFinals();

    }

    public void showFinals(){
        Student s4=Student.StudentInfo(StudentForm.accID);
        String []column={"SezonID","LendaID","Emri i Lendes","Data","Ora","Salla"};
        Object[][] data=Administrator.getFinals(s4.getCourseId(),s4.getStudentID());
        JTable provimetTable=new JTable(data,column);
        JScrollPane scrollpane = new JScrollPane(provimetTable);
        provimetTable.getColumnModel().getColumn(2).setPreferredWidth(140);
        panel.add(provimetTable.getTableHeader());
        panel.add(provimetTable);
        panel.add(scrollpane);
    }
}
