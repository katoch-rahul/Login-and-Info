import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class LoginForm
{
JFrame f1;
JPanel p;
JLabel lmsg,lu,lp;
JTextField tu;
JPasswordField tps;
Button bl,bc,breg,bex;

GridBagLayout gbl;
GridBagConstraints gbc;


public LoginForm()
{

f1=new JFrame("login_Page");
p=new JPanel();


lu=new JLabel("Username");
lp=new JLabel("Password");
lmsg=new JLabel("**                                                                                                 **");

tu=new JTextField(20);
 
tps=new JPasswordField(20);
 


bl=new Button("Login");
bc=new Button("Clear");
breg=new Button("Register");
bex=new Button("Exit");


gbl=new GridBagLayout();
gbc=new GridBagConstraints();
f1.getContentPane().add(p).setBackground(Color.yellow);

p.setLayout(gbl);


gbc.anchor=GridBagConstraints.NORTHWEST;




gbc.gridx=1;
gbc.gridy=2;
gbl.setConstraints(lu,gbc);
p.add(lu);

gbc.gridx=4;
gbc.gridy=2;
gbl.setConstraints(tu,gbc);
p.add(tu);

gbc.gridx=1;
gbc.gridy=4;
gbl.setConstraints(lp,gbc);
p.add(lp);

gbc.gridx=4;
gbc.gridy=4;
gbl.setConstraints(tps,gbc);
p.add(tps);



gbc.gridx=1;
gbc.gridy=6;
gbl.setConstraints(bl,gbc);
ActionLoginForm log=new ActionLoginForm();
bl.addActionListener(log);
p.add(bl);

gbc.gridx=3;
gbc.gridy=6;
gbl.setConstraints(bc,gbc);
ActionLoginForm clr=new ActionLoginForm();
bc.addActionListener(clr);
p.add(bc);

gbc.gridx=5;
gbc.gridy=6;
gbl.setConstraints(breg,gbc);
ActionLoginForm reg=new ActionLoginForm();
breg.addActionListener(reg);
p.add(breg);

gbc.gridx=3;
gbc.gridy=7;
gbl.setConstraints(bex,gbc);
ActionLoginForm ex=new ActionLoginForm();
bex.addActionListener(ex);
p.add(bex);

gbc.gridx=1;
gbc.gridy=8;
gbl.setConstraints(lmsg,gbc);
p.add(lmsg);


f1.setVisible(true);  

f1.setSize(400,400);

}
class ActionLoginForm implements ActionListener
{
public void actionPerformed(ActionEvent ae)
{
Object obj=ae.getSource();

if(obj==bc)
{
tu.setText("");
tps.setText("");
}
if(obj==bl)
login();
if(obj==breg)
register();
if(obj==bex)
System.exit(0);
}

}	
public void login()
{
	try
	{
	String uname,pwd,pass;
	uname=tu.getText();
	pwd=tps.getText();
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://10.16.31.12:3306/studb","admin","Admin123");
	
	Statement stm=con.createStatement();
	ResultSet rs=stm.executeQuery("Select Password from log where UserName='"+uname+"'");
	rs.next();
	pass=rs.getString(1);

	if(pass.equals(pwd))
		{lmsg.setText("Password is valid");
		 f1.setVisible(false);
		StudentForm objj=new StudentForm();
		}
	else
		lmsg.setText("Password is not valid");
	}
	catch(Exception e1)
	{
		System.out.println("Some exception occured :  "+e1);
	}
}
public void register()
{
	try
	{
	String ru=tu.getText();
	String rp=tps.getText();
	
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con;
	con=DriverManager.getConnection("jdbc:mysql://10.16.31.12:3306/studb","admin","Admin123");

	PreparedStatement ps=con.prepareStatement("Insert into Log values(?,?)");
	ps.setString(1,ru);
	ps.setString(2,rp);
	ps.executeUpdate();
	lmsg.setText("One ID Registered.");
	}
	catch(Exception e2)
	{
	System.out.println("Some exception occured:   "+e2);
	}
}
public static void main(String args[])
{
LoginForm objj=new LoginForm();
}
}