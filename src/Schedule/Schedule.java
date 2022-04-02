package Schedule;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import ConnectSQL.Connect;
import FootballPlayerManagement.UpdateFootballPlayer;
import FootballTeamManagement.addFootballTeam;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Schedule extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Vector vT, vD;
	private JButton image_bt, image_bt2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Schedule frame = new Schedule();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static Vector getvD() {
		Connection conn = new Connect().getConnection();
		Vector vD = new Vector();
		String sql = "SELECT * FROM schedule";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Vector vtemp = new Vector();
				vtemp.add(rs.getString(1));
				vtemp.add(rs.getDate(2));
				vtemp.add(rs.getString(3));
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
	
	public static int getIM(String ID) {
		Connection conn = new Connect().getConnection();
		Vector vD = new Vector();
		String sql = "SELECT idimage FROM footballteam WHERE ID = ?";
		try {
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, ID);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				return Integer.parseInt(rs.getString(1));
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return 0;
	}

	/**
	 * Create the frame.
	 */
	public Schedule() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(41, 59, 367, 426);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 347, 395);
		panel.add(scrollPane);
		
		vT = new Vector();
		vT.add("ID");
		vT.add("Ngày");
		vT.add("Giờ");
		vT.add("Đội bóng 1");
		vT.add("Đội bóng 2");
		
		vD = getvD();
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				Vector v = (Vector) vD.get(index);
				int Id1 = getIM(v.get(3) + "");
				int Id2 = getIM(v.get(4) + "");
				System.out.println(v.get(3) + " " + v.get(4));
				image_bt.setIcon(new addFootballTeam().getIcon(Id1));
				image_bt2.setIcon(new addFootballTeam().getIcon(Id2));
			}
		});
		table.setModel(new DefaultTableModel(vD, vT));
		scrollPane.setViewportView(table);
		
		image_bt = new JButton("");
		image_bt.setIcon(new addFootballTeam().getIcon(0));
		image_bt.setBounds(451, 57, 152, 193);
		contentPane.add(image_bt);
		
		image_bt2 = new JButton("");
		image_bt2.setIcon(new addFootballTeam().getIcon(0));
		image_bt2.setBounds(451, 292, 152, 193);
		contentPane.add(image_bt2);
		
		JLabel lblLchThiu = new JLabel("Lịch thi đấu");
		lblLchThiu.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblLchThiu.setBounds(276, 23, 95, 23);
		contentPane.add(lblLchThiu);
		
		JButton btn_add = new JButton("Thêm");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSchedule add = new AddSchedule();
				add.setVisible(true);
				add.btn_add.addActionListener(new ActionListener() {
					Connection conn = new Connect().getConnection();
					public void actionPerformed(ActionEvent e) {
						String sql = "INSERT INTO schedule VALUES (?, ?, ?, ?, ?)";
						try {
							PreparedStatement stm = conn.prepareStatement(sql);
							stm.setString(1, add.ID.getText());
							stm.setDate(2, java.sql.Date.valueOf(add.NDR.getText()));
							stm.setString(3, add.GDR.getText());
							stm.setString(4, add.MDB1.getSelectedItem() + "");
							stm.setString(5, add.MDB2.getSelectedItem() + "");
							if (add.MDB1.getSelectedIndex() == add.MDB2.getSelectedIndex()) {
								JOptionPane.showMessageDialog(null, "Hai đội bóng phải khác nhau");
							}
							else {
								stm.execute();
								JOptionPane.showMessageDialog(null, "Thêm lịch thi đấu thành công");
								add.dispose();
							}
								
							
//							sql = "UPDATE footballteam set quantily = (quantily + 1) WHERE ID = ?";
//							stm = conn.prepareStatement(sql);
//							stm.setString(1, add.MDB.getSelectedItem() + "");
//							stm.execute();
							
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Chưa thêm lịch thi đấu");
							e1.printStackTrace();
						}
						vD = getvD();
						table.setModel(new DefaultTableModel(vD, vT));
					}
				});
			}
		});
		btn_add.setBounds(83, 512, 106, 25);
		contentPane.add(btn_add);
		
		JLabel lblVs = new JLabel("VS");
		lblVs.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 14));
		lblVs.setBounds(510, 258, 32, 23);
		contentPane.add(lblVs);
		
		JButton btn_update = new JButton("Sửa");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateSchedule up = new UpdateSchedule();
				up.setVisible(true);
				
				int index = table.getSelectedRow();
				Vector v = (Vector) vD.get(index);
				up.ID.setText(v.get(0) + "");
				up.NDR.setText(v.get(1) + "");
				up.GDR.setText(v.get(2) + "");
				up.MDB1.setSelectedItem(v.get(3) + "");
				up.MDB2.setSelectedItem(v.get(4) + "");
				up.btn_update.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {Connection conn = new Connect().getConnection();
						String sql = "UPDATE schedule SET ID = ?, Date = ?, Time = ?, FootballTeam1 = ?, FootballTeam2 = ? WHERE ID = ?";
						try {
							PreparedStatement stm = conn.prepareStatement(sql);
							stm.setString(1, up.ID.getText());
							stm.setString(2, up.NDR.getText());
							stm.setString(3, up.GDR.getText());
							stm.setString(4, up.MDB1.getSelectedItem() + "");
							stm.setString(5, up.MDB2.getSelectedItem() + "");
							stm.setString(6, up.ID.getText());
							if (up.MDB1.getSelectedIndex() == up.MDB2.getSelectedIndex()) {
								JOptionPane.showMessageDialog(null, "Hai đội bóng phải khác nhau");
							}
							else {
								stm.execute();
								JOptionPane.showMessageDialog(null, "Cập nhật thành công");
								up.dispose();
								vD = getvD();
								table.setModel(new DefaultTableModel(vD, vT));
							}
							
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "ID \u0111\u00E3 t\u1ED3n t\u1EA1i");
							e2.printStackTrace();
						}
					}
				});
			}
		});
		btn_update.setBounds(272, 513, 105, 23);
		contentPane.add(btn_update);
		
		JButton btn_delete = new JButton("Xoá");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = new Connect().getConnection();
				int index_row = table.getSelectedRow();
				String idSchedule = ((Vector) vD.get(index_row)).get(0) + "";
				String sql = "DELETE FROM schedule WHERE ID = ?";
				try {
					PreparedStatement stm = conn.prepareStatement(sql);
					stm.setString(1, idSchedule);
					int k = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa lịch thi đấu này không ?");
					if (k == 0) {
						stm.execute();
						JOptionPane.showMessageDialog(null, "Đã xóa");
						vD = getvD();
						table.setModel(new DefaultTableModel(vD, vT));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Xóa không thành công");
				}
			}
		});
		btn_delete.setBounds(460, 513, 105, 23);
		contentPane.add(btn_delete);
		
		setLocationRelativeTo(null);
	}
}
