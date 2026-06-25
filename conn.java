package UniversityManagementSystem;

import java.sql.*;

public class conn {

    Connection c;
    Statement s;

    conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/UniversityManagementSystem", "root", "qaz123@");
            s=c.createStatement();

        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("System");
        
    }
    
}