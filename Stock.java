import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
class Stock implements ActionListener
{
DBConnect d;
Statement s;
Frame fs;
Button bs,bs1,bs2,bs3;
TextArea tas;
Label l1,l2;
String a;
MenuBar mb;
MenuItem m1,m2,m3;
Menu m;
Dialog d1;
Panel p;
Stock()
{
d=new DBConnect();
fs=new Frame("Stock : Jaikit Jilka");
bs=new Button("Products");
bs1=new Button("Back");
bs2=new Button("Add Product");
bs3=new Button("OK");
l1=new Label(" SUPER MARKET BILLING SYSTEM");
l2=new Label("PROJECT BY JAIKIT JILKA");
d1=new Dialog(fs);
tas=new TextArea();
mb=new MenuBar();
m=new Menu("File");
m1=new MenuItem("About");
m2=new MenuItem("Exit");
m3=new MenuItem("Help");
d1.setTitle("About");
p=new Panel();
fs.setLayout(new FlowLayout());
bs.addActionListener(this);
bs1.addActionListener(this);
bs2.addActionListener(this);
m1.addActionListener(this);
m2.addActionListener(this);
m3.addActionListener(this);
bs3.addActionListener(this);
p.add(l1);
p.add(l2);
p.add(bs3);
d1.add(p);
m.add(m1);
m.add(m3);
m.add(m2);
mb.add(m);
fs.setMenuBar(mb);
fs.add(bs);
fs.add(bs1);
fs.add(bs2);
fs.add(tas);
fs.setVisible(true);
d1.setSize(500,100);
fs.setSize(800,500);
d1.setLocation(450,400);
fs.setLocation(350,350);
}
public void actionPerformed(ActionEvent e)
{
if (e.getSource()==bs)
{
try
{
String Q="select product1,product2,Quantity from Product";
ResultSet rs=d.s.executeQuery(Q);
tas.append("Name-------------Mrp-------------Quantity"+"\n"+"\n");
while(rs.next())
{
String product1 = rs.getString("product1");
String product2 = rs.getString("product2");
String Quantity = rs.getString("Quantity");

tas.append(product1+"-------------Rs"+product2+"-------------"+Quantity+"pcs"+"\n");
}}
catch(Exception z)
{
z.printStackTrace();
}}
else if(e.getSource()==bs1)
{
new ManagerWelcome();
fs.dispose();
}
else if(e.getSource()==bs2)
{
new AddStock();
fs.dispose();
}
else if(e.getSource()==m1)
{
d1.setVisible(true);
}
else if(e.getSource()==m2)
{
fs.dispose();
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
else if(e.getSource()==bs3)
{
d1.setVisible(false);
}
}
public static void main(String []args)
{
new Stock();
}}
