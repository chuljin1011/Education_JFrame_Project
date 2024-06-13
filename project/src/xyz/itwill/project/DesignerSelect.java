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
import javax.swing.JComboBox;

public class DesignerSelect extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DesignerSelect dialog = new DesignerSelect();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DesignerSelect() {
		setTitle("디자이너 검색");
		setBounds(100, 100, 400, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{80, 130, 80, 0};
		gbl_contentPanel.rowHeights = new int[]{23, 33, 23, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("디자이너 검색");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JComboBox comboBox = new JComboBox();
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 0, 5);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 2;
			contentPanel.add(comboBox, gbc_comboBox);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			GridBagLayout gbl_buttonPane = new GridBagLayout();
			gbl_buttonPane.columnWidths = new int[]{130, 40, 40, 0};
			gbl_buttonPane.rowHeights = new int[]{23, 23, 23, 23, 0};
			gbl_buttonPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_buttonPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			buttonPane.setLayout(gbl_buttonPane);
			{
				JButton okButton = new JButton("검색");
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
	}

}
