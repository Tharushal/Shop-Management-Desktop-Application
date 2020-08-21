package shop_management_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class Category2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDate;
	private JTextField txtCname;
	private JTextField txtCate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Category2 frame = new Category2();
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
	 private void Cate_Item()
		{
			try {
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			CategoryInfo ci = new CategoryInfo();
			ci.Id(Integer.parseInt(txtCate.getText()));
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
	 * Create the frame.
	 */
	public Category2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(188, 143, 143));
		panel.setBounds(0, 0, 886, 76);
		contentPane.add(panel);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setForeground(new Color(255, 215, 0));
		lblCategory.setFont(new Font("Verdana", Font.BOLD, 30));
		lblCategory.setBounds(356, 13, 153, 38);
		panel.add(lblCategory);
		
		JLabel label_1 = new JLabel("Close");
		label_1.setForeground(new Color(255, 215, 0));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_1.setBackground(new Color(240, 230, 140));
		label_1.setBounds(766, 21, 82, 31);
		panel.add(label_1);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setForeground(new Color(255, 215, 0));
		lblHome.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblHome.setBackground(new Color(240, 230, 140));
		lblHome.setBounds(29, 20, 82, 31);
		panel.add(lblHome);
		
		JLabel lblIdCateg = new JLabel("Id Categ");
		lblIdCateg.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIdCateg.setBounds(46, 118, 167, 29);
		contentPane.add(lblIdCateg);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(46, 208, 167, 29);
		contentPane.add(lblName);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDate.setBounds(46, 306, 167, 29);
		contentPane.add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtDate.setColumns(10);
		txtDate.setBounds(225, 294, 316, 41);
		contentPane.add(txtDate);
		
		txtCname = new JTextField();
		txtCname.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtCname.setColumns(10);
		txtCname.setBounds(225, 196, 316, 41);
		contentPane.add(txtCname);
		
		txtCate = new JTextField();
		txtCate.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtCate.setColumns(10);
		txtCate.setBounds(225, 107, 316, 41);
		contentPane.add(txtCate);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cate_Item();
			}
		});
		btnSave.setForeground(new Color(0, 128, 0));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnSave.setBounds(658, 146, 167, 52);
		contentPane.add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container c = getContentPane();
				Clear(c);
			}
		});
		btnClear.setForeground(new Color(0, 128, 0));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnClear.setBounds(658, 266, 167, 52);
		contentPane.add(btnClear);
	}

}
