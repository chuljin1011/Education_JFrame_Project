package xyz.itwill.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class MemberLogin2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int imin = 5;
	int imax = 22;
	JButton[] buttons;
	private JTable table;
	private JTable table_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MemberLogin2 dialog = new MemberLogin2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MemberLogin2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(446, 90, 209, 400);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		buttons = new JButton[imax - imin + 1];
		for (int i = imin; i <= imax; i++) {
			int startNum = 9;
			int closeNum = 18;
			JButton tButton = new JButton("<html><center><font size = 4>" + i + ":00<br>예약 가능</html>");
			buttons[i - imin] = tButton;
			panel.add(tButton);

			if (i < startNum) {
				tButton.setEnabled(false);
				tButton.setBackground(Color.gray);
				tButton.setText(tButton.getText().replace("예약 가능", "영업 전"));

			} else if (i > closeNum) {
				tButton.setEnabled(false);
				tButton.setBackground(Color.gray);
				tButton.setText(tButton.getText().replace("예약 가능", "영업 종료"));

			} else {

				tButton.setBackground(Color.white);
			}

			tButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton actionbutton = (JButton) e.getSource();

					if (actionbutton.getText().indexOf("가능") != -1) {

						if (actionbutton.getText().substring(30, 31).equals(":")) {
							textField.setText((actionbutton.getText().substring(29, 30)));
						} else {
							textField.setText((actionbutton.getText().substring(29, 31)));

						}

					} else {
						textField.setText("");
					}

				}
			});
		}
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(492, 500, 163, 33);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			JButton okButton = new JButton("로그아웃");
			okButton.setActionCommand("OK");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("종료");
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);
		}
		
		JComboBox ycomboBox = new JComboBox();
		ycomboBox.setFont(new Font("굴림", Font.PLAIN, 15));
		ycomboBox.setBounds(446, 10, 70, 30);
		contentPane.add(ycomboBox);
		ycomboBox.addItem(2024);
		ycomboBox.addItem(2025);
		
		JComboBox mcomboBox = new JComboBox();
		mcomboBox.setFont(new Font("굴림", Font.PLAIN, 15));
		mcomboBox.setBounds(535, 10, 50, 30);
		contentPane.add(mcomboBox);
		for (int i = 1; i < 12; i++) {
			mcomboBox.addItem(i);			
		}
		
		JComboBox dcomboBox = new JComboBox();
		dcomboBox.setFont(new Font("굴림", Font.PLAIN, 15));
		dcomboBox.setBounds(605, 10, 50, 30);
		contentPane.add(dcomboBox);
		for (int i = 1; i < 31; i++) {
			dcomboBox.addItem(i);
		}
		
		JLabel lblNewLabel = new JLabel("/");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(515, 14, 20, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("날짜 조회");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton.setBounds(446, 50, 209, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(585, 14, 20, 25);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(234, 10, 200, 480);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setEnabled(false);
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(new Object[][] {},
                new String[] {"종류","시술 시간","가격"}));
		table_1.setEnabled(false);
		table_1.getTableHeader().setReorderingAllowed(false);
		table_1.getTableHeader().setResizingAllowed(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 10, 200, 480);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
                new String[] {"이름","직급","경력"}));
		table.setEnabled(false);
		
		textField = new JTextField();
		textField.setBounds(364, 500, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
	}
}
