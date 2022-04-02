package FootballTeamManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConnectSQL.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class addFootballTeam extends JFrame {

	public JPanel contentPane;
	public JTextField MDB;
	public JTextField TDB;
	public JTextField NTL;
	public JTextField MI;
	public JButton btn_add;
	public JButton image_bt;
	private JLabel lblThmiBng;
	private JButton clear_Im;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addFootballTeam frame = new addFootballTeam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Icon getIcon(int d) {
//		System.out.println(f + " " + d);
		int width = 152, height = 193;
		Image image = new ImageIcon(getClass().getResource("/icon/footballteam/" + d + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
	}

	/**
	 * Create the frame.
	 */
	public addFootballTeam() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 361);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã đội bóng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(28, 54, 100, 30);
		contentPane.add(lblNewLabel);
		
		MDB = new JTextField();
		MDB.setBounds(143, 59, 259, 25);
		contentPane.add(MDB);
		MDB.setColumns(10);
		
		JLabel lblTniBng = new JLabel("Tên đội bóng");
		lblTniBng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTniBng.setBounds(28, 107, 100, 30);
		contentPane.add(lblTniBng);
		
		TDB = new JTextField();
		TDB.setColumns(10);
		TDB.setBounds(143, 112, 259, 25);
		contentPane.add(TDB);
		
		JLabel lblNgyThnhLp = new JLabel("Ngày thành lập");
		lblNgyThnhLp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgyThnhLp.setBounds(28, 162, 116, 30);
		contentPane.add(lblNgyThnhLp);
		
		NTL = new JTextField();
		NTL.setColumns(10);
		NTL.setBounds(143, 167, 259, 25);
		contentPane.add(NTL);
		
		JLabel lblMImage = new JLabel("Mã Image");
		lblMImage.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMImage.setBounds(28, 218, 100, 30);
		contentPane.add(lblMImage);
		
		MI = new JTextField();
		MI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					int idIM = Integer.parseInt(MI.getText());
					image_bt.setIcon(getIcon(idIM));
				} catch (Exception e2) {
					// TODO: handle exception
					image_bt.setIcon(getIcon(0));
				}
			}
		});
		MI.setColumns(10);
		MI.setBounds(143, 223, 259, 25);
		contentPane.add(MI);
		
		btn_add = new JButton("Thêm");
		btn_add.setBackground(Color.WHITE);
		btn_add.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_add.setBounds(153, 279, 100, 25);
		contentPane.add(btn_add);
		
		lblThmiBng = new JLabel("Thêm đội bóng");
		lblThmiBng.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 16));
		lblThmiBng.setBounds(244, 11, 144, 23);
		contentPane.add(lblThmiBng);
		
		image_bt = new JButton("");
		image_bt.setBounds(430, 57, 152, 193);
		image_bt.setIcon(getIcon(0));
		contentPane.add(image_bt);
		
		clear_Im = new JButton("Thoát");
		clear_Im.setBackground(Color.WHITE);
		clear_Im.setFont(new Font("Tahoma", Font.BOLD, 13));
		clear_Im.setBounds(296, 279, 92, 25);
		contentPane.add(clear_Im);
		
		setLocationRelativeTo(null);
	}
}
