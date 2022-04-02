package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import FootballPlayerManagement.FootballPlayerManagement;
import FootballTeamManagement.FootballTeamManagement;
import Schedule.Schedule;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	public Timer timer;
	private int indexIM = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
					frame.timer.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Icon getIcon(int d, int width, int height) {
		Image image = new ImageIcon(getClass().getResource("/icon/MainIcon/" + d + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
	}
	
	public Icon getIcon2(int d, int width, int height) {
		Image image = new ImageIcon(getClass().getResource("/icon/footballteam/" + d + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
	}
	
	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setTitle("V-Leaguage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 519);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton team_bt = new JButton("");
		team_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FootballTeamManagement frame = new FootballTeamManagement();
				frame.setVisible(true);
			}
		});
		team_bt.setBounds(52, 101, 289, 155);
		team_bt.setIcon(getIcon(1, team_bt.getWidth(), team_bt.getHeight()));
		contentPane.add(team_bt);
		
		JButton rank = new JButton("");
		rank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rank.setBounds(363, 101, 107, 155);
		rank.setIcon(getIcon(4, rank.getWidth(), rank.getHeight()));
		contentPane.add(rank);
		
		JButton player = new JButton("");
		player.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FootballPlayerManagement frame = new FootballPlayerManagement();
				frame.setVisible(true);
			}
		});
		player.setBounds(52, 285, 139, 169);
		player.setIcon(getIcon(2, player.getWidth(), player.getHeight()));
		contentPane.add(player);
		
		JButton schedule = new JButton("");
		schedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Schedule frame = new Schedule();
				frame.setVisible(true);
			}
		});
		schedule.setBounds(217, 285, 253, 169);
		schedule.setIcon(getIcon(3, schedule.getWidth(), schedule.getHeight()));
		contentPane.add(schedule);
		
		JButton IM = new JButton("");
		IM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		IM.setBounds(516, 101, 253, 353);
		IM.setIcon(getIcon2(2, IM.getWidth(), IM.getHeight()));
		contentPane.add(IM);
		
		JLabel lblNewLabel_1 = new JLabel("GIẢI BÓNG ĐÁ V-LEAGUAGE 2022 ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(217, 27, 415, 63);
		contentPane.add(lblNewLabel_1);
		
		setLocationRelativeTo(null);
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				IM.setIcon(getIcon2(indexIM++, IM.getWidth(), IM.getHeight()));
				if (indexIM > 14)
					indexIM = 1;
			}
		});
	}
}
