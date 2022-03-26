import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Questionpaper2 implements ActionListener {
    JButton r1, r2;
    JLabel s1, s2, s3, s4;
    JLabel k1,k2,k3;
    JTextField t1,t2,t3;
    JRadioButton j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12;
    ButtonGroup bg1, bg2, bg3;

    Questionpaper2() {
        JFrame f = new JFrame();
        k1=new JLabel("Rollno");
        t1=new JTextField();
        k2=new JLabel("name");
        t2=new JTextField();
        k3=new JLabel("marks");
        t3=new JTextField();
        //s1 = new JLabel("Q1");
        s2 = new JLabel("Which of the following user-defined header file extension used in c++?");
        s3 = new JLabel("Which of the following is not a type of Constructor in C++?");
        s4 = new JLabel("Which of the following approach is used by C++?");
        j1 = new JRadioButton("hg");
        j2 = new JRadioButton("cpp");
        j3 = new JRadioButton("h");
        j4 = new JRadioButton("hpp");
        j5 = new JRadioButton("Default constructor");
        j6 = new JRadioButton("Parameterized constructor");
        j7 = new JRadioButton("Copy constructor");
        j8 = new JRadioButton("Friend constructor");
        j9 = new JRadioButton(" Left-right");
        j10 = new JRadioButton(" Right-left");
        j11 = new JRadioButton("Bottom-up");
        j12 = new JRadioButton("Top-down");
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        bg1 = new ButtonGroup();
        bg2 = new ButtonGroup();
        bg3 = new ButtonGroup();
        r1 = new JButton("Insert");
        k1.setBounds(50,20,50,20);
        t1.setBounds(50,40,100,20);
        k2.setBounds(50,60,100,20);
        t2.setBounds(50,80,100,20);
        k3.setBounds(50,100,100,20);
        t3.setBounds(50,120,100,20);
        //s1.setBounds(200, 100, 100, 50);
        s2.setBounds(100, 150, 500, 50);
        j1.setBounds(100, 200, 100, 30);
        j2.setBounds(200, 200, 100, 30);
        j3.setBounds(300, 200, 100, 30);
        j4.setBounds(400, 200, 100, 30);
        r1.setBounds(500, 500, 100, 30);
        r1.addActionListener(this);
        s3.setBounds(100, 300, 550, 30);
        j5.setBounds(100, 350, 100, 30);
        j6.setBounds(200, 350, 100, 30);
        j7.setBounds(300, 350, 100, 30);
        j8.setBounds(400, 350, 200, 30);
        s4.setBounds(100, 400, 650, 30);
        j9.setBounds(100, 450, 100, 30);
        j10.setBounds(200, 450, 100, 30);
        j11.setBounds(300, 450, 100, 30);
        j12.setBounds(400, 450, 100, 30);
        f.add(k1);
        f.add(k2);
        f.add(k3);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        //f.add(s1);
        f.add(s2);
        f.add(j1);
        f.add(j2);
        f.add(j3);
        f.add(j4);
        f.add(r1);
        bg1.add(j1);
        bg1.add(j2);
        bg1.add(j3);
        bg1.add(j4);

        bg2.add(j5);
        bg2.add(j6);
        bg2.add(j7);
        bg2.add(j8);

        bg3.add(j9);
        bg3.add(j10);
        bg3.add(j11);
        bg3.add(j12);

        //f.add(s1);
        f.add(s2);
        f.add(j1);
        f.add(j2);
        f.add(j3);
        f.add(j4);
        f.add(r1);
        f.add(s3);
        f.add(j5);
        f.add(j6);
        f.add(j7);
        f.add(j8);
        f.add(s4);
        f.add(j9);
        f.add(j10);
        f.add(j11);
        f.add(j12);


        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);


    }

    public static void main(String[] args) {

        new Questionpaper2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String v1=t1.getText();
        String v2=t2.getText();
        String v3=t3.getText();
        if (e.getSource() == r1) {
            int marks = 0;
            String res="";
            String tans1 = "h";
            String tans2="Friend constructor";
            String tans3="Bottom-up";
            System.out.println(tans1);

            if(j3.isSelected()){
                res="h";

                if(tans1.equals(res)){

                    marks=marks+1;
                }
            }

            if(j8.isSelected()){
                res="Friend constructor";

                if(tans2.equals(res)){

                    marks=marks+1;
                    System.out.println(tans2);
                }
            }


            if(j11.isSelected()){
                res="Bottom-up";

                if(tans3.equals(res)){
                    System.out.println(tans3);
                    marks=marks+1;
                }
            }

            System.out.println("marks obtained"+marks);
            try   {
                Connection conn = null;
                Statement stmt = null;

                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo5", "root", "akash@123");
                stmt = conn.createStatement();
                String sq1 = "INSERT INTO stddata(roll,name,marks)" + "VALUES (' " + v1 + " ','" + v2 + "','" + marks + "')";
                stmt.executeUpdate(sq1);
                System.out.println("Inserted data succesfully");


            } catch (Exception e1) {
                System.out.println(e1);


            }
        }
    }


}
