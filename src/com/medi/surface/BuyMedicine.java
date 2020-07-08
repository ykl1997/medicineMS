package com.medi.surface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.medi.dao.MedicineDao;
import com.medi.dao.OutputDao;
import com.medi.model.Customer;
import com.medi.model.Medicine;
import com.medi.model.Output;
import com.medi.tool.NumberTool;
import com.medi.tool.Session;

public class BuyMedicine extends JFrame {

	private JPanel contentPane;
	private JTextField nameOrFaction;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel midJLabel;
	private JTextField midField;
	private JLabel mnameJLabel;
	private JTextField mnameField;
	private JLabel numJLabel;
	private JTextField numField;
	private JTextField toprinceField;
	private JLabel totalLabel;
	private JButton buyButton;
	private JButton backButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyMedicine frame = new BuyMedicine();
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
	public BuyMedicine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("logo/logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("买药");
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(150, 194, 78));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Customer customer = (Customer) Session.getAttribute("user");

		JLabel lblNewLabel = new JLabel("\u836F\u540D\u6216\u529F\u6548");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 14));
		lblNewLabel.setBounds(26, 24, 75, 34);
		contentPane.add(lblNewLabel);

		nameOrFaction = new JTextField();
		nameOrFaction.setBounds(111, 25, 217, 34);
		contentPane.add(nameOrFaction);
		nameOrFaction.setColumns(10);

		midJLabel = new JLabel("药品编号");
		midJLabel.setBounds(440, 25, 70, 30);
		contentPane.add(midJLabel);

		midField = new JTextField();
		midField.setBounds(500, 25, 100, 30);
		midField.setEnabled(false);
		midField.setForeground(Color.black);
		contentPane.add(midField);

		mnameJLabel = new JLabel("药品名称");
		mnameJLabel.setBounds(440, 80, 70, 30);
		contentPane.add(mnameJLabel);

		mnameField = new JTextField();
		mnameField.setBounds(500, 80, 100, 30);
		mnameField.setEnabled(false);
		contentPane.add(mnameField);

		numJLabel = new JLabel("数      量");
		numJLabel.setBounds(440, 135, 70, 30);
		contentPane.add(numJLabel);

		numField = new JTextField();
		numField.setBounds(500, 135, 100, 30);
		contentPane.add(numField);

		totalLabel = new JLabel("总     计");
		totalLabel.setBounds(440, 180, 70, 30);
		contentPane.add(totalLabel);

		toprinceField = new JTextField();
		toprinceField.setBounds(500, 180, 100, 30);
		toprinceField.setEnabled(false);
		contentPane.add(toprinceField);

		buyButton = new JButton("购   买");
		buyButton.setBackground(new Color(249, 244, 220));
		buyButton.setBounds(440, 230, 163, 40);
		contentPane.add(buyButton);

		backButton = new JButton("返   回");
		backButton.setBackground(new Color(249, 244, 220));
		backButton.setBounds(440, 280, 163, 40);
		contentPane.add(backButton);

		JButton btnNewButton = new JButton("\u67E5\u627E");
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(249, 244, 220));
		btnNewButton.setBounds(338, 23, 86, 39);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Medicine> mlist = MedicineDao.findMedicineByNameOrFinction(nameOrFaction.getText());
				String[] rowname = { "编号", "药名", "价格", "库存", "功效" };
				String[][] tabv = new String[mlist.size()][rowname.length];
				for (int i = 0; i < mlist.size(); i++) {
					tabv[i][0] = String.valueOf(mlist.get(i).getMediId());
					tabv[i][1] = mlist.get(i).getMediName();
					tabv[i][2] = String.valueOf(mlist.get(i).getPrice());
					tabv[i][3] = String.valueOf(mlist.get(i).getNum());
					tabv[i][4] = mlist.get(i).getFaction();
				}
				table = new JTable(tabv, rowname);
				scrollPane = new JScrollPane(table);
				scrollPane.setBounds(26, 70, 400, 290);
				contentPane.add(scrollPane);
				table.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						new Thread(new Runnable() {
							@Override
							public void run() {
								midField.setText((String) table.getValueAt(table.getSelectedRow(), 0));
								mnameField.setText((String) table.getValueAt(table.getSelectedRow(), 1));
								numField.setText("1");
							}
						}).start();
					}
				});

			}
		});
		numField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				if (NumberTool.isNumeric(numField.getText()) && !numField.getText().isEmpty()
						&& !midField.getText().isEmpty()) {
					toprinceField.setText(
							String.valueOf(Double.parseDouble((String) table.getValueAt(table.getSelectedRow(), 2))
									* Integer.parseInt(numField.getText())));
				} else {
					toprinceField.setText("******");
				}

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				if (NumberTool.isNumeric(numField.getText()) && !numField.getText().isEmpty()
						&& !midField.getText().isEmpty()) {
					toprinceField.setText(
							String.valueOf(Double.parseDouble((String) table.getValueAt(table.getSelectedRow(), 2))
									* Integer.parseInt(numField.getText())));
				} else {
					toprinceField.setText("******");
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		buyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (midField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "您还没有选择药品", "提示", JOptionPane.WARNING_MESSAGE);
				} else if (!NumberTool.isNumeric(numField.getText()) || numField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入正确数量", "提示", JOptionPane.WARNING_MESSAGE);
				} else {
					Output output = new Output(0, Integer.parseInt(midField.getText()),
							Integer.parseInt(numField.getText()), customer.getId(),
							Double.parseDouble(toprinceField.getText()), new Date());
					OutputDao.addOutput(output);
					OutputDao.callprocedure(Integer.parseInt(midField.getText()));
					JOptionPane.showMessageDialog(null, "购买成功", "提示", JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CusMainF cusMainF = new CusMainF();
				cusMainF.setVisible(true);
				dispose();
			}
		});

	}

}
