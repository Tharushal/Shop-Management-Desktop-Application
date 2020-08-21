package shop_management_system;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtPawd;
	private JTextField txtUname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void Connect()
	{
		 String connection = "jdbc:sqlserver://localhost:1433;databaseName=JavaProject;IntegratedSecurity=true;";
	    	Connection con=null;
	    	Statement stmt = null;
	    	ResultSet set = null;
	    	try {
	    		 
	    		
	    		String name = txtUname.getText();
	    		String upawd = txtPawd.getText();
	    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    		con = DriverManager.getConnection(connection);
	    		   stmt = con.createStatement();
	    		String r_qU = "Select Uname,U_Password From User_Account";
	    		  set=  stmt.executeQuery(r_qU);
	    		  while(set.next())
	    		  {
	    		  String uname = set.getString("Uname");
	    		  String pawd =  set.getString("U_Password");
	    		  if(name.equals(uname) && upawd.equals(pawd))
	    		  {
	    			  dispose();
	    			  System sys = new System();
	    			  sys.setVisible(true);
	    			   txtUname.setText("");
		    	       txtPawd.setText("");
		    	       break;
	    		  }
	    		  else
	    		  {
	    		  JOptionPane.showMessageDialog(null,"Username or Password Invalid","Login Error",JOptionPane.ERROR_MESSAGE);
	    		  break;
	    		  }
	    		  
	    		  }
	    	}catch(Exception ex)
	    	{
	    		ex.printStackTrace();
	    	}
	}
	public void Access()
	{
		
	}
	private void Clear(Container cont)
    {
    	for(Component ctrl : cont.getComponents())
    	{
    		if(ctrl instanceof JTextField)
    		{
    			JTextField tb = (JTextField)ctrl;
    			tb.setText("");
    		}
    	}
    }
	/**
	 * Create the frame.
	 */
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1171, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Shop Management");
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(424, 29, 273, 78);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("User Name");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(295, 164, 130, 32);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(295, 268, 130, 32);
		contentPane.add(label_2);
		
		txtPawd = new JPasswordField();
		txtPawd.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtPawd.setBounds(468, 265, 360, 45);
		contentPane.add(txtPawd);
		
		txtUname = new JTextField();
		txtUname.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtUname.setColumns(10);
		txtUname.setBounds(468, 151, 360, 45);
		contentPane.add(txtUname);
		
		JLabel label_3 = new JLabel("Forgot Password");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_3.setBounds(576, 341, 206, 32);
		contentPane.add(label_3);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container c = getContentPane();
				Clear(c);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBounds(334, 452, 212, 69);
		contentPane.add(btnClear);
		
		JButton btnLogIn = new JButton("Login");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogIn.setBounds(652, 452, 212, 69);
		contentPane.add(btnLogIn);
	}

}
