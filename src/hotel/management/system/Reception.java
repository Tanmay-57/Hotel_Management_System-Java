package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {
    JButton newCustomer,rooms,allEmployee,manginfo,customers,searchRoom,update,roomstatus,checkout,logout;
    Reception() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        newCustomer = new JButton("New Customer Form");
	newCustomer.setBounds(40, 30, 150, 20);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
	add(newCustomer);
        
        rooms = new JButton("Rooms");
	rooms.setBounds(40, 60, 150, 20);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
	add(rooms);
        
        allEmployee = new JButton("All Employees");
	allEmployee.setBounds(40, 90, 150, 20);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE); 
        allEmployee.addActionListener(this);
	add(allEmployee);
        
        customers = new JButton("Customer Info");
	customers.setBounds(40, 120, 150, 20);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers.addActionListener(this);
	add(customers);
        
        checkout = new JButton("Checkout");
	checkout.setBounds(40, 150, 150, 20);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
	add(checkout);
        
        update = new JButton("Update status");
	update.setBounds(40, 180, 150, 20);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE); 
        update.addActionListener(this);
	add(update);
        
        manginfo = new JButton("Manager Info");
	manginfo.setBounds(40, 220, 150, 20);
        manginfo.setBackground(Color.BLACK);
        manginfo.setForeground(Color.WHITE); 
        manginfo.addActionListener(this);
	add(manginfo);
        
        roomstatus = new JButton("Update Room Status");
	roomstatus.setBounds(40, 250, 150, 20);
        roomstatus.setBackground(Color.BLACK);
        roomstatus.addActionListener(this);
        roomstatus.setForeground(Color.WHITE);       
	add(roomstatus);
        
        searchRoom = new JButton("Search Rooms");
	searchRoom.setBounds(40, 280, 150, 20);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
	add(searchRoom);
        
        logout = new JButton("Logout");
	logout.setBounds(40, 310, 150, 20);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
	add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(220,10,500,380);
        add(image);

        
        setBounds(310,180,750,470);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == newCustomer) {
            setVisible(false);
            new AddCustomer();
        } else if (ae.getSource() == rooms) {
            setVisible(false);
            new Room();
        } else if (ae.getSource() == allEmployee) {
            setVisible(false);
            new EmployeeInfo();
        } else if (ae.getSource() == manginfo) {
            setVisible(false);
            new ManagerInfo();
        } else if (ae.getSource() == customers) {
            setVisible(false);
            new CustomerInfo();
        } else if (ae.getSource() == searchRoom) {
            setVisible(false);
            new SearchRoom();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateCheck();
        } else if (ae.getSource() == roomstatus) {
            setVisible(false);
            new UpdateRoom();
        } else if (ae.getSource() == checkout) {
            setVisible(false);
            new Checkout();
        } else if (ae.getSource() == logout) {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String [] args) {
        new Reception();
        
    }
    
}
