package shop_management_system;

import java.awt.BorderLayout;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Order extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCategory;
	private JTextField txtItem;
	private JTextField txtUprice;
	private JTextField txtQuan;
	private JTextField txtAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order frame = new Order();
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
	 private void TType(JComboBox cT)
	 {
		 String connection = "jdbc:sqlserver://localhost:1433;databaseName=JavaProject;IntegratedSecurity=true;";
	    	Connection con=null;
	    	Statement stmt = null;
	    	ResultSet set=null;
	    	try {
	    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    		con = DriverManager.getConnection(connection);
	    		stmt = con.createStatement();
	    		String que = "Select C_Name from Category";
	    		  set=stmt.executeQuery(que);
	    		  while(set.next())
	    		  {
	    			  //cT.addItem();
	    		  }
	    		
	    		
	    	}catch(Exception ex)
	    	{
	    		ex.printStackTrace();
	    	}
	 }
	 private void Data_Insert()
	 {
		 try {
		 OrderInfo Oi = new OrderInfo();
		 Oi.Cate(txtCategory.getText());
		 Oi.Item(txtItem.getText());
		 BigDecimal uprice = new BigDecimal(txtUprice.getText());
		 Oi.Uprice(uprice);
		 int quan=Integer.parseInt(txtQuan.getText());
		 Oi.Quan(quan);
		 BigDecimal am = new BigDecimal(Oi.Quan());
		 BigDecimal amount = am.multiply(Oi.Uprice());
		 Aadd(amount);
		 //BigDecimal amount = new BigDecimal(amo);
		 
		 Oi.Amount(amount);
		 Connect(Oi);
		 }catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
	 }
	 private void Aadd(BigDecimal amo)
	 {
		 String am = amo.toString();
		 txtAmount.setText(am);
	 }
	 private void Connect(OrderInfo oI)
	 {

		 String connection = "jdbc:sqlserver://localhost:1433;databaseName=JavaProject;IntegratedSecurity=true;";
	    	Connection con=null;
	    	
	    	try {
	    		int id=0;
	    		int sId=100;
	    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    		con = DriverManager.getConnection(connection);
	    		String Q_que ="{call OInfo(?,?,?,?,?,?,?)}";
	    		PreparedStatement  st = con.prepareStatement(Q_que);
	    		st.setInt(1, id);
	    		st.setString(2, oI.Cate());
	    		st.setString(3, oI.Item());
	    		st.setBigDecimal(4, oI.Uprice());
	    		st.setInt(5,oI.Quan());
	    		st.setBigDecimal(6, oI.Amount());
	    		st.setInt(7, sId);
	    		 st.execute();
	    			JOptionPane.showMessageDialog(null,"Inserted Successfully");
	    	}
	    		catch(SQLServerException sx)
	    		{
	    			JOptionPane.showMessageDialog(null,sx.getMessage());
	    		}
	    	catch(Exception ex)
	    	{
	    		ex.printStackTrace();
	    	}
	 }
	/**
	 * Create the frame.
	 */
	public Order() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1202, 738);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(0, 0, 453, 580);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Purchase -");
		label.setForeground(new Color(221, 160, 221));
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setBounds(70, 44, 187, 37);
		panel.add(label);
		
		JLabel lblPId = new JLabel("C8-98673");
		lblPId.setBackground(new Color(205, 133, 63));
		lblPId.setForeground(new Color(25, 25, 112));
		lblPId.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPId.setBounds(251, 46, 140, 37);
		panel.add(lblPId);
		
		JLabel label_2 = new JLabel("Supplier Id :");
		label_2.setForeground(new Color(238, 232, 170));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_2.setBounds(55, 144, 179, 27);
		panel.add(label_2);
		
		JLabel lblSId = new JLabel("B54343C");
		lblSId.setForeground(new Color(253, 245, 230));
		lblSId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSId.setBounds(212, 184, 140, 27);
		panel.add(lblSId);
		
		JLabel label_4 = new JLabel("Supplier Name :");
		label_4.setForeground(new Color(238, 232, 170));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_4.setBounds(55, 283, 179, 27);
		panel.add(label_4);
		
		JLabel lblSname = new JLabel("Balloon");
		lblSname.setForeground(new Color(253, 245, 230));
		lblSname.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSname.setBounds(212, 336, 140, 27);
		panel.add(lblSname);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(152, 251, 152));
		panel_1.setBounds(0, 578, 1184, 113);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_6 = new JLabel("Total Amount :");
		label_6.setForeground(new Color(47, 79, 79));
		label_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_6.setBounds(83, 42, 182, 34);
		panel_1.add(label_6);
		
		JLabel lblTamount = new JLabel("3000.00");
		lblTamount.setForeground(new Color(210, 105, 30));
		lblTamount.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTamount.setBounds(258, 46, 134, 28);
		panel_1.add(lblTamount);
		
		JButton btnPay = new JButton("Payment");
		btnPay.setForeground(new Color(148, 0, 211));
		btnPay.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPay.setBackground(new Color(238, 130, 238));
		btnPay.setBounds(407, 38, 134, 49);
		panel_1.add(btnPay);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container c = getContentPane();
				Clear(c);
			}
		});
		btnClear.setForeground(new Color(160, 82, 45));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBackground(new Color(224, 255, 255));
		btnClear.setBounds(584, 38, 134, 49);
		panel_1.add(btnClear);
		
		JButton btnClose = new JButton("Close");
		btnClose.setForeground(new Color(160, 82, 45));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClose.setBackground(new Color(224, 255, 255));
		btnClose.setBounds(754, 38, 134, 49);
		panel_1.add(btnClose);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Data_Insert();
			}
		});
		btnAdd.setForeground(new Color(160, 82, 45));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdd.setBackground(new Color(224, 255, 255));
		btnAdd.setBounds(924, 35, 134, 49);
		panel_1.add(btnAdd);
		
		JLabel label_8 = new JLabel("Order Info");
		label_8.setForeground(new Color(106, 90, 205));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_8.setBounds(524, 56, 187, 37);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Category");
		label_9.setForeground(new Color(128, 128, 0));
		label_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_9.setBounds(536, 128, 129, 25);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("Item");
		label_10.setForeground(new Color(128, 128, 0));
		label_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_10.setBounds(536, 213, 129, 25);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("Unit Price");
		label_11.setForeground(new Color(128, 128, 0));
		label_11.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_11.setBounds(536, 299, 129, 25);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("Quantity");
		label_12.setForeground(new Color(128, 128, 0));
		label_12.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_12.setBounds(536, 378, 129, 25);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("Amount");
		label_13.setForeground(new Color(128, 128, 0));
		label_13.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_13.setBounds(536, 456, 129, 25);
		contentPane.add(label_13);
		
		txtCategory = new JTextField();
		txtCategory.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtCategory.setColumns(10);
		txtCategory.setBounds(747, 116, 317, 37);
		contentPane.add(txtCategory);
		
		txtItem = new JTextField();
		txtItem.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtItem.setColumns(10);
		txtItem.setBounds(747, 201, 317, 37);
		contentPane.add(txtItem);
		
		txtUprice = new JTextField();
		txtUprice.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtUprice.setColumns(10);
		txtUprice.setBounds(747, 287, 317, 37);
		contentPane.add(txtUprice);
		
		txtQuan = new JTextField();
		txtQuan.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtQuan.setColumns(10);
		txtQuan.setBounds(747, 366, 317, 37);
		contentPane.add(txtQuan);
		
		txtAmount = new JTextField();
		txtAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtAmount.setColumns(10);
		txtAmount.setBounds(747, 444, 317, 37);
		contentPane.add(txtAmount);
		
		JComboBox cmbT = new JComboBox();
		cmbT.setBounds(834, 42, 270, 51);
		contentPane.add(cmbT);
		TType(cmbT);
	}
}
