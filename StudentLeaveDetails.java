package UniversityManagementSystem;
import javax.swing.*;
import java.awt.*;


public class StudentLeaveDetails extends JFrame{

    StudentLeaveDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(900,700);
        setLocation(300,100);

        JLabel heading  = new JLabel("Search by roll number ");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        Choice  rollno = new Choice() ;
        rollno.setBounds(180, 20, 150, 20);
        add(rollno);

        

        JTable table  = new JTable();

        setVisible(true);
        


    }
    public static void main(String ashish[] ){
        new StudentLeaveDetails();
    }
}