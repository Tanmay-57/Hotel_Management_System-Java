package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
    
    JButton add,cancel;
    JTextField tfroom,tfprice;
    JComboBox typecombo,availablecombo,cleancombo;
    AddRooms() {
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,16));
        heading.setBounds(150,0,200,50);
        add(heading);
        
        JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoma",Font.BOLD,13));
        lblroomno.setBounds(60,70,200,40);
        add(lblroomno);
        
        tfroom = new JTextField();
        tfroom.setBounds(180,80,100,20);
        add(tfroom);
        
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma",Font.BOLD,13));
        lblavailable.setBounds(60,120,200,40);
        add(lblavailable);
        
        String availableOptions[] = {"Available","Occupied"};
        availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(180,130,100,20);
        add(availablecombo);
        
        JLabel lblclean= new JLabel("Cleaning status");
        lblclean.setFont(new Font("Tahoma",Font.BOLD,13));
        lblclean.setBounds(60,170,200,40);
        add(lblclean);
        
        String cleanOptions[] = {"Cleaned","Dirty"};
        cleancombo = new JComboBox(cleanOptions);
        cleancombo.setBounds(180,180,100,20);
        add(cleancombo);
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("Tahoma",Font.BOLD,13));
        lblprice.setBounds(60,220,200,40);
        add(lblprice);
        
        tfprice = new JTextField();
        tfprice.setBounds(180,230,100,20);
        add(tfprice);
        
        JLabel lbltype= new JLabel("Bed Type");
        lbltype.setFont(new Font("Tahoma",Font.BOLD,13));
        lbltype.setBounds(60,270,200,40);
        add(lbltype);
        
        String typeOptions[] = {"Single bed","Double bed"};
        typecombo = new JComboBox(typeOptions);
        typecombo.setBounds(180,280,100,20);
        add(typecombo);
        
        add = new JButton("Add Room");
	add.setBounds(64, 340, 100, 20);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
	add(add);
        
        cancel = new JButton("Cancel");
	cancel.setBounds(200, 340, 100, 20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
	add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(360,50,390,300);
        add(image);

	
        
        
        setBounds(260,170,830,470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String roomnumber = tfroom.getText();
            String availability = (String) availablecombo.getSelectedItem();
            String status = (String) cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String) typecombo.getSelectedItem();
            
            try {
                Conn conn = new Conn();
            
                String str = "insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
            
                conn.s.executeUpdate(str);
            
                JOptionPane.showMessageDialog(null,"Room added successfully");
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        } else {
            setVisible(false);
        }
    }
    

    public static void main(String[] args) {
            new AddRooms();
    }
    
}

