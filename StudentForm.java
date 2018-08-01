simport java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class StudentForm
{
JFrame f1;
JPanel p;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,lmsg;
JTextField t1,t2,t3,t5,t6,t7,t8,t9,t10,t11;
JComboBox t4;
JButton b1,nr,dlt,ret,mdf;
GridBagLayout gbl;
GridBagConstraints gbc;

public StudentForm()
{

f1=new JFrame("Student Information");
p=new JPanel();
l1= new JLabel("Roll no");
l2= new JLabel("Name");
l3= new JLabel("Age");
l4= new JLabel("Course");
l5= new JLabel("Fee");
l6= new JLabel("Enter roll no");
l7= new JLabel("Rollno");
l8= new JLabel("Name");
l9= new JLabel("Age");
l10= new JLabel("Course");
l11= new JLabel("Fee");


t1= new JTextField(10);
t2= new JTextField(10);
t3= new JTextField(10);
t5= new JTextField(10);
t6= new JTextField(10);
t7= new JTextField(10);
t8= new JTextField(10);
t9= new JTextField(10);
t10= new JTextField(10);
t11 =new JTextField(10);
b1= new JButton("Save");
nr= new JButton("New Record");
dlt= new JButton("Delete");
ret= new JButton("Retrive");
mdf= new JButton("Modify");
 String Course[]={"C++","java","php","Pascal"};
t4=new JComboBox(Course);
gbl=new GridBagLayout();
gbc=new GridBagConstraints();
f1.getContentPane().add(p);


p.setLayout(gbl);


gbc.anchor=GridBagConstraints.NORTHWEST;

lmsg=new JLabel("**                                            **");


gbc.gridx=1;
gbc.gridy=1;
gbl.setConstraints(l1,gbc);
p.add(l1);
gbc.gridx=4;
gbc.gridy=1;
gbl.setConstraints(t1,gbc);
p.add(t1);



gbc.gridx=1;
gbc.gridy=3;
gbl.setConstraints(l2,gbc);
p.add(l2);
gbc.gridx=4;
gbc.gridy=3;
gbl.setConstraints(t2,gbc);
p.add(t2);



gbc.gridx=1;
gbc.gridy=5;
gbl.setConstraints(l3,gbc);
p.add(l3);
gbc.gridx=4;
gbc.gridy=5;
gbl.setConstraints(t3,gbc);
p.add(t3);


gbc.gridx=1;
gbc.gridy=7;
gbl.setConstraints(l4,gbc);
p.add(l4);
gbc.gridx=4;
gbc.gridy=7;
gbl.setConstraints(t4,gbc);
p.add(t4);


gbc.gridx=1;
gbc.gridy=9;
gbl.setConstraints(l5,gbc);
p.add(l5);
gbc.gridx=4;
gbc.gridy=9;
gbl.setConstraints(t5,gbc);
p.add(t5);



gbc.gridx=1;
gbc.gridy=12;
gbl.setConstraints(l6,gbc);
p.add(l6);
gbc.gridx=4;
gbc.gridy=12;
gbl.setConstraints(t6,gbc);
p.add(t6);

gbc.gridx=1;
gbc.gridy=14;
gbl.setConstraints(l7,gbc);
p.add(l7);
gbc.gridx=1;
gbc.gridy=15;
gbl.setConstraints(t7,gbc);
p.add(t7);

gbc.gridx=3;
gbc.gridy=14;
gbl.setConstraints(l8,gbc);
p.add(l8);
gbc.gridx=3;
gbc.gridy=15;
gbl.setConstraints(t8,gbc);
p.add(t8);


gbc.gridx=4;
gbc.gridy=14;
gbl.setConstraints(l9,gbc);
p.add(l9);
gbc.gridx=4;
gbc.gridy=15;
gbl.setConstraints(t9,gbc);
p.add(t9);



gbc.gridx=5;
gbc.gridy=14;
gbl.setConstraints(l10,gbc);
p.add(l10);
gbc.gridx=5;
gbc.gridy=15;
gbl.setConstraints(t10,gbc);
p.add(t10);

gbc.gridx=6;
gbc.gridy=14;
gbl.setConstraints(l11,gbc);
p.add(l11);
gbc.gridx=6;
gbc.gridy=15;
gbl.setConstraints(t11,gbc);
p.add(t11);

StudentFormAction sia=new StudentFormAction();
gbc.gridx=1;
gbc.gridy=11;
gbl.setConstraints(b1,gbc);
b1.addActionListener(sia);
p.add(b1);
gbc.gridx=3;
gbc.gridy=11;
gbl.setConstraints(nr,gbc);
nr.addActionListener(sia);
p.add(nr);

gbc.gridx=6;
gbc.gridy=12;
gbl.setConstraints(dlt,gbc);
dlt.addActionListener(sia);
p.add(dlt);
gbc.gridx=7;
gbc.gridy=12;
gbl.setConstraints(ret,gbc);
ret.addActionListener(sia);
p.add(ret);

gbc.gridx=8;
gbc.gridy=12;
gbl.setConstraints(mdf,gbc);
mdf.addActionListener(sia);
p.add(mdf);



gbc.gridx=1;
gbc.gridy=17;
gbl.setConstraints(lmsg,gbc);
p.add(lmsg);
f1.setVisible(true);  

f1.setSize(400,400);
}

class StudentFormAction implements ActionListener
{
public void actionPerformed(ActionEvent ae)
{
Object obj=ae.getSource();
if(obj==b1)
{
saveRecord();
}
if(obj==nr)
{
newRecord();
}

if(obj==dlt)
{
Delete();
}

if(obj==ret)
{
Retrive();
}

if(obj==mdf)
{
Modify();
}
}

public void saveRecord()
{
int val1=Integer.parseInt(t1.getText());
if(val1==0)
{
lmsg.setText("Student RollNo zero ");
return;
}
String val2=t2.getText();
if(val2.length()==0)
{
lmsg.setText("Name cannot be empty");
return;
}
int val3=Integer.parseInt(t3.getText());
if(val3<18)
{
lmsg.setText("Invalid Age");
return;
}
String val4=String.valueOf(t4.getSelectedItem());
if(val4.length()==0)
{
lmsg.setText("Course cannot be empty");
return;
}
Float val5=Float.parseFloat(t5.getText());
if(val5<2500)
{
lmsg.setText("Fee cannot be less than rs 2500/-");
return;
}
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studb","root","");

PreparedStatement st=con.prepareStatement("insert into sturec values(?,?,?,?,?)");
st.setInt(1,val1);
st.setString(2,val2);
st.setInt(3,val3);
st.setString(4,val4);
st.setFloat(5,val5);
st.executeUpdate();
lmsg.setText("One Record Inserted ");
}
catch(SQLException e)
{
System.out.println("Some error during inserting of records"+e);
}
catch(ClassNotFoundException e1)
{
System.out.println("Class not found "+e1);
}
}

public void newRecord()
{

t2.setText("");
t3.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
t9.setText("");
t10.setText("");
t11.setText("");
lmsg.setText("******       ************");
try {
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studb","root","");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("Select max(sturoll) from sturec");
rs.next();
int newroll;
newroll=rs.getInt(1);
newroll=newroll+1;
t1.setText(String.valueOf(newroll));
}
catch(Exception e)
{
System.out.println("Some error occured: "+e);
}
}

public void Delete() 
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studb","root","");
String delId=t6.getText();
PreparedStatement st=con.prepareStatement("delete from sturec where sturoll=?");
st.setString(1,delId);
st.executeUpdate();
lmsg.setText("Records deleted");
}
catch(Exception e)
{
System.out.println("Some error occured: "+e);
}
}

public void Retrive()
{
try {
String rno=t6.getText();
Class.forName("com.mysql.jdbc.Driver");
Connection con;
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studb","root","");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("Select * from sturec where sturoll=' "+rno+ " ' ");
rs.next();
t7.setText(Integer.toString(rs.getInt(1)));
t8.setText(rs.getString(2));
t9.setText(Integer.toString(rs.getInt(3)));
t10.setText(rs.getString(4));
t11.setText(Double.toString(rs.getInt(5)));
con.close();

}
catch(Exception e)
{
System.out.println("Some error occured: "+e);
}
}



public void Modify()
{
ResultSet result;
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con;
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studb","root","");
PreparedStatement st1=con.prepareStatement("Update sturec set sturoll=? where sturoll=?");

st1.setInt(1,Integer.parseInt(t7.getText()));
st1.setInt(2,Integer.parseInt(t6.getText()));
st1.executeUpdate();

PreparedStatement st2=con.prepareStatement("Update sturec set stuname=? where sturoll=?");
st2.setString(1,t8.getText());
st2.setInt(2,Integer.parseInt(t6.getText()));
st2.executeUpdate();

PreparedStatement st3=con.prepareStatement("Update sturec set stuage=? where sturoll=?");
st3.setInt(1,Integer.parseInt(t9.getText()));
st3.setInt(2,Integer.parseInt(t6.getText()));
st3.executeUpdate();
 
PreparedStatement st4=con.prepareStatement("Update sturec set stucourse=? where sturoll=?");

st4.setString(1,t10.getText());
st4.setInt(2,Integer.parseInt(t6.getText()));
st4.executeUpdate();

PreparedStatement st5=con.prepareStatement("Update sturec set stufee=? where sturoll=?");
st5.setFloat(1,Float.parseFloat(t11.getText()));
st5.setInt(2,Integer.parseInt(t6.getText()));
st5.executeUpdate();

lmsg.setText("Records Updated");
}
catch(Exception e)
{
System.out.println("error"+e);
}
}
}

public static void main(String args[])
{
StudentForm  si =new StudentForm();
}
}