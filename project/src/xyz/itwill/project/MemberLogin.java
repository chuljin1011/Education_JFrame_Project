package xyz.itwill.project;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;


public class MemberLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private String login_id;
	private String login_name;
 

	public MemberLogin(String login_id, String login_name) {
		
		// code 검증부

		this.login_id = login_id;
		this.login_name = login_name;
		System.out.println(login_id);
		System.out.println(login_name);
		
		//
		setTitle("회원 로그인");
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
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("시술 검색", null, scrollPane, null);
				
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
                new String[] {"종류","시술 시간","가격"}));
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("디자이너 검색", null, scrollPane_1, null);
			
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(new Object[][] {},
                new String[] {"이름","직급","경력"}));
		table_1.setEnabled(false);
		table_1.getTableHeader().setReorderingAllowed(false);
		table_1.getTableHeader().setResizingAllowed(false);
				
		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("예약", null, scrollPane_2, null);
		
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);		
		table_2.setModel(new DefaultTableModel(new Object[][] {},
                new String[] {"번호","날짜","시간","디자이너","회원","시술","결제금액","현금여부","예약상태","메모"}));
		table_2.setEnabled(false);
		table_2.getTableHeader().setReorderingAllowed(false);
		table_2.getTableHeader().setResizingAllowed(false);
				
		JPanel panel = new JPanel();
		panel.setBounds(0, 481, 780, 80);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 57, 57, 57, 57, 57, 50};
		gbl_panel.rowHeights = new int[]{5, 23, 23, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton_2 = new JButton("예약 ");
				
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = tabbedPane.getSelectedIndex();
				switch (sel) {
				case 0 :
					
				case 1 :
					
					break;
				case 2 :
					ReservationInsert reservationInsertdialog = new ReservationInsert();
					reservationInsertdialog.setVisible(true);
					break;
				default:						
					break;
				}
			}
		});
		
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 1;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("예약 확인");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = tabbedPane.getSelectedIndex();
				switch (sel) {
				case 0 :
					
				case 1 :
					
					break;
				case 2 :
					ReservationSelect reservationSelectdialog = new ReservationSelect();
					reservationSelectdialog.setVisible(true);
					break;
				default:						
					break;
				}
			}
		});
		
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 1;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton = new JButton("예약 변경");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = tabbedPane.getSelectedIndex();
				switch (sel) {
				case 0 :
					
				case 1 :
					
					break;
				case 2 :
					ReservationUpdate reservationUpdatedialog = new ReservationUpdate();
					reservationUpdatedialog.setVisible(true);
					break;
				default:						
					break;
				}
			}
		});
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 1;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_3 = new JButton("예약 취소");
		
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 4;
		gbc_btnNewButton_3.gridy = 1;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("검색");
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        int selectedIndex = tabbedPane.getSelectedIndex(); 
		        switch (selectedIndex) {
		            case 0:
		                MenuSelect menuSelect = new MenuSelect();
		                menuSelect.setVisible(true);
		                break;
		            case 1: 
		                DesignerSelect designerSelect = new DesignerSelect();
		                designerSelect.setVisible(true);
		                break;
		            default:
		                break;
		        }
		    }
		});
		
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 5;
		gbc_btnNewButton_4.gridy = 1;
		panel.add(btnNewButton_4, gbc_btnNewButton_4);
	
		btnNewButton_2.setVisible(false);
		btnNewButton_1.setVisible(false);
		btnNewButton.setVisible(false);
		btnNewButton_3.setVisible(false);
		
				
		tabbedPane.addChangeListener(new ChangeListener() {
		    public void stateChanged(ChangeEvent e) {
		        int selectedIndex = tabbedPane.getSelectedIndex();
		        if (selectedIndex == 0 || selectedIndex == 1) {
		            btnNewButton_2.setVisible(false); 
		            btnNewButton_1.setVisible(false); 
		            btnNewButton.setVisible(false);
		            btnNewButton_3.setVisible(false); 
		            btnNewButton_4.setVisible(true); 
		        } else if (selectedIndex == 2) {
		            btnNewButton_2.setVisible(true); 
		            btnNewButton_1.setVisible(true); 
		            btnNewButton.setVisible(true); 
		            btnNewButton_3.setVisible(true); 
		            btnNewButton_4.setVisible(false); 
		        }
		    }
		});		
	}			
}