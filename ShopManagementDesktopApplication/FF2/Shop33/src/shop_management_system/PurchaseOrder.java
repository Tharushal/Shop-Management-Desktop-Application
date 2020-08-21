package shop_management_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PurchaseOrder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseOrder frame = new PurchaseOrder();
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
	public PurchaseOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1175, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Goods Purchase");
		label.setForeground(new Color(250, 128, 114));
		label.setFont(new Font("Nirmala UI", Font.BOLD, 32));
		label.setBounds(106, 36, 283, 36);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Date");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(123, 142, 91, 25);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Supplier Id");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(517, 142, 174, 25);
		contentPane.add(label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox.setBounds(674, 133, 316, 36);
		contentPane.add(comboBox);
		
		JButton btnAdd = new JButton("Add Purchase");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order o = new Order();
				o.setVisible(true);
			}
		});
		btnAdd.setForeground(new Color(25, 25, 112));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnAdd.setBackground(new Color(135, 206, 250));
		btnAdd.setBounds(856, 260, 224, 50);
		contentPane.add(btnAdd);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField.setBounds(190, 133, 283, 35);
		contentPane.add(textField);
		textField.setColumns(10);
	}

}
