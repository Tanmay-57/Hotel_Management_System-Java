package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JTextField tfroom,tfavailable,tfpaid,tfstatus,tfpending;
    JButton check,update,back;
    
    UpdateRoom() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(90,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);
      
        JLabel lblid = new JLabel("Customer Id");
        lblid.setFont(new Font("Tahoma",Font.PLAIN,15));
        lblid.setBounds(30,85,100,20);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(150,83,150,25);
        add(ccustomer);
        
        try {
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery("select * from customer");
            while(rs.next()) {
                ccustomer.add(rs.getString("number"));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setFont(new Font("Tahoma",Font.PLAIN,15));
        lblroom.setBounds(30,130,100,20);
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(150,130,150,25);
        add(tfroom);
        
        JLabel lblname = new JLabel("Availability");
        lblname.setFont(new Font("Tahoma",Font.PLAIN,15));
        lblname.setBounds(30,175,100,20);
        add(lblname);
        
        tfavailable = new JTextField();
        tfavailable.setBounds(150,175,150,25);
        add(tfavailable);
        
        JLabel lblstatus = new JLabel("Cleaning Status");
        lblstatus.setFont(new Font("Tahoma",Font.PLAIN,15));
        lblstatus.setBounds(30,220,100,20);
        add(lblstatus);
        
        tfstatus = new JTextField();
        tfstatus.setBounds(150,220,150,25);
        add(tfstatus);
        
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        check.setBounds(30,340,90,30);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setBounds(140,340,90,30);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(250,340,90,30);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(470, 420,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(340,20,450,300);
        add(image);
        
        
        
        
        
                
        setBounds(250,130,830,450);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()) {
                    tfroom.setText(rs.getString("room"));
                }
                
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
                while(rs2.next()) {
                    tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaning_status"));
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String status = tfstatus.getText();
            
            try {
                Conn c = new Conn();
                c.s.executeUpdate("update room set availability = '"+available+"',cleaning_status = '"+status+"' where roomnumber = '"+room+"'");
                
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                
                setVisible(false);
                new Reception();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else {
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String [] agrs) {
        new UpdateRoom();
    }
    
}
