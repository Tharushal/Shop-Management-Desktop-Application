package shop_management_system;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.sql.Connection;
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
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.sql.DriverManager;
import java.sql.CallableStatement;

public class UserAcc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUname;
	private JPasswordField txtPawd;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAcc frame = new UserAcc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    public void Input(String type)
    {
    	UserDetail ud = new UserDetail();
    	ud.setUname(txtUname.getText());
    	ud.setPassword(txtPawd.getText());
    	ud.setEmail(txtEmail.getText());
    	ud.setType(type);
    	Insert_Connect(ud);
    	
    	}
    public void Insert_Connect(UserDetail uD)
    {
    	String connection = "jdbc:sqlserver://localhost:1433;databaseName=JavaProject;IntegratedSecurity=true;";
    	Connection con;
    	try {
    		int id =0;
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		con = DriverManager.getConnection(connection);
    		String que = "{call User_Insert(?,?,?,?,?)}";
    		CallableStatement cst = con.prepareCall(que);
    		cst.setInt(1,id);
    		cst.setString(2,uD.getUname());
    		cst.setString(3,uD.getPassword());
    		cst.setString(4,uD.getEmail());
    		cst.setString(5,uD.getType());
    		cst.execute();
    		JOptionPane.showMessageDialog(null,"Inserted Successfully");
    		UserInfo2 uf2 = new UserInfo2();
    		uf2.show(con);
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    }
	/**
	 * Create the frame.
	 */
	public UserAcc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1209, 728);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 232, 170));
		panel.setBounds(0, 0, 436, 681);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Information");
		label.setForeground(new Color(199, 21, 133));
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setBounds(481, 117, 152, 31);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("User_Account");
		label_1.setForeground(new Color(178, 34, 34));
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		label_1.setBounds(679, 13, 287, 89);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("User Name");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(515, 200, 165, 43);
		contentPane.add(label_2);
		
		txtUname = new JTextField();
		txtUname.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtUname.setColumns(10);
		txtUname.setBounds(689, 194, 451, 49);
		contentPane.add(txtUname);
		
		JLabel label_3 = new JLabel("Password");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(515, 310, 165, 43);
		contentPane.add(label_3);
		
		txtPawd = new JPasswordField();
		txtPawd.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtPawd.setBounds(689, 304, 451, 49);
		contentPane.add(txtPawd);
		
		JLabel label_4 = new JLabel("Email");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(515, 423, 165, 43);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("User Type");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_5.setBounds(515, 521, 165, 43);
		contentPane.add(label_5);
		
		JComboBox cmbType = new JComboBox();
		cmbType.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Normal"}));
		cmbType.setToolTipText("");
		cmbType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbType.setBackground(new Color(240, 255, 240));
		cmbType.setBounds(689, 515, 451, 49);
		cmbType.setSelectedItem(null);
		contentPane.add(cmbType);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = (String)cmbType.getSelectedItem();
				Input(type);
			}
		});
		btnSave.setForeground(new Color(139, 0, 0));
		btnSave.setFont(new Font("Sylfaen", Font.BOLD, 30));
		btnSave.setBackground(Color.CYAN);
		btnSave.setBounds(579, 607, 213, 61);
		contentPane.add(btnSave);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtEmail.setColumns(10);
		txtEmail.setBounds(689, 406, 451, 49);
		contentPane.add(txtEmail);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnClose.setBounds(899, 607, 213, 61);
		contentPane.add(btnClose);
		btnClose.setForeground(new Color(139, 0, 0));
		btnClose.setFont(new Font("Sylfaen", Font.BOLD, 30));
		btnClose.setBackground(Color.CYAN);
	}
}
