package xyz.itwill.project;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MenuUpdate extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField mpricetextField;
	private JTextField mvaluetextField;
	private JTextField mtimetextField;
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
			mvaluetextField = new JTextField();
			GridBagConstraints gbc_mvaluetextField = new GridBagConstraints();
			gbc_mvaluetextField.insets = new Insets(0, 0, 5, 5);
			gbc_mvaluetextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_mvaluetextField.gridx = 2;
			gbc_mvaluetextField.gridy = 2;
			contentPanel.add(mvaluetextField, gbc_mvaluetextField);
			mvaluetextField.setColumns(10);
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
			mtimetextField = new JTextField();
			GridBagConstraints gbc_mtimetextField = new GridBagConstraints();
			gbc_mtimetextField.insets = new Insets(0, 0, 5, 5);
			gbc_mtimetextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_mtimetextField.gridx = 2;
			gbc_mtimetextField.gridy = 3;
			contentPanel.add(mtimetextField, gbc_mtimetextField);
			mtimetextField.setColumns(10);
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
			mpricetextField = new JTextField();
			GridBagConstraints gbc_mpricetextField = new GridBagConstraints();
			gbc_mpricetextField.insets = new Insets(0, 0, 0, 5);
			gbc_mpricetextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_mpricetextField.gridx = 2;
			gbc_mpricetextField.gridy = 4;
			contentPanel.add(mpricetextField, gbc_mpricetextField);
			mpricetextField.setColumns(10);
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

					dispose();
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
			mvaluetextField.setText(String.valueOf(pushValue));
			mtimetextField.setText(String.valueOf(pushMtime));
			mpricetextField.setText(String.valueOf(pushPrice));
		}

//		this.pushValue = administratorLogin.pushValue;
//		this.pushMtime = administratorLogin.pushMtime;
//		this.pushPrice = administratorLogin.pushPrice;	
	}

}