import java.awt.*;
import java.awt.event.*;
import java.io.*;
class ManagerWelcome implements ActionListener
{
Frame fmw;
Button bmw1,bmw2,bmw3,b4;
Label lmw,l5,l6;
Dialog d2;
Panel p1;
MenuBar mb;
MenuItem m1,m2,m3;
Menu m;

ManagerWelcome()
{

fmw=new Frame("ManagerWelcome : Jaikit Jilka");
bmw1=new Button("Bill Details");
bmw2=new Button("Stock");
bmw3=new Button("Logout");
lmw=new Label("Welcome");
bmw1.addActionListener(this);
bmw2.addActionListener(this);
bmw3.addActionListener(this);
fmw.setLayout(null);
fmw.setSize(800,500);
fmw.setLocation(350,350);
fmw.setVisible(true);
fmw.add(lmw);
fmw.add(bmw1);
fmw.add(bmw2);
fmw.add(bmw3);
l5=new Label(" SUPER MARKET BILLING SYSTEM");
l6=new Label("PROJECT BY JAIKIT JILKA");
d2=new Dialog(fmw);
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
fmw.setMenuBar(mb);
d2.setSize(500,100);
d2.setLocation(450,400);
lmw.setBounds(335,210,250,20);
bmw1.setBounds(310,250,120,20);
bmw2.setBounds(310,300,120,20);
bmw3.setBounds(310,350,120,20);
}
public void actionPerformed(ActionEvent e)
{
if (e.getSource()==bmw1)
{
new BillDetail();
fmw.dispose();
}
else if(e.getSource()==bmw2)
{
new Stock();
fmw.dispose();
}
else if(e.getSource()==bmw3)
{
new ManagerLogin();
fmw.dispose();
}
else if(e.getSource()==m1)
{
d2.setVisible(true);
}
else if(e.getSource()==m2)
{
fmw.dispose();
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
new ManagerWelcome();
}}
