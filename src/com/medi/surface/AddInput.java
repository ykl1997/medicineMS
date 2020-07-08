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

import com.medi.dao.InputDao;
import com.medi.model.Employee;
import com.medi.model.Input;
import com.medi.tool.NumberTool;
import com.medi.tool.Session;

public class AddInput extends JFrame {

	private JPanel contentPane;
	private JTextField mid;
	private JTextField num;
	private JTextField eid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddInput frame = new AddInput();
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
	public AddInput() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 234);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("logo/logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Employee employee = (Employee) Session.getAttribute("user");

		JLabel label = new JLabel("\u836F\u54C1\u7F16\u53F7");
		label.setFont(new Font("黑体", Font.PLAIN, 14));
		label.setBounds(20, 24, 65, 30);
		contentPane.add(label);

		JLabel sdas = new JLabel("\u5165\u5E93\u6570\u76EE");
		sdas.setFont(new Font("黑体", Font.PLAIN, 14));
		sdas.setBounds(20, 74, 65, 15);
		contentPane.add(sdas);

		JLabel gdfg = new JLabel("\u64CD\u4F5C\u4EBA\u7F16\u53F7");
		gdfg.setFont(new Font("黑体", Font.PLAIN, 14));
		gdfg.setBounds(20, 105, 72, 26);
		contentPane.add(gdfg);

		mid = new JTextField();
		mid.setBounds(95, 27, 158, 26);
		contentPane.add(mid);
		mid.setColumns(10);

		num = new JTextField();
		num.setBounds(95, 69, 158, 26);
		contentPane.add(num);
		num.setColumns(10);

		eid = new JTextField();
		eid.setBounds(95, 106, 158, 26);
		eid.setText(String.valueOf(employee.getId()));
		eid.setEnabled(false);
		contentPane.add(eid);
		eid.setColumns(10);

		JButton btnNewButton = new JButton("\u5165\u5E93");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eid.setText(String.valueOf(employee.getId()));
				if (mid.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "药品编号不能为空", "提示", JOptionPane.WARNING_MESSAGE);
				} else if (!NumberTool.isNumeric(num.getText())) {
					JOptionPane.showMessageDialog(null, "数量应该是数字", "提示", JOptionPane.WARNING_MESSAGE);

				} else {
					Input input = new Input(0, Integer.parseInt(mid.getText()), Integer.parseInt(num.getText()),
							employee.getId());
					InputDao.addInput(input);
					InputDao.callprocedure(Integer.parseInt(mid.getText()));
					JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.WARNING_MESSAGE);
					mid.setText("");
					num.setText("");
				}

			}
		});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 14));
		btnNewButton.setBounds(280, 28, 93, 61);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainF mainF = new MainF();
				Employee employee = (Employee) Session.getAttribute("user");
				if (employee.getPosition().equals("员工")) {
					mainF.getContentPane().remove(1);
				}
				mainF.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(280, 106, 93, 25);
		contentPane.add(btnNewButton_1);
	}
}
