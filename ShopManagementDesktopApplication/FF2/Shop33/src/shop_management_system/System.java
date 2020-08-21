package shop_management_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class System extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System frame = new System();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public System() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1162, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(169, 169, 169));
		panel.setBounds(370, 0, 774, 670);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnUaccount = new JButton("User Account");
		btnUaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInfo2 u2 = new UserInfo2();
				u2.Insert_Connect();
				u2.setVisible(true);
			}
		});
		btnUaccount.setForeground(new Color(75, 0, 130));
		btnUaccount.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnUaccount.setBackground(new Color(218, 112, 214));
		btnUaccount.setBounds(18, 152, 207, 54);
		panel.add(btnUaccount);
		
		JButton btnSupplier = new JButton("Supplier");
		btnSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Supplier sup = new Supplier();
				sup.setVisible(true);
			}
		});
		btnSupplier.setForeground(new Color(75, 0, 130));
		btnSupplier.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnSupplier.setBackground(new Color(218, 112, 214));
		btnSupplier.setBounds(283, 152, 207, 54);
		panel.add(btnSupplier);
		
		JLabel label = new JLabel("Shop Management System");
		label.setForeground(new Color(139, 0, 0));
		label.setFont(new Font("Tahoma", Font.PLAIN, 48));
		label.setBounds(111, 42, 587, 59);
		panel.add(label);
		
		JButton btnCategory = new JButton("Category");
		btnCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Category2 ca = new Category2();
				ca.setVisible(true);
			}
		});
		btnCategory.setForeground(new Color(75, 0, 130));
		btnCategory.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnCategory.setBackground(new Color(218, 112, 214));
		btnCategory.setBounds(555, 152, 207, 54);
		panel.add(btnCategory);
		
		JButton button_3 = new JButton("Report");
		button_3.setForeground(new Color(75, 0, 130));
		button_3.setFont(new Font("Tahoma", Font.BOLD, 24));
		button_3.setBackground(new Color(218, 112, 214));
		button_3.setBounds(181, 353, 427, 54);
		panel.add(button_3);
		
		JButton btnItem = new JButton("Item");
		btnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Items it = new Items();
				it.setVisible(true);
			}
		});
		btnItem.setForeground(new Color(75, 0, 130));
		btnItem.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnItem.setBackground(new Color(218, 112, 214));
		btnItem.setBounds(18, 561, 207, 54);
		panel.add(btnItem);
		
		JButton btnCategory_1 = new JButton("Purchase");
		btnCategory_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseOrder po = new PurchaseOrder();
				po.setVisible(true);
			}
		});
		btnCategory_1.setForeground(new Color(75, 0, 130));
		btnCategory_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnCategory_1.setBackground(new Color(218, 112, 214));
		btnCategory_1.setBounds(283, 561, 207, 54);
		panel.add(btnCategory_1);
		
		JButton button_6 = new JButton("Invoice");
		button_6.setForeground(new Color(75, 0, 130));
		button_6.setFont(new Font("Tahoma", Font.BOLD, 24));
		button_6.setBackground(new Color(218, 112, 214));
		button_6.setBounds(555, 561, 207, 54);
		panel.add(button_6);
	}

}
