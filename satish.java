package UniversityManagementSystem;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class satish extends JFrame implements Runnable{

    Thread t;

    satish(){

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("UniversityManagementSystem/icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image); 

        setLocation(250,50);
        setSize(1000,700);
        setVisible(true);

        t=new Thread(this); 

        int x =1;
        for(int i = 2;i<=600;i+=4,x+=1){
            setLocation(600-((i+x)/2),350-(i/2));
            setSize(i+3*x,i+x/2);

            try{
                Thread.sleep(10);
        //setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void run(){
        try{
            Thread.sleep(7000);
            setVisible(false);

            //next frame
            new Login();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    
    public static void main(String args[]){
        new satish();

    }
} 
