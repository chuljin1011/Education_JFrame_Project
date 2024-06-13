package xyz.itwill.project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JButton;

public class MainLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JCheckBox chckbxMember;
	private JCheckBox chckbxAdmin;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainLogin frame = new MainLogin();
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
	public MainLogin() {
		setTitle("메인 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{100, 57, 57, 57, 28, 28, 0};
		gbl_contentPane.rowHeights = new int[]{23, 23, 23, 23, 23, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("아이디");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		chckbxMember = new JCheckBox("회원");
		GridBagConstraints gbc_chckbxMember = new GridBagConstraints();
		gbc_chckbxMember.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMember.gridx = 2;
		gbc_chckbxMember.gridy = 3;
		contentPane.add(chckbxMember, gbc_chckbxMember);
		
		chckbxMember.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (chckbxMember.isSelected()) {
				    chckbxAdmin.setSelected(false);
		        }
		    }
		});
		
		chckbxAdmin = new JCheckBox("관리자");
		GridBagConstraints gbc_chckbxAdmin = new GridBagConstraints();
		gbc_chckbxAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAdmin.gridx = 3;
		gbc_chckbxAdmin.gridy = 3;
		contentPane.add(chckbxAdmin, gbc_chckbxAdmin);
		
		chckbxAdmin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (chckbxAdmin.isSelected()) {
		            chckbxMember.setSelected(false);
		        }
		    }
		});
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        dispose(); 
		    }
		});
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxMember.isSelected()) {									
				} else if(chckbxAdmin.isSelected()) {
					
				}
			}
		});
		
		btnNewButton_2 = new JButton("비회원");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 5;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuestLogin guestLogin = new GuestLogin();
                guestLogin.setVisible(true);
                setVisible(false);
            }
        });	
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 5;
		contentPane.add(btnNewButton, gbc_btnNewButton);		
		
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String username = textField.getText();
		        String password = textField_1.getText();
		    	
		    	if (username.trim().isEmpty() || password.trim().isEmpty()) {
		             JOptionPane.showMessageDialog(MainLogin.this, "아이디나 비밀번호를 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
		             return;
		    	}		    	
		    	
		        if (chckbxMember.isSelected()) {		            
		        	MemberLogin memberLogin = new MemberLogin();
		        	memberLogin.setVisible(true);
		        	setVisible(false);
		        } else if (chckbxAdmin.isSelected()) {		           
		        	AdministratorLogin administratorLogin = new AdministratorLogin();
		        	administratorLogin.setVisible(true);
		        	setVisible(false);
		        } else {
		            JOptionPane.showMessageDialog(MainLogin.this, "계정 유형을 반드시 선택하세요.", "경고", JOptionPane.WARNING_MESSAGE);
		        }
		    }
		});	
		
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 5;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		}

}
