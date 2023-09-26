package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    
    Dashboard() {
        setBounds(30,10,1300,700);
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1600, 700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel image = new JLabel(i3);
	image.setBounds(0, 0, 1600, 700); 
        add(image);
        
        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
	text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma", Font.PLAIN, 46));
	text.setBounds(300, 60, 1300, 85);
	image.add(text);
		
	JMenuBar mb = new JMenuBar();
	mb.setBounds(0,0,1300,30);
        image.add(mb);
		
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.BLUE);
	mb.add(hotel);
		
        JMenuItem reception = new JMenuItem("RECEPTION");
	hotel.add(reception);
        reception.addActionListener(this);
		
	JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.RED);
	mb.add(admin);
        
        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
	admin.add(addemployee);
        
        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
	admin.add(addrooms);
        addrooms.addActionListener(this);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddEmployee();
        } else if (ae.getActionCommand().equals("ADD ROOMS")) {
            new AddRooms();
        } else if (ae.getActionCommand().equals("RECEPTION")) {
            new Reception();
        }
    }
    
    public static void main(String[] args) {
        new Dashboard();
    }
    
}
