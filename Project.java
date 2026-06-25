package UniversityManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Project extends JFrame implements ActionListener {
    JMenuItem faculty,studentinformation;
    Project(){
      //  getContentPane().setBackground(Color.WHITE);
      //  setLayout(null);

       // setLocation(300,200);
        setSize(1540,850);
       // setVisible(true);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("UniversityManagementSystem/icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();

        JMenu information = new JMenu("New information");
        information.setForeground(Color.BLUE);
        mb.add(information);

        faculty = new JMenuItem("New faculty information");
        faculty.setBackground(Color.white);
        faculty.addActionListener(this);
        information.add(faculty);

        studentinformation = new JMenuItem("New Student information");
        studentinformation.setBackground(Color.white);
        studentinformation.addActionListener(this);
        information.add(studentinformation);



    
        JMenu view = new JMenu("view Details ");
        view.setForeground(Color.red);
        mb.add(view);

        JMenuItem viewstudent = new JMenuItem("View Student Details");
        viewstudent.setBackground(Color.white);
        viewstudent.addActionListener(this);
        view.add(viewstudent);

        JMenuItem viewteacher = new JMenuItem("View Teacher Details");
        viewteacher.setBackground(Color.white);
        viewteacher.addActionListener(this);
        view.add(viewteacher);



        JMenu apply = new JMenu("apply Leave");
        apply.setForeground(Color.BLUE);
        mb.add(apply);

        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.white);
        facultyleave.addActionListener(this);
        apply.add(facultyleave);

        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setBackground(Color.white);
        studentleave.addActionListener(this);
        apply.add(studentleave);



        JMenu Leave = new JMenu("Leave Details");
        Leave.setForeground(Color.red);
        mb.add(Leave);

        JMenuItem leavestudent = new JMenuItem("Leave Student Details");
        leavestudent.setBackground(Color.white);
        leavestudent.addActionListener(this);
        Leave.add(leavestudent);

        JMenuItem leaveteacher = new JMenuItem("Leave Teacher Details");
        leaveteacher.setBackground(Color.white);
        leaveteacher.addActionListener(this);
        Leave.add(leaveteacher);



        JMenu Examination = new JMenu("Examination");
        Examination.setForeground(Color.BLUE);
        mb.add(Examination);

        JMenuItem examinationdetails = new JMenuItem("Examination Details");
        examinationdetails.setBackground(Color.white);
        examinationdetails.addActionListener(this);
        Examination.add(examinationdetails);

        JMenuItem enter = new JMenuItem("Enter Marks");
        enter.setBackground(Color.white);
        enter.addActionListener(this);
        Examination.add(enter);



        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.red);
        mb.add(fee);

        JMenuItem fees = new JMenuItem("Fee Structure");
        fees.setBackground(Color.white);
        fees.addActionListener(this);
        fee.add(fees);

        JMenuItem studentfee = new JMenuItem("Student Fee Form");
        studentfee.setBackground(Color.white);
        studentfee.addActionListener(this);
        fee.add(studentfee);



        JMenu update = new JMenu("Update Details");
        update.setForeground(Color.BLUE);
        mb.add(update);

        JMenuItem updatestudent = new JMenuItem("update Student Details");
        updatestudent.setBackground(Color.white);
        updatestudent.addActionListener(this);
        update.add(updatestudent);

        JMenuItem updateteacher = new JMenuItem("Update Teacher Details");
        updateteacher.setBackground(Color.white);
        updateteacher.addActionListener(this);
        update.add(updateteacher);



        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.red);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.white);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.white);
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenuItem web  = new JMenuItem("Google Chrome");
        web.setBackground(Color.white);
        web.addActionListener(this);
        utility.add(web);



        JMenu about = new JMenu("About");
        about.setForeground(Color.blue);
        mb.add(about);

        JMenuItem aboutus  = new JMenuItem("About Us");
        aboutus.setBackground(Color.white);
        aboutus.addActionListener(this);
        about.add(aboutus);



        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.red);
        mb.add(exit);

        JMenuItem exits = new JMenuItem("Exit");
        exits.setBackground(Color.white);
        exits.addActionListener(this);
        exit.add(exits);

        setJMenuBar(mb);
         
        
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();

        if(msg.equals("Exit")){
            setVisible(false);
        }
        else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");

            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(msg.equals("Google Chrome")){
            try{
                Runtime.getRuntime().exec("c:\\program Files\\Google\\Chrome\\Application\\chrome.exe");

            }catch(Exception e){
        
        
                e.printStackTrace();
            }
        }else if(msg.equals("New faculty information")){
            new addTeacher();
        }else if(msg.equals("New Student information")){
            new addStudent();

        }
        else if (msg.equals("Faculty Leave")){
            new TeacherLeave();
        }else if(msg.equals("Student Leave")){
            new LeaveStudent();
        }else if(msg.equals("View Student Details")){
            new StudentDetails();
        }else if(msg.equals("View Teacher Details")){
            new TeacherDetails();
        }else if(msg.equals("Fee Structure")){
            new FeeStructure();
        }else if(msg.equals("About Us"));
            new about();

    }
    public static void main(String args[]){
        new Project();

    }

}
