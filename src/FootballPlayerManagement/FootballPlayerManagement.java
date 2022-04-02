package FootballPlayerManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import ConnectSQL.Connect;
import FootballTeamManagement.UpdateFootballTeam;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FootballPlayerManagement extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Vector vT, vD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FootballPlayerManagement frame = new FootballPlayerManagement();
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
		String sql = "SELECT * FROM footballplayer";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
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
	
	public static Vector getMDB() {
		Vector v = new Vector();
		
		Connection conn = new Connect().getConnection();
		Vector vD = new Vector();
		String sql = "SELECT * FROM footballteam";
		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				v.add(rs.getString(1));
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return v;
	}

	/**
	 * Create the frame.
	 */
	public FootballPlayerManagement() {
		System.out.println(getMDB());
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 393);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQunLCu = new JLabel("Player Management");
		lblQunLCu.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 16));
		lblQunLCu.setBounds(228, 11, 196, 23);
		contentPane.add(lblQunLCu);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh sách cầu thủ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(34, 36, 573, 273);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 554, 241);
		panel.add(scrollPane);
		
		vT = new Vector();
		vT.add("Mã cầu thủ");
		vT.add("Tên cầu thủ");
		vT.add("Tuổi");
		vT.add("Chức vụ");
		vT.add("Mã đội bóng");
		
		vD = getvD();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(vD, vT));
		scrollPane.setViewportView(table);
		
		JButton btn_add = new JButton("Thêm");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFootballPlayer add = new AddFootballPlayer();
				add.setVisible(true);
				Connection conn = new Connect().getConnection();
				add.btn_add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String sql = "INSERT INTO footballplayer VALUES (?, ?, ?, ?, ?)";
						try {
							PreparedStatement stm = conn.prepareStatement(sql);
							stm.setString(1, add.Name.getText());
							stm.setString(2, add.TCT.getText());
							stm.setInt(3, Integer.parseInt(add.T.getText()));
							stm.setString(4, add.CV.getSelectedItem() + "");
							stm.setString(5, add.MDB.getSelectedItem() + "");
							stm.execute();
							JOptionPane.showMessageDialog(null, "Thêm cầu thủ thành công");
							
							sql = "UPDATE footballteam set quantily = (quantily + 1) WHERE ID = ?";
							stm = conn.prepareStatement(sql);
							stm.setString(1, add.MDB.getSelectedItem() + "");
							stm.execute();
							
							add.dispose();
							
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Chưa thêm cầu thủ");
							e1.printStackTrace();
						}
						vD = getvD();
						table.setModel(new DefaultTableModel(vD, vT));
					}
				});
			}
		});
		btn_add.setBounds(104, 320, 105, 23);
		contentPane.add(btn_add);
		
		JButton btn_add_1 = new JButton("Sửa");
		btn_add_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateFootballPlayer up = new UpdateFootballPlayer();
				up.setVisible(true);
				
				int index = table.getSelectedRow();
				Vector v = (Vector) vD.get(index);
				up.Name.setText(v.get(0) + "");
				up.TCT.setText(v.get(1) + "");
				up.T.setText(v.get(2) + "");
				up.CV.setSelectedItem(v.get(3) + "");
				up.MDB.setSelectedItem(v.get(4) + "");
				String MDB = up.MDB.getSelectedItem() + "";
				
				up.btn_update.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {Connection conn = new Connect().getConnection();
						String sql = "UPDATE footballplayer SET ID = ?, Name = ?, Age = ?, Position = ?, IDFootballTeam = ? WHERE ID = ?";
						try {
							PreparedStatement stm = conn.prepareStatement(sql);
							stm.setString(1, up.Name.getText());
							stm.setString(2, up.TCT.getText());
							stm.setInt(3, Integer.parseInt(up.T.getText()));
							stm.setString(4, up.CV.getSelectedItem() + "");
							stm.setString(5, up.MDB.getSelectedItem() + "");
							stm.setString(6, up.Name.getText());
							stm.execute();
							
							JOptionPane.showMessageDialog(null, "Cập nhật thành công");
							
							if (!MDB.equals(up.MDB.getSelectedItem() + "")) {
								sql = "UPDATE footballteam set quantily = (quantily + 1) WHERE ID = ?";
								stm = conn.prepareStatement(sql);
								stm.setString(1, up.MDB.getSelectedItem() + "");
								stm.execute();
								
								sql = "UPDATE footballteam set quantily = (quantily - 1) WHERE ID = ?";
								stm = conn.prepareStatement(sql);
								stm.setString(1, MDB);
								stm.execute();
							}
							
							up.dispose();
							vD = getvD();
							table.setModel(new DefaultTableModel(vD, vT));
						} catch (SQLException e2) {
							JOptionPane.showMessageDialog(null, "ID \u0111\u00E3 t\u1ED3n t\u1EA1i");
							e2.printStackTrace();
						}
					}
				});
			}
		});
		btn_add_1.setBounds(263, 320, 105, 23);
		contentPane.add(btn_add_1);
		
		JButton btn_delete = new JButton("Xoá");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = new Connect().getConnection();
				int index_row = table.getSelectedRow();
				String idFootballplayer = ((Vector) vD.get(index_row)).get(0) + "";
				String sql = "DELETE FROM footballplayer WHERE ID = ?";
				try {
					PreparedStatement stm = conn.prepareStatement(sql);
					stm.setString(1, idFootballplayer);
					int k = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa cầu thủ "+ ((Vector) vD.get(index_row)).get(1) + "?");
					if (k == 0) {
						stm.execute();
						JOptionPane.showMessageDialog(null, "Đã xóa");
						
						sql = "UPDATE footballteam set quantily = (quantily - 1) WHERE ID = ?";
						stm = conn.prepareStatement(sql);
						System.out.print( ((Vector) vD.get(index_row)));
						stm.setString(1,  ((Vector) vD.get(index_row)).get(4) + "");
						stm.execute();
						
						vD = getvD();
						table.setModel(new DefaultTableModel(vD, vT));
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Xóa không thành công");
				}
			}
		});
		btn_delete.setBounds(417, 320, 105, 23);
		contentPane.add(btn_delete);
		setLocationRelativeTo(null);
	}

}
