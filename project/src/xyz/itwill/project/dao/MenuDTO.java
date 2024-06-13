package xyz.itwill.project.dao;

public class MenuDTO {
	private int mno;
	private String value;
	private int mtime;
	private int price;
	
	public MenuDTO() {
		// TODO Auto-generated constructor stub
	}

	public MenuDTO(int mno, String value, int mtime, int price) {
		super();
		this.mno = mno;
		this.value = value;
		this.mtime = mtime;
		this.price = price;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getMtime() {
		return mtime;
	}

	public void setMtime(int mtime) {
		this.mtime = mtime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
