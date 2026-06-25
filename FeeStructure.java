package UniversityManagementSystem;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.sql.ResultSet;


public class FeeStructure extends JFrame {

    JTable table;
    JLabel heading;
    
    FeeStructure(){
        setSize(1000,700);
        setLocation(250,50);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        heading = new JLabel("Fee Structure");
        heading.setBounds(50,10,400,30);
        heading.setFont(new Font("Tohama",Font.BOLD,30));
        add(heading);
        
        table = new JTable();

        try{
            conn con = new conn();
            ResultSet rs = con.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 60, 1000, 700);
        add(jsp);


        setVisible(true);
    }


    public static void main(String ashish[]){
        new FeeStructure();
    }
}
