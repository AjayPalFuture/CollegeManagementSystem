import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;
public class StudentLeave extends JFrame implements ActionListener {
    Choice crollno,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    StudentLeave(){
             setSize(500,550);
             setLocation(500,100);
             getContentPane().setBackground(Color.WHITE);
             setLayout(null);

             JLabel heading=new JLabel("Apply Leave (Student)");
             heading.setBounds(150,20,300,40);
             heading.setFont(new Font("serif",Font.BOLD,20));
             add(heading);

             JLabel lblrollno=new JLabel("Search by Roll Number");
             lblrollno.setBounds(60,100,300,25);
             lblrollno.setFont(new Font("serif",Font.PLAIN,18));
             add(lblrollno);

             crollno=new Choice();
             crollno.setBounds(60,130,200,25);
             add(crollno);

             JLabel lbldate=new JLabel("Date");
             lbldate.setBounds(60,190,300,20);
             lbldate.setFont(new Font("serif",Font.PLAIN,18));
             add(lbldate);
             
             dcdate=new JDateChooser();
             dcdate.setBounds(60,220,200,25);
             add(dcdate);

             JLabel lbltime=new JLabel("Time Duration");
             lbltime.setBounds(60,270,200,20);
             lbltime.setFont(new Font("serif",Font.PLAIN,18));
             add(lbltime);
             
             ctime=new Choice();
             ctime.setBounds(60,300,200,25);
             ctime.add("Full Time");
             ctime.add("Half Time");
             add(ctime);

             submit=new JButton("Submit");
             submit.setBounds(110,400,120,30);
             submit.setBackground(Color.BLACK);
             submit.setForeground(Color.WHITE);
             submit.addActionListener(this);
             submit.setFont(new Font("serif",Font.BOLD,20));
             add(submit);
     
             cancel=new JButton("Cancel");
             cancel.setBounds(260,400,120,30);
             cancel.setBackground(Color.red);
             cancel.setForeground(Color.WHITE);
             cancel.addActionListener(this);
             cancel.setFont(new Font("serif",Font.BOLD,20));
             add(cancel);
             try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("Select*from student");
                while (rs.next()) {
                    crollno.add(rs.getString("Rollno"));    
                }

             }catch(Exception e){
                e.printStackTrace();
             }


             setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==submit){
                 String Rollno=crollno.getSelectedItem();
                 String Date=((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
                 String Duration=ctime.getSelectedItem();
                 
                 try{
                    String query="insert into studentleave values('"+Rollno+"','"+Date+"','"+Duration+"')";
                    
                    Conn con=new Conn();
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Studnet Leave Confirmed");
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
        new StudentLeave();
    }
}
