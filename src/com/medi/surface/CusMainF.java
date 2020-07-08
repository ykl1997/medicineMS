package com.medi.surface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CusMainF extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CusMainF frame = new CusMainF();
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
	public CusMainF() {
		this.setIconImage(new ImageIcon("logo/logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 359);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		setTitle("主页");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("\u4E70\u836F");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(173, 255, 47));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyMedicine buyMedicine = new BuyMedicine();
				buyMedicine.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 14));
		btnNewButton.setBounds(46, 192, 156, 76);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("查看个人订单");
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CusOder cusOder = new CusOder();
				cusOder.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(300, 192, 156, 76);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u767B\u5F55\u836F\u54C1\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("华文行楷", Font.PLAIN, 33));
		lblNewLabel.setBounds(78, 26, 337, 111);
		contentPane.add(lblNewLabel);
	}
}
