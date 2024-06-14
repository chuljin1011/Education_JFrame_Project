package xyz.itwill.project.dao;

public class RsrrvtDTO {
	// 예약 테이블 칼럼 _ 10개
	private int rno;             // RSRRVT_MENU.NEXTVA
	private String rdate;
	private int rtime;
	private String rdid;
	private String rcid;
	private int menu_no;
	private int payment;
	private String cash;
	private String status;
	private String memo;
	
	// join 디자이너 테이블 칼럼
	private String dname;
	
	// join 고객 테이블 칼럼
	private String cname;
	
	// join 메뉴 테이블 칼럼
	private String mvalue;
	
	
	public RsrrvtDTO() {
		// TODO Auto-generated constructor stub
	}


	public RsrrvtDTO(int rno, String rdate, int rtime, String rdid, String rcid, int menu_no, int payment,
			String cash, String status, String dname, String cname, String mvalue, String memo) {
		super();
		this.rno = rno;
		this.rdate = rdate;
		this.rtime = rtime;
		this.rdid = rdid;
		this.rcid = rcid;
		this.menu_no = menu_no;
		this.payment = payment;
		this.cash = cash;
		this.status = status;
		this.memo = memo;
		this.dname = dname;
		this.cname = cname;
		this.mvalue = mvalue;
	}


	public int getRno() {
		return rno;
	}


	public void setRno(int rno) {
		this.rno = rno;
	}


	public String getRdate() {
		return rdate;
	}


	public void setRdate(String rdate) {
		this.rdate = rdate;
	}


	public int getRtime() {
		return rtime;
	}


	public void setRtime(int rtime) {
		this.rtime = rtime;
	}


	public String getRdid() {
		return rdid;
	}


	public void setRdid(String rdid) {
		this.rdid = rdid;
	}


	public String getRcid() {
		return rcid;
	}


	public void setRcid(String rcid) {
		this.rcid = rcid;
	}


	public int getMenu_no() {
		return menu_no;
	}


	public void setMenu_no(int menu_no) {
		this.menu_no = menu_no;
	}


	public int getPayment() {
		return payment;
	}


	public void setPayment(int payment) {
		this.payment = payment;
	}


	public String getCash() {
		return cash;
	}


	public void setCash(String cash) {
		this.cash = cash;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getMvalue() {
		return mvalue;
	}


	public void setMvalue(String mvalue) {
		this.mvalue = mvalue;
	}	

}
