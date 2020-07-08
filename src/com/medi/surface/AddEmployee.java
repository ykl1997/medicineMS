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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.medi.dao.EmployeeDao;
import com.medi.model.Employee;
import com.medi.tool.Session;

public class AddEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField age;
	private JTextField password;
	private JTextField sex;
	private JTextField position;
	private JTextField degree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
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
	public AddEmployee() {
		setTitle("\u6DFB\u52A0\u5458\u5DE5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 344);
		setTitle("添加员工");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("logo/logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 14));
		lblNewLabel.setBounds(38, 33, 54, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5E74\u9F84");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(38, 81, 38, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(38, 124, 54, 15);
		contentPane.add(lblNewLabel_2);

		name = new JTextField();
		name.setBounds(86, 24, 177, 33);
		contentPane.add(name);
		name.setColumns(10);

		age = new JTextField();
		age.setBounds(86, 72, 177, 33);
		contentPane.add(age);
		age.setColumns(10);

		password = new JTextField();
		password.setBounds(86, 115, 177, 33);
		contentPane.add(password);
		password.setColumns(10);

		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (name.getText().isEmpty() || degree.getText().isEmpty() || position.getText().isEmpty()
						|| age.getText().isEmpty() || password.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请填写完整信息", "提示消息", JOptionPane.WARNING_MESSAGE);
				} else if (!sex.getText().equals("男") || !sex.getText().equals("女")) {
					JOptionPane.showMessageDialog(null, "性别只能是男或女", "提示消息", JOptionPane.WARNING_MESSAGE);
				} else {
					Employee employee = new Employee(0, name.getName(), sex.getText(), degree.getText(),
							position.getText(), Integer.parseInt(age.getText()), password.getText());
					EmployeeDao.addEployee(employee);
					JOptionPane.showMessageDialog(null, "添加成功", "提示消息", JOptionPane.WARNING_MESSAGE);
					name.setText("");
					age.setText("");
					password.setText("");
					sex.setText("");
					position.setText("");
					degree.setText("");
				}
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(274, 65, 115, 227);
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
		btnNewButton_1.setBounds(273, 24, 116, 36);
		contentPane.add(btnNewButton_1);

		JLabel label = new JLabel("\u6027\u522B");
		label.setFont(new Font("黑体", Font.PLAIN, 14));
		label.setBounds(38, 171, 54, 15);
		contentPane.add(label);

		sex = new JTextField();
		sex.setBounds(86, 162, 177, 33);
		contentPane.add(sex);
		sex.setColumns(10);

		position = new JTextField();
		position.setBounds(86, 205, 177, 33);
		contentPane.add(position);
		position.setColumns(10);

		JLabel label_1 = new JLabel("\u804C\u4F4D");
		label_1.setFont(new Font("黑体", Font.PLAIN, 14));
		label_1.setBounds(38, 214, 54, 15);
		contentPane.add(label_1);

		JLabel lblNewLabel_3 = new JLabel("\u5B66\u5386");
		lblNewLabel_3.setFont(new Font("黑体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(38, 268, 31, 15);
		contentPane.add(lblNewLabel_3);

		degree = new JTextField();
		degree.setBounds(86, 259, 177, 33);
		contentPane.add(degree);
		degree.setColumns(10);
	}

}
