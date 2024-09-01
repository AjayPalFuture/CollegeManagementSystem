import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

import javax.swing.*;

public class StudentLeaveDetails extends JFrame implements ActionListener{
    Choice crollno;
    JTable table;
    JButton search,print,update,add,cancel;
    StudentLeaveDetails (){
        getContentPane().setBackground(Color.MAGENTA);
           setSize(1100,800);
           setLocation(350,50);
           setLayout(null);
           JLabel heading=new JLabel("Search by Roll Number");
           heading.setBounds(20,20,200,20);
           heading.setForeground(Color.white);

           heading.setFont(new Font("serif",Font.BOLD,18));
           add(heading);

           crollno=new Choice();
           crollno.setBounds(220,20,150,40);
           crollno.setBackground(Color.white);
           add(crollno);
           
           try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select* from student");
                while (rs.next()) {
                    crollno.add(rs.getString("Rollno"));
                }
           }catch(Exception e){
            e.printStackTrace();
           }
           table=new JTable();
           
           try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select* from studentleave");
           table.setModel(DbUtils.resultSetToTableModel(rs));
       }catch(Exception e){
        e.printStackTrace();
       }

           JScrollPane jsp=new JScrollPane(table);
           jsp.setBounds(0,120,1100,700);
           add(jsp);

           search=new JButton("Search");
           search.setBounds(20,70,80,25);
           search.addActionListener(this);
           add(search);

           print=new JButton("Print");
           print.setBounds(110,70,80,25);
           print.addActionListener(this);
           add(print);

           cancel=new JButton("Cancel");
           cancel.setBounds(200,70,80,25);
           cancel.addActionListener(this);
           add(cancel);

        

           setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==search){
            String query="select * from studentleave where Rollno='"+crollno.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception e){
                e.printStackTrace();
            }

         }else if(ae.getSource()==print){
            try{
                table.print();

            }catch(Exception e){
                e.printStackTrace();
            }

         }else if(ae.getSource()==cancel){
                  setVisible(false);
         }
         

    }
    public static void main(String[] args) {
        new StudentLeaveDetails();
    }
}

