package xyz.itwill.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RsrrvtDAO extends JdbcDAO {
	private static RsrrvtDAO _dao;

	public RsrrvtDAO() {
		// TODO Auto-generated constructor stub
	}

	static {
		_dao = new RsrrvtDAO();
	}

	public static RsrrvtDAO get_dao() {
		return _dao;
	}

	// 예약 추가
	public int insertRsrrvt(RsrrvtDTO rsrrvt) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;

		try {
			con = getConnection();

			String sql = "insert into rsrrvt values(RSRRVT_MENU.NEXTVA,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, rsrrvt.getRdate());
			pstmt.setInt(2, rsrrvt.getRtime());
			pstmt.setString(3, rsrrvt.getRdid());
			pstmt.setString(4, rsrrvt.getRcid());
			pstmt.setString(5, rsrrvt.getMenu_no());
			pstmt.setInt(6, rsrrvt.getPayment());
			pstmt.setString(7, rsrrvt.getCash());
			pstmt.setString(8, rsrrvt.getStatus());
			pstmt.setString(9, rsrrvt.getMemo());

			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertRsrrvt() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	// 예약 수정
	public int updateRsrrvt(RsrrvtDTO rsrrvt) {
		Connection con = null;
		PreparedStatement pstmt = null;

		int rows = 0;

		try {
			con = getConnection();

			String sql = "update rsrrvt set rdate=?,rtime=?,rdid=?,rcid=?,menu_no=?,payment=?,cash=?,status=?,memo=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, rsrrvt.getRdate());
			pstmt.setInt(2, rsrrvt.getRtime());
			pstmt.setString(3, rsrrvt.getRdid());
			pstmt.setString(4, rsrrvt.getRcid());
			pstmt.setString(5, rsrrvt.getMenu_no());
			pstmt.setInt(6, rsrrvt.getPayment());
			pstmt.setString(7, rsrrvt.getCash());
			pstmt.setString(8, rsrrvt.getStatus());
			pstmt.setString(9, rsrrvt.getMemo());

			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateRsrrvt() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	// 단일 검색 _ rno
	public RsrrvtDTO selectRsrrvtbyRno(int rno) {
		Connection con = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		RsrrvtDTO rsrrvt = null;

		try {
			con = getConnection();

			String sql = "select rno,rdate,rtime,designer.name dname,customer.name cname,menu.value mvalue,payment,cash,status,rsrrvt.memo memo from rsrrvt join customer on customer.id = rsrrvt.rcid join designer on designer.id = rsrrvt.rdid join menu on menu.mno = rsrrvt.menu_no where rno = ? order by rdate desc, rtime desc";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, rno);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				rsrrvt = new RsrrvtDTO();

				rsrrvt.setRno(rs.getInt("rno"));
				rsrrvt.setRdate(rs.getString("rdate").substring(0, 11));
				rsrrvt.setRtime(rs.getInt("rtime"));
				rsrrvt.setRdid(rs.getString("rdid"));
				rsrrvt.setRcid(rs.getString("rcid"));
				rsrrvt.setMenu_no(rs.getString("menu_no"));
				rsrrvt.setPayment(rs.getInt("payment"));
				rsrrvt.setCash(rs.getString("cash"));
				rsrrvt.setStatus(rs.getString("status"));
				rsrrvt.setMemo(rs.getString("memo"));

			}

		} catch (SQLException e) {
			System.out.println("[에러]selectRsrrvtbyRno() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return rsrrvt;

	}

	public List<RsrrvtDTO> selectRsrrvtbyRdate(String rdate) {
		Connection con = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		List<RsrrvtDTO> rsrrvtList = new ArrayList<RsrrvtDTO>();

		try {
			con = getConnection();

			String sql = "select rno,rdate,rtime,designer.name dname,customer.name cname,menu.value mvalue,payment,cash,status,rsrrvt.memo memo from rsrrvt join customer on customer.id = rsrrvt.rcid join designer on designer.id = rsrrvt.rdid join menu on menu.mno = rsrrvt.menu_no where rdate = ? order by rdate desc, rtime desc";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, rdate);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				RsrrvtDTO rsrrvt = new RsrrvtDTO();

				rsrrvt.setRno(rs.getInt("rno"));
				rsrrvt.setRdate(rs.getString("rdate").substring(0, 11));
				rsrrvt.setRtime(rs.getInt("rtime"));
				rsrrvt.setRdid(rs.getString("rdid"));
				rsrrvt.setRcid(rs.getString("rcid"));
				rsrrvt.setMenu_no(rs.getString("menu_no"));
				rsrrvt.setPayment(rs.getInt("payment"));
				rsrrvt.setCash(rs.getString("cash"));
				rsrrvt.setStatus(rs.getString("status"));
				rsrrvt.setMemo(rs.getString("memo"));

				rsrrvtList.add(rsrrvt);
			}

		} catch (SQLException e) {
			System.out.println("[에러]selectRsrrvtbyRdate() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return rsrrvtList;
	}

	public List<RsrrvtDTO> selectRsrrvtAll() {
		Connection con = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		List<RsrrvtDTO> rsrrvtList = new ArrayList<RsrrvtDTO>();

		try {
			con = getConnection();

			String sql = "select rno,rdate,rtime,designer.name dname,customer.name cname,menu.value mvalue,payment,cash,status,rsrrvt.memo memo from rsrrvt join customer on customer.id = rsrrvt.rcid join designer on designer.id = rsrrvt.rdid join menu on menu.mno = rsrrvt.menu_no order by rdate desc, rtime desc";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				RsrrvtDTO rsrrvt = new RsrrvtDTO();

				rsrrvt.setRno(rs.getInt("rno"));
				rsrrvt.setRdate(rs.getString("rdate").substring(0, 11));
				rsrrvt.setRtime(rs.getInt("rtime"));
				rsrrvt.setRdid(rs.getString("rdid"));
				rsrrvt.setRcid(rs.getString("rcid"));
				rsrrvt.setMenu_no(rs.getString("menu_no"));
				rsrrvt.setPayment(rs.getInt("payment"));
				rsrrvt.setCash(rs.getString("cash"));
				rsrrvt.setStatus(rs.getString("status"));
				rsrrvt.setMemo(rs.getString("memo"));

				rsrrvtList.add(rsrrvt);
			}

		} catch (SQLException e) {
			System.out.println("[에러]selectRsrrvtAll() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return rsrrvtList;
	}

}
