package xyz.itwill.project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministratorLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorLogin frame = new AdministratorLogin();
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
	public AdministratorLogin() {
		setTitle("관리자 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 785, 480);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("시술 관리", null, scrollPane_2, null);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(new Object[][] {},
                new String[] {"번호","종류","시간","가격"}));
		table_2.setEnabled(false);
		table_2.getTableHeader().setReorderingAllowed(false);
		table_2.getTableHeader().setResizingAllowed(false);
		
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("디자이너 관리", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
                new String[] {"아이디","비밀번호","생년월일","이름","성별","핸드폰번호","직급","급여","고용일","경력"}));

		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("회원 관리", null, scrollPane_1, null);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(new Object[][] {},
                new String[] {"아이디","비밀번호","생년월일","이름","성별","핸드폰번호","가입일","이용횟수","메모"}));
		table_1.setEnabled(false);
		table_1.getTableHeader().setReorderingAllowed(false);
		table_1.getTableHeader().setResizingAllowed(false);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		tabbedPane.addTab("예약 관리", null, scrollPane_3, null);
				
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		table_3.setModel(new DefaultTableModel(new Object[][] {},
                new String[] {"번호","날짜","시간","디자이너","회원","시술","결제금액","현금여부","예약상태","메모"}));
		table_3.setEnabled(false);
		table_3.getTableHeader().setReorderingAllowed(false);
		table_3.getTableHeader().setResizingAllowed(false);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 481, 780, 80);
		contentPane.add(panel);
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{450, 57, 57, 57, 57, 50, 0};
		gbl_panel.rowHeights = new int[]{5, 23, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton = new JButton("등록");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = tabbedPane.getSelectedIndex();
				switch (sel) {
				case 0 :
					MenuInsert menuInsertdialog = new MenuInsert();
					menuInsertdialog.setVisible(true);
					break;
				case 1 :
					DesignerInsert designerInsertdialog = new DesignerInsert();
					designerInsertdialog.setVisible(true);
					break;
				case 2 :
					MemberInsert memberInsertdialog = new MemberInsert();
					memberInsertdialog.setVisible(true);
					break;
				case 3 :
					ReservationInsert reservationInsertdialog = new ReservationInsert();
					reservationInsertdialog.setVisible(true);
					break;
				default:	
					break;
				}
			}
		});
				
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		panel.add(btnNewButton, gbc_btnNewButton);
				
		JButton btnNewButton_2 = new JButton("검색");
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = tabbedPane.getSelectedIndex();
				switch (sel) {
				case 0 :
					MenuSelect menuSelectdialog = new MenuSelect();
					menuSelectdialog.setVisible(true);
					break;
				case 1 :
					DesignerSelect designerSelectdialog = new DesignerSelect();
					designerSelectdialog.setVisible(true);
					break;
				case 2 :
					MemberSelect memberSelectdialog = new MemberSelect();
					memberSelectdialog.setVisible(true);
					break;
				case 3 :
					ReservationSelect reservationSelectdialog = new ReservationSelect();
					reservationSelectdialog.setVisible(true);
					break;
				default:					
					break;
				}
			}
		});
				
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 1;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
				
		JButton btnNewButton_3 = new JButton("수정");
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = tabbedPane.getSelectedIndex();
				switch (sel) {
				case 0 :
					MenuUpdate menuUpdatedialog = new MenuUpdate();
					menuUpdatedialog.setVisible(true);
					break;
				case 1 :
					DesignerUpdate designerUpdatedialog = new DesignerUpdate();
					designerUpdatedialog.setVisible(true);
					break;
				case 2 :
					MemberUpdate memberUpdatedialog = new MemberUpdate();
					memberUpdatedialog.setVisible(true);
					break;
				case 3 :
					ReservationUpdate reservationUpdatedialog = new ReservationUpdate();
					reservationUpdatedialog.setVisible(true);
					break;
				default:						
					break;
				}
			}
		});
				
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 3;
		gbc_btnNewButton_3.gridy = 1;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);
						
		JButton btnNewButton_1 = new JButton("삭제");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 1;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
	}
}
