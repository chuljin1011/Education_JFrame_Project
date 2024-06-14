package xyz.itwill.project;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import xyz.itwill.project.dao.RsrrvtDAO;
import xyz.itwill.project.dao.RsrrvtDTO;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ReservationInsert extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField rdateTF;
	private JTextField cnameTF;
	private JTextField memoTF;
	private JTextField rtimeTF;
	private JTextField dnameTF;
	private JTextField mvalueTF;
	private JTextField cashTF;

	/**
	 * Launch the application.
	 */
/*
	public static void main(String[] args) {
		try {
			ReservationInsert dialog = new ReservationInsert();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 */
	public ReservationInsert(AdministratorLogin administratorLogin) {
		setTitle("예약 등록");
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{100, 60, 150, 100, 0};
		gbl_contentPanel.rowHeights = new int[]{23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel_1 = new JLabel("예약 날짜");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 2;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			rdateTF = new JTextField();
			GridBagConstraints gbc_rdateTF = new GridBagConstraints();
			gbc_rdateTF.insets = new Insets(0, 0, 5, 5);
			gbc_rdateTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_rdateTF.gridx = 2;
			gbc_rdateTF.gridy = 2;
			contentPanel.add(rdateTF, gbc_rdateTF);
			rdateTF.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("예약 시간");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 3;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			rtimeTF = new JTextField();
			GridBagConstraints gbc_rtimeTF = new GridBagConstraints();
			gbc_rtimeTF.insets = new Insets(0, 0, 5, 5);
			gbc_rtimeTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_rtimeTF.gridx = 2;
			gbc_rtimeTF.gridy = 3;
			contentPanel.add(rtimeTF, gbc_rtimeTF);
			rtimeTF.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("예약 디자이너");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 4;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			dnameTF = new JTextField();
			GridBagConstraints gbc_dnameTF = new GridBagConstraints();
			gbc_dnameTF.insets = new Insets(0, 0, 5, 5);
			gbc_dnameTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_dnameTF.gridx = 2;
			gbc_dnameTF.gridy = 4;
			contentPanel.add(dnameTF, gbc_dnameTF);
			dnameTF.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("예약 회원");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 1;
			gbc_lblNewLabel_4.gridy = 5;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			cnameTF = new JTextField();
			GridBagConstraints gbc_cnameTF = new GridBagConstraints();
			gbc_cnameTF.insets = new Insets(0, 0, 5, 5);
			gbc_cnameTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_cnameTF.gridx = 2;
			gbc_cnameTF.gridy = 5;
			contentPanel.add(cnameTF, gbc_cnameTF);
			cnameTF.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("예약 시술");
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 1;
			gbc_lblNewLabel_5.gridy = 6;
			contentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		}
		{
			mvalueTF = new JTextField();
			GridBagConstraints gbc_mvalueTF = new GridBagConstraints();
			gbc_mvalueTF.insets = new Insets(0, 0, 5, 5);
			gbc_mvalueTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_mvalueTF.gridx = 2;
			gbc_mvalueTF.gridy = 6;
			contentPanel.add(mvalueTF, gbc_mvalueTF);
			mvalueTF.setColumns(10);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("현금 여부");
			GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
			gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_7.gridx = 1;
			gbc_lblNewLabel_7.gridy = 7;
			contentPanel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		}
		{
			cashTF = new JTextField();
			GridBagConstraints gbc_cashTF = new GridBagConstraints();
			gbc_cashTF.insets = new Insets(0, 0, 5, 5);
			gbc_cashTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_cashTF.gridx = 2;
			gbc_cashTF.gridy = 7;
			contentPanel.add(cashTF, gbc_cashTF);
			cashTF.setColumns(10);
		}
		{
			JLabel lblNewLabel_9 = new JLabel("메모");
			GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
			gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_9.gridx = 1;
			gbc_lblNewLabel_9.gridy = 8;
			contentPanel.add(lblNewLabel_9, gbc_lblNewLabel_9);
		}
		{
			memoTF = new JTextField();
			GridBagConstraints gbc_memoTF = new GridBagConstraints();
			gbc_memoTF.gridheight = 2;
			gbc_memoTF.insets = new Insets(0, 0, 5, 5);
			gbc_memoTF.fill = GridBagConstraints.BOTH;
			gbc_memoTF.gridx = 2;
			gbc_memoTF.gridy = 8;
			contentPanel.add(memoTF, gbc_memoTF);
			memoTF.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			GridBagLayout gbl_buttonPane = new GridBagLayout();
			gbl_buttonPane.columnWidths = new int[]{200, 57, 57, 0};
			gbl_buttonPane.rowHeights = new int[]{23, 23, 0};
			gbl_buttonPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_buttonPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			buttonPane.setLayout(gbl_buttonPane);
			{
				JButton okButton = new JButton("등록");
				okButton.setActionCommand("OK");
				GridBagConstraints gbc_okButton = new GridBagConstraints();
				gbc_okButton.anchor = GridBagConstraints.NORTHWEST;
				gbc_okButton.insets = new Insets(0, 0, 5, 5);
				gbc_okButton.gridx = 1;
				gbc_okButton.gridy = 0;
				buttonPane.add(okButton, gbc_okButton);
				getRootPane().setDefaultButton(okButton);
				
				okButton.addActionListener(e -> {
					addRsrrvt();
					administratorLogin.displayAllDesigner();
//				    dispose();
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
	public void addRsrrvt() {		
		String rdate=rdateTF.getText();
		
		if(rdate.equals("")) {
			JOptionPane.showMessageDialog(this, "예약 날짜를 입력해 주세요.");
			rdateTF.requestFocus();
			return;
		}
		String rtimeString=rtimeTF.getText();
		
		if(rtimeString.equals("")) {
			JOptionPane.showMessageDialog(this, "예약 시간을 입력해 주세요.");
			rtimeTF.requestFocus();
			return;
		}
		int rtime=Integer.parseInt(rtimeString);
		
		String dname=dnameTF.getText();
		
		if(dname.equals("")) {
			JOptionPane.showMessageDialog(this, "예약 디자이너를 입력해 주세요.");
			dnameTF.requestFocus();
			return;
		}
		String cname=cnameTF.getText();
		
		if(cname.equals("")) {
			JOptionPane.showMessageDialog(this, "예약 회원을 입력해 주세요.");
			cnameTF.requestFocus();
			return;
		}
		String mvalue=mvalueTF.getText();
		
		if(mvalue.equals("")) {
			JOptionPane.showMessageDialog(this, "예약 시술을 입력해 주세요.");
			mvalueTF.requestFocus();
			return;
		}
		String cash=cashTF.getText();
		
		if(cash.equals("")) {
			JOptionPane.showMessageDialog(this, "현금 여부를 입력해 주세요.");
			cashTF.requestFocus();
			return;
		}
		String memo=memoTF.getText();
		
		if(memo.equals("")) {
			JOptionPane.showMessageDialog(this, "메모를 입력해 주세요.");
			memoTF.requestFocus();
			return;
		}		
		RsrrvtDTO rsrrvt=new RsrrvtDTO();		
		
		rsrrvt.setRdate(rdate);
		rsrrvt.setRtime(rtime);
		rsrrvt.setDname(dname);
		rsrrvt.setCname(cname);
		rsrrvt.setMvalue(mvalue);
		rsrrvt.setCash(cash);
		rsrrvt.setMemo(memo);
		
		int rows=RsrrvtDAO.get_dao().insertRsrrvt(rsrrvt);
		
		if (rows > 0) {
		JOptionPane.showMessageDialog(this, rows+"개의 예약을 삽입하여 저장 하였습니다.");
		dispose();
		
		} else {
			JOptionPane.showMessageDialog(this, "입력 양식에 맞는 값을 입력해주세요");
		}		
		
		
	}
}
