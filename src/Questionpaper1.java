import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Questionpaper1 implements ActionListener {
    JButton r1, r2;
    JLabel s1, s2, s3, s4;
    JRadioButton j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12;
    ButtonGroup bg1,bg2,bg3;
    JLabel k1, k2, k3;
    JTextField t1, t2, t3;


    Questionpaper1() {
        JFrame f = new JFrame();
      //  s1 = new JLabel("Q1");
        k1 = new JLabel("Rollno");
        t1 = new JTextField();
        k2 = new JLabel("studentname");
        t2 = new JTextField();
        k3 = new JLabel("totalmarks");
        t3 = new JTextField();
        s2 = new JLabel("who invented c language");
        s3 = new JLabel("Which level of c language is");
        s4 = new JLabel("C is ______ type of progrsmming language");
        j1 = new JRadioButton("Charles Babbage");
        j2 = new JRadioButton("Grahambel");
        j3 = new JRadioButton("Dennis Ritchie");
        j4 = new JRadioButton("steve jobs");
        j5 = new JRadioButton("Low level");
        j6 = new JRadioButton("High level");
        j7 = new JRadioButton("Low+High");
        j8 = new JRadioButton("None");
        j9 = new JRadioButton("Object Orinted");
        j10 = new JRadioButton("Procedural");
        j11 = new JRadioButton("Bit level language");
        j12 = new JRadioButton("Functional");
        bg1 = new ButtonGroup();
        bg2 = new ButtonGroup();
        bg3 = new ButtonGroup();
        r1 = new JButton("Insert");
    //    s1.setBounds(200, 100, 100, 50);
        k1.setBounds(100, 20, 50, 20);
        t1.setBounds(100, 40, 75, 20);
        k2.setBounds(100, 60, 100, 20);
        t2.setBounds(100, 80, 100, 20);
        k3.setBounds(100, 100, 100, 20);
        t3.setBounds(100, 120, 100, 20);

        s2.setBounds(100, 150, 500, 50);
        j1.setBounds(100, 200, 100, 30);
        j2.setBounds(200, 200, 100, 30);
        j3.setBounds(300, 200, 100, 30);
        j4.setBounds(400, 200, 100, 30);
        r1.setBounds(500, 500, 100, 30);
        r1.addActionListener(this);
        s3.setBounds(100, 300, 600, 30);
        j5.setBounds(100, 350, 100, 30);
        j6.setBounds(200, 350, 100, 30);
        j7.setBounds(300, 350, 100, 30);
        j8.setBounds(400, 350, 100, 30);
        s4.setBounds(100, 400, 800, 30);
        j9.setBounds(100, 450, 100, 30);
        j10.setBounds(200, 450, 100, 30);
        j11.setBounds(300, 450, 100, 30);
        j12.setBounds(400, 450, 100, 30);
     //   f.add(s1);
        f.add(k1);
        f.add(k2);
        f.add(t1);
        f.add(t2);
        f.add(k3);
        f.add(t3);

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
        f.add(s2);
        f.add(j1);
        f.add(j2);
        f.add(j3);
        f.add(j4);
        f.add(s3);
        f.add(j5);
        f.add(j6);
        f.add(j7);
        f.add(j8);
        bg2.add(j5);
        bg2.add(j6);
        bg2.add(j7);
        bg2.add(j8);
        f.add(s4);
        f.add(j9);
        f.add(j10);
        f.add(j11);
        f.add(j12);
        bg3.add(j9);
        bg3.add(j10);
        bg3.add(j11);
        bg3.add(j12);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == r1) {
            String v1 = t1.getText();
            String v2 = t2.getText();
            String v3 = t3.getText();
            int marks = 0;
            String res = "";
            String trans1 = "Dennis Ritchie";
            String trans2 = "Low level";
            String trans3 = "Procedural";
            if (j3.isSelected()) {
                res = "Dennis Ritchie";
                if (trans1.equals(res)) {

                    marks = marks + 1;
                    System.out.println(trans1);
                }
            }
            if (j5.isSelected()) {
                res = "Low level";
                if (trans2.equals(res)) {
                    marks = marks + 1;
                    System.out.println(trans2);
                }

            }
            if (j10.isSelected()) {
                res = "Procedural";
                if (trans3.equals(res)) {
                    marks = marks + 1;
                    System.out.println(trans3);
                }
            }
            System.out.println("marks obtained" + marks);
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


    public static void main(String[] args) {
        new Questionpaper1();
    }
    }

