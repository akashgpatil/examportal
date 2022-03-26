import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Loginforadminstratrion implements ActionListener {


    JButton r1, r2;


    JLabel j1;




    Loginforadminstratrion() {

        JFrame f = new JFrame();
        j1 = new JLabel("Admin");
        r1 = new JButton("Register Student");
        r2 = new JButton("Get Result");
        j1.setBounds(100, 100, 100, 30);
        r1.setBounds(100, 200, 100, 30);
        r1.addActionListener((ActionListener) this);
        r2.setBounds(100, 300, 100, 30);
        r2.addActionListener((ActionListener) this);
        f.add(j1);
        f.add(r1);
        f.add(r2);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }


    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == r1) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo9", "root", "akash@123");
                Statement stmt = conn.createStatement();
                System.out.println("createDb connection...");
                ResultSet rs = stmt.executeQuery("select * from Registrationform3");
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getString(4));
                    System.out.println(rs.getString(5));
                    System.out.println(rs.getString(6));
                    System.out.println(rs.getString(7));
                    System.out.println(rs.getString(8));

                }
                conn.close();
            } catch (Exception e1) {
                System.out.println(e1);
            }


        }
        if (ac.getSource() == r2) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo5", "root", "akash@123");
                Statement stmt = conn.createStatement();
                System.out.println("createDb connection...");
                ResultSet rs = stmt.executeQuery("select * from stddata");
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));


                }
                conn.close();
            } catch (Exception e1) {
                System.out.println(e1);
            }
        }

        }



    public static void main(String args[]){
        new Loginforadminstratrion();
    }
}

