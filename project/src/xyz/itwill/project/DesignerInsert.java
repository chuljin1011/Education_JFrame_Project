package xyz.itwill.project;

import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import xyz.itwill.project.dao.DesignerDAO;
import xyz.itwill.project.dao.DesignerDTO;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DesignerInsert extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField hire_dateTF;
	private JTextField salTF;
	private JTextField phoneTF;
	private JTextField nameTF;
	private JTextField birthTF;
	private JTextField idTF;
	private JTextField pwTF;
	private JTextField careerTF;
	private JTextField genderTF;   
    private JTextField rankTF;
      


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			DesignerInsert dialog = new DesignerInsert();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public DesignerInsert(AdministratorLogin administratorLogin) {
		setTitle("디자이너 등록");
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{100, 60, 75, 75, 100, 0};
		gbl_contentPanel.rowHeights = new int[]{23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("아이디");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			idTF = new JTextField();
			GridBagConstraints gbc_idTF = new GridBagConstraints();
			gbc_idTF.gridwidth = 2;
			gbc_idTF.insets = new Insets(0, 0, 5, 5);
			gbc_idTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_idTF.gridx = 2;
			gbc_idTF.gridy = 1;
			contentPanel.add(idTF, gbc_idTF);
			idTF.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("비밀번호");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 2;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			pwTF = new JTextField();
			GridBagConstraints gbc_pwTF = new GridBagConstraints();
			gbc_pwTF.gridwidth = 2;
			gbc_pwTF.insets = new Insets(0, 0, 5, 5);
			gbc_pwTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_pwTF.gridx = 2;
			gbc_pwTF.gridy = 2;
			contentPanel.add(pwTF, gbc_pwTF);
			pwTF.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("생년월일");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 3;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			birthTF = new JTextField();
			GridBagConstraints gbc_birthTF = new GridBagConstraints();
			gbc_birthTF.gridwidth = 2;
			gbc_birthTF.insets = new Insets(0, 0, 5, 5);
			gbc_birthTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_birthTF.gridx = 2;
			gbc_birthTF.gridy = 3;
			contentPanel.add(birthTF, gbc_birthTF);
			birthTF.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("이름");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 4;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			nameTF = new JTextField();
			GridBagConstraints gbc_nameTF = new GridBagConstraints();
			gbc_nameTF.gridwidth = 2;
			gbc_nameTF.insets = new Insets(0, 0, 5, 5);
			gbc_nameTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_nameTF.gridx = 2;
			gbc_nameTF.gridy = 4;
			contentPanel.add(nameTF, gbc_nameTF);
			nameTF.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("성별");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 1;
			gbc_lblNewLabel_4.gridy = 5;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}		
		{
			genderTF = new JTextField();
			GridBagConstraints gbc_genderTF = new GridBagConstraints();
			gbc_genderTF.gridwidth = 2;
			gbc_genderTF.insets = new Insets(0, 0, 5, 5);
			gbc_genderTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_genderTF.gridx = 2;
			gbc_genderTF.gridy = 5;
			contentPanel.add(genderTF, gbc_genderTF);
			genderTF.setColumns(10);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("핸드폰 번호");
			GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
			gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_8.gridx = 1;
			gbc_lblNewLabel_8.gridy = 6;
			contentPanel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		}
		{
			phoneTF = new JTextField();
			GridBagConstraints gbc_phoneTF = new GridBagConstraints();
			gbc_phoneTF.gridwidth = 2;
			gbc_phoneTF.insets = new Insets(0, 0, 5, 5);
			gbc_phoneTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_phoneTF.gridx = 2;
			gbc_phoneTF.gridy = 6;
			contentPanel.add(phoneTF, gbc_phoneTF);
			phoneTF.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("직급");
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 1;
			gbc_lblNewLabel_5.gridy = 7;
			contentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		}		
		{
			rankTF = new JTextField();
			GridBagConstraints gbc_rankTF = new GridBagConstraints();
			gbc_rankTF.gridwidth = 2;
			gbc_rankTF.insets = new Insets(0, 0, 5, 5);
			gbc_rankTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_rankTF.gridx = 2;
			gbc_rankTF.gridy = 7;
			contentPanel.add(rankTF, gbc_rankTF);
			rankTF.setColumns(10);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("급여");
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_6.gridx = 1;
			gbc_lblNewLabel_6.gridy = 8;
			contentPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		}
		{
			salTF = new JTextField();
			GridBagConstraints gbc_salTF = new GridBagConstraints();
			gbc_salTF.gridwidth = 2;
			gbc_salTF.insets = new Insets(0, 0, 5, 5);
			gbc_salTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_salTF.gridx = 2;
			gbc_salTF.gridy = 8;
			contentPanel.add(salTF, gbc_salTF);
			salTF.setColumns(10);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("고용일");
			GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
			gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_7.gridx = 1;
			gbc_lblNewLabel_7.gridy = 9;
			contentPanel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		}
		{
			hire_dateTF = new JTextField();
			GridBagConstraints gbc_hire_dateTF = new GridBagConstraints();
			gbc_hire_dateTF.gridwidth = 2;
			gbc_hire_dateTF.insets = new Insets(0, 0, 5, 5);
			gbc_hire_dateTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_hire_dateTF.gridx = 2;
			gbc_hire_dateTF.gridy = 9;
			contentPanel.add(hire_dateTF, gbc_hire_dateTF);
			hire_dateTF.setColumns(10);
		}
		{
			JLabel lblNewLabel_9 = new JLabel("경력");
			GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
			gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_9.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_9.gridx = 1;
			gbc_lblNewLabel_9.gridy = 10;
			contentPanel.add(lblNewLabel_9, gbc_lblNewLabel_9);
		}
		{
			careerTF = new JTextField();
			GridBagConstraints gbc_careerTF = new GridBagConstraints();
			gbc_careerTF.gridwidth = 2;
			gbc_careerTF.insets = new Insets(0, 0, 0, 5);
			gbc_careerTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_careerTF.gridx = 2;
			gbc_careerTF.gridy = 10;
			contentPanel.add(careerTF, gbc_careerTF);
			careerTF.setColumns(10);
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
				gbc_okButton.insets = new Insets(0, 0, 5, 5);
				gbc_okButton.gridx = 1;
				gbc_okButton.gridy = 0;
				buttonPane.add(okButton, gbc_okButton);
				getRootPane().setDefaultButton(okButton);
				
				okButton.addActionListener(e -> {
					addDesigner();
				    administratorLogin.displayAllDesigner();
//				    dispose();
				});
			}
			{
				JButton cancelButton = new JButton("취소");
				cancelButton.setActionCommand("Cancel");
				GridBagConstraints gbc_cancelButton = new GridBagConstraints();
				gbc_cancelButton.insets = new Insets(0, 0, 5, 0);
				gbc_cancelButton.gridx = 2;
				gbc_cancelButton.gridy = 0;
				buttonPane.add(cancelButton, gbc_cancelButton);
				
				cancelButton.addActionListener(e -> {
					dispose(); 
				});
			}
		}
	}
	
	public void addDesigner() {	
		String id=idTF.getText();
		
		if(id.equals("")) {
			JOptionPane.showMessageDialog(this, "아이디를 입력해 주세요.");
			idTF.requestFocus();
			return;
		}
		String pw=pwTF.getText();
		
		if(pw.equals("")) {
			JOptionPane.showMessageDialog(this, "비밀번호를 입력해 주세요.");
			pwTF.requestFocus();
			return;
		}
		String birth=birthTF.getText();
		
		if(birth.equals("")) {
			JOptionPane.showMessageDialog(this, "생년월일을 입력해 주세요.");
			birthTF.requestFocus();
			return;
		}
		String name=nameTF.getText();
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}		
		String gender=genderTF.getText();
		
		if(gender.equals("")) {
			JOptionPane.showMessageDialog(this, "성별을 입력해 주세요.");
			genderTF.requestFocus();
			return;
		}		
		
		String phone=phoneTF.getText();
		
		if(phone.equals("")) {
			JOptionPane.showMessageDialog(this, "핸드폰 번호를 입력해 주세요.");
			phoneTF.requestFocus();
			return;
		}
		String rank=rankTF.getText();
		
		if(rank.equals("")) {
			JOptionPane.showMessageDialog(this, "직급을 입력해 주세요.");
			rankTF.requestFocus();
			return;
		}
		String salString=salTF.getText();
		
		if(salString.equals("")) {
			JOptionPane.showMessageDialog(this, "급여를 입력해 주세요.");
			salTF.requestFocus();
			return;
		}
		int sal=Integer.parseInt(salString);
		
		String hire_date=hire_dateTF.getText();
		
		if(hire_date.equals("")) {
			JOptionPane.showMessageDialog(this, "고용일을 입력해 주세요.");
			hire_dateTF.requestFocus();
			return;
		}
		String careerString=careerTF.getText();
		
		if(careerString.equals("")) {
			JOptionPane.showMessageDialog(this, "경력을 입력해 주세요.");
			careerTF.requestFocus();
			return;
		}
		int career=Integer.parseInt(careerString);
		
		DesignerDTO designer=new DesignerDTO();		
		designer.setId(id);
		designer.setPw(pw);
		designer.setBirth(birth);
		designer.setName(name);
		designer.setGender(gender);
		designer.setPhone(phone);
		designer.setRank(rank);
		designer.setSal(sal);
		designer.setHire_date(hire_date);
		designer.setCareer(career);
		
		int rows=DesignerDAO.getDAO().insertDesigner(designer);
		
		if (rows > 0) {
		JOptionPane.showMessageDialog(this, rows+"명의 디자이너를 삽입하여 저장 하였습니다.");
		dispose();
		// TF 초기화
		idTF.setText("");
		pwTF.setText("");
		birthTF.setText("");
		nameTF.setText("");
		genderTF.setText("");
		phoneTF.setText("");
		rankTF.setText("");
		salTF.setText("");
		hire_dateTF.setText("");
		careerTF.setText("");
		
		} else {
			JOptionPane.showMessageDialog(this, "입력 양식에 맞는 값을 입력해주세요");
		}		
		

						
		
		
	}

}
