
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Register implements ActionListener {
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL ="jdbc:mysql://localhost:3306/demo9";
    static final String USER="root";
    static final String PASS="akash@123";
    JRadioButton r1,r2,r3;
    ButtonGroup bg1;
    JFrame f;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    JLabel l7;
    JLabel l8;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    JComboBox<Object> cb;

    /**
     *
     */
    Register() {
        JFrame f=new JFrame("Registration Form");
        String std[]={"ssc","hsc","B.Tech","M.Tech,Other"};
        cb=new JComboBox<Object>(std);
        l1=new JLabel("Enter name");
        l2=new JLabel("Enter Roll No");
        l3=new JLabel("Enter class");
        l4=new JLabel("Enter DOB");
        l5=new JLabel("Select gender");
        r1=new JRadioButton("Male");
        r2=new JRadioButton("Female");
        bg1=new ButtonGroup();
        l6=new JLabel("Enter Mobile no");
        l7=new JLabel("Enter emial");
        l8= new JLabel("Enter password");
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t7=new JTextField();
        t6=new JPasswordField(20);
        b1=new JButton("Insert");
        b2=new JButton("Retrive");
        l1.setBounds(50,50,300,30);
        t1.setBounds(200,50,100,30);
        l2.setBounds(50,100,300,30);
        t2.setBounds(200,100,100,30);
        l3.setBounds(50,150,300,30);
        cb.setBounds(200,150,100,20);
        l4.setBounds(50,200,100,30);
        t3.setBounds(200,200,100,30);
        l5.setBounds(50,250,100,30);
        r1.setBounds(200,250,100,30);
        r2.setBounds(300,250,100,30);
        l6.setBounds(50,300,100,30);
        t4.setBounds(200,300,100,30);
        l7.setBounds(50,350,100,30);
        t5.setBounds(200,350,100,30);
        l8.setBounds(50,400,100,30);
        t6.setBounds(200,400,100,30);
        b1.setBounds(50,450,100,30);
        b2.setBounds(300,450,100,30);

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
        f.add(b1);
        b1.addActionListener(this);
        f.add(b2);
        b2.addActionListener(this);

        f.setSize(1000,1000);
        f.setLayout(null);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ac) {
        //INSERT DATA
        if (ac.getSource() == b1) {
            String v1 = t1.getText();//name;
            String v2 = t2.getText();//Roll No;
            String v3 = t3.getText();//DOB;
            String v4 = t4.getText();//MOBNO;
            String v5 = t5.getText();//EMAIL;
            String v6 = t6.getText();//PASSWORD;
            String v7;
            if (r1.isSelected()) {
                v7 = "Male";
            } else {
                v7 = "Female";
            }
            String v8 = (String) cb.getItemAt(cb.getSelectedIndex()); //class
            try {
                Connection conn = null;
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("connecting to database");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("connected to database");
                Statement stmt = conn.createStatement();
                String sql = "insert into  Registrationform3(rollNO,name,class,dob,gender,mno,email,password)values(' " + v2 + " ','" + v1 + " ','" + v8 + "','" + v3 + "','" + v7 + "','" + v4 + "','" + v5 + "','" + v6 + "')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(f, "data inserted");

            } catch (Exception e1) {
                System.out.println(e1);

            }
        }


        if (ac.getSource() == b2) {
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

    }
    public static void main(String args[]){

        new Register();
    }
}