package FootballTeamManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import ConnectSQL.Connect;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Color;

public class InfoFootballTeam extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public JLabel date_lb, name_lb_1_1, name_lb, member_Lb;
	public JButton image_bt;
	private Vector vT, vD;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoFootballTeam frame = new InfoFootballTeam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static Vector getvD(String MDB) {
		Connection conn = new Connect().getConnection();
		Vector vD = new Vector();
		String sql = "SELECT * FROM footballplayer WHERE IDFootballTeam = ?";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, MDB);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Vector vtemp = new Vector();
				vtemp.add(rs.getString(1));
				vtemp.add(rs.getString(2));
				vtemp.add(rs.getInt(3));
				vtemp.add(rs.getString(4));
				vtemp.add(rs.getString(5));
				vD.add(vtemp);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return vD;
	}

	/**
	 * Create the frame.
	 */
	public InfoFootballTeam() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 498);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Thông tin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(36, 50, 515, 226);
		contentPane.add(panel);
		panel.setLayout(null);
		
		image_bt = new JButton("");
		image_bt.setBounds(10, 22, 152, 193);
		panel.add(image_bt);
		
		date_lb = new JLabel("Ngày thành lập");
		date_lb.setHorizontalAlignment(SwingConstants.CENTER);
		date_lb.setVerticalAlignment(SwingConstants.CENTER);
		date_lb.setBounds(186, 35, 298, 23);
		panel.add(date_lb);
		date_lb.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		
		member_Lb = new JLabel("Số thành viên");
		member_Lb.setBounds(186, 89, 298, 23);
		member_Lb.setHorizontalAlignment(SwingConstants.CENTER);
		member_Lb.setVerticalAlignment(SwingConstants.CENTER);
		panel.add(member_Lb);
		member_Lb.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		
		name_lb = new JLabel("Name");
		name_lb.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		name_lb.setBounds(50, 11, 479, 23);
		name_lb.setHorizontalAlignment(SwingConstants.CENTER);
		name_lb.setVerticalAlignment(SwingConstants.CENTER);
		contentPane.add(name_lb);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 37, 501, 2);
		contentPane.add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Danh sách cầu thủ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(36, 285, 515, 152);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		vT = new Vector();
		vT.add("Mã cầu thủ");
		vT.add("Tên cầu thủ");
		vT.add("Tuổi");
		vT.add("Chức vụ");
		vT.add("Mã đội bóng");
		
		vD = new Vector();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 16, 501, 130);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(new DefaultTableModel(vD, vT));
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public void setVDTable(String MDB) {
		vD = getvD(MDB);
		table.setModel(new DefaultTableModel(vD, vT));
	}
}
