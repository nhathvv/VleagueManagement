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

public class UpdateSchedule extends JFrame {

	public JPanel contentPane;
	public JTextField ID;
	public JTextField NDR;
	public JTextField GDR;
	public JButton btn_update;
	public JComboBox MDB1, MDB2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateSchedule frame = new UpdateSchedule();
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
	public UpdateSchedule() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 357);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(39, 53, 100, 30);
		contentPane.add(lblId);
		
		ID = new JTextField();
		ID.setColumns(10);
		ID.setBounds(149, 57, 259, 25);
		contentPane.add(ID);
		
		JLabel lblNgyDinRa = new JLabel("Ngày diễn ra");
		lblNgyDinRa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgyDinRa.setBounds(39, 94, 100, 30);
		contentPane.add(lblNgyDinRa);
		
		NDR = new JTextField();
		NDR.setColumns(10);
		NDR.setBounds(149, 98, 259, 25);
		contentPane.add(NDR);
		
		JLabel lblGiDinRa = new JLabel("Giờ diễn ra");
		lblGiDinRa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGiDinRa.setBounds(39, 135, 100, 30);
		contentPane.add(lblGiDinRa);
		
		GDR = new JTextField();
		GDR.setColumns(10);
		GDR.setBounds(149, 139, 259, 25);
		contentPane.add(GDR);
		
		JLabel lblMiBng = new JLabel("Mã đội bóng 1");
		lblMiBng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMiBng.setBounds(39, 179, 100, 30);
		contentPane.add(lblMiBng);
		
		JLabel lblMiBng_1 = new JLabel("Mã đội bóng 2");
		lblMiBng_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMiBng_1.setBounds(39, 221, 100, 30);
		contentPane.add(lblMiBng_1);
		
		JLabel lblThmLchThi = new JLabel("Sửa lịch thi đấu");
		lblThmLchThi.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblThmLchThi.setBounds(195, 23, 127, 23);
		contentPane.add(lblThmLchThi);
		
		MDB1 = new JComboBox(FootballPlayerManagement.getMDB());
		MDB1.setBounds(149, 182, 259, 26);
		contentPane.add(MDB1);
		
		MDB2 = new JComboBox(FootballPlayerManagement.getMDB());
		MDB2.setBounds(149, 224, 259, 26);
		contentPane.add(MDB2);
		
		btn_update = new JButton("S\u1EEDa");
		btn_update.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_update.setBounds(149, 276, 106, 25);
		contentPane.add(btn_update);
		
		JButton btn_add_1 = new JButton("Thoát");
		btn_add_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_add_1.setBounds(304, 276, 106, 25);
		contentPane.add(btn_add_1);
		
		setLocationRelativeTo(null);
	}
}
