package shop_management_system;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserDetails extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTable table;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDetails window = new UserDetails();
					window.frame.setVisible(true);
					window.Insert_Connect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void Insert_Connect()
    {
    	String connection = "jdbc:sqlserver://localhost:1433;databaseName=JavaProject;IntegratedSecurity=true;";
    	Connection con=null;
    	ResultSet res = null;
    	try {
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		con = DriverManager.getConnection(connection);
    		String ret ="Select * from User_Account";
    		PreparedStatement st = con.prepareStatement(ret);
    		res=st.executeQuery();
    		table.setModel(DbUtils.resultSetToTableModel(res));
    		
    		
    		
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    }
	/**
	 * Create the application.
	 */
	public UserDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1197, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Information");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(442, 28, 276, 60);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(157, 142, 915, 356);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setBackground(Color.PINK);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnUpdate.setBounds(514, 566, 216, 60);
		frame.getContentPane().add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.BLUE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnDelete.setBackground(Color.PINK);
		btnDelete.setBounds(802, 566, 216, 60);
		frame.getContentPane().add(btnDelete);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserAcc ac = new UserAcc();
				ac.setVisible(true);
			}
		});
		btnAdd.setForeground(Color.BLUE);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnAdd.setBackground(Color.PINK);
		btnAdd.setBounds(199, 566, 216, 60);
		frame.getContentPane().add(btnAdd);
	}
}
