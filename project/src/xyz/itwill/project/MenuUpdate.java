package xyz.itwill.project;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import xyz.itwill.project.dao.MenuDAO;
import xyz.itwill.project.dao.MenuDTO;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MenuUpdate extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField priceTF;
	private JTextField valueTF;
	private JTextField mtimeTF;
	private JTextField mnotextField;

	// 시술 변경 변수 //
	int pushMno;
	String pushValue;
	int pushMtime;
	int pushPrice;

	public MenuUpdate(AdministratorLogin administratorLogin) {
		setTitle("시술 수정");
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 100, 60, 150, 100, 0 };
		gbl_contentPanel.rowHeights = new int[] { 23, 23, 23, 23, 23, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };

		// 메인프레임 필드 전달
		this.pushMno = administratorLogin.pushMno;
		this.pushValue = administratorLogin.pushValue;
		this.pushMtime = administratorLogin.pushMtime;
		this.pushPrice = administratorLogin.pushPrice;

		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("시술 번호");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			mnotextField = new JTextField();
			mnotextField.setEditable(false);
			GridBagConstraints gbc_mnotextField = new GridBagConstraints();
			gbc_mnotextField.insets = new Insets(0, 0, 5, 5);
			gbc_mnotextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_mnotextField.gridx = 2;
			gbc_mnotextField.gridy = 1;
			contentPanel.add(mnotextField, gbc_mnotextField);
			mnotextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("시술 종류");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 2;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			valueTF = new JTextField();
			GridBagConstraints gbc_valueTF = new GridBagConstraints();
			gbc_valueTF.insets = new Insets(0, 0, 5, 5);
			gbc_valueTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_valueTF.gridx = 2;
			gbc_valueTF.gridy = 2;
			contentPanel.add(valueTF, gbc_valueTF);
			valueTF.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("시술 시간");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 3;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			mtimeTF = new JTextField();
			GridBagConstraints gbc_mtimeTF = new GridBagConstraints();
			gbc_mtimeTF.insets = new Insets(0, 0, 5, 5);
			gbc_mtimeTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_mtimeTF.gridx = 2;
			gbc_mtimeTF.gridy = 3;
			contentPanel.add(mtimeTF, gbc_mtimeTF);
			mtimeTF.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("시술 가격");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 4;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			priceTF = new JTextField();
			GridBagConstraints gbc_priceTF = new GridBagConstraints();
			gbc_priceTF.insets = new Insets(0, 0, 0, 5);
			gbc_priceTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_priceTF.gridx = 2;
			gbc_priceTF.gridy = 4;
			contentPanel.add(priceTF, gbc_priceTF);
			priceTF.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			GridBagLayout gbl_buttonPane = new GridBagLayout();
			gbl_buttonPane.columnWidths = new int[] { 200, 57, 57, 0 };
			gbl_buttonPane.rowHeights = new int[] { 23, 23, 23, 23, 23, 23, 23, 0 };
			gbl_buttonPane.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_buttonPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			buttonPane.setLayout(gbl_buttonPane);
			{
				JButton okButton = new JButton("수정");
				okButton.setActionCommand("OK");
				GridBagConstraints gbc_okButton = new GridBagConstraints();
				gbc_okButton.anchor = GridBagConstraints.NORTHWEST;
				gbc_okButton.insets = new Insets(0, 0, 5, 5);
				gbc_okButton.gridx = 1;
				gbc_okButton.gridy = 0;
				buttonPane.add(okButton, gbc_okButton);
				getRootPane().setDefaultButton(okButton);

				okButton.addActionListener(e -> {
					updateMenu();
					administratorLogin.displayAllMenu();
//					dispose();
				});
			}
			{
				JButton cancelButton = new JButton("취소");
				cancelButton.setActionCommand("Cancel");
				GridBagConstraints gbc_cancelButton = new GridBagConstraints();
				gbc_cancelButton.insets = new Insets(0, 0, 5, 0);
				gbc_cancelButton.anchor = GridBagConstraints.NORTHWEST;
				gbc_cancelButton.gridx = 2;
				gbc_cancelButton.gridy = 0;
				buttonPane.add(cancelButton, gbc_cancelButton);

				cancelButton.addActionListener(e -> {
					dispose();
				});
			}
		}

		if (pushMno != 0) {
			mnotextField.setText(String.valueOf(pushMno));
			valueTF.setText(String.valueOf(pushValue));
			mtimeTF.setText(String.valueOf(pushMtime));
			priceTF.setText(String.valueOf(pushPrice));
		}

//		this.pushValue = administratorLogin.pushValue;
//		this.pushMtime = administratorLogin.pushMtime;
//		this.pushPrice = administratorLogin.pushPrice;	
	}

	public void updateMenu() {

		String value = valueTF.getText();

		if (value.equals("")) {
			JOptionPane.showMessageDialog(this, "시술 종류를 입력해 주세요.");
			valueTF.requestFocus();
			return;
		}

		String mtimeString = mtimeTF.getText();

		if (mtimeString.equals("")) {
			JOptionPane.showMessageDialog(this, "시술 시간을 입력해 주세요.");
			mtimeTF.requestFocus();
			return;
		}

		int mtime = Integer.parseInt(mtimeString);

		String priceString = priceTF.getText();

		if (priceString.equals("")) {
			JOptionPane.showMessageDialog(this, "시술 가격을 입력해 주세요.");
			priceTF.requestFocus();
			return;
		}

		int price = Integer.parseInt(priceString);

		MenuDTO menu = new MenuDTO();
		menu.setValue(value);
		menu.setMtime(mtime);
		menu.setPrice(price);
		menu.setMno(pushMno);

		int rows = MenuDAO.getDAO().updateMenu(menu);

		if (rows > 0) {
			JOptionPane.showMessageDialog(this, rows + "개의 시술을 수정 하였습니다.");
			dispose();
			// TF 초기화
			valueTF.setText("");
			mtimeTF.setText("");
			priceTF.setText("");

		} else {
			JOptionPane.showMessageDialog(this, "입력 양식에 맞는 값을 입력해주세요");
		}

	}

}