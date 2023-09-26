package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
    
    JComboBox comboid;
    JTextField tfnumber,tfname,tfdeposit;
    JRadioButton rmale,rfemale;
    Choice croom;
    JLabel checkintime;
    JButton add,back;
    
            
    AddCustomer() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setFont(new Font("Tahoma",Font.BOLD,16));
        text.setBounds(50,0,200,70);
        add(text);
        
        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Tahoma",Font.BOLD,14));
        lblid.setBounds(30,80,20,15);
        add(lblid);
        
        String options[] = {"Aadhar Card","Passport","Driving License"};
        comboid = new JComboBox(options);
        comboid.setBounds(180,78,100,22);
        add(comboid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma",Font.BOLD,14));
        lblnumber.setBounds(30,130,100,15);
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(180,128,100,25);
        add(tfnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        lblname.setBounds(30,183,100,15);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(180,179,100,25);
        add(tfname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma",Font.BOLD,14));
        lblgender.setBounds(30,233,100,15);
        add(lblgender);
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(160,230,70,20);
        rmale.setBackground(Color.WHITE);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(230,230,80,20);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setFont(new Font("Tahoma",Font.BOLD,14));
        lblroom.setBounds(30,330,150,15);
        add(lblroom);
        
        croom = new Choice();
        
        try {
            Conn conn = new Conn();
            String query = "select * from room where availability = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()) {
                croom.add(rs.getString("roomnumber"));
            }
            conn.s.executeQuery(query);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        croom.setBounds(180,328,100,25);
        add(croom);
        
        JLabel lbltime = new JLabel("Checkin Time");
        lbltime.setFont(new Font("Tahoma",Font.BOLD,14));
        lbltime.setBounds(30,380,150,15);
        add(lbltime);
        
        Date date = new Date();
        
        checkintime = new JLabel(""+date);
        checkintime.setFont(new Font("Tahoma",Font.BOLD,14));
        checkintime.setBounds(180,380,165,15);
        add(checkintime);
        
        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setFont(new Font("Tahoma",Font.BOLD,14));
        lbldeposit.setBounds(30,280,100,15);
        add(lbldeposit);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(180,278,100,25);
        add(tfdeposit);
        
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(30,410,100,20);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(180,410,100,20);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(320, 380,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(320,100,370,330);
        add(image);

        setBounds(320,100,700,500);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            
            if (rmale.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }
           
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();
            
            try {
                String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+room+"','"+time+"','"+deposit+"')";
                String query2 = "update room set availability = 'Occupied' where roomnumber = '" +room+"'";
                
                Conn conn = new Conn();
                
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"New Customer added successfully");
                setVisible(false);
                new Reception();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
            
        }
        
    }
    
    public static void main (String[] args) {
        new AddCustomer();
    }
    
}
