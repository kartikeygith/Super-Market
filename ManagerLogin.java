import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
class ManagerLogin  implements ActionListener
{
DBConnect d;
Statement s;
Frame mf;
Label ml1,ml2,ml3,l5,l6;
TextField mlt1,mlt2;
Button mb1,mb2,mb3,mb4,b4;
Dialog d1,d2;
Panel p,p1;
MenuBar mb;
MenuItem m1,m2,m3;
Menu m;
ManagerLogin()
{
d=new DBConnect();
mf=new Frame("Manager : Jaikit Jilka");
p=new Panel();
ml1=new Label("Username");
ml2=new Label("Password");
ml3=new Label("Invalid credentails");
mlt1=new TextField(10);
mlt2=new TextField(10);
mlt2.setEchoChar('*');
mb1=new Button("Login");
mb2=new Button("Reset");
mb3=new Button("Back");
mb4=new Button("OK");
d1=new Dialog(mf);
d1.setTitle("Error");
mf.setLayout(new FlowLayout());
mf.add(ml1);
mf.add(mlt1);
mf.add(ml2);
mf.add(mlt2);
mf.add(mb1);
mf.add(mb2);
mf.add(mb3);
mb1.addActionListener(this);
mb2.addActionListener(this);
mb3.addActionListener(this);
mb4.addActionListener(this);
l5=new Label(" SUPER MARKET BILLING SYSTEM");
l6=new Label("PROJECT BY JAIKIT JILKA");
d2=new Dialog(mf);
mb=new MenuBar();
m=new Menu("File");
m1=new MenuItem("About");
m2=new MenuItem("Exit");
m3=new MenuItem("Help");
d2.setTitle("About");
b4=new Button("OK");
p1=new Panel();
m1.addActionListener(this);
m2.addActionListener(this);
m3.addActionListener(this);
b4.addActionListener(this);
p1.add(l5);
p1.add(l6);
p1.add(b4);
d2.add(p1);
m.add(m1);
m.add(m3);
m.add(m2);
mb.add(m);
mf.setMenuBar(mb);
d2.setSize(500,100);
d2.setLocation(450,400);
mf.setSize(800,500);
d1.setSize(200,90);
mf.setLocation(350,350);
d1.setLocation(450,450);
mf.setVisible(true);
p.add(ml3);
p.add(mb4);
d1.add(p);

}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==mb1)
{
String x=mlt1.getText();
String y=mlt2.getText();
try
{
ResultSet rs=d.s.executeQuery("select * From ManagerLogin where Username='"+x+"' and Password='"+y+"'");
if(rs.next())
{
String N=rs.getString(1);
new ManagerWelcome();
mf.dispose();
}
else
{
d1.setVisible(true);
mb1.setEnabled(false);
mb2.setEnabled(false);
mb3.setEnabled(false);
}
}
catch(Exception g)
{
g.printStackTrace();
}}
else if(e.getSource()==mb2)
{
mlt1.setText("");
mlt2.setText("");
}
else if(e.getSource()==mb3)
{
Welcome w=new Welcome();
mf.dispose();
}
else if(e.getSource()==mb4)
{
d1.setVisible(false);
mb1.setEnabled(true);
mb2.setEnabled(true);
mb3.setEnabled(true);
}
else if(e.getSource()==m1)
{
d2.setVisible(true);
}
else if(e.getSource()==m2)
{
mf.dispose();
}
else if(e.getSource()==m3)
{
try
{
Runtime.getRuntime().exec("C:/Program Files/Internet Explorer/iexplore.exe"+" file:///D:/project/help.html");
}
catch(IOException z)
{}
}
else if(e.getSource()==b4)
{
d2.setVisible(false);
}
}
public static void main(String []args)
{
new ManagerLogin();
}}
