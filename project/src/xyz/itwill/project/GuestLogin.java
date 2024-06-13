package xyz.itwill.project;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import xyz.itwill.project.dao.DesignerDAO;
import xyz.itwill.project.dao.DesignerDTO;
import xyz.itwill.project.dao.MenuDAO;
import xyz.itwill.project.dao.MenuDTO;

import java.awt.GridLayout;
import java.awt.Font;

public class GuestLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable mTable;
	private JTable dTable;


	public GuestLogin() {
		setTitle("비회원 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 570);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 500, 485);
		contentPane.add(tabbedPane);
		
		JScrollPane mScrollPane = new JScrollPane();
		tabbedPane.addTab("시술 검색", null, mScrollPane, null);
		
		mTable = new JTable();
		mScrollPane.setViewportView(mTable);
		mTable.setModel(new DefaultTableModel(new Object[][] {},
                new String[] {"종류","시술 시간","가격"}));
		mTable.setEnabled(false);
		mTable.getTableHeader().setReorderingAllowed(false);
		mTable.getTableHeader().setResizingAllowed(false);
		
		MenuAllDsigner();
		

		
		JScrollPane dScrollPane = new JScrollPane();
		tabbedPane.addTab("디자이너 검색", null, dScrollPane, null);
		
		dTable = new JTable();
		dScrollPane.setViewportView(dTable);
		dTable.setModel(new DefaultTableModel(new Object[][] {},
                new String[] {"이름","직급","경력"}));
		dTable.setEnabled(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 490, 500, 31);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("닫기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 13));
		btnNewButton.setBounds(393, 3, 95, 24);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("돌아가기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainLogin mainLogin = new MainLogin();
				mainLogin.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 13));
		btnNewButton_1.setBounds(295, 3, 95, 24);
		panel.add(btnNewButton_1);
		dTable.getTableHeader().setReorderingAllowed(false);
		dTable.getTableHeader().setResizingAllowed(false);
		
		DisplayAllDsigner();
				
	}	
	
	public void DisplayAllDsigner() {
		List<DesignerDTO> designerList = DesignerDAO.getDAO().selectDesignerAll();
		
		if(designerList.isEmpty()) {	//표 초기화 코드 제외 
			return;
		}
		
		DefaultTableModel defaultTableModel = (DefaultTableModel)dTable.getModel();
		
		for(DesignerDTO designer : designerList) {
			Vector<Object> rowData = new Vector<Object>();
			
			rowData.add(designer.getName());
			rowData.add(designer.getRank());
			rowData.add(designer.getCareer());
			
			defaultTableModel.addRow(rowData);
						
		}
			
	}
	
	public void MenuAllDsigner() {
		List<MenuDTO> menuList = MenuDAO.getDAO().selectMenuAll();
		
		if(menuList.isEmpty()) {	//표 초기화 코드 제외 
			return;
		}
		
		DefaultTableModel defaultTableModel = (DefaultTableModel)mTable.getModel();
		
		for(MenuDTO menu : menuList) {
			Vector<Object> rowData = new Vector<Object>();
			
			rowData.add(menu.getValue());
			rowData.add(menu.getMtime());
			rowData.add(menu.getPrice());
			
			defaultTableModel.addRow(rowData);
						
		}
			
	}
}
