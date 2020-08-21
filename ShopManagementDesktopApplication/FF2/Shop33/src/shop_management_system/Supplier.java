package shop_management_system;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class Supplier extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSId;
	private JTextField txtSname;
	private JTextField txtEmail;
	private JTextField txtPnum;
	private JTextField txtAddress;
	private JTextField txtDate;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supplier frame = new Supplier();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	 private void Insert_Connect()
	 {
		 String connection = "jdbc:sqlserver://localhost:1433;databaseName=JavaProject;IntegratedSecurity=true;";
	    	Connection con=null;
	    	Statement stmt = null;
	    	try {
	    		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    		con = DriverManager.getConnection(connection);
	    		String Id = txtSId.getText();
	    		String name = txtSname.getText();
	    		String mail=txtEmail.getText();
	    		String pnum=txtPnum.getText();
	    		String addr = txtAddress.getText();
	    		java.util.Date udate = format.parse(txtDate.getText());
	    		Date date = new Date(udate.getTime());
	    		SupplierInfo SI = new SupplierInfo(Id,name,mail,pnum,date,addr);
	    		
	    		String ins = "Insert Into Supplier(NIC,Sname,Email,Phone_num,S_Date,S_Address)"+"Values ('"+SI.NIC()+"','"+SI.Name()+"','"+SI.Mail()+"','"+SI.Pnum()+"','"+SI._Date()+"','"+SI.Saddress()+"');";
	    				//String iQuery ="Insert Into Member(UserName,Email,Password)"+"Values ('"+me.Uname()+"','"+me.Email()+"','"+me.Pawd()+"');";
	    		stmt=con.createStatement();
	 		   stmt.executeUpdate(ins);
	 		   JOptionPane.showMessageDialog(null,"Inserted Successfully");
	    	}catch(Exception ex)
	    	{
	    		ex.printStackTrace();
	    	}
	 }
	/**
	 * Create the frame.
	 */
	public Supplier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Supplier Info");
		label.setForeground(new Color(255, 20, 147));
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setBounds(101, 0, 225, 85);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Supplier Id");
		label_1.setForeground(new Color(85, 107, 47));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(30, 121, 137, 32);
		contentPane.add(label_1);
		
		txtSId = new JTextField();
		txtSId.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtSId.setColumns(10);
		txtSId.setBounds(193, 111, 268, 38);
		contentPane.add(txtSId);
		
		JLabel label_2 = new JLabel("Supplier Name");
		label_2.setForeground(new Color(85, 107, 47));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(30, 245, 151, 32);
		contentPane.add(label_2);
		
		txtSname = new JTextField();
		txtSname.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtSname.setColumns(10);
		txtSname.setBounds(193, 239, 268, 38);
		contentPane.add(txtSname);
		
		JLabel label_3 = new JLabel("Email");
		label_3.setForeground(new Color(85, 107, 47));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(40, 357, 151, 32);
		contentPane.add(label_3);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(193, 356, 268, 38);
		contentPane.add(txtEmail);
		
		txtPnum = new JTextField();
		txtPnum.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtPnum.setColumns(10);
		txtPnum.setBounds(744, 59, 268, 38);
		contentPane.add(txtPnum);
		
		JLabel label_4 = new JLabel("Phone Number");
		label_4.setForeground(new Color(85, 107, 47));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(558, 60, 151, 32);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Address");
		label_5.setForeground(new Color(85, 107, 47));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_5.setBounds(558, 171, 151, 32);
		contentPane.add(label_5);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtAddress.setColumns(10);
		txtAddress.setBounds(744, 170, 268, 38);
		contentPane.add(txtAddress);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insert_Connect();
			}
		});
		btnSave.setForeground(new Color(0, 0, 128));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnSave.setBackground(new Color(175, 238, 238));
		btnSave.setBounds(491, 402, 169, 62);
		contentPane.add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container c = getContentPane();
				Clear(c);
			}
		});
		btnClear.setForeground(new Color(0, 0, 128));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnClear.setBackground(new Color(175, 238, 238));
		btnClear.setBounds(685, 402, 169, 62);
		contentPane.add(btnClear);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(85, 107, 47));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDate.setBounds(558, 269, 151, 32);
		contentPane.add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtDate.setColumns(10);
		txtDate.setBounds(744, 268, 268, 38);
		contentPane.add(txtDate);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setForeground(new Color(0, 0, 128));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnClose.setBackground(new Color(175, 238, 238));
		btnClose.setBounds(878, 402, 169, 62);
		contentPane.add(btnClose);
	}

}
