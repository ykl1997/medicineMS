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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.medi.dao.CustomerDao;
import com.medi.model.Customer;
import com.medi.model.Employee;
import com.medi.tool.Session;

public class AddCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField phone;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomer frame = new AddCustomer();
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
	public AddCustomer() {

		setTitle("\u6DFB\u52A0\u987E\u5BA2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 236);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("logo/logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel yyy = new JLabel("\u59D3\u540D");
		yyy.setFont(new Font("黑体", Font.PLAIN, 14));
		yyy.setBounds(43, 34, 54, 15);
		contentPane.add(yyy);

		JLabel hhhhh = new JLabel("\u7535\u8BDD");
		hhhhh.setFont(new Font("黑体", Font.PLAIN, 14));
		hhhhh.setBounds(43, 81, 54, 15);
		contentPane.add(hhhhh);

		JLabel hhhtt = new JLabel("\u5BC6\u7801");
		hhhtt.setFont(new Font("黑体", Font.PLAIN, 14));
		hhhtt.setBounds(43, 131, 54, 15);
		contentPane.add(hhhtt);

		name = new JTextField();
		name.setBounds(98, 28, 153, 27);
		contentPane.add(name);
		name.setColumns(10);

		phone = new JTextField();
		phone.setBounds(98, 78, 153, 27);
		contentPane.add(phone);
		phone.setColumns(10);

		password = new JTextField();
		password.setBounds(98, 125, 153, 27);
		contentPane.add(password);
		password.setColumns(10);

		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (name.getText().isEmpty() || phone.getText().isEmpty() || password.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入完整信息", "提示", JOptionPane.WARNING_MESSAGE);
				} else {
					Customer customer = new Customer(0, name.getText(), phone.getText(), password.getText());
					CustomerDao.addCutomer(customer);
					JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.WARNING_MESSAGE);
					name.setText("");
					phone.setText("");
					password.setText("");
				}
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 14));
		btnNewButton.setBounds(284, 75, 93, 77);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainF mainF = new MainF();
				Employee employee = (Employee) Session.getAttribute("user");
				if (employee.getPosition().equals("员工")) {
					mainF.getContentPane().remove(1);
				}
				mainF.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 14));
		btnNewButton_1.setBounds(284, 24, 93, 35);
		contentPane.add(btnNewButton_1);
	}

}
