import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class loginofstudentandadmin2 implements ActionListener {
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL ="jdbc:mysql://localhost:3306/demo9";
    static final String USER="root";
    static final String PASS="akash@123";

    JFrame f=new JFrame();
    JLabel  l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4;
    JButton b1,b2,b3,b4;
    loginofstudentandadmin2(){
        JFrame f=new JFrame("EXAMINATION PORTAL");
        l1=new JLabel("Login page(Student)");
        l2=new JLabel("Login page(Adminitrator)");
        l3=new JLabel("enter Email address of student");
        l4=new JLabel("enter Email address of adminstrator");
        l5=new JLabel("enter passwords");
        l6=new JLabel("enter passwords");
        t1=new JTextField(20);
        t2=new JTextField(20);
        t3=new JPasswordField(20);
        t4=new JPasswordField(20);
        b1=new JButton("Login student");
        b2=new JButton("Register student");
        b3=new JButton("Login admintrator");
        b4=new JButton("Register admintrator");
        l1.setBounds(50,50,300,30);
        l2.setBounds(500,50,300,30);
        l3.setBounds(50,100,100,30);
        t1.setBounds(200,100,100,30);
        l4.setBounds(500,100,100,30);
        t2.setBounds(650,100,100,30);
        l5.setBounds(50,150,100,30);
        t3.setBounds(200,150,100,30);
        l6.setBounds(500,150,100,30);
        t4.setBounds(650,150,100,30);
        b1.setBounds(50,300,100,30);
        b2.setBounds(250,300,100,30);
        b3.setBounds(500,300,100,30);
        b4.setBounds(650,300,100,30);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        f.setSize(1000,1000);
        f.setLayout(null);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==b1){
            String v1=t1.getText();
            String v2=t3.getText();
            try {
                Connection conn = null;
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("connecting to database");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("connected to database");
                Statement stmt = conn.createStatement();
                ResultSet rs=stmt.executeQuery("select * from  Registrationform3");
                while (rs.next()){
                    String v3=rs.getString(7);
                    String v4=rs.getString(8);
                    if (v1.equals(v3)) {

                        System.out.println("Login successfully");
                        selectpaper1 s1=new selectpaper1();
                    }
                }
                conn.close();
            }
            catch (Exception e2){
                System.out.println(e2);
            }
        }
        if (e.getSource()==b2){
            Register r1=new Register();
        }
        if (e.getSource()==b3){
            String v5=t2.getText();
            String v6=t4.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql:// localhost:3306/demo21","root","akash@123");
                Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery("select * from Loginforadminstration3");
                while (rs.next()){
                    String v7=rs.getString(7);
                    String v8=rs.getString(8);
                    if (v5.equals(v7)) {

                        System.out.println("Login successfully");

                        Loginforadminstratrion log = new Loginforadminstratrion();
                    }
                }
                conn.close();
            }
            catch (Exception e2){
                System.out.println(e2);
            }
        }
        if (e.getSource()==b4){
      AdminRegister1 r1=new AdminRegister1();
            }
        }


    public static void main(String[] args) {
        new loginofstudentandadmin2();
    }
}
