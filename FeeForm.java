import java.awt.Color;

import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FeeForm  extends JFrame{
    FeeForm(){
        setSize(900,500);
        setLocation(300,100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
         Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image); 

        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50, 100, 200, 20);
        lblrollnumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblrollnumber);
        
        crollno = new Choice();
        crollno.setBounds(250, 100, 200, 20);
        add(crollno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("Rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200, 150, 150, 30);
        labelname.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(600, 150, 250, 30);
        labelfname.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelfname);

        setVisible(true);
    }
public static void main(String[] args) {
        new FeeForm();
    }
}
