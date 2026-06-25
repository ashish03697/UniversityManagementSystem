package UniversityManagementSystem;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;


public class StudentDetails extends JFrame implements ActionListener {

    Choice rollno;
    JTable table;
    JButton print,search,add,update,cancel;

    StudentDetails(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading  = new JLabel("Search by Roll Number");
        heading .setBounds(20,20,150,20);
        add(heading);

        rollno = new Choice();
        rollno.setBounds(180,20,150,20);
        add(rollno);

        try{
            conn con = new conn();
            ResultSet rs = con.s.executeQuery(" select * from addStudent");
            while(rs.next()){
                rollno.add(rs.getString("rollno"));
            }
        }catch(Exception e){
             e.printStackTrace();
        }

        table = new JTable();
        try{
            conn con =new conn();
            ResultSet rs = con.s.executeQuery("select * from addStudent");
            table.setModel(DbUtils.resultSetToTableModel(rs)); 

        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0,100,900,600);
        add(scroll);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
       
        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        add.addActionListener(this);
        add(add);
       
        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.addActionListener(this);
        add(update);
       
        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
       
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query ="select * from addStudent where rollno = '"+rollno.getSelectedItem()+"' ";
            try{
                conn con = new conn();
                ResultSet rs = con.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == print){
            try{
                table.print();

            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == add){
            setVisible(false);
            new addStudent();

        }else if(ae.getSource() == update){

        }else {
            setVisible(false);

        }

    }
    public static void main(String ashish[]){
        new StudentDetails();

    }

}
