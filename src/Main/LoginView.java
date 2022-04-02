package Main;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConnectSQL.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LoginView extends JFrame {
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setTitle("LoginSystem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 336, 416);
		contentPane.add(panel);
		panel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordField.setBounds(59, 278, 234, 23);
		panel.add(passwordField);
		passwordField.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			
		});
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 16));
		txtUsername.setBounds(59, 237, 234, 23);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = new Connect().getConnection();
				Vector vD = new Vector();
				String sql = "SELECT * FROM account WHERE username = ? AND password = ?";
				PreparedStatement stm;
				try {
					stm = conn.prepareStatement(sql);
					stm.setString(1, txtUsername.getText());
					stm.setString(2, passwordField.getText());
					ResultSet rs = stm.executeQuery();
					if (rs.next()) {
						MainGUI frame = new MainGUI();
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
						frame.setVisible(true);
						frame.timer.start();
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
//						e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng");
				}
				
			}
		});
		btnNewButton.setBounds(59, 334, 234, 35);
		panel.add(btnNewButton);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 17));
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterView();
				dispose();
			}
		});
		btnNewButton_1.setBounds(59, 375, 234, 30);
		panel.add(btnNewButton_1);
		btnNewButton_1.setForeground(Color.ORANGE);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblNewLabel_3 = new JLabel("Soccer Management");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3.setBounds(69, 196, 206, 30);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Hoang Van Nhat\\IdeaProjects\\Downloads\\images.jpg"));
		lblNewLabel_2.setBounds(67, 17, 187, 168);
		panel.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Rememberpassword");
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if ( chckbxNewCheckBox.isSelected()) {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField .setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox.setBounds(69, 304, 150, 23);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hoang Van Nhat\\IdeaProjects\\Downloads\\1x\\outline_lock_black_24dp.png"));
		lblNewLabel.setBounds(20, 273, 28, 28);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Hoang Van Nhat\\IdeaProjects\\Downloads\\1x\\outline_account_circle_black_24dp.png"));
		lblNewLabel_1.setBounds(20, 237, 28, 23);
		panel.add(lblNewLabel_1);
	}
}
