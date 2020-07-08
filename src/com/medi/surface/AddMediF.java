package com.medi.surface;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.eltima.components.ui.DatePicker;
import com.medi.dao.MedicineDao;
import com.medi.model.Employee;
import com.medi.model.Medicine;
import com.medi.tool.Session;

public class AddMediF extends JFrame {

	private JPanel contentPane;
	private JTextField medeName;
	private JTextField munifac;
	private JLabel lblNewLabel;
	private JTextField price;
	private JTextField position;
	private JLabel lblNewLabel_3;
	private DatePicker muniDate;
	private DatePicker deadLine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMediF frame = new AddMediF();
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
	public AddMediF() {
		setTitle("\u6DFB\u52A0\u836F\u54C1\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 417);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("logo/logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u836F   \u540D");
		label.setFont(new Font("黑体", Font.PLAIN, 14));
		label.setBounds(34, 25, 58, 15);
		contentPane.add(label);

		medeName = new JTextField();
		medeName.setBounds(95, 16, 148, 33);
		contentPane.add(medeName);
		medeName.setColumns(10);

		JLabel label_1 = new JLabel("\u751F\u4EA7\u5382\u5BB6");
		label_1.setFont(new Font("黑体", Font.PLAIN, 14));
		label_1.setBounds(34, 80, 58, 15);
		contentPane.add(label_1);

		munifac = new JTextField();
		munifac.setBounds(95, 71, 148, 33);
		contentPane.add(munifac);
		munifac.setColumns(10);

		lblNewLabel = new JLabel("\u751F\u4EA7\u65E5\u671F");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 14));
		lblNewLabel.setBounds(34, 134, 58, 15);
		contentPane.add(lblNewLabel);

		muniDate = new DatePicker();
		muniDate.setBounds(95, 125, 148, 33);
		contentPane.add(muniDate);

		JLabel lblNewLabel_1 = new JLabel("\u4EF7    \u683C");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(268, 25, 58, 15);
		contentPane.add(lblNewLabel_1);

		price = new JTextField();
		price.setBounds(336, 19, 148, 30);
		contentPane.add(price);
		price.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u4F4D    \u7F6E");
		lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(268, 80, 58, 15);
		contentPane.add(lblNewLabel_2);

		position = new JTextField();
		position.setBounds(336, 74, 148, 30);
		contentPane.add(position);
		position.setColumns(10);

		lblNewLabel_3 = new JLabel("\u6709 \u6548 \u671F");
		lblNewLabel_3.setFont(new Font("黑体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(268, 134, 58, 15);
		contentPane.add(lblNewLabel_3);

		deadLine = new DatePicker();
		deadLine.setBounds(336, 125, 148, 30);
		contentPane.add(deadLine);

		JLabel lblNewLabel_4 = new JLabel("\u529F   \u6548");
		lblNewLabel_4.setFont(new Font("黑体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(34, 197, 58, 15);
		contentPane.add(lblNewLabel_4);

		JTextArea faction = new JTextArea();
		faction.setBounds(95, 192, 394, 136);
		contentPane.add(faction);

		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 35));
		btnNewButton.setBounds(505, 80, 113, 248);
		contentPane.add(btnNewButton);

		JButton back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("黑体", Font.PLAIN, 14));
		back.setBounds(501, 16, 117, 33);
		contentPane.add(back);
		back.addActionListener(new ActionListener() {
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

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date muniDateinner = new Date();
				Date deadLineinner = new Date();
				if (medeName.getText().isEmpty() || munifac.getText().isEmpty() || muniDate.getText().isEmpty()
						|| deadLine.getText().isEmpty() || price.getText().isEmpty() || faction.getText().isEmpty()
						|| position.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请填写完整信息", "提示", JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						muniDateinner = sdf.parse(muniDate.getText());
						deadLineinner = sdf.parse(deadLine.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					Medicine medicine = new Medicine(0, medeName.getText(), munifac.getText(), muniDateinner,
							faction.getText(), Double.parseDouble(price.getText()), deadLineinner, 0,
							position.getText());
					MedicineDao.addMedicine(medicine);
					JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.WARNING_MESSAGE);
					medeName.setText("");
					munifac.setText("");
					lblNewLabel.setText("");
					price.setText("");
					position.setText("");
				}
			}
		});

	}

}
