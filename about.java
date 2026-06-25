package UniversityManagementSystem;
import javax.swing.*;
import java.awt.*;


public class about extends JFrame {

    about(){
        setSize(700,500);
        setLocation(400,200);
        setLayout(null);

        JLabel heading = new JLabel("<html>University </br>Management <br>System</html>");
        heading.setBounds(70,20,190,130);
        heading.setFont(new Font("tohama",Font.BOLD,30));
        add(heading);

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("UniversityManagementSystem/icons/about.jpg"));
       Image i2 = i1.getImage().getScaledInstance(300,200, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(320,0,300,200);
       add(image);

        JLabel name = new JLabel("Developer By: Code for Ashish");
        name.setBounds(70,220,550,40);
        name.setFont(new Font("tohama",Font.BOLD,30));
        add(name);

        JLabel rollno = new JLabel("Roll number:1533146");
        rollno.setBounds(70,280,550,40);
        rollno.setFont(new Font("tohama",Font.PLAIN,22));
        add(rollno);

        JLabel contact = new JLabel("Contact: ashishpal418665@gmail.com");
        contact.setBounds(70,310,550,40);
        contact.setFont(new Font("tohama",Font.PLAIN,20));
        add(contact);
        setVisible(true);

    }

    public static void main(String ashish[]){
        new about();
    }
}
