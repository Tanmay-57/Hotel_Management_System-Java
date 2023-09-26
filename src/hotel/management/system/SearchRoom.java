package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
    SearchRoom() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Search for Room");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(310,30,200,30);
        add(text);
        
        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
        bedType = new JComboBox(new String[] {"Single Bed","Double Bed"});
        bedType.setBounds(150,100,150,25);
        add(bedType);
        
        available = new JCheckBox("Only display Available");
        available.setBounds(450,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);
        
        JLabel I1 = new JLabel("Room No");
        I1.setBounds(50,170,90,10);
        add(I1);
        
        JLabel I2 = new JLabel("Availability");
        I2.setBounds(200,170,90,13);
        add(I2);
        
        JLabel I3 = new JLabel("Status");
        I3.setBounds(360,170,90,13);
        add(I3);
        
        JLabel I4 = new JLabel("Price");
        I4.setBounds(510,170,90,13);
        add(I4);
        
        JLabel I5 = new JLabel("Bed Type");
        I5.setBounds(660,170,90,13);
        add(I5);
        
        table = new JTable();
        table.setBounds(20,200,750,100);
        add(table);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBounds(150, 410, 80, 20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
	add(back);
        
        submit = new JButton("Submit");
        submit.setBounds(350, 410, 80, 20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
	add(submit);
        
        setBounds(300,100,800,500);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== submit) {
            try {
                String query1 = "select * from room where bed_type = '"+bedType.getSelectedItem()+"'";
                String query2 = "select * from room where availability = 'Available' AND bed_type = '"+bedType.getSelectedItem()+"'" ;
                
                Conn conn = new Conn();
                ResultSet rs;
                if (available.isSelected()) {
                    rs = conn.s.executeQuery(query2);
                } else {
                    rs = conn.s.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args) {
        new SearchRoom();
        
    }
}

