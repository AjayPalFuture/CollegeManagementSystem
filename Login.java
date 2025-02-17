import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton login,cancel;
    JTextField tfusername;
   JPasswordField tfpassword;
    Login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40,20,100,20);
        lblusername.setFont(new Font("serif",Font.BOLD,15));
        add(lblusername);


        tfusername=new JTextField();
        tfusername.setBounds(150, 20, 200, 30);
        add(tfusername);
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setFont(new Font("serif",Font.BOLD,15));
        lblpassword.setBounds(40, 70, 100, 20);
        add(lblpassword);

        tfpassword=new JPasswordField();
        tfpassword.setBounds(150, 70, 200, 30);
        add(tfpassword);

        login=new JButton("LogIn");
        login.setBounds(40,160,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("serif",Font.BOLD,17));
        add(login);

        cancel=new JButton("Cancel");
        cancel.setBounds(200,160,120,30);
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,17));
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,0,200,200);
        add(image);


        setSize(600,300);
        setLocation(500, 250);
        setVisible(true);
    }
        public  void actionPerformed(ActionEvent ae){
            if(ae.getSource()==login){
                 String username=tfusername.getText();
                 String password=tfpassword.getText();
                 String query="select * from login where username='"+username+"'and password='"+password+"'";
                 try{
                     Conn c=new Conn();
                   ResultSet rs=  c.s.executeQuery(query);

                   if(rs.next()){
                        setVisible(false);
                        new Project();
                   }else{
                       JOptionPane.showMessageDialog(null, "Invalid  username and password");
                       setVisible(false);
                   }
                 }catch(Exception e){
                    e.printStackTrace();
                 }

            }
            else if(ae.getSource()==cancel){
                setVisible(false);
            }
        }

    public static void main(String[] args) {
        new Login();
    }
}
