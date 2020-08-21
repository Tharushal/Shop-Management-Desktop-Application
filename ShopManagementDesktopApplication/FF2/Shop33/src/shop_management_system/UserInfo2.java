package shop_management_system;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.font.OpenType;
import java.awt.event.ActionEvent;

public class UserInfo2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo2 frame = new UserInfo2();
					frame.setVisible(true);
					frame.Insert_Connect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void show(Connection con)
	{
		ResultSet set = null;
		try {
		String ret ="Select U_Id [User Id],Uname [User Name],U_Password [User Password],Email,U_Type [User Type] from User_Account";
		PreparedStatement st = con.prepareStatement(ret);
		set=st.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(set));
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void Insert_Connect()
    {
    	String connection = "jdbc:sqlserver://localhost:1433;databaseName=JavaProject;IntegratedSecurity=true;";
    	Connection con=null;
    	try {
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		con = DriverManager.getConnection(connection);
    		/*String ret ="Select U_Id [User Id],Uname [User Name],U_Password [User Password],Email,U_Type [User Type] from User_Account";
    		PreparedStatement st = con.prepareStatement(ret);
    		res=st.executeQuery();
    		table.setModel(DbUtils.resultSetToTableModel(res));*/
    		show(con);
    		
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    }
	private void Update_Data()
	{
		UpdateInfo in = new UpdateInfo();
		DefaultTableModel mode = (DefaultTableModel)table.getModel();
		int index = table.getSelectedRow();
		    in.UId(mode.getValueAt(index,0).toString());
		    in.Uname(mode.getValueAt(index,1).toString());
		    in.Pawd(mode.getValueAt(index,2).toString());
		    in.Email(mode.getValueAt(index,3).toString());
		    in.Utype(mode.getValueAt(index,4).toString());
		    Update2 up = new Update2();
		    up.set(in);
		    up.setVisible(true);
		    //Insert_Connect();
		
	}
	private void temp()
	{
		String connection = "jdbc:sqlserver://localhost:1433;databaseName=JavaProject;IntegratedSecurity=true;";
    	Connection con=null;
	    	//ResultSet res = null;
    	try {
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		con = DriverManager.getConnection(connection);
		int row = table.getSelectedRow();
		 Object value=table.getModel().getValueAt(row,0);
			String dq= "Delete from User_Account where U_id='"+value+"'";
	 		  PreparedStatement st = con.prepareStatement(dq);
	    		int i=st.executeUpdate();
	    		if(i != -1)
	    		{
	    		JOptionPane.showMessageDialog(null,"Member Details is Deleted","Confirmation",JOptionPane.INFORMATION_MESSAGE);
	    		show(con);
	    		}
	    		


    	}catch(Exception ex)
    	{
    		JOptionPane.showMessageDialog(null,ex.getMessage());
    	}
	}
		
	/**
	 * Create the frame.
	 */
	public UserInfo2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1244, 754);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("User Information");
		label.setForeground(Color.GRAY);
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setBounds(465, 36, 276, 60);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(119, 146, 1006, 339);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
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
		btnAdd.setBounds(220, 563, 216, 60);
		contentPane.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(0<table.getSelectedRowCount())
				{
					
					    Update_Data();
					    Insert_Connect();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please select a member to update");
				}
			}
		});
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnUpdate.setBackground(Color.PINK);
		btnUpdate.setBounds(524, 563, 216, 60);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(0<table.getSelectedRowCount())
				
					{
                    temp();
			}
				else {
					JOptionPane.showMessageDialog(null,"Please Select One of the Member");
				}
				
			}
		});
		btnDelete.setForeground(Color.BLUE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnDelete.setBackground(Color.PINK);
		btnDelete.setBounds(823, 563, 216, 60);
		contentPane.add(btnDelete);
	}
}
