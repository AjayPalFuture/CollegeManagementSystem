import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
public class FeeStructure extends JFrame {
    FeeStructure(){
        setSize(1000,700);
        setLocation(250,50);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel heading= new JLabel("Fee Structure");
        heading.setBounds(430,20,400,30);
        heading.setForeground(Color.black);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);
        JTable table=new JTable();
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            
        }

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,60,1000,700);
        add(jsp);
        setVisible(true);
    }
    public static void main(String[] args) {
        new FeeStructure();
    }
    
}
