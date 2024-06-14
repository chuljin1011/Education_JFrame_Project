package xyz.itwill.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import xyz.itwill.project.dao.DesignerDAO;
import xyz.itwill.project.dao.DesignerDTO;
import xyz.itwill.project.dao.MenuDAO;
import xyz.itwill.project.dao.MenuDTO;
import xyz.itwill.project.dao.RsrrvtDAO;
import xyz.itwill.project.dao.RsrrvtDTO;

public class MemberLogin2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int buttonTimeMin = 5; // 예약시간 버튼 최소 시간
	int buttonTimeMax = 22; // 예약시간 버튼 최대 시간
	int openTime = 9; // 예약가능 버튼 최소 시간
	int closeTime = 18; // 예약가능 버튼 최대 시간
	JButton[] buttons;
	private JTable dTable;
	private JTable mTable;
	private JTextField select_Date;
	private JTextField select_dName;
	private JTextField select_mValue;
	private JTable rTable;
	private String login_id;
	private String login_name;
	private String get_date;
	private int chk; 
	private JComboBox ycomboBox;
	private JComboBox mcomboBox;
	private JComboBox dcomboBox;
	private boolean getDate_Status;
	
	private String final_Rdate;		
	private int final_Rtime;
	private String final_Rdid;  
	private String final_Rdname;  
//	private String final_Rcid;		login_id로 대체
	private int final_Menu_No;
	private String final_Memo;
	private int final_Payment;
	private String final_Cash;
	private String final_Status;
	
	private String get_Rank;
	
	private JTextField select_Memo;
	private JCheckBox cashCheckBox;
	private JButton btnNewButton;
	
	
	
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
		setBounds(100, 100, 680, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		login_id = "oao";
		login_name = "김수지";		

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(446, 190, 209, 400);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		// 예약시간 버튼 생성
		buttons = new JButton[buttonTimeMax - buttonTimeMin + 1];
		for (int i = buttonTimeMin; i <= buttonTimeMax; i++) {
//			startNum = 9;     최상단 필드 참조
//			closeNum = 18;
			JButton tButton = new JButton("<html><center><font size = 4>" + i + ":00<br>예약 가능</html>");
			buttons[i - buttonTimeMin] = tButton;
			tButton.setEnabled(false); // 조회전 비활성화
			
			panel.add(tButton);

			if (i < openTime) {
//				tButton.setEnabled(false);
				tButton.setBackground(Color.gray);
				tButton.setText(tButton.getText().replace("예약 가능", "영업 전"));

			} else if (i > closeTime) {
//				tButton.setEnabled(false);
				tButton.setBackground(Color.gray);
				tButton.setText(tButton.getText().replace("예약 가능", "영업 종료"));

			} else {

				tButton.setBackground(Color.white);
			}

			tButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton actionbutton = (JButton) e.getSource();

					if (getDate_Status == true) {

						if (actionbutton.getText().substring(30, 31).equals(":")) {
							String getYear = ycomboBox.getSelectedItem().toString();
							String getMonth = mcomboBox.getSelectedItem().toString();
							String getDay = dcomboBox.getSelectedItem().toString();
							
							final_Rdate = getYear+"-"+getMonth+"-"+getDay;
							final_Rtime = Integer.parseInt(actionbutton.getText().substring(29, 30));
							select_Date.setText(getYear+"-"+getMonth+"-"+getDay+"  "+(actionbutton.getText().substring(29, 30)+"시"));
						} else {
							String getYear = ycomboBox.getSelectedItem().toString();
							String getMonth = mcomboBox.getSelectedItem().toString();
							String getDay = dcomboBox.getSelectedItem().toString();
							
							final_Rdate = getYear+"-"+getMonth+"-"+getDay;
							final_Rtime = Integer.parseInt(actionbutton.getText().substring(29, 31));
							select_Date.setText(getYear+"-"+getMonth+"-"+getDay+"  "+(actionbutton.getText().substring(29, 31)+"시"));

							
						}
						
						btnNewButton.setEnabled(true); // 예약하기 버튼 활성화
						
					} 

				}
			});
		}
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(469, 648, 186, 43);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(null);
		{
			JButton okButton = new JButton("로그아웃");
			okButton.setBounds(12, 6, 95, 30);
			okButton.setActionCommand("OK");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("종료");
			cancelButton.setBounds(112, 6, 65, 30);
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);
		}

		ycomboBox = new JComboBox();
		ycomboBox.setFont(new Font("굴림", Font.PLAIN, 15));
		ycomboBox.setBounds(446, 110, 70, 30);
		contentPane.add(ycomboBox);
		ycomboBox.addItem(2024);
		ycomboBox.addItem(2025);

		mcomboBox = new JComboBox();
		mcomboBox.setFont(new Font("굴림", Font.PLAIN, 15));
		mcomboBox.setBounds(535, 110, 50, 30);
		contentPane.add(mcomboBox);
		for (int i = 1; i <= 12; i++) {
			mcomboBox.addItem(i);
		}

		dcomboBox = new JComboBox();
		dcomboBox.setFont(new Font("굴림", Font.PLAIN, 15));
		dcomboBox.setBounds(605, 110, 50, 30);
		contentPane.add(dcomboBox);
		for (int i = 1; i <= 31; i++) {
			dcomboBox.addItem(i);
		}

		JLabel lblNewLabel = new JLabel("/");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(515, 114, 20, 25);
		contentPane.add(lblNewLabel);

		JButton getDateButton = new JButton("날짜 조회");
		getDateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object getYear = ycomboBox.getSelectedItem();
				Object getMonth = mcomboBox.getSelectedItem();
				Object getDay = dcomboBox.getSelectedItem();
				get_date = getYear + "-" + getMonth + "-" + getDay;

				getRdateRsrrvtData(get_date);
				
				getDate_Status = true;

			}
		});

		getDateButton.setFont(new Font("굴림", Font.BOLD, 15));
		getDateButton.setBounds(446, 150, 209, 30);
		contentPane.add(getDateButton);

		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(585, 114, 20, 25);
		contentPane.add(lblNewLabel_1);

		JScrollPane mscrollPane = new JScrollPane();
		mscrollPane.setBounds(234, 110, 200, 480);
		contentPane.add(mscrollPane);

		mTable = new JTable();
		mscrollPane.setViewportView(mTable);
		mTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "메뉴 번호","종류", "시술 시간", "가격" }));
		mTable.getTableHeader().setReorderingAllowed(false);
		mTable.getTableHeader().setResizingAllowed(false);

		// 메뉴 테이블 불러오기
		DisplayAllMenu();

		// 메뉴 테이블 값 반환
		mTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = mTable.getSelectedRow();
					if (selectedRow != -1) {

						Integer no = (Integer) (mTable.getValueAt(selectedRow, 0));
						String value = (String) (mTable.getValueAt(selectedRow, 1));
						Integer price = (Integer) (mTable.getValueAt(selectedRow, 3));

						select_mValue.setText(value);
						
						final_Menu_No = no;
						final_Payment = price;						

					}
				}
			}
		});

		JScrollPane dscrollPane = new JScrollPane();
		dscrollPane.setBounds(22, 110, 200, 480);
		contentPane.add(dscrollPane);

		dTable = new JTable();
		dscrollPane.setViewportView(dTable);
		dTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "이름", "직급", "경력" }));
		dTable.getTableHeader().setReorderingAllowed(false);
		dTable.getTableHeader().setResizingAllowed(false);

		// 디자이너 테이블 불러오기
		DisplayAllDsigner();

		// 디자이너 테이블 값 반환
		dTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = dTable.getSelectedRow();
					if (selectedRow != -1) {

						String name = (String) (dTable.getValueAt(selectedRow, 0));
						String rank = (String) (dTable.getValueAt(selectedRow, 1));

						select_dName.setText(name);
						
						final_Rdname = name;
						get_Rank = rank;

					}
				}
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 600, 633, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		select_Date = new JTextField();
		select_Date.setEnabled(false);
		select_Date.setHorizontalAlignment(SwingConstants.CENTER);
		select_Date.setFont(new Font("굴림", Font.PLAIN, 13));
		select_Date.setBounds(387, 7, 125, 27);
		panel_1.add(select_Date);
		select_Date.setColumns(10);

		select_dName = new JTextField();
		select_dName.setEnabled(false);
		select_dName.setHorizontalAlignment(SwingConstants.CENTER);
		select_dName.setFont(new Font("굴림", Font.PLAIN, 14));
		select_dName.setColumns(10);
		select_dName.setBounds(82, 7, 80, 27);
		panel_1.add(select_dName);

		JLabel lblNewLabel_2 = new JLabel("디자이너 :");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_2.setBounds(12, 13, 80, 17);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("시술 :");
		lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(175, 13, 50, 17);
		panel_1.add(lblNewLabel_2_1);

		select_mValue = new JTextField();
		select_mValue.setEnabled(false);
		select_mValue.setHorizontalAlignment(SwingConstants.CENTER);
		select_mValue.setFont(new Font("굴림", Font.PLAIN, 14));
		select_mValue.setColumns(10);
		select_mValue.setBounds(217, 7, 116, 27);
		panel_1.add(select_mValue);

		JLabel lblNewLabel_2_1_1 = new JLabel("날짜 :");
		lblNewLabel_2_1_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(345, 13, 50, 17);
		panel_1.add(lblNewLabel_2_1_1);

		btnNewButton = new JButton("예약하기");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRsrrvt();

				
				
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 14));
		btnNewButton.setBounds(524, 5, 97, 31);
		panel_1.add(btnNewButton);

		JScrollPane rscrollPane = new JScrollPane();
		rscrollPane.setBounds(22, 32, 630, 70);
		contentPane.add(rscrollPane);

		rTable = new JTable();
		rTable.setEnabled(false);
		rscrollPane.setViewportView(rTable);
		rTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "예약번호", "예약날짜", "예약시간", "디자이너", "시술명", "결제금액", "결제수단", "예약상태", "메모" }));
		rTable.getTableHeader().setReorderingAllowed(false);
//		rTable.getTableHeader().setResizingAllowed(false);

		// 예약 테이블 불러오기
		displayAllRsrrvt();

		JLabel lblNewLabel_3 = new JLabel(login_name + " 고객님 환영합니다.");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(443, 10, 209, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("내 예약");
		lblNewLabel_3_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3_1.setBackground(Color.white);
		lblNewLabel_3_1.setOpaque(true);
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(22, 8, 60, 25);
		contentPane.add(lblNewLabel_3_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(22, 648, 443, 43);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("현금결제 :");
		lblNewLabel_2_2.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(12, 13, 80, 17);
		panel_2.add(lblNewLabel_2_2);
		
		select_Memo = new JTextField();
		select_Memo.setFont(new Font("굴림", Font.PLAIN, 14));
		select_Memo.setColumns(10);
		select_Memo.setBounds(187, 7, 253, 28);
		panel_2.add(select_Memo);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("요청사항 :");
		lblNewLabel_2_2_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(115, 13, 80, 17);
		panel_2.add(lblNewLabel_2_2_1);
		
		cashCheckBox = new JCheckBox("");
		cashCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		cashCheckBox.setBounds(80, 8, 25, 25);
		panel_2.add(cashCheckBox);
		dTable.getTableHeader().setReorderingAllowed(false);
		dTable.getTableHeader().setResizingAllowed(false);
	}

	public void DisplayAllDsigner() {
		List<DesignerDTO> designerList = DesignerDAO.getDAO().selectDesignerAll();

		if (designerList.isEmpty()) { // 표 초기화 코드 제외
			return;
		}

		DefaultTableModel defaultTableModel = (DefaultTableModel) dTable.getModel();
		
		defaultTableModel.setNumRows(0);

		for (DesignerDTO designer : designerList) {
			Vector<Object> rowData = new Vector<Object>();

			rowData.add(designer.getName());
			rowData.add(designer.getRank());
			rowData.add(designer.getCareer());

			defaultTableModel.addRow(rowData);

		}

	}

	public void DisplayAllMenu() {
		List<MenuDTO> menuList = MenuDAO.getDAO().selectMenuAll();

		if (menuList.isEmpty()) { // 표 초기화 코드 제외
			return;
		}

		DefaultTableModel defaultTableModel = (DefaultTableModel) mTable.getModel();
		
		defaultTableModel.setNumRows(0);

		for (MenuDTO menu : menuList) {
			Vector<Object> rowData = new Vector<Object>();

			rowData.add(menu.getMno());
			rowData.add(menu.getValue());
			rowData.add(menu.getMtime()+" 시간");
			rowData.add(menu.getPrice());

			defaultTableModel.addRow(rowData);

		}

	}

	public void displayAllRsrrvt() {
		List<RsrrvtDTO> rsrrvtList = RsrrvtDAO.get_dao().selectRsrrvtbyDnama(login_name);

		if (rsrrvtList.isEmpty()) { // 표 초기화 코드 제외
			return;
		}

		DefaultTableModel defaultTableModel = (DefaultTableModel) rTable.getModel();
		
		defaultTableModel.setNumRows(0);

		for (RsrrvtDTO rsrrvt : rsrrvtList) {
			Vector<Object> rowData = new Vector<Object>();

			rowData.add(rsrrvt.getRno());
			rowData.add(rsrrvt.getRdate());
			rowData.add(rsrrvt.getRtime());
			rowData.add(rsrrvt.getDname());
			rowData.add(rsrrvt.getMvalue());
			rowData.add(rsrrvt.getPayment());
			rowData.add(rsrrvt.getCash());
			rowData.add(rsrrvt.getStatus());
			rowData.add(rsrrvt.getMemo());

			defaultTableModel.addRow(rowData);

		}

	}

	public void getRdateRsrrvtData(String rdate) {
		List<RsrrvtDTO> rsrrvtList = RsrrvtDAO.get_dao().selectRsrrvtbyRdate(rdate);
		
		
		for (int i = openTime-buttonTimeMin; i <= (23-closeTime)+(openTime-1); i++) {
			buttons[i].setBackground(Color.white);
			buttons[i].setEnabled(true);
			if (buttons[i].getText().contains("완료")) {
				buttons[i].setText(buttons[i].getText().replace("완료", "가능"));
			}
				
			
		}

		if (rsrrvtList.isEmpty()) { // 표 초기화 코드 제외
			return;
		}



		
		for (RsrrvtDTO rsrrvt : rsrrvtList) { 

			chk = (rsrrvt.getRtime())-buttonTimeMin;
			
			

			buttons[chk].setBackground(new Color(200, 140, 210));
			buttons[chk].setText(buttons[chk].getText().replace("가능", "완료"));
			buttons[chk].setEnabled(false);



		}
	}
	
	public void DesignerchangeNameToId() {
		DesignerDTO designer=DesignerDAO.getDAO().selectDesignerByNameRank(final_Rdname, get_Rank);
		
		final_Rdid = designer.getId();		
		System.out.println(designer.getId());
		
	}
	
	
	
	public void addRsrrvt() {
		DesignerchangeNameToId();

		
		if (select_dName.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "디자이너를 선택해 주세요");
			select_dName.requestFocus();
			return;
		}
		if (select_mValue.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "시술 받으실 메뉴를 선택해 주세요");
			select_mValue.requestFocus();
			return;
		}
		if (select_Date.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "예약 날짜 및 시간을 선택해주세요.");
			return;
		}
		
		final_Memo = select_Memo.getText();
		final_Status = "1";
		
		
		if (cashCheckBox.isSelected()) {
			final_Cash = "2";
		} else {
			final_Cash = "1";
			

		}
		
		RsrrvtDTO rsrrvt = new RsrrvtDTO();
		
		rsrrvt.setRdate(final_Rdate);
		rsrrvt.setRtime(final_Rtime);
		rsrrvt.setRdid(final_Rdid);
		rsrrvt.setRcid(login_id);
		rsrrvt.setMenu_no(final_Menu_No);
		rsrrvt.setPayment(final_Payment);
		rsrrvt.setCash(final_Cash);
		rsrrvt.setStatus(final_Status);
		rsrrvt.setMemo(final_Memo);
		
		int rows = RsrrvtDAO.get_dao().insertRsrrvt(rsrrvt);
		
		if (rows > 0) {
		JOptionPane.showMessageDialog(this, "예약이 완료 되었습니다.");
		displayAllRsrrvt();
		
		} else {
			JOptionPane.showMessageDialog(this, "잘못된 접근으로 예약이 진행되지 못했습니다..");
		}
		
		
	}
	
}





