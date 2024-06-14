package xyz.itwill.project.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends JdbcDAO {
	private static MemberDAO _dao;
	
	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MemberDAO();
	}
	
	public static MemberDAO getDAO() {
		return _dao;
	}
	
	public int insertMember(MemberDTO member) {
		Connection con = null;
		PreparedStatement pstmt = null;		
		
		int rows = 0;
		
		try {
			con = getConnection();

			String sql = "insert into member values(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);			
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getBirth());
			pstmt.setString(4, member.getName());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getJoin_date());
			pstmt.setInt(8, member.getUsed_count());
			pstmt.setString(9, member.getMemo());
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertMember() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	public int updateMember(MemberDTO member) {
		Connection con = null;
		PreparedStatement pstmt = null;
			
		int rows = 0;
		try {
			con = getConnection();
			
			String sql = "update member set pw=?,birth=?,name=?,gender=?,phone=?,join_date=?,used_count=?,memo=? where id=?";
			pstmt = con.prepareStatement(sql);				
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getBirth());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getJoin_date());
			pstmt.setInt(7, member.getUsed_count());
			pstmt.setString(8, member.getMemo());
			pstmt.setString(9, member.getId());
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateMember() 메소드의 SQL 오류 = " + e.getMessage());
			} finally {
			close(con, pstmt);
		}
		return rows;
		
	}
	public int deleteMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int rows = 0;
		try {
			con = getConnection();

			String sql = "delete from member where id=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]deleteMember() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}	

	public MemberDTO selectMemberByID(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		MemberDTO member = null;
		
		try {
			con = getConnection();

			String sql = "select id,pw,birth,name,gender,phone,join_date,used_count,memo from member where id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);

			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberDTO(); 
				
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setBirth(rs.getString("birth"));
				member.setName(rs.getString("name"));
				member.setGender(rs.getString("gender"));
				member.setPhone(rs.getString("phone"));
				member.setJoin_date(rs.getString("join_date"));
				member.setUsed_count(rs.getInt("used_count"));
				member.setMemo(rs.getString("memo"));				
			}

		} catch (SQLException e) {
			System.out.println("[에러]selectMemberByID() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return member;
		
	}
	
	public List<MemberDTO> selectMemberByName(String name) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		
		try {
			con = getConnection();

			String sql = "select id,pw,birth,name,gender,phone,join_date,used_count,memo from member where name like '%'||?||'%' order by name";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);

			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO member = new MemberDTO(); 
				
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setBirth(rs.getString("birth"));
				member.setName(rs.getString("name"));
				member.setGender(rs.getString("gender"));
				member.setPhone(rs.getString("phone"));
				member.setJoin_date(rs.getString("join_date"));
				member.setUsed_count(rs.getInt("used_count"));
				member.setMemo(rs.getString("memo"));
				
				
				memberList.add(member);
			}

		} catch (SQLException e) {
			System.out.println("[에러]selectMemberByName() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return memberList;
	}
	
	public List<MemberDTO> selectMemberAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		
		try {
			con = getConnection();

			String sql = "select id,pw,birth,name,gender,phone,join_date,used_count,memo from member order by name";
			pstmt = con.prepareStatement(sql);

			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setBirth(rs.getString("birth"));
				member.setName(rs.getString("name"));
				member.setGender(rs.getString("gender"));
				member.setPhone(rs.getString("phone"));
				member.setJoin_date(rs.getString("join_date"));
				member.setUsed_count(rs.getInt("used_count"));
				member.setMemo(rs.getString("memo"));
				
				memberList.add(member);
			}

		} catch (SQLException e) {
			System.out.println("[에러]selectMemberAll() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return memberList;
	}
}