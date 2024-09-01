import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame {
     About(){
        setSize(700,500);
        setLocation(400,150);
        getContentPane().setBackground(Color.WHITE);
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
         Image i2=i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,300,200);
        add(image); 

        JLabel heading=new JLabel("<html>University<br/> Management System<html/>");
        heading.setBounds(70,20,300,130);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);
        setLayout(null);

        JLabel name=new JLabel("Developed By : AJAY PAL");
        name.setBounds(70,220,500,40);
        name.setFont(new Font("Tahoma",Font.BOLD,30));
        add(name);

        JLabel Rollno=new JLabel(" Roll No : 1531146");
        Rollno.setBounds(70,280,500,40);
        Rollno.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(Rollno);

        JLabel contact=new JLabel(" Email: apal30100@gmail.com");
        contact.setBounds(70,320,500,40);
        contact.setFont(new Font("serif",Font.ITALIC,30));
        add(contact);
        setLayout(null);

        setVisible(true);
     }
     public static void main(String[] args) {
        new About();
     }
}
