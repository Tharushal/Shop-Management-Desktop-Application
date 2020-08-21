package shop_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class Category {

	private JFrame frame;
	private JTextField txtCId;
	private JTextField txtCname;
	private JTextField txtDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Category window = new Category();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Category() {
		initialize();
	}
	private void Cate_Item()
	{
		try {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		CategoryInfo ci = new CategoryInfo();
		ci.Id(Integer.parseInt(txtCId.getText()));
		ci.Name(txtCname.getText());
		java.util.Date ddate = format.parse(txtDate.getText());
		Date date = new Date(ddate.getTime());
		ci._Date(date);
		Insert_Connect(ci);
		}catch(NumberFormatException nx)
		{
			nx.printStackTrace();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
    private void Insert_Connect(CategoryInfo Cinfo)
    {
    	String connection = "jdbc:sqlserver://localhost:1433;databaseName=JavaProject;IntegratedSecurity=true;";
    	Connection con=null;
    	try {
    		
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		con = DriverManager.getConnection(connection);
    		String in_I = "Insert Into Category(CId,C_Name,C_Date) Values (?,?,?)";
    		PreparedStatement  pstmt = con.prepareStatement(in_I);
    		pstmt.setInt(1,Cinfo.Id());
    		pstmt.setString(2,Cinfo.Name());
    		pstmt.setDate(3,Cinfo._Date());
    		int i = pstmt.executeUpdate();
    		if(i != -1)
    		{
    			JOptionPane.showMessageDialog(null,"Inserted Succfully");
    		}
    		
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    }
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 958, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setForeground(new Color(123, 104, 238));
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblCategory.setBackground(new Color(211, 211, 211));
		lblCategory.setBounds(373, 29, 250, 46);
		frame.getContentPane().add(lblCategory);
		
		JLabel lblIdCateg = new JLabel("ID Categ");
		lblIdCateg.setForeground(new Color(255, 20, 147));
		lblIdCateg.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIdCateg.setBounds(54, 128, 157, 32);
		frame.getContentPane().add(lblIdCateg);
		
		JLabel lblItemName = new JLabel("Name");
		lblItemName.setForeground(new Color(255, 20, 147));
		lblItemName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblItemName.setBounds(54, 201, 157, 32);
		frame.getContentPane().add(lblItemName);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(255, 20, 147));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDate.setBounds(54, 275, 157, 32);
		frame.getContentPane().add(lblDate);
		
		txtCId = new JTextField();
		txtCId.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtCId.setColumns(10);
		txtCId.setBounds(311, 125, 388, 41);
		frame.getContentPane().add(txtCId);
		
		txtCname = new JTextField();
		txtCname.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtCname.setColumns(10);
		txtCname.setBounds(311, 192, 388, 41);
		frame.getContentPane().add(txtCname);
		
		txtDate = new JTextField();
		txtDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtDate.setColumns(10);
		txtDate.setBounds(311, 266, 388, 41);
		frame.getContentPane().add(txtDate);
		
		JButton btnSave = new JButton("Add");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cate_Item();
			}
		});
		btnSave.setForeground(new Color(128, 0, 0));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnSave.setBackground(new Color(0, 139, 139));
		btnSave.setBounds(152, 370, 212, 68);
		frame.getContentPane().add(btnSave);
		
		JButton btnClear = new JButton("Close");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnClear.setForeground(new Color(128, 0, 0));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnClear.setBackground(new Color(0, 139, 139));
		btnClear.setBounds(451, 370, 212, 68);
		frame.getContentPane().add(btnClear);
	}

}
