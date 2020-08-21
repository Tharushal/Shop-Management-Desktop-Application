package shop_management_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Update2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JPasswordField txtpawd;
	private JTextField txtMail;
	private JTextField txtutype;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update2 frame = new Update2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void set(UpdateInfo uI)
	   {
		   txtId.setText(uI.UId());
		   txtName.setText(uI.Uname());
		   txtpawd.setText(uI.Pawd());
		   txtMail.setText(uI.Email());
		   txtutype.setText(uI.Utype());
		   
	   }
	private void Update()
	{
		String connection = "jdbc:sqlserver://localhost:1433;databaseName=JavaProject;IntegratedSecurity=true;";
    	Connection con=null;
    	try {
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		con = DriverManager.getConnection(connection);
    		String U_que = "Update User_Account set Uname = ? , U_Password = ? , Email = ? , U_Type = ? where U_Id = ? ";
    		PreparedStatement st = con.prepareStatement(U_que);
    		st.setString(1,txtName.getText());
    		st.setString(2, txtpawd.getText());
    		st.setString(3, txtMail.getText());
    		st.setString(4, txtutype.getText());
    		int id = Integer.parseInt(txtId.getText());
    		st.setInt(5,id);
    		int f = st.executeUpdate();
    		if(f !=-1)
    			JOptionPane.showMessageDialog(null,"Update Successfully");
    		UserInfo2 uf2 = new UserInfo2();
    		uf2.show(con);
    	    
    	}catch(Exception ex)
    	{
    		JOptionPane.showMessageDialog(null,"Update Successfully");
    	}
	}
	private void Connect(Connection c)
    {
    	ResultSet res = null;
    	try {
    		
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}

    }
	/**
	 * Create the frame.
	 */
	public Update2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 754);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Update User Information");
		label.setForeground(new Color(148, 0, 211));
		label.setFont(new Font("Sylfaen", Font.BOLD, 30));
		label.setBounds(182, 27, 401, 91);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("User Id");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(46, 143, 165, 43);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("User Name");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(46, 238, 165, 43);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Password");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(46, 342, 165, 43);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Email");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(46, 430, 165, 43);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("User Type");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_5.setBounds(46, 520, 165, 43);
		contentPane.add(label_5);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtId.setColumns(10);
		txtId.setBounds(210, 131, 431, 49);
		contentPane.add(txtId);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtName.setColumns(10);
		txtName.setBounds(210, 226, 431, 49);
		contentPane.add(txtName);
		
		txtpawd = new JPasswordField();
		txtpawd.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpawd.setBounds(210, 331, 431, 49);
		contentPane.add(txtpawd);
		
		txtMail = new JTextField();
		txtMail.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtMail.setColumns(10);
		txtMail.setBounds(210, 418, 431, 49);
		contentPane.add(txtMail);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update();
			}
		});
		btnUpdate.setForeground(new Color(46, 139, 87));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnUpdate.setBounds(12, 611, 177, 63);
		contentPane.add(btnUpdate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(new Color(46, 139, 87));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnClear.setBounds(284, 611, 190, 63);
		contentPane.add(btnClear);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setForeground(new Color(46, 139, 87));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnClose.setBounds(564, 611, 177, 63);
		contentPane.add(btnClose);
		
		txtutype = new JTextField();
		txtutype.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtutype.setColumns(10);
		txtutype.setBounds(210, 514, 431, 49);
		contentPane.add(txtutype);
	}

}
