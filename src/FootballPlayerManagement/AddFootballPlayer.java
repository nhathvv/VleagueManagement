package FootballPlayerManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class AddFootballPlayer extends JFrame {

	private JPanel contentPane;
	public JTextField Name;
	public JTextField TCT;
	public JTextField T;
	public JButton btn_add;
	public JComboBox CV, MDB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFootballPlayer frame = new AddFootballPlayer();
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
	public AddFootballPlayer() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 376);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(131, 62, 259, 25);
		contentPane.add(Name);
		
		JLabel lblMCuTh = new JLabel("Mã cầu thủ");
		lblMCuTh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMCuTh.setBounds(32, 59, 100, 30);
		contentPane.add(lblMCuTh);
		
		JLabel lblThmCuTh = new JLabel("Thêm cầu thủ");
		lblThmCuTh.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblThmCuTh.setBounds(171, 28, 119, 23);
		contentPane.add(lblThmCuTh);
		
		JLabel lblTnCuTh = new JLabel("Tên cầu thủ");
		lblTnCuTh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnCuTh.setBounds(32, 102, 100, 30);
		contentPane.add(lblTnCuTh);
		
		TCT = new JTextField();
		TCT.setColumns(10);
		TCT.setBounds(131, 105, 259, 25);
		contentPane.add(TCT);
		
		JLabel lblT = new JLabel("Tuổi");
		lblT.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblT.setBounds(32, 145, 100, 30);
		contentPane.add(lblT);
		
		T = new JTextField();
		T.setColumns(10);
		T.setBounds(131, 148, 259, 25);
		contentPane.add(T);
		
		JLabel lblChcV = new JLabel("Chức vụ");
		lblChcV.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChcV.setBounds(32, 192, 100, 30);
		contentPane.add(lblChcV);
		
		JLabel lblNewLabel_4 = new JLabel("Mã đội bóng");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(32, 237, 100, 30);
		contentPane.add(lblNewLabel_4);
		
		btn_add = new JButton("Thêm");
		btn_add.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btn_add.setBounds(129, 294, 106, 25);
		contentPane.add(btn_add);
		
		JButton btn_add_1 = new JButton("Thoát");
		btn_add_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_add_1.setBounds(284, 294, 106, 25);
		contentPane.add(btn_add_1);
		
		CV = new JComboBox();
		CV.setModel(new DefaultComboBoxModel(new String[] {"Huấn luyện viên", "Tiền đạo", "Hậu vệ", "Thủ môn"}));
		CV.setBounds(131, 196, 259, 26);
		contentPane.add(CV);
		
		MDB = new JComboBox(FootballPlayerManagement.getMDB());
		MDB.setBounds(131, 241, 259, 26);
		contentPane.add(MDB);
		
		setLocationRelativeTo(null);
	}
}
