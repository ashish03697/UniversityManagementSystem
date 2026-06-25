package UniversityManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
  
public class Login extends JFrame implements ActionListener{

    JButton login,cancel;
    JTextField usertext,passwordtext;
    Login(){

        getContentPane().setBackground(Color.white);

        setSize(600,300);
        setLocation(500,250);
        setLayout(null);

        JLabel username = new JLabel("Username");
        username.setBounds(20, 20, 100, 30);
        username.setFont(new Font("ARIAL",Font.PLAIN,20));
        add(username);

        usertext = new JTextField();
        usertext.setBounds(150, 20, 160, 30);
        usertext.addActionListener(this);
        add(usertext);

        JLabel password = new JLabel("Password");
        password.setBounds(20, 70, 100, 30);
        password.setFont(new Font("ARIAL",Font.PLAIN,20));
        add(password);

        passwordtext = new JPasswordField();
        passwordtext.setBounds(150, 70, 160, 30);
        passwordtext.addActionListener(this);
        add(passwordtext);

        login = new JButton("login");
        login.setBounds(30, 150, 120, 30);
        login.setFont(new Font("ARIAL",Font.PLAIN,18));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setFont(new Font("ARIAL",Font.PLAIN,18));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("UniversityManagementSystem/icons/second.jpg"));
        Image i2= i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(350,0, 200, 200);
        add(image);

        setVisible(true);
 
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String username=usertext.getText();
            String password = passwordtext.getText();

            String Query = "select * from login where username='"+username+"' and password='"+password+"'";

            try{
                conn c = new conn();
                ResultSet rs=c.s.executeQuery(Query);

                if(rs.next()){
                    setVisible(false);
                    new Project();

                }else{
                    JOptionPane.showMessageDialog(null,"Invaid username or password");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }

    public static void main(String []args){
        new Login();
    }

}

