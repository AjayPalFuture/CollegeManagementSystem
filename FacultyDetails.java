import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

import javax.swing.*;

public class FacultyDetails extends JFrame implements ActionListener{
    Choice cempId;
    JTable table;
    JButton search,print,update,add,cancel;
    FacultyDetails (){
        getContentPane().setBackground(Color.MAGENTA);
           setSize(1100,800);
           setLocation(350,50);
           setLayout(null);
           JLabel heading=new JLabel("Search by Employee Id");
           heading.setBounds(20,20,200,20);
           heading.setForeground(Color.white);

           heading.setFont(new Font("serif",Font.BOLD,18));
           add(heading);

           cempId=new Choice();
           cempId.setBounds(220,20,150,40);
           cempId.setBackground(Color.white);
           add(cempId);
           
           try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select* from teacher");
                while (rs.next()) {
                    cempId.add(rs.getString("EmpId"));
                }
           }catch(Exception e){
            e.printStackTrace();
           }
           table=new JTable();
           
           try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select* from teacher");
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

           update=new JButton("Update");
           update.setBounds(200,70,80,25);
           update.addActionListener(this);
           add(update);

           add=new JButton("Add");
           add.setBounds(290,70,80,25);
           add.addActionListener(this);
           add(add);

           cancel=new JButton("Cancel");
           cancel.setBounds(380,70,80,25);
           cancel.addActionListener(this);
           add(cancel);

           setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==search){
            String query="select * from teacher where EmpId='"+cempId.getSelectedItem()+"'";
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

         }else if(ae.getSource()==update){
            setVisible(false);
            // new UpdateTeacher();

         }else if(ae.getSource()==add){
            setVisible(false);
            new AddTeacher();

         }else if(ae.getSource()==cancel){
                  setVisible(false);
         }
         

    }
    public static void main(String[] args) {
        new FacultyDetails();
    }
}

