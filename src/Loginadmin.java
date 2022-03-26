import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Loginadmin  implements ActionListener {


    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL ="jdbc:mysql://localhost:3306/demo9";
    static final String USER="root";
    static final String PASS="akash@123";
    JLabel s1,s2;
    JTextField t1,t2;
    JButton r1;
    JFrame f;
   Loginadmin(){
        JFrame f=new JFrame();
        s1=new JLabel("Enter Email");
        s2=new JLabel("Enter Password");
        t1=new JTextField();
        t2=new JTextField();
        r1=new JButton("Login");
        s1.setBounds(100,100,100,30);
        t1.setBounds(100,150,100,30);
        s2.setBounds(100,200,100,30);
        t2.setBounds(100,250,100,30);
        r1.setBounds(100,300,100,30);
        r1.addActionListener(this);
        f.add(s1);
        f.add(s2);
        f.add(t1);
        f.add(t2);
        f.add(r1);
        f.setSize(600,600);
        f.setLayout(null);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ac){
        if (ac.getSource()==r1){
            String v1=t1.getText();
            String v2=t2.getText();
            Connection conn=null;
            Statement stmt=null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection( DB_URL,USER,PASS);
                System.out.println("create db connection...");
                ResultSet res = stmt.executeQuery("select * from  Loginforadminstration3");
                while (res.next()) {
                    String v3 = res.getString(7);
                    String v4 = res.getString(8);
                    if (v2.equals(v4)) {
                        System.out.println("Login successfully");
                        loginofstudentandadmin2 s2=new loginofstudentandadmin2();
                    }
                }
                conn.close();
            }
            catch (Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(f,"Insert data");
            }
        }

    }

    public static void main(String[] args) {
        new Loginadmin();
    }
}

