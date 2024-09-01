import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
public class AddStudent extends JFrame implements ActionListener{
    JTextField tfname,tffname,tfaddress,tfphone,tfemail,tfhigh,tfinter,tfaadharno;
    JDateChooser dcdob;
    JLabel labelrollno;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;
    Random ran=new Random();
    long first=Math.abs(ran.nextLong()%9000L)+1000L;

    AddStudent(){
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);

        JLabel heading=new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel lblname=new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

        JLabel lblfname=new JLabel("Father's Name");
        lblfname.setBounds(450,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);

        tffname=new JTextField();
        tffname.setBounds(650,150,150,30);
        add(tffname);

       JLabel lblrollno=new JLabel("Roll Number");
        lblrollno.setBounds(50,200,150,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);

        labelrollno=new JLabel("1622"+first);
        labelrollno.setBounds(200,200,200,30);
        labelrollno.setFont(new Font("serif",Font.BOLD,20));
        add(labelrollno);

        JLabel lbldob=new JLabel("Date OF Birth");
        lbldob.setBounds(450,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        
        dcdob=new JDateChooser();
        dcdob.setBounds(650,200,150,30);
        add(dcdob);

        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(50,250,200,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);
         
        tfaddress=new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel lblphone= new JLabel("Phone Number");
        lblphone.setBounds(450,250,150,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);
        
        tfphone =new JTextField();
        tfphone.setBounds(650,250,150,30);
        add(tfphone);

        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(50,300,150,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);

        tfemail=new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel lblhigh=new JLabel("Class X (%)");
        lblhigh.setBounds(450,300,200,30);
        lblhigh.setFont(new Font("serif",Font.BOLD,20));
        add(lblhigh);

        tfhigh=new JTextField();
        tfhigh.setBounds(650,300,150,30);
        add(tfhigh);

        JLabel lblinter=new JLabel("Class XII (%)");
        lblinter.setBounds(50,350,200,30);
        lblinter.setFont(new Font("serif",Font.BOLD,20));
        add(lblinter);

        tfinter=new JTextField();
        tfinter.setBounds(200,350,150,30);
        add(tfinter);

        JLabel lblaadharno=new JLabel("Aadhar Number");
        lblaadharno.setBounds(450,350,200,30);
        lblaadharno.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadharno);

        tfaadharno=new JTextField();
        tfaadharno.setBounds(650,350,150,30);
        add(tfaadharno);

        JLabel lblcourse=new JLabel("Course");
        lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        
       String course[]={"B.Tech","BBA","BCA","Bsc","Msc","MBA","MCA","MCom","Mcom","BA","MA"};
        cbcourse=new JComboBox(course);
        cbcourse.setBackground(Color.WHITE);
        cbcourse.setBounds(200,400,150,30);
        add(cbcourse);

        JLabel lblbranch=new JLabel("Branch");
        lblbranch.setBounds(450,400,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
        
       String branch[]={"Computer Science","Mechanical","Electrical","Civil","Electronic","Hindi","PCM","Biology","Chemistry","English","Finance","History"};
        cbbranch=new JComboBox(branch);
        cbbranch.setBackground(Color.WHITE);
        cbbranch.setBounds(650,400,150,30);
        add(cbbranch);

        
        submit=new JButton("Submit");
        submit.setBounds(200,500,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,20));
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(400,500,120,30);
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,20));
        add(cancel);




        


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==submit){
                String Rollno=labelrollno.getText();
                 String StudentName=tfname.getText();
                 String FatherName=tffname.getText();
                 String HighSchool=tfhigh.getText();
                 String Inter=tfinter.getText();
                 String Email=tfemail.getText();
                 String Phone=tfphone.getText();
                 String Address=tfaddress.getText();
                 String Aadhar=tfaadharno.getText();
                 String DOB=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
                 String Course=(String)cbcourse.getSelectedItem();
                 String Branch=(String)cbbranch.getSelectedItem();
                 try{
                    String query="insert into student values('"+Rollno+"','"+StudentName+"','"+FatherName+"','"+HighSchool+"','"+Inter+"','"+Email+"','"+Phone+"','"+Address+"','"+Aadhar+"','"+DOB+"','"+Course+"','"+Branch+"')";
                    
                    Conn con=new Conn();
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                    setVisible(false);
                } catch(Exception e){
                    e.printStackTrace();
                }
            } 
            else if(ae.getSource()==cancel){
                setVisible(false);
            } 
    }
    public static void main(String[] args) {
        new AddStudent();
    }
}
