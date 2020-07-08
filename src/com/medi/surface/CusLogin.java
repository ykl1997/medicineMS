package com.medi.surface;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.medi.dao.CustomerDao;
import com.medi.model.Customer;
import com.medi.tool.Dbtool;
import com.medi.tool.Session;

public class CusLogin extends JFrame {

	private JPanel contentPane;
	private JLabel a1 = new JLabel("\u59D3   \u540D");
	private JTextField username = new JTextField();
	private JLabel a2 = new JLabel("密   码");
	private JPasswordField password = new JPasswordField();
	private JButton okbtn = new JButton("登录");
	private JButton admbtn = new JButton("员工入口");
	private JButton cancelbtn = new JButton("取消");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CusLogin frame = new CusLogin();
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
	public CusLogin() {
		this.setIconImage(new ImageIcon("logo/logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 300, 375, 284);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		setTitle("登录");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		/* 标题部分--North */
		contentPane.setLayout(null);

		/* 输入部分--Center */
		JPanel fieldPanel = new JPanel();
		fieldPanel.setBounds(5, 0, 354, 236);
		fieldPanel.setLayout(null);
		a1.setBounds(50, 53, 50, 20);
		a2.setBounds(50, 94, 50, 20);
		fieldPanel.add(a1);
		fieldPanel.add(a2);
		username.setBounds(121, 48, 153, 30);
		password.setBounds(121, 90, 153, 30);
		fieldPanel.add(username);
		fieldPanel.add(password);
		contentPane.add(fieldPanel);
		okbtn.setBounds(30, 152, 85, 45);
		fieldPanel.add(okbtn);
		cancelbtn.setBounds(225, 152, 85, 45);
		fieldPanel.add(cancelbtn);
		admbtn.setBounds(120, 152, 100, 45);
		fieldPanel.add(admbtn);
		JLabel label = new JLabel("药品信息管理系统");
		label.setFont(new Font("楷体", Font.BOLD, 20));
		label.setBounds(100, 10, 200, 29);
		fieldPanel.add(label);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(5, 247, 424, 10);
		buttonPanel.setLayout(new FlowLayout());
		contentPane.add(buttonPanel);
		cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		okbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection = Dbtool.getConnection();
				if (username.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入姓名", "错误", JOptionPane.WARNING_MESSAGE);
				} else if (password.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入密码", "错误", JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						PreparedStatement prepareStatement = connection
								.prepareStatement("select password from CUSTOMER_INFO where name=?");
						prepareStatement.setString(1, username.getText());
						ResultSet query = prepareStatement.executeQuery();
						if (!query.next()) {
							JOptionPane.showMessageDialog(null, "用户不存在", "错误", JOptionPane.WARNING_MESSAGE);
						} else {
							if (password.getText().equals(query.getString("password"))) {
								JOptionPane.showMessageDialog(null, "成功", "提示", JOptionPane.WARNING_MESSAGE);
								Customer customer = CustomerDao.findCustomerByName(username.getText());
								Session.setAttribute("user", customer);
								CusMainF f = new CusMainF();
								f.setVisible(true);
								dispose();
							} else {
								JOptionPane.showMessageDialog(null, "密码或用户名错误", "错误", JOptionPane.WARNING_MESSAGE);
							}
							query.close();
							prepareStatement.close();
							connection.close();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		admbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin adminLogin = new AdminLogin();
				adminLogin.setVisible(true);
				dispose();
			}
		});

	}

}
