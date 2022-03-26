import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class selectpaper1 implements ActionListener{
    JLabel j1,j2,j3,j4,j5,j6,j7;
    JRadioButton o1,o2,o3;
    JButton r1;
    ButtonGroup bg1;
    selectpaper1(){
        JFrame f=new JFrame();
        j1=new JLabel("Select paper");
        o1=new JRadioButton("c programmning");
        o2=new JRadioButton("c++ programming");
        o3=new JRadioButton("java programming");
        j2=new JLabel("Instriction");
        j3=new JLabel("Hall-Ticket is mandatory");
        j4=new JLabel("Mask is requried");
        j5=new JLabel("candidate should reach 30 min before examination time");
        j6=new JLabel("Digital gadets not allow");
        j7=new JLabel("water is provide");
        r1=new JButton("proceed");
        bg1=new ButtonGroup();
        j1.setBounds(50,50,50,20);
        o1.setBounds(100,100,100,20);
        o2.setBounds(100,150,100,20);
        o3.setBounds(100,200,100,30);
        j2.setBounds(100,250,100,30);
        j3.setBounds(100,300,100,30);
        j4.setBounds(100,350,100,30);
        j5.setBounds(100,400,100,30);
        j6.setBounds(100,450,100,30);
        j7.setBounds(100,500,100,30);
        r1.setBounds(100,550,100,30);
        r1.addActionListener(this);
        f.add(j1);
        f.add(o1);
        f.add(o2);
        f.add(o3);
        f.add(j2);
        f.add(j3);
        f.add(j4);
        f.add(j5);
        f.add(j6);
        f.add(j7);
        f.add(r1);
        bg1.add(o1);
        bg1.add(o2);
        bg1.add(o3);
        f.setSize(600,600);
        f.setLayout(null);
        f.setVisible(true);

    }
    public void actionPerformed(ActionEvent ac){
        if (ac.getSource()==r1){
            if (o1.isSelected()) {

                Questionpaper1 q1 = new Questionpaper1();

            }
            if (o2.isSelected()){
            Questionpaper2 q2=new Questionpaper2();

            }
            if (o3.isSelected()){
                Questionpaper3java q3=new Questionpaper3java();

            }
        }
    }

    public static void main(String[] args) {
        new selectpaper1();
    }
}
