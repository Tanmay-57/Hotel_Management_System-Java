package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Room() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 440,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420,20,330,400);
        add(image);
        
        JLabel I1 = new JLabel("Room No");
        I1.setBounds(12,10,90,10);
        add(I1);
        
        JLabel I2 = new JLabel("Availability");
        I2.setBounds(99,10,90,13);
        add(I2);
        
        JLabel I3 = new JLabel("Status");
        I3.setBounds(190,10,90,13);
        add(I3);
        
        JLabel I4 = new JLabel("Price");
        I4.setBounds(270,10,90,13);
        add(I4);
        
        JLabel I5 = new JLabel("Bed Type");
        I5.setBounds(345,10,90,13);
        add(I5);
        
        table = new JTable();
        table.setBounds(10,40,400,300);
        add(table);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
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
        
        setBounds(300,100,800,500);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args) {
        new Room();
        
    }
}
