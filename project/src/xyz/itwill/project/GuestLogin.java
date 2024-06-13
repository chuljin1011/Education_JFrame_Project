package xyz.itwill.project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GuestLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestLogin frame = new GuestLogin();
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
	public GuestLogin() {
		setTitle("비회원 로그인");
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
		
				
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 482, 780, 79);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{600, 57, 50, 0};
		gbl_panel.rowHeights = new int[]{5, 23, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton = new JButton("검색");
		
		btnNewButton.addActionListener(new ActionListener() {
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
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		panel.add(btnNewButton, gbc_btnNewButton);
				
	}	
}
