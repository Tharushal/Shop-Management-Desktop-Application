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

public class Items extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIname;
	private JTextField txtCate;
	private JTextField txtDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Items frame = new Items();
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
	 private void Data_Insert()
	 {
		 String cate;
		 String name;
		 Date date;
		 try {
		 cate = txtCate.getText();
		 name= txtIname.getText();
		 SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		 java.util.Date ddate = format.parse(txtDate.getText());
		 date = new Date(ddate.getTime());
		 ItemInfo in = new ItemInfo(cate,name,date);
		 Connect(in);
		 }catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
	 }
	 private void Connect(ItemInfo I)
	 {
		 String connection = "jdbc:sqlserver://localhost:1433;databaseName=JavaProject;IntegratedSecurity=true;";
	    	Connection con=null;
	    	try {
	    		
	    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    		con = DriverManager.getConnection(connection);
	    		String in_I = "Insert Into Item(Category,I_name,I_Date) Values (?,?,?)";
	    		PreparedStatement  pstmt = con.prepareStatement(in_I);
	    		pstmt.setString(1,I.Cate());
	    		pstmt.setString(2,I.Name());
	    		pstmt.setDate(3,I._Date());
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
	public Items() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 410);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(210, 105, 30));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 886, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblItem = new JLabel("Item");
		lblItem.setBounds(394, 13, 153, 38);
		lblItem.setForeground(new Color(135, 206, 235));
		lblItem.setFont(new Font("Verdana", Font.BOLD, 30));
		panel.add(lblItem);
		
		JLabel lblClose = new JLabel("Close");
		lblClose.setBackground(new Color(240, 230, 140));
		lblClose.setBounds(766, 21, 82, 31);
		panel.add(lblClose);
		lblClose.setForeground(new Color(255, 215, 0));
		lblClose.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JLabel lblItemId = new JLabel("Category");
		lblItemId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblItemId.setBounds(51, 108, 167, 29);
		contentPane.add(lblItemId);
		
		JLabel lblItemName = new JLabel("Name Of Item");
		lblItemName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblItemName.setBounds(51, 198, 167, 29);
		contentPane.add(lblItemName);
		
		txtIname = new JTextField();
		txtIname.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtIname.setColumns(10);
		txtIname.setBounds(230, 186, 316, 41);
		contentPane.add(txtIname);
		
		txtCate = new JTextField();
		txtCate.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtCate.setColumns(10);
		txtCate.setBounds(230, 97, 316, 41);
		contentPane.add(txtCate);
		
		JLabel lblDateOfItem = new JLabel("Date Of Item");
		lblDateOfItem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDateOfItem.setBounds(51, 296, 167, 29);
		contentPane.add(lblDateOfItem);
		
		txtDate = new JTextField();
		txtDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtDate.setColumns(10);
		txtDate.setBounds(230, 284, 316, 41);
		contentPane.add(txtDate);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Data_Insert();
			}
		});
		btnSave.setForeground(new Color(0, 128, 0));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnSave.setBounds(639, 128, 167, 52);
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
		btnClear.setBounds(639, 248, 167, 52);
		contentPane.add(btnClear);
	}
}
