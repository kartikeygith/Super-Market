import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
class BillDetail implements ActionListener
{
DBConnect d;
Statement s;
Frame bdf;
Label l5,l6;
TextField bdl;
Button bdb1,bdb2,b4;
TextArea bda;
FileDialog fd1;
MenuBar mb;
MenuItem m1,m2,m3;
Menu m;
Dialog d1;
Panel p;
BillDetail()
{
bdf=new Frame("Bill Details : Jaikit Jilka");
bdl=new TextField(10);
bdb1=new Button("OK");
bdb2=new Button("BACK");
bda=new TextArea();
fd1=new FileDialog(bdf,"open Bill",FileDialog.LOAD);
bdb1.addActionListener(this);
bdb2.addActionListener(this);
b4=new Button("OK");
l5=new Label(" SUPER MARKET BILLING SYSTEM");
l6=new Label("PROJECT BY JAIKIT JILKA");
d1=new Dialog(bdf);
mb=new MenuBar();
m=new Menu("File");
m1=new MenuItem("About");
m2=new MenuItem("Exit");
m3=new MenuItem("Help");
d1.setTitle("About");
p=new Panel();
m1.addActionListener(this);
m2.addActionListener(this);
m3.addActionListener(this);
b4.addActionListener(this);
p.add(l5);
p.add(l6);
p.add(b4);
d1.add(p);
m.add(m1);
m.add(m3);
m.add(m2);
mb.add(m);
bdf.setMenuBar(mb);
d1.setSize(500,100);
d1.setLocation(450,400);
bdf.setLayout(new FlowLayout());
//bdf.add(bdl);
bdf.add(bdb1);
bdf.add(bdb2);
bdf.add(bda);
bdf.setSize(800,500);
bdf.setLocation(350,350);
bdf.setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==bdb2)
{
new ManagerWelcome();
bdf.dispose();
}
else if(e.getSource()==m1)
{
d1.setVisible(true);
}
else if(e.getSource()==m2)
{
bdf.dispose();
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
d1.setVisible(false);
}
else if(e.getSource()==bdb1)
{
fd1.setVisible(true);
bda.setEnabled(false);
String f1=fd1.getDirectory()+"/"+fd1.getFile();
try
{
FileReader fr=new FileReader(f1);
BufferedReader br=new BufferedReader(fr);
String x;
while((x=br.readLine())!=null)
{
bda.append(x+"\n");
}
fr.close();
br.close();
}
catch(Exception z)
{
z.printStackTrace();
}}}
public static void main(String args[])
{
new BillDetail();
}}
