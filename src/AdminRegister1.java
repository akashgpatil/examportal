import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminRegister1 implements ActionListener {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/demo21";
    static final String USER = "root";
    static final String PASS = "akash@123";


    JLabel l1, l2, l3, l4, l5, l6,l7 ,l8;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8 ;
    JRadioButton r1, r2;
    JButton b1, b2;
    ButtonGroup bg1;

    JFrame f;
    JComboBox<Object> cb;


    AdminRegister1() {
        JFrame f = new JFrame("Admintrationform");
        String std[] = {"computer", "IT", "civi", "mechanical"};
        cb = new JComboBox<Object>(std);
        l1 = new JLabel("Enter name");
        l2 = new JLabel("Enter id");
        l3 = new JLabel("Enter Department");
        l4 = new JLabel("Enter dob");
        l5 = new JLabel("Select contactno");
        l6 = new JLabel("Enter email");
        l8 = new JLabel ("Enter password");
        l7=new JLabel("Select gender");
        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");
        bg1 = new ButtonGroup();
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JPasswordField(30);
        t7 = new JTextField();
        t8=new JTextField();
        b1 = new JButton("Insert");
        b2 = new JButton("Retrive");
        l1.setBounds(50, 50, 300, 30);
        t1.setBounds(200, 50, 100, 30);
        l2.setBounds(50, 100, 300, 30);
        t2.setBounds(200, 100, 100, 30);
        l3.setBounds(50, 150, 300, 30);
        cb.setBounds(200, 150, 100, 20);
        l4.setBounds(50, 200, 100, 30);
        t3.setBounds(200, 200, 100, 30);
        l5.setBounds(50, 250, 100, 30);
        t4.setBounds(200, 250, 100, 30);
        l7.setBounds(50,275,100,30);
        r1.setBounds(200, 300, 100, 30);
        r2.setBounds(200, 325, 100, 30);
        l6.setBounds(50, 370, 100, 30);

        t5.setBounds(200, 370, 100, 30);
        l8.setBounds(50, 400, 100, 30);
        t6.setBounds(200, 400, 100, 30);

        //  t7.setBounds(250,475,100,30);
        // t8.setBounds(250,500,100,30);

        b1.setBounds(100, 500, 100, 30);
        b2.setBounds(100, 600, 100, 30);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(cb);
        f.add(l4);
        f.add(l5);
        bg1.add(r1);
        bg1.add(r2);
        f.add(r1);
        f.add(r2);
        f.add(l6);
        f.add(l7);
        f.add(l8);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(t5);
        f.add(t6);
        f.add(t7);
        f.add(t8);
        f.add(r1);
        f.add(r2);
        b1.addActionListener(this);
        f.add(b1);
        b2.addActionListener(this);
        f.add(b2);

        f.setSize(1000, 1000);
        f.setLayout(null);
        f.setVisible(true);


    }

    public void actionPerformed(ActionEvent ac) {

        if (ac.getSource() == b1) {
            String v1 = t1.getText();//name;
            String v2 = t2.getText();//id;
            String v3 = String.valueOf(cb.getItemAt(cb.getSelectedIndex()));//department;
            String v4 = t3.getText();//dob;
            String v5 = t4.getText();//contactno;
            String v6 = t5.getText();//email;
            String v9 = t6.getText();//password;
            String v7;
            if (r1.isSelected()) {
                v7 = "Male";
            } else {
                v7 = "Female";
            }

            try {
                Connection conn = null;
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("connecting to database");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("connected to database");
                //    Statement stmt = conn.createStatement();
                String sql = "insert into Loginforadminstration3(name,id,department,dob,contactno,gender,email,password)values(' " + v1 + " ','" + v2 + " ','" + v3 + "','" + v4 + "','" + v5 + "','" + v7 + "','" + v6 + "','" + v9 + "')";
                //    stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(f, "data inserted");

            } catch (Exception e1) {
                System.out.println(e1);

            }
        }


        if (ac.getSource() == b2) {
            try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo21", "root", "akash@123");
            Statement stmt = conn.createStatement();
            System.out.println("createDb connection...");
                ResultSet rs = stmt.executeQuery("select * Loginforadminstration3");
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

    }
public static void main(String args[]) {

        new AdminRegister1();
        }
        }

