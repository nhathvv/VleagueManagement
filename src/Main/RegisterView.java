package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import ConnectSQL.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Color;

public class RegisterView extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField jPasswordField;
	private JPasswordField jPasswordField1;
	private JPanel panel;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView frame = new RegisterView();
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
	public RegisterView() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 369, 435);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		textField.setBounds(134, 237, 212, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		jPasswordField = new JPasswordField();
		jPasswordField.setFont(new Font("Arial", Font.PLAIN, 16));
		jPasswordField.setBounds(134, 278, 212, 23);
		panel.add(jPasswordField);
		jPasswordField.setColumns(10);
		
		jPasswordField1 = new JPasswordField();
		jPasswordField1.setFont(new Font("Arial", Font.PLAIN, 16));
		jPasswordField1.setBounds(134, 319, 212, 23);
		panel.add(jPasswordField1);
		jPasswordField1.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 17));
		btnNewButton.setBounds(134, 364, 212, 30);
		panel.add(btnNewButton);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Hoang Van Nhat\\IdeaProjects\\Downloads\\images.jpg"));
		lblNewLabel_3.setBounds(92, 11, 189, 168);
		panel.add(lblNewLabel_3);
		
		lblNewLabel = new JLabel("Soccer Management");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel.setBounds(73, 190, 261, 30);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginView();
				dispose();
			}
		});
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Hoang Van Nhat\\IdeaProjects\\Downloads\\1x\\outline_logout_black_24dp.png"));
		btnNewButton_1.setBounds(10, 11, 42, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Username ");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 234, 96, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Passwords ");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 279, 100, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password ");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 321, 127, 14);
		panel.add(lblNewLabel_4);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jPasswordField.getText().equals(jPasswordField1.getText())) {
					String sql = "INSERT INTO account VALUES (?, ?)";
					try {
						Connection conn = new Connect().getConnection();
						PreparedStatement stm = conn.prepareStatement(sql);
						stm.setString(1, textField .getText());
						stm.setString(2, jPasswordField.getText());
						stm.execute();
						JOptionPane.showMessageDialog(null, "Đăng ký thành công");
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu chưa nhập");
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Hai mật khẩu không giống nhau");
				}
			}
		});
	}
}
