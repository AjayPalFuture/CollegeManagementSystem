
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
public class AddTeacher extends JFrame implements ActionListener{
    JTextField tfname,tffname,tfaddress,tfphone,tfemail,tfhigh,tfinter,tfaadharno;
    JDateChooser dcdob;
    JLabel labelempId;
    JComboBox cbqualification,cbdepartment;
    JButton submit,cancel;
    Random ran=new Random();
    long first=Math.abs(ran.nextLong()%9000L)+1000L;

    AddTeacher(){
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);

        JLabel heading=new JLabel("New Teacher Details");
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

       JLabel lblempId=new JLabel("Employee Id");
        lblempId.setBounds(50,200,150,30);
        lblempId.setFont(new Font("serif",Font.BOLD,20));
        add(lblempId);

        labelempId=new JLabel("101"+first);
        labelempId.setBounds(200,200,200,30);
        labelempId.setFont(new Font("serif",Font.BOLD,20));
        add(labelempId);

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

        JLabel lblhigherEducation=new JLabel("HigherEducation");
        lblhigherEducation.setBounds(50,400,200,30);
        lblhigherEducation.setFont(new Font("serif",Font.BOLD,20));
        add(lblhigherEducation);
        
       String qualification[]={"B.Tech","BBA","BCA","Bsc","Msc","MBA","MCA","MCom","Mcom","BA","MA"};
        cbqualification=new JComboBox(qualification);
        cbqualification.setBackground(Color.WHITE);
        cbqualification.setBounds(200,400,150,30);
        add(cbqualification);

        JLabel lbldepartment=new JLabel("Department");
        lbldepartment.setBounds(450,400,200,30);
        lbldepartment.setFont(new Font("serif",Font.BOLD,20));
        add(lbldepartment);
        
       String department[]={"Computer Science","Mechanical","Electrical","Civil","Electronic","Hindi","PCM","Biology","Chemistry","English","Finance","History"};
        cbdepartment=new JComboBox(department);
        cbdepartment.setBackground(Color.WHITE);
        cbdepartment.setBounds(650,400,150,30);
        add(cbdepartment);

        
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
                 String TeacherName=tfname.getText();
                 String FatherName=tffname.getText();
                 String EmpId=labelempId.getText();
                 String DOB=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
                 String Address=tfaddress.getText();
                 String Phone=tfphone.getText();
                 String Email=tfemail.getText();
                 String HighSchool=tfhigh.getText();
                 String Inter=tfinter.getText();
                 String Aadhar=tfaadharno.getText();
                 String Qualification=(String)cbqualification.getSelectedItem();
                 String Department=(String)cbdepartment.getSelectedItem();
                 try{
                    String query="insert into teacher values('"+EmpId+"','"+TeacherName+"','"+FatherName+"','"+HighSchool+"','"+Inter+"','"+Email+"','"+Phone+"','"+Address+"','"+Aadhar+"','"+DOB+"','"+Qualification+"','"+Department+"')";
                    
                    Conn con=new Conn();
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
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
        new AddTeacher();
    }
}


