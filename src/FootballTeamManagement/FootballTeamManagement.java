package FootballTeamManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import ConnectSQL.Connect;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;
import java.awt.Color;

public class FootballTeamManagement extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Vector vT, vD;
	private Connection conn = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FootballTeamManagement frame = new FootballTeamManagement();
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
		String sql = "SELECT * FROM footballteam";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Vector vtemp = new Vector();
				vtemp.add(rs.getString(1));
				vtemp.add(rs.getString(2));
				vtemp.add(rs.getInt(3));
				vtemp.add(rs.getDate(4));
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
	public FootballTeamManagement() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 497);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh sách đội bóng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(33, 38, 642, 352);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 16, 622, 325);
		panel.add(scrollPane);
		
		
		vT = new Vector();
		vT.add("Mã đội bóng");
		vT.add("Tên đội bóng");
		vT.add("Số thành viên");
		vT.add("Ngày thành lập");
		
		vD = getvD();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(vD, vT));
		scrollPane.setViewportView(table);
		
		JButton btn_add = new JButton("Thêm");
		btn_add.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_add.setBackground(Color.WHITE);
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFootballTeam add = new addFootballTeam();
				add.setVisible(true);
				add.btn_add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Connection conn = new Connect().getConnection();
						String sql = "INSERT INTO footballteam VALUES (?, ?, ?, ?, ?)";
						try {
							PreparedStatement stm = conn.prepareStatement(sql);
							stm.setString(1, add.MDB.getText());
							stm.setString(2, add.TDB.getText());
							stm.setInt(3, 0);
							stm.setDate(4, java.sql.Date.valueOf(add.NTL.getText()));
							stm.setInt(5, Integer.parseInt(add.MI.getText()));
							stm.execute();
							JOptionPane.showMessageDialog(null, "Thêm đội bóng thành công");
							add.dispose();
							
						} catch (SQLException e1) {					
							JOptionPane.showMessageDialog(null, "Chưa thêm đội bóng");
						}
						vD = getvD();
						table.setModel(new DefaultTableModel(vD, vT));
					}
				});
			}
		});
		btn_add.setBounds(64, 412, 112, 23);
		contentPane.add(btn_add);
		
		JLabel lblNewLabel = new JLabel("Football Management");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(269, 11, 243, 23);
		contentPane.add(lblNewLabel);
		
		JButton btn_update = new JButton("Sửa");
		btn_update.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_update.setBackground(Color.WHITE);
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn = new Connect().getConnection();
				UpdateFootballTeam up = new UpdateFootballTeam();
				int index = table.getSelectedRow();
				Vector v = (Vector) vD.get(index);
				String sql = "SELECT * FROM footballteam WHERE ID = '" + v.get(0) + "'";
				PreparedStatement stm;
				try {
					stm = conn.prepareStatement(sql);
					ResultSet rs = stm.executeQuery();
					if(rs.next()) {
						up.MDB.setText(rs.getString(1) + "");
						up.TDB.setText(rs.getString(2) + "");
						up.NTL.setText(rs.getDate(4) + "");
						up.MI.setText(rs.getString(5)+ "");
						up.image_bt.setIcon(up.getIcon(Integer.parseInt(rs.getString(5))));
					}
				} catch (Exception e2) {
					up.image_bt.setIcon(up.getIcon(0));
				}
				
				
				up.btn_update.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						conn = new Connect().getConnection();
						String sql = "UPDATE footballteam SET ID = ?, footballname = ?, quantily = ?, founding = ?, idimage = ? WHERE ID = ?";
						try {
							PreparedStatement stm = conn.prepareStatement(sql);
							stm.setString(1, up.MDB.getText());
							stm.setString(2, up.TDB.getText());
							stm.setInt(3, Integer.parseInt(v.get(2) + ""));
							stm.setDate(4, java.sql.Date.valueOf(up.NTL.getText()));
							stm.setInt(5, Integer.parseInt(up.MI.getText()));
							stm.setString(6, v.get(0) + "");
							stm.execute();
							JOptionPane.showMessageDialog(null, "Cập nhật thành công");
							up.dispose();
							vD = getvD();
							table.setModel(new DefaultTableModel(vD, vT));
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "ID \u0111\u00E3 t\u1ED3n t\u1EA1i");
						}
					}
				});
			}
		});
		btn_update.setBounds(220, 412, 112, 23);
		contentPane.add(btn_update);
		
		JButton btn_delete = new JButton("Xoá");
		btn_delete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_delete.setBackground(Color.WHITE);
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn = new Connect().getConnection();
				int index_row = table.getSelectedRow();
				String idFootballTeam = ((Vector) vD.get(index_row)).get(0) + "";
				String sql = "DELETE FROM footballteam WHERE ID = ?";
				try {
					PreparedStatement stm = conn.prepareStatement(sql);
					stm.setString(1, idFootballTeam);
					int k = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa đội bóng "+ ((Vector) vD.get(index_row)).get(1) + "?");
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
		btn_delete.setBounds(378, 412, 112, 23);
		contentPane.add(btn_delete);
		
		JButton btn_view = new JButton("Xem thông tin");
		btn_view.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_view.setBackground(Color.WHITE);
		btn_view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn = new Connect().getConnection();
				InfoFootballTeam inf = new InfoFootballTeam();
				
				int index = table.getSelectedRow();
				Vector v = (Vector) vD.get(index);
				String sql = "SELECT * FROM footballteam WHERE ID = '" + v.get(0) + "'";
				System.out.println(sql);
				PreparedStatement stm;
				try {
					stm = conn.prepareStatement(sql);
					ResultSet rs = stm.executeQuery();
					if(rs.next()) {
						System.out.print("Ok");
						inf.name_lb.setText("Đội bóng " + rs.getString(2));
						addFootballTeam add = new addFootballTeam();
						add.setVisible(false);
						inf.image_bt.setIcon(add.getIcon(rs.getInt(5)));
						inf.date_lb.setText(inf.date_lb.getText() + ": " + rs.getDate(4));
						inf.member_Lb.setText(inf.member_Lb.getText() + ": " + rs.getInt(3));
						inf.setVDTable(rs.getString(1));
					}
				} catch (SQLException e2) {
				}
				
			}
		});
		btn_view.setBounds(527, 412, 117, 23);
		contentPane.add(btn_view);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 38, 642, 2);
		contentPane.add(separator);
		
		setLocationRelativeTo(null);
	}
}
