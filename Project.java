import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Project extends JFrame implements ActionListener{
    Project(){
        setSize(1540,850);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1540, 850, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        JMenuBar mb=new JMenuBar();

        JMenu newInformation=new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);

        JMenuItem facultyInfo=new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo=new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
         studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        JMenu details=new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);

        JMenuItem facultyDetails=new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);


        JMenuItem studentDetails=new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.addActionListener(this);
        details.add(studentDetails);


        JMenu leave=new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);

        JMenuItem  facultyLeave=new JMenuItem("Apply Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem studentLeave=new JMenuItem("Apply Student Leave");
        studentLeave.setBackground(Color.WHITE);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);
        
        JMenu leaveDetails=new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED);
        mb.add(leaveDetails);
        
        JMenuItem facultyLeaveDetails=new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.WHITE);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);
        
        JMenuItem studentLeaveDetails=new JMenuItem("Student Leave Details");
        studentLeaveDetails.addActionListener(this);
        studentLeaveDetails.setBackground(Color.WHITE);
        leaveDetails.add(studentLeaveDetails);

        JMenu exam=new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        exam.addActionListener(this);
        mb.add(exam);

        JMenuItem examinationDetails=new JMenuItem("Examination Results");
        examinationDetails.setBackground(Color.WHITE);
        examinationDetails.addActionListener(this);
        exam.add(examinationDetails);

        JMenuItem enterMark=new JMenuItem("Enter Mark");
        examinationDetails.setBackground(Color.WHITE);
        enterMark.addActionListener(this);
        exam.add(enterMark);

        JMenu UpdateInfo=new JMenu("Update Details");
        UpdateInfo.setForeground(Color.RED);
        mb.add(UpdateInfo);

        JMenuItem updateFacultyInfo=new JMenuItem("Update Faculty Information");
        updateFacultyInfo.addActionListener(this);
        updateFacultyInfo.setBackground(Color.WHITE);
        UpdateInfo.add(updateFacultyInfo);

        JMenuItem updateStudentInfo=new JMenuItem("Update Student Information");
        updateStudentInfo.setBackground(Color.WHITE);
        updateStudentInfo.addActionListener(this);
        UpdateInfo.add(updateStudentInfo);

        JMenu fee=new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);

        JMenuItem feeStructure=new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem feeForm=new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.WHITE);
        fee.add(feeForm);

        JMenu utility=new JMenu("Utility");
        utility.setForeground(Color.RED);
        mb.add(utility);

        JMenuItem notepad=new JMenuItem("NotePad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc=new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);
        setJMenuBar(mb);

        JMenu about=new JMenu("About");
         about.setForeground(Color.BLUE);
         mb.add(about);
         

         JMenuItem ab=new JMenuItem("About");
         ab.setBackground(Color.WHITE);
         ab.addActionListener(this);
        about.add(ab);

        JMenu exit=new JMenu("Exit");
         exit.setForeground(Color.RED);
         mb.add(exit);

         JMenuItem ex=new JMenuItem("Exit");
         ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
        
        setVisible(true);
    }
        public void actionPerformed(ActionEvent ae){
            String msg=ae.getActionCommand();
            if(msg.equals("Exit")){
                setVisible(false);
            }
            else if(msg.equals("Calculator")){
                try{
                     Runtime.getRuntime().exec("calc.exe");
                }catch(Exception e){}
            }
            else if(msg.equals("NotePad")){
                try{
                    Runtime.getRuntime().exec("notepad.exe");
                }catch(Exception e){}
            }
            else if(msg.equals("New Faculty Information")){
                new AddTeacher();
            }else if(msg.equals("New Student Information")){
                new AddStudent();
            }else if(msg.equals("View Student Details")){
                new StudentDetails();
            }else if(msg.equals("View Faculty Details")){
                new FacultyDetails();
            }else if(msg.equals("Apply Faculty Leave")){
                new TeacherLeave();
            }else if(msg.equals("Apply Student Leave")){
                new StudentLeave();
            }else if(msg.equals("Faculty Leave Details")){
                new TeacherLeaveDetails();
            }else if(msg.equals("Student Leave Details")){
                new StudentLeaveDetails();
            }else if(msg.equals("Update Faculty Information")){
                new UpdateTeacher();
            }else if(msg.equals("Update Student Information")){
                new UpdateStudent();
            }else if(msg.equals("Enter Mark")){
                new EnterMarks();
            }else if(msg.equals("Examination Results")){
                new ExaminationDetails();
            }else if(msg.equals("Fee Structure")){
                new FeeStructure();
            }else if(msg.equals("About")){
                new About();
            }
            

        }
    public static void main(String[] args) {
        new Project();
    }
}
