package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener  {

    HotelManagementSystem (){
        setSize(1170,565);
        setLocation(100,100);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1170,565);
        add(image);
        setVisible(true);
        
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(30,430,2000,100);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN,40));
        image.add(text);
        
        JButton next = new JButton("NEXT");
        next.setBounds(1000,465,100,50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.MAGENTA);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN,20));
        image.add(next);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
