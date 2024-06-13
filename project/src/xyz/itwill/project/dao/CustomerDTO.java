package xyz.itwill.project.dao;

public class CustomerDTO {
	private String id;
	private String pw;
	private String birth;
	private String name;
	private String gender;
	private String phone;
	private String join_date;
	private int used_count;
	private String memo;
	
	public CustomerDTO() {
		// TODO Auto-generated constructor stub
	}	

	public CustomerDTO(String id, String pw, String birth, String name, String gender, String phone, String join_date,
			int used_count, String memo) {
		super();
		this.id = id;
		this.pw = pw;
		this.birth = birth;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.join_date = join_date;
		this.used_count = used_count;
		this.memo = memo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getJoin_date() {
		return join_date;
	}

	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}

	public int getUsed_count() {
		return used_count;
	}

	public void setUsed_count(int used_count) {
		this.used_count = used_count;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
