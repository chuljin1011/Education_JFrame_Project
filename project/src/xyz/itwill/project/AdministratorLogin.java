package xyz.itwill.project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import xyz.itwill.project.dao.MemberDAO;
import xyz.itwill.project.dao.MemberDTO;
import xyz.itwill.project.dao.DesignerDAO;
import xyz.itwill.project.dao.DesignerDTO;
import xyz.itwill.project.dao.MenuDAO;
import xyz.itwill.project.dao.MenuDTO;
import xyz.itwill.project.dao.RsrrvtDAO;
import xyz.itwill.project.dao.RsrrvtDTO;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;


import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;


public class AdministratorLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable mTable;
	private JTable table_3;
	
	// Insert Frame
	MenuInsert menuInsertdialog;
	DesignerInsert designerInsertdialog;
	MemberInsert memberInsertdialog;
	ReservationInsert reservationInsertdialog;
	
	// Update Frame
	MenuUpdate menuUpdatedialog;
	DesignerUpdate designerUpdatedialog;
	MemberUpdate memberUpdatedialog;
	ReservationUpdate reservationUpdatedialog;
	
	// 시술 변경 변수 //
	int pushMno;
	String pushValue;
	int pushMtime;
	int pushPrice;
	private JTextField textField;
	
	// 디자이너 변경 변수 //
	
	

	
	// 회원 변경 변수 //

	
	// 예약 변경 변수 //

	
	 
	
	 
	
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
		
		// insert Frame
		menuInsertdialog = new MenuInsert(this);
		designerInsertdialog = new DesignerInsert(this);
		memberInsertdialog =new MemberInsert(this);
		reservationInsertdialog = new ReservationInsert(this);
		
		//update Frame
		menuUpdatedialog = new MenuUpdate(this);
		designerUpdatedialog = new DesignerUpdate(this);
		memberUpdatedialog = new MemberUpdate();
		reservationUpdatedialog = new ReservationUpdate();
				
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 785, 480);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("시술 관리", null, scrollPane_2, null);
		
		mTable = new JTable();
		scrollPane_2.setViewportView(mTable);
		mTable.setModel(new DefaultTableModel(new Object[][] {},
                new String[] {"번호","종류","시간","가격"}));
		mTable.getTableHeader().setReorderingAllowed(false);
		mTable.getTableHeader().setResizingAllowed(false);
		mTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int selectedRow = mTable.getSelectedRow();

						Integer mno = (Integer) (mTable.getValueAt(selectedRow, 0));
						String value = (String) (mTable.getValueAt(selectedRow, 1));
						Integer mtime = (Integer) (mTable.getValueAt(selectedRow, 2));
						Integer price = (Integer) (mTable.getValueAt(selectedRow, 3));

						pushMno = mno;
						pushValue = value;
						pushMtime = mtime;
						pushPrice = price;
						
						

					
				}
			}
		});
		
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("디자이너 관리", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
                new String[] {"아이디","비밀번호","생년월일","이름","성별","핸드폰번호","직급","급여","고용일","경력"}));
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(150); 
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("회원 관리", null, scrollPane_1, null);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(new Object[][] {},
                new String[] {"아이디","비밀번호","생년월일","이름","성별","핸드폰번호","가입일","이용횟수","메모"}));
		table_1.getTableHeader().setReorderingAllowed(false);
		table_1.getTableHeader().setResizingAllowed(false);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(150);
		table_1.getColumnModel().getColumn(8).setPreferredWidth(150);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		tabbedPane.addTab("예약 관리", null, scrollPane_3, null);
				
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		table_3.setModel(new DefaultTableModel(new Object[][] {},
                new String[] {"번호","날짜","시간","디자이너","회원","시술","결제금액","현금여부","예약상태","메모"}));
		table_3.getTableHeader().setReorderingAllowed(false);
		table_3.getTableHeader().setResizingAllowed(false);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 481, 780, 80);
		contentPane.add(panel);
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{50, 150, 57, 200, 57, 57, 57, 50, 0};
		gbl_panel.rowHeights = new int[]{5, 23, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton_2 = new JButton("검색");
	
		btnNewButton_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int sel = tabbedPane.getSelectedIndex();
		        String searchText = textField.getText().trim(); 
		        
		        switch (sel) {
		            case 0:
		                DefaultTableModel menuTableModel = (DefaultTableModel) mTable.getModel();
		                performTableSearch(menuTableModel, searchText,0);
		                break;
		            case 1:		                
		                DefaultTableModel designerTableModel = (DefaultTableModel) table.getModel();
		                performTableSearch(designerTableModel, searchText,0);
		                break;
		            case 2:		               
		                DefaultTableModel memberTableModel = (DefaultTableModel) table_1.getModel();
		                performTableSearch(memberTableModel, searchText,0);
		                break;
		            case 3:		              
		                DefaultTableModel reservationTableModel = (DefaultTableModel) table_3.getModel();
		                performTableSearch(reservationTableModel, searchText,0);
		                break;
		            default:		               
		                break;
		        }
		        textField.setText("");
		    }
		});		
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
				
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 1;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
				
		JButton btnNewButton_3 = new JButton("수정");
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = tabbedPane.getSelectedIndex();
				switch (sel) {
				case 0 :
					menuUpdatedialog = new MenuUpdate(AdministratorLogin.this);
					menuUpdatedialog.setVisible(true);
					break;
				case 1 :
					designerUpdatedialog = new DesignerUpdate(AdministratorLogin.this);
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
		
		JButton btnNewButton = new JButton("등록");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel = tabbedPane.getSelectedIndex();
				switch (sel) {
				case 0 :
//					MenuInsert menuInsertdialog = new MenuInsert();
					menuInsertdialog.setVisible(true);					
					break;
				case 1 :
//					DesignerInsert designerInsertdialog = new DesignerInsert();
					designerInsertdialog.setVisible(true);
					break;
				case 2 :
//					MemberInsert memberInsertdialog = new MemberInsert();
					memberInsertdialog.setVisible(true);
					break;
				case 3 :
//					ReservationInsert reservationInsertdialog = new ReservationInsert();
					reservationInsertdialog.setVisible(true);
					break;
				default:	
					break;
				}
			}
		});
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 1;
		panel.add(btnNewButton, gbc_btnNewButton);
				
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 5;
		gbc_btnNewButton_3.gridy = 1;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);
						
		JButton btnNewButton_1 = new JButton("삭제");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 6;
		gbc_btnNewButton_1.gridy = 1;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("(번호나 아이디를 입력하세요)");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		btnNewButton_1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            int sel = tabbedPane.getSelectedIndex();
	            switch (sel) {
	                case 0:
	                    int selectedMenuRow = mTable.getSelectedRow();
	                    if (selectedMenuRow != -1) {
	                        int mno = (int) mTable.getValueAt(selectedMenuRow, 0);
	                        removeMenu(mno);
	                    } else {
	                        JOptionPane.showMessageDialog(null, "삭제할 메뉴를 선택해주세요.");
	                    }
	                    break;
	                case 1:
	                	int selectedDesignerRow = table.getSelectedRow();
	                    if (selectedDesignerRow != -1) {
	                    	String id = (String) table.getValueAt(selectedDesignerRow, 0);
	                        removedesigner(id);
	                    } else {
	                        JOptionPane.showMessageDialog(null, "삭제할 디자이너를 선택해주세요.");
	                    }
	                    break;
	                case 2:
	                	int selectedMemberRow = table_1.getSelectedRow();
	                    if (selectedMemberRow != -1) {
	                    	String id = (String) table_1.getValueAt(selectedMemberRow, 0);
	                        removeMember(id);
	                    } else {
	                        JOptionPane.showMessageDialog(null, "삭제할 회원을 선택해주세요.");
	                    }
	                    break;
	                case 3:
	                	int selectedRsrrvtRow = table_3.getSelectedRow();
	                    if (selectedRsrrvtRow != -1) {
	                    	int rno= (int) table_3.getValueAt(selectedRsrrvtRow, 0);
	                        removeRsrrvt(rno);
	                    } else {
	                        JOptionPane.showMessageDialog(null, "삭제할 예약을 선택해주세요.");
	                    }
	                    break;
	                default:
	                    break;
	            }
	        }
		});		
		
		displayAllMenu();
		displayAllDesigner();
		displayAllmember();	
		displayAllRsrrvt();
	}		
	
	private void performTableSearch(DefaultTableModel tableModel, String searchText, int columnIndex) {
	    if (searchText.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(this, "검색 정보를 입력해 주세요.");
	        textField.requestFocus();
	        return;
	    }

	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);

	    try {
	        sorter.setRowFilter(RowFilter.regexFilter("(?i).*" + searchText + ".*", columnIndex));
	        if (tableModel == mTable.getModel()) {
	            mTable.setRowSorter(sorter);
	        } else if (tableModel == table.getModel()) {
	            table.setRowSorter(sorter);
	        } else if (tableModel == table_1.getModel()) {
	            table_1.setRowSorter(sorter);
	        } else if (tableModel == table_3.getModel()) {
	            table_3.setRowSorter(sorter);
	        }
	        
	        JOptionPane.showMessageDialog(this, "검색을 완료했습니다.");

	    } catch (java.util.regex.PatternSyntaxException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "유효하지 않은 검색어입니다.");
	        textField.requestFocus();
	    }
	   
	    if (sorter.getViewRowCount() == 0) {
	        JOptionPane.showMessageDialog(this, "검색 결과가 없습니다.");
	    }
	}

		
	public void displayAllMenu() {
		List<MenuDTO> MenuList=MenuDAO.getDAO().selectMenuAll();
		if(MenuList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "저장된 시술 정보가 없습니다.");
			return;
		}		
		
		DefaultTableModel defaultTableModel=(DefaultTableModel)mTable.getModel();
		
		defaultTableModel.setNumRows(0);
				
		for(MenuDTO menu : MenuList) {
			
			Vector<Object> rowData=new Vector<Object>();
			
			rowData.add(menu.getMno());
			rowData.add(menu.getValue());
			rowData.add(menu.getMtime());
			rowData.add(menu.getPrice());
			
			defaultTableModel.addRow(rowData);
		}
	}
	
	public void displayAllDesigner() {
		List<DesignerDTO> DesignerList=DesignerDAO.getDAO().selectDesignerAll();
		if(DesignerList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "저장된 디자이너 정보가 없습니다.");
			return;
		}
		
		DefaultTableModel defaultTableModel=(DefaultTableModel)table.getModel();
		
		defaultTableModel.setNumRows(0);
				
		for(DesignerDTO designer : DesignerList) {
			
			Vector<Object> rowData=new Vector<Object>();
			
			rowData.add(designer.getId());
			rowData.add(designer.getPw());
			rowData.add(designer.getBirth().substring(0, 10));
			rowData.add(designer.getName());
			rowData.add(designer.getGender());
			rowData.add(designer.getPhone());
			rowData.add(designer.getRank());
			rowData.add(designer.getSal());
			rowData.add(designer.getHire_date().substring(0, 10));
			rowData.add(designer.getCareer());
			
			defaultTableModel.addRow(rowData);
		}
	}
	
	public void displayAllmember() {
		List<MemberDTO> memberList=MemberDAO.getDAO().selectMemberAll();
		if(memberList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "저장된 회원 정보가 없습니다.");
			return;
		}
		
		DefaultTableModel defaultTableModel=(DefaultTableModel)table_1.getModel();
				
		for(MemberDTO member : memberList) {
			
			Vector<Object> rowData=new Vector<Object>();
			
			rowData.add(member.getId());
			rowData.add(member.getPw());
			rowData.add(member.getBirth().substring(0, 10));
			rowData.add(member.getName());
			rowData.add(member.getGender());
			rowData.add(member.getPhone());
			rowData.add(member.getJoin_date().substring(0, 10));
			rowData.add(member.getUsed_count());
			rowData.add(member.getMemo());
						
			defaultTableModel.addRow(rowData);
		}
	}	
	
	public void displayAllRsrrvt() {
		List<RsrrvtDTO> rsrrvtList = RsrrvtDAO.get_dao().selectRsrrvtAll();
		if (rsrrvtList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "저장된 예약 정보가 없습니다.");
			return;
		}

		DefaultTableModel defaultTableModel = (DefaultTableModel) table_3.getModel();

		for (RsrrvtDTO rsrrvt : rsrrvtList) {
			
			Vector<Object> rowData = new Vector<Object>();

			rowData.add(rsrrvt.getRno());
			rowData.add(rsrrvt.getRdate());
			rowData.add(rsrrvt.getRtime());
			rowData.add(rsrrvt.getDname());
			rowData.add(rsrrvt.getCname());
			rowData.add(rsrrvt.getMvalue());
			rowData.add(rsrrvt.getPayment());
			rowData.add(rsrrvt.getCash());
			rowData.add(rsrrvt.getStatus());
			rowData.add(rsrrvt.getMemo());

			defaultTableModel.addRow(rowData);

		}
	}
	
	public void removeMenu(int mno) {
		int rows=MenuDAO.getDAO().deleteMenu(mno);
        	
		if(rows > 0) {
			JOptionPane.showMessageDialog(null, rows+"개의 메뉴 정보를 삭제 하였습니다.");
			DefaultTableModel defaultTableModel=(DefaultTableModel)mTable.getModel();
			defaultTableModel.setNumRows(0);	
			displayAllMenu();
			
		} else {
			JOptionPane.showMessageDialog(null, "삭제할 번호의 메뉴 정보를 찾을 수 없습니다.");
		}
        
	}
	public void removedesigner(String id) {
		int rows=DesignerDAO.getDAO().deleteDesigner(id);
        	
		if(rows > 0) {
			JOptionPane.showMessageDialog(null, rows+"개의 디자이너 정보를 삭제 하였습니다.");
			DefaultTableModel defaultTableModel=(DefaultTableModel)table.getModel();
			defaultTableModel.setNumRows(0);
			displayAllDesigner();
			
		} else {
			JOptionPane.showMessageDialog(null, "삭제할 아이디의 디자이너 정보를 찾을 수 없습니다.");
		}
	}
	public void removeMember(String id) {
		int rows=MemberDAO.getDAO().deleteMember(id);
        	
		if(rows > 0) {
			JOptionPane.showMessageDialog(null, rows+"개의 회원	정보를 삭제 하였습니다.");
			DefaultTableModel defaultTableModel=(DefaultTableModel)table_1.getModel();
			defaultTableModel.setNumRows(0);
			displayAllmember();	
			
		} else {
			JOptionPane.showMessageDialog(null, "삭제할 아이디의 회원 정보를 찾을 수 없습니다.");
		}
	}
	public void removeRsrrvt(int rno) {
		int rows=RsrrvtDAO.get_dao().deleteRsrrvt(rno);
        	
		if(rows > 0) {
			JOptionPane.showMessageDialog(null, rows+"개의 예약 정보를 삭제 하였습니다.");
			DefaultTableModel defaultTableModel=(DefaultTableModel)table_3.getModel();
			defaultTableModel.setNumRows(0);
			displayAllRsrrvt();
			
		} else {
			JOptionPane.showMessageDialog(null, "삭제할 날짜의 예약 정보를 찾을 수 없습니다.");
		}
	}	
}