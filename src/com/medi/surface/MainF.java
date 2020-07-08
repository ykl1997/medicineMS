package com.medi.surface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainF extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainF frame = new MainF();
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
	public MainF() {
		this.setIconImage(new ImageIcon("logo/logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 49, 124));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("\u6DFB\u52A0\u836F\u54C1");
		button.setBackground(new Color(238, 247, 242));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMediF addMediF = new AddMediF();
				addMediF.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("黑体", Font.PLAIN, 14));
		button.setBounds(120, 50, 104, 36);
		contentPane.add(button);

		JButton btnNewButton = new JButton("\u6DFB\u52A0\u5458\u5DE5");
		btnNewButton.setBackground(new Color(238, 247, 242));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmployee addEmployee = new AddEmployee();
				addEmployee.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 14));
		btnNewButton.setBounds(120, 234, 104, 36);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0\u987E\u5BA2");
		btnNewButton_1.setBackground(new Color(238, 247, 242));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomer addCustomer = new AddCustomer();
				addCustomer.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(120, 96, 104, 36);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("入库药品");
		btnNewButton_2.setBackground(new Color(238, 247, 242));
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddInput addInput = new AddInput();
				addInput.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("黑体", Font.PLAIN, 14));
		btnNewButton_2.setBounds(120, 188, 104, 36);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\u67E5\u770B\u8BA2\u5355");
		btnNewButton_3.setBackground(new Color(238, 247, 242));
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderF orderF = new OrderF();
				orderF.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("黑体", Font.PLAIN, 14));
		btnNewButton_3.setBounds(120, 140, 104, 36);
		contentPane.add(btnNewButton_3);

	}
}
