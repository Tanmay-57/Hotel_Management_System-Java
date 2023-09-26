package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    CustomerInfo() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel I1 = new JLabel("Document Type");
        I1.setBounds(35,10,90,15);
        add(I1);
        
        JLabel I2 = new JLabel("Phone No");
        I2.setBounds(180,10,90,13);
        add(I2);
        
        JLabel I3 = new JLabel("Name");
        I3.setBounds(300,10,90,13);
        add(I3);
        
        JLabel I4 = new JLabel("Gender");
        I4.setBounds(420,10,90,13);
        add(I4);
        
        JLabel I5 = new JLabel("Allocated Room");
        I5.setBounds(510,10,90,13);
        add(I5);
        
        JLabel I6 = new JLabel("Checkin Time");
        I6.setBounds(640,10,90,13);
        add(I6);
        
        JLabel I7 = new JLabel("Deposit");
        I7.setBounds(760,10,150,13);
        add(I7);
        
        table = new JTable();
        table.setBounds(25,40,830,300);
        add(table);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBounds(150, 400, 80, 20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
	add(back);
        
        setBounds(300,100,900,500);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args) {
        new CustomerInfo();
        
    }
}


    


