package shop_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Update extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtMail;
	private JPasswordField txtpawd;
	private JTextField txtutype;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update window = new Update();
					window.frame.setVisible(true);
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
	/**
	 * Create the application.
	 */
	public Update() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 250, 210));
		frame.setBounds(100, 100, 811, 748);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update User Information");
		lblNewLabel.setForeground(new Color(148, 0, 211));
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 30));
		lblNewLabel.setBounds(206, 27, 401, 91);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("User Name");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(70, 238, 165, 43);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(70, 342, 165, 43);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Email");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(70, 430, 165, 43);
		frame.getContentPane().add(label_2);
		
		JLabel lblUserId = new JLabel("User Id");
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUserId.setBounds(70, 143, 165, 43);
		frame.getContentPane().add(lblUserId);
		
		JLabel label_4 = new JLabel("User Type");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(70, 520, 165, 43);
		frame.getContentPane().add(label_4);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtId.setColumns(10);
		txtId.setBounds(247, 141, 431, 49);
		frame.getContentPane().add(txtId);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtName.setColumns(10);
		txtName.setBounds(247, 236, 431, 49);
		frame.getContentPane().add(txtName);
		
		txtMail = new JTextField();
		txtMail.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtMail.setColumns(10);
		txtMail.setBounds(247, 428, 431, 49);
		frame.getContentPane().add(txtMail);
		
		txtpawd = new JPasswordField();
		txtpawd.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpawd.setBounds(247, 341, 431, 49);
		frame.getContentPane().add(txtpawd);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setForeground(new Color(46, 139, 87));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(309, 600, 177, 63);
		frame.getContentPane().add(btnNewButton);
		
		txtutype = new JTextField();
		txtutype.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtutype.setColumns(10);
		txtutype.setBounds(247, 514, 431, 49);
		frame.getContentPane().add(txtutype);
	}
}
