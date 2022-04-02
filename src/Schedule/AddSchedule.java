package Schedule;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FootballPlayerManagement.FootballPlayerManagement;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddSchedule extends JFrame {

	public JPanel contentPane;
	public JTextField ID;
	public JTextField NDR;
	public JTextField GDR;
	public JButton btn_add;
	public JComboBox MDB1, MDB2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSchedule frame = new AddSchedule();
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
	public AddSchedule() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 357);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(34, 53, 100, 30);
		contentPane.add(lblId);
		
		ID = new JTextField();
		ID.setColumns(10);
		ID.setBounds(144, 57, 259, 25);
		contentPane.add(ID);
		
		JLabel lblNgyDinRa = new JLabel("Ngày diễn ra");
		lblNgyDinRa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgyDinRa.setBounds(34, 94, 100, 30);
		contentPane.add(lblNgyDinRa);
		
		NDR = new JTextField();
		NDR.setColumns(10);
		NDR.setBounds(144, 98, 259, 25);
		contentPane.add(NDR);
		
		JLabel lblGiDinRa = new JLabel("Giờ diễn ra");
		lblGiDinRa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGiDinRa.setBounds(34, 135, 100, 30);
		contentPane.add(lblGiDinRa);
		
		GDR = new JTextField();
		GDR.setColumns(10);
		GDR.setBounds(144, 139, 259, 25);
		contentPane.add(GDR);
		
		JLabel lblMiBng = new JLabel("Mã đội bóng 1");
		lblMiBng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMiBng.setBounds(34, 180, 100, 30);
		contentPane.add(lblMiBng);
		
		JLabel lblMiBng_1 = new JLabel("Mã đội bóng 2");
		lblMiBng_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMiBng_1.setBounds(34, 221, 100, 30);
		contentPane.add(lblMiBng_1);
		
		JLabel lblThmLchThi = new JLabel("Thêm lịch thi đấu");
		lblThmLchThi.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblThmLchThi.setBounds(160, 23, 141, 23);
		contentPane.add(lblThmLchThi);
		
		MDB1 = new JComboBox(FootballPlayerManagement.getMDB());
		MDB1.setBounds(144, 183, 259, 26);
		contentPane.add(MDB1);
		
		MDB2 = new JComboBox(FootballPlayerManagement.getMDB());
		MDB2.setBounds(144, 224, 259, 26);
		contentPane.add(MDB2);
		
		btn_add = new JButton("Thêm");
		btn_add.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_add.setBounds(144, 276, 106, 25);
		contentPane.add(btn_add);
		
		JButton btn_add_1 = new JButton("Thoát");
		btn_add_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_add_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_add_1.setBounds(297, 276, 106, 25);
		contentPane.add(btn_add_1);
		
		setLocationRelativeTo(null);
	}
}
