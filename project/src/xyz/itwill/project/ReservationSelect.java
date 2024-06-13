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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ReservationSelect extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReservationSelect dialog = new ReservationSelect();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReservationSelect() {
		setTitle("예약 검색");
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
			JLabel lblNewLabel = new JLabel("예약 검색 (이름)");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 0, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 2;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
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
				    String name = textField.getText(); 
				    
				    if (name.trim().isEmpty()) { 
                        JOptionPane.showMessageDialog(this, "이름을 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
                    } else {                        
                        dispose();
                    }
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
