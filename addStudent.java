package UniversityManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.*;
import java.util.*;
import java.sql.*;

public class addStudent extends JFrame implements ActionListener{

    Random ran = new Random();
    long first4 = Math.abs(ran.nextLong()% 9000L) + 1000L;
    
    JLabel rolltext;
    JTextField nametext,fathertext,phonetext,aadhartext,emailtext,addresstext,classtext,catext;
    JButton submit,cancel;
    JDateChooser datetext;
    JComboBox coursetext,branchtext;

    
    addStudent(){
        setSize(900,700);
        setLocation(350,40);
        setLayout(null);

        JLabel newdetails  =new JLabel("New Student Details");
        newdetails.setBounds(300,70,400,30);
        newdetails.setFont(new Font("ARIAL",Font.BOLD,30));
        add(newdetails); 

        JLabel name  =new JLabel("Name");
        name.setBounds(40,180,100,40);
        name.setFont(new Font("ARIAL",Font.PLAIN,22));
        add(name);

        nametext = new JTextField();
        nametext.setBounds(220,180,170,28);
        nametext.addActionListener(this);
        add(nametext);

        JLabel father  =new JLabel("Father's Name");
        father.setBounds(450,180,200,40);
        father.setFont(new Font("ARIAL",Font.PLAIN,22));
        add(father); 

        fathertext = new JTextField();
        fathertext.setBounds(650, 180, 170, 28);
        fathertext.addActionListener(this);
        add(fathertext);

        JLabel roll  =new JLabel("Roll Number");
        roll.setBounds(40,220,200,40);
        roll.setFont(new Font("ARIAL",Font.PLAIN,22));
        add(roll); 

        rolltext = new JLabel("1533"+first4);
        rolltext.setBounds(220,220,170,28);
        rolltext.setFont(new Font("ARIAL",Font.BOLD,22));
        add(rolltext);

        JLabel date  =new JLabel("Date of Birth");
        date.setBounds(450,220,200,40);
        date.setFont(new Font("ARIAL",Font.PLAIN,22));
        add(date); 

        datetext = new JDateChooser();
        datetext.setBounds(650, 220, 170, 28);
       // datetext.addActionListener(this);
        add(datetext);

        JLabel address =new JLabel("Address");
        address.setBounds(40,260,100,40);
        address.setFont(new Font("ARIAL",Font.PLAIN,22));
        add(address); 

        addresstext = new JTextField();
        addresstext.setBounds(220, 260, 170, 28);
        addresstext.addActionListener(this);
        add(addresstext);

        JLabel phone  =new JLabel("Phone");
        phone.setBounds(450,260,100,40);
        phone.setFont(new Font("ARIAL",Font.PLAIN,22));
        add(phone); 

        phonetext = new JTextField();
        phonetext.setBounds(650, 260, 170, 28);
        phonetext.addActionListener(this);
        add(phonetext);

        JLabel email  =new JLabel("Email Id");
        email.setBounds(40,300,200,40);
        email.setFont(new Font("ARIAL",Font.PLAIN,22));
        add(email); 

        emailtext = new JTextField();
        emailtext.setBounds(220, 300, 170, 28);
        emailtext.addActionListener(this);
        add(emailtext);

        JLabel clas  =new JLabel("ClassX(%)");
        clas.setBounds(450,300,200,40);
        clas.setFont(new Font("ARIAL",Font.PLAIN,22));
        add(clas); 

        classtext = new JTextField();
        classtext.setBounds(650, 300, 170, 28);
        classtext.addActionListener(this);
        add(classtext);

        JLabel ca  =new JLabel("Class XII(%)");
        ca.setBounds(40,340,200,40);
        ca.setFont(new Font("ARIAL",Font.PLAIN,22));
        add(ca); 

        catext = new JTextField();
        catext.setBounds(220, 340, 170, 28);
        catext.addActionListener(this);
        add(catext);

        JLabel aadhar  =new JLabel("Aadhar Number");
        aadhar.setBounds(450,340,200,40);
        aadhar.setFont(new Font("ARIAL",Font.PLAIN,22));
        add(aadhar); 

        aadhartext = new JTextField();
        aadhartext.setBounds(650, 340, 170, 28);
        aadhartext.addActionListener(this);
        add(aadhartext);

        JLabel course =new JLabel("Course");
        course.setBounds(40,380,100,40);
        course.setFont(new Font("ARIAL",Font.PLAIN,22));
        add(course); 

        String courses[]={"B.Tech","BBA","BCA","BSc","MCA","MBA"};
        coursetext = new JComboBox(courses);
        coursetext.setBounds(220, 380, 170, 28);
        coursetext.addActionListener(this);
        add(coursetext);

        JLabel branch =new JLabel("Branch");
        branch.setBounds(450,380,100,40);
        branch.setFont(new Font("ARIAL",Font.PLAIN,22));
        add(branch); 

        String branchs[] ={"Computer Science","Electronics","Mechnical","IT"}; 
        branchtext = new JComboBox(branchs);
        branchtext.setBounds(650, 380, 170, 28);
        branchtext.addActionListener(this);
        add(branchtext);

        submit = new JButton("Submit");
        submit.setBounds(250, 530, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(480, 530, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel); 

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String Nname = nametext.getText();
            String Fname = fathertext.getText();
            String rollno = this.rolltext.getText();
            String dob = ((JTextField) datetext.getDateEditor().getUiComponent()).getText();
            String address = addresstext.getText();
            String email = emailtext.getText();
            String phone = phonetext.getText();
            String x = classtext.getText();
            String XII = catext.getText();
            String aadhar =aadhartext.getText();
            String course =(String) coursetext.getSelectedItem(); 
            String branch = (String) branchtext.getSelectedItem();

            try{
                String query = "insert into addstudent values('"+Nname+"','"+Fname+"','"+rollno+"','"+dob+"','"+address+"','"+email+"','"+phone+"','"+x+"','"+XII+"','"+aadhar+"','"+course+"','"+branch+"')";

                conn con = new conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Student Details Inserted Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }
        
    }

    public static void main(String args[]){
        new addStudent();
    }

}
