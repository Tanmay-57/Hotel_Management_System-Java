package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField tfname,tfemail,tfphone,tfage,tfsalary;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    JComboBox cbjob;
    
    AddEmployee() {
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,130,750,470);
        setVisible(true);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblname.setBounds(60, 30, 150, 27);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(140, 30, 130, 27);
        add(tfname);
        
        JLabel lblage = new JLabel("AGE");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblage.setBounds(60, 77, 150, 27);
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(140, 77, 130, 27);
        add(tfage);
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblgender.setBounds(60, 124, 150, 27);
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(140, 124, 70, 27);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(210, 124, 80, 27);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lbljob = new JLabel("JOB");
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbljob.setBounds(60, 171, 150, 27);
        add(lbljob);
        
        String str[] = {"Front desk clerks","Kitchen staff","Waiter/Waitress","Chefs","Room service"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(140,177,150,24);
        add(cbjob);
        
        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblsalary.setBounds(60, 230, 150, 27);
        add(lblsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(140, 230, 130, 27);
        add(tfsalary);
        
        JLabel lblphone = new JLabel("PHONE");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblphone.setBounds(60, 280, 150, 27);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(140, 280, 130, 27);
        add(tfphone);
        
        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblemail.setBounds(60, 330, 150, 27);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(140, 330, 130, 27);
        add(tfemail);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(110,380,130,27);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(360, 420,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(320,100,370,260);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,180,750,470);
        setVisible(true);
  
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String age =tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        
        String gender = null;
        
        if(rbmale.isSelected()) {
            gender = "Male";
        } else if (rbfemale.isSelected()) {
            gender = "Female";
        }
        
        String job = (String) cbjob.getSelectedItem();
        
        try {
            Conn conn = new Conn();
            
            String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Employee added successfully");
            setVisible(false);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    public static void main (String[] args) {
        new AddEmployee();
    }
    
}
