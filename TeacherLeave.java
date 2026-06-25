package UniversityManagementSystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;




public class TeacherLeave extends JFrame implements ActionListener{


    JButton cancel,submit;
    Choice dtext,emp;
    JDateChooser datetext;


        TeacherLeave(){
        setSize(500,550);
        setLocation(550,100);
        getContentPane().setBackground(Color.white);
        setLayout(null);


        JLabel apply = new JLabel("Apply Leave (Teacher)");
        apply.setBounds(50,50, 200, 20);
        apply.setFont(new Font("ARIAL",Font.BOLD,18));
        add(apply);


        JLabel search = new JLabel("Search by (EmpolyeeID)");
        search.setBounds(100,100, 200, 20);
        search.setFont(new Font("ARIAL",Font.PLAIN,18));
        add(search);


        emp = new Choice();
        emp.setBounds(100,130,150,20);
        add(emp);


        try{
            conn con = new conn();
            ResultSet rs = con.s.executeQuery("select * from Teacher");
            while(rs.next()){
                emp.add(rs.getString("EmployeeID"));
            }


        }catch(Exception e){
            e.printStackTrace();
        }


        JLabel date = new JLabel("Date");
        date.setBounds(100,160,100,30);
        date.setFont (new Font("Thohma",Font.PLAIN,18));
        add(date); 


        datetext = new JDateChooser();
        datetext.setBounds(100, 200, 150, 20);
        add(datetext);


        JLabel duration = new JLabel("Time Duration");
        duration.setBounds(100,240,150,20);
        duration.setFont(new Font("Tohma",Font.PLAIN,18));
        add(duration);


        dtext = new Choice();
        dtext.setBounds(100,280,150,20);
        dtext.add("Full Day");
        dtext.add("Haft Day");
        add(dtext);


        submit = new JButton("Submit");
        submit.setBounds(80,380,120,28);
        submit.addActionListener(this);
        add(submit);


        cancel = new JButton("Cancel");
        cancel.setBounds(250,380,120,28);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit ){
            String empolyeeid = emp.getSelectedItem();
            String date  =  ((JTextField) datetext.getDateEditor().getUiComponent()).getText();
            String duration = dtext.getSelectedItem();

           // String query = "insert into teacherLeave values('"+empolyeeid+"','"+datetext+"','"+duration+"')";
            try{

                String query = "insert into teacherLeave values('"+empolyeeid+"','"+date+"','"+duration+"')";
                conn con = new conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,  "Leave Conformed");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }
    public static void main(String ashish[]){
        new TeacherLeave();
    }

}
