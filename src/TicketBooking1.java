package akashproject1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import static javafx.scene.input.KeyCode.S;
public class TicketBooking1 implements ActionListener{
    static final String JDBC_DriverManager="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/demo10";
    static final String USER="root";
    static final String PASS="akash@123";
    JRadioButton b1,b2;
    ButtonGroup bg1,bg2;
    JButton r1,r2,r3,r4;
    JFrame f;
    JLabel s1,s2,s3,s4,s5,s6,s7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JComboBox<Object> cb;
    TicketBooking1 (){
        JFrame f=new JFrame();
        s1=new JLabel("Name");
        s2=new JLabel("Mob-no");
        s3=new JLabel("Age");
        s4=new JLabel("Email");
        s5=new JLabel("Boarding point");
        s6=new JLabel("Destination point");
        s7=new JLabel("Time");
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();
        t7=new JTextField();
        bg1=new ButtonGroup();
        bg2=new ButtonGroup();
        r1=new JButton("BOOk");
        r2=new JButton("Show");
        r3=new JButton("delete");
        r4=new JButton("Update");
        s1.setBounds(100,75,100,20);
        t1.setBounds(100,110,100,30);
        s2.setBounds(100,150,100,30);
        t2.setBounds(100,175,100,30);
        s3.setBounds(100,200,100,30);
        t3.setBounds(100,225,100,30);
        s4.setBounds(100,250,100,30);
        t4.setBounds(100,275,100,30);
        s5.setBounds(100,300,100,30);
        t5.setBounds(100,325,100,30);
        s6.setBounds(100,350,100,30);
        t6.setBounds(100,400,100,30);
        s7.setBounds(100,425,100,30);
        t7.setBounds(100,450,100,30);
        r1.setBounds(100,500,100,30);
        r2.setBounds(100,550,100,30);
        r3.setBounds(100,600,100,30);
        r4.setBounds(100,650,100,30);
        f.add(s1);
        f.add(s2);
        f.add(s3);
        f.add(s4);
        f.add(s5);
        f.add(s6);
        f.add(s7);
        f.add(t1);

        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(t5);
        f.add(t6);
        f.add(t7);
        f.add(r1);
        f.add(r3);
        f.add(r4);
        bg1.add(r1);
        bg1.add(r2);


        f.add(r2);
        r1.addActionListener(this);
        r2.addActionListener(this);
        r3.addActionListener(this);
        r4.addActionListener(this);
        f.setSize(600,600);
        f.setLayout(null);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent  ac) {
        if (ac.getSource() == r1) {
            String v1 = t1.getText();//name;
            String v2 = t2.getText();//Mobno;
            String v3 = t3.getText();//age;
            String v4 = t4.getText();//email;
            String v5 = t5.getText();//boarding pnt;
            String v6 = t6.getText();//destination pnt;
            String v7 = t7.getText();//time;


            try {
                Connection conn = null;
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Connecting to database");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("connected to database");
                Statement stmt = conn.createStatement();
                String sql = "insert into  TicketBooking(name,Mobno,age,email,Boardingpnt,Destinationpnt,time)values('" + v1 + "','" + v2 + "','" + v3 + "','" + v4 + "','" + v5 + "','" + v6 + "','" + v7 + "')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(f, "data inserted");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (ac.getSource()==r2){
            try {
                Connection conn=null;
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo10", "root", "akash@123");
                Statement stmt = conn.createStatement();
                System.out.println("createDb connection...");
                ResultSet rs = stmt.executeQuery("select * from TicketBooking");
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getString(4));
                    System.out.println(rs.getString(5));
                    System.out.println(rs.getString(6));
                    System.out.println(rs.getString(7));
                }
                conn.close();
            } catch (Exception e1) {
                System.out.println(e1);
            }

        }

        if (ac.getSource() == r3) {
            String v1 = t1.getText();//name;


            try {
                Connection conn = null;
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Connecting to database");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("connected to database");
                Statement stmt = conn.createStatement();
                String sql = "delete from TicketBooking where name='" + v1 + "'";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(f, "data deleted");
            } catch (Exception e) {
                System.out.println(e);
            }
        }


        if (ac.getSource() == r4) {
            String v1 = t1.getText();//name;
            String v2 = t2.getText();//Mobno;
            String v3 = t3.getText();//age;
            String v4 = t4.getText();//email;
            String v5 = t5.getText();//boarding pnt;
            String v6 = t6.getText();//destination pnt;
            String v7 = t7.getText();//time;


            try {
                Connection conn = null;
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Connecting to database");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("connected to database");
                Statement stmt = conn.createStatement();
                String sql = "update TicketBooking set Mobno='"+v2+"',age='"+v3+"' where name='"+v1+"'";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(f, "data updated");
            } catch (Exception e) {
                System.out.println(e);
            }
        }



    }

    public static void main(String[] args) {
        new TicketBooking1();
    }
}