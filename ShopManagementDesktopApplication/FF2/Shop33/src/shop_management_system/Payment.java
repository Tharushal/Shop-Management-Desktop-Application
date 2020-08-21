package shop_management_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Payment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
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
	public Payment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1178, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(0, 0, 1160, 83);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Payment");
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("Tahoma", Font.BOLD, 26));
		label.setBackground(new Color(0, 250, 154));
		label.setBounds(125, 34, 159, 36);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Close");
		label_1.setForeground(new Color(0, 0, 128));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		label_1.setBackground(new Color(0, 250, 154));
		label_1.setBounds(924, 34, 159, 36);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Order Id");
		label_2.setForeground(new Color(165, 42, 42));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBackground(new Color(160, 82, 45));
		label_2.setBounds(192, 149, 119, 33);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Date");
		label_3.setForeground(new Color(165, 42, 42));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBackground(new Color(160, 82, 45));
		label_3.setBounds(192, 229, 119, 33);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Total");
		label_4.setForeground(new Color(165, 42, 42));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBackground(new Color(160, 82, 45));
		label_4.setBounds(192, 306, 119, 33);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(413, 149, 341, 34);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(413, 226, 341, 34);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(413, 303, 341, 34);
		contentPane.add(textField_2);
		
		JButton button = new JButton("Payment Via Card");
		button.setForeground(new Color(222, 184, 135));
		button.setFont(new Font("Tahoma", Font.BOLD, 25));
		button.setBackground(new Color(0, 128, 128));
		button.setBounds(167, 368, 365, 51);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Payment Via Cash");
		button_1.setForeground(new Color(222, 184, 135));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		button_1.setBackground(new Color(0, 128, 128));
		button_1.setBounds(599, 368, 365, 51);
		contentPane.add(button_1);
	}

}
