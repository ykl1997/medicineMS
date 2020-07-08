package com.medi.surface;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.medi.dao.EmployeeDao;
import com.medi.model.Employee;
import com.medi.tool.Session;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setTitle("\u5458\u5DE5\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 357);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("logo/logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 17));
		lblNewLabel.setBounds(126, 10, 136, 41);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("\u59D3\u540D");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(65, 91, 38, 24);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(65, 151, 38, 18);
		contentPane.add(label_1);

		username = new JTextField();
		username.setBounds(110, 88, 207, 32);
		contentPane.add(username);
		username.setColumns(10);

		JButton login = new JButton("\u767B\u5F55");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (username.getText().isEmpty() || password.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入账号密码", "提示", JOptionPane.WARNING_MESSAGE);
				} else {
					if (EmployeeDao.checkemployee(username.getText(), password.getText())) {
						JOptionPane.showMessageDialog(null, "成功", "提示", JOptionPane.WARNING_MESSAGE);
						Employee employee = EmployeeDao.findEmployeeByName(username.getText());
						Session.setAttribute("user", employee);
						MainF mainF = new MainF();
						mainF.setVisible(true);
						if (EmployeeDao.getPosition(username.getText()).equals("员工")) {
							mainF.getContentPane().remove(1);
						}
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "密码错误", "错误", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		login.setBounds(33, 211, 99, 41);
		contentPane.add(login);
		JButton exit = new JButton("\u53D6\u6D88");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exit.setBounds(142, 211, 99, 41);
		contentPane.add(exit);

		JButton back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CusLogin cusLogin = new CusLogin();
				cusLogin.setVisible(true);
				dispose();
			}
		});
		back.setBounds(251, 211, 106, 41);
		contentPane.add(back);

		password = new JPasswordField();
		password.setText("");
		password.setBounds(110, 145, 207, 32);
		contentPane.add(password);
	}
}
