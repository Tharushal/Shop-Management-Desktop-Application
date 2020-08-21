package shop_management_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Cash extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cash frame = new Cash();
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
	public Cash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1141, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 94, 420, 437);
		panel.setBackground(new Color(175, 238, 238));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_7 = new JLabel("Details");
		label_7.setForeground(new Color(75, 0, 130));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_7.setBackground(new Color(255, 20, 147));
		label_7.setBounds(33, 91, 128, 31);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Amount : ");
		label_8.setForeground(new Color(160, 82, 45));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_8.setBounds(33, 161, 170, 31);
		panel.add(label_8);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(124, 203, 284, 36);
		panel.add(textField);
		
		JLabel label_9 = new JLabel("Date : ");
		label_9.setForeground(new Color(160, 82, 45));
		label_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_9.setBounds(33, 282, 170, 31);
		panel.add(label_9);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(124, 320, 284, 36);
		panel.add(textField_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 529, 1123, 107);
		panel_1.setBackground(new Color(250, 240, 230));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_10 = new JLabel("Current Balance : ");
		label_10.setBounds(47, 41, 182, 25);
		label_10.setForeground(new Color(255, 20, 147));
		label_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("67000.00");
		label_11.setBounds(264, 43, 83, 22);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(label_11);
		
		JLabel label = new JLabel("Cach : ");
		label.setBounds(607, 35, 127, 37);
		label.setForeground(new Color(138, 43, 226));
		label.setFont(new Font("Tahoma", Font.BOLD, 35));
		label.setBackground(new Color(139, 0, 139));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("B43223D");
		label_1.setBounds(734, 40, 158, 35);
		label_1.setForeground(new Color(107, 142, 35));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Details");
		label_2.setBounds(569, 169, 128, 31);
		label_2.setForeground(new Color(75, 0, 130));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		label_2.setBackground(new Color(255, 20, 147));
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Name : ");
		label_3.setBounds(602, 230, 170, 31);
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Supplier Name");
		label_4.setBounds(701, 231, 144, 31);
		label_4.setForeground(new Color(128, 0, 0));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Supplier id");
		label_5.setBounds(756, 336, 144, 31);
		label_5.setForeground(new Color(128, 0, 0));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Supplier Id : ");
		label_6.setBounds(602, 336, 170, 31);
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(label_6);
		
		JButton button = new JButton("Clear");
		button.setBounds(493, 438, 229, 60);
		button.setForeground(new Color(139, 0, 139));
		button.setFont(new Font("Tahoma", Font.BOLD, 25));
		button.setBackground(new Color(238, 232, 170));
		contentPane.add(button);
		
		JButton button_1 = new JButton("Save and Close");
		button_1.setBounds(777, 438, 238, 60);
		button_1.setForeground(new Color(139, 0, 139));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_1.setBackground(new Color(238, 232, 170));
		contentPane.add(button_1);
	}

}
