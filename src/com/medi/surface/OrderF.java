package com.medi.surface;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.medi.dao.ViewOrderDao;
import com.medi.model.Employee;
import com.medi.model.ViewOrder;
import com.medi.tool.Session;

public class OrderF extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton jButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderF frame = new OrderF();
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
	public OrderF() {
		this.setIconImage(new ImageIcon("logo/logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		setTitle("订单");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String[] cluname = { "客户名", "药品名", "数量", "价格" };
		List<ViewOrder> orders = ViewOrderDao.findOrders();
		String[][] tvalue = new String[orders.size()][cluname.length];
		for (int i = 0; i < orders.size(); i++) {
			tvalue[i][0] = orders.get(i).getCusName();
			tvalue[i][1] = orders.get(i).getMediName();
			tvalue[i][2] = String.valueOf(orders.get(i).getNum());
			tvalue[i][3] = String.valueOf(orders.get(i).getTotalPrince());
		}
		table = new JTable(tvalue, cluname);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 450, 200);
		contentPane.add(scrollPane);

		jButton = new JButton("返回");
		jButton.setFont(new Font("黑体", Font.PLAIN, 14));
		jButton.setBounds(10, 210, 416, 43);
		contentPane.add(jButton);
		jButton.addActionListener(new ActionListener() {
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
	}

}
