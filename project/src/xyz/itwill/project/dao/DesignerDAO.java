package xyz.itwill.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DesignerDAO extends JdbcDAO {
	private static DesignerDAO _dao;

	public DesignerDAO() {
		// TODO Auto-generated constructor stub
	}

	static {
		_dao = new DesignerDAO();
	}

	public static DesignerDAO getDAO() {
		return _dao;
	}

	// 디자이너 추가
	public int insertDesigner(DesignerDTO designer) {
		Connection con = null;
		PreparedStatement pstmt = null;		
		int rows = 0;
		
		try {
			con = getConnection();

			String sql = "insert into deisigner values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, designer.getId());
			pstmt.setString(2, designer.getPw());
			pstmt.setString(3, designer.getBirth());
			pstmt.setString(4, designer.getName());
			pstmt.setString(5, designer.getGender());
			pstmt.setString(6, designer.getPhone());
			pstmt.setString(7, designer.getRank());
			pstmt.setInt(8, designer.getSal());
			pstmt.setString(9, designer.getHire_date());
			pstmt.setInt(10, designer.getCareer());

			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertStudent() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	// 디자이너 수정
	public int updateDesigner(DesignerDTO designer) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int rows = 0;
		try {
			con = getConnection();

			String sql = "update designer set pw=?,birth=?,name=?,gender=?,rank=?,sal=?,hire_date=?,phone=?,carrer=?,id=?, where id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, designer.getPw());
			pstmt.setString(2, designer.getBirth());
			pstmt.setString(3, designer.getName());
			pstmt.setString(4, designer.getGender());
			pstmt.setString(5, designer.getPhone());
			pstmt.setString(6, designer.getRank());
			pstmt.setInt(7, designer.getSal());
			pstmt.setString(8, designer.getHire_date());
			pstmt.setInt(9, designer.getCareer());
			pstmt.setString(10, designer.getId());

			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertStudent() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	public int deleteDesigner(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int rows = 0;
		try {
			con = getConnection();

			String sql = "delete from designer where = id=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertStudent() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	public DesignerDTO selectDesignerByID(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		DesignerDTO designer = null;
		
		try {
			con = getConnection();

			String sql = "select id,pw,birth,name,gender,rank,sal,hire_date,phone,carrer from designer where id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);

			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				designer = new DesignerDTO(); // 필요없는지 확인
				
				designer.setId(rs.getString("id"));
				designer.setPw(rs.getString("pw"));
				designer.setBirth(rs.getString("birth"));
				designer.setName(rs.getString("name"));
				designer.setGender(rs.getString("gender"));
				designer.setPhone(rs.getString("phone"));
				designer.setRank(rs.getString("rank"));
				designer.setSal(rs.getInt("sal"));
				designer.setHire_date(rs.getString("hire_date"));
				designer.setCareer(rs.getInt("career"));
			}

		} catch (SQLException e) {
			System.out.println("[에러]insertStudent() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return designer;
	}
	
	public List<DesignerDTO> selectDesignerByName(String name) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		List<DesignerDTO> designerList = new ArrayList<DesignerDTO>();
		
		try {
			con = getConnection();

			String sql = "select id,pw,birth,name,gender,phone,rank,sal,hire_date,carrer from designer where name like '%'||?||'%' order by name";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);

			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				DesignerDTO designer = new DesignerDTO(); // 필요없는지 확인
				
				designer.setId(rs.getString("id"));
				designer.setPw(rs.getString("pw"));
				designer.setBirth(rs.getString("birth"));
				designer.setName(rs.getString("name"));
				designer.setGender(rs.getString("gender"));
				designer.setPhone(rs.getString("phone"));
				designer.setRank(rs.getString("rank"));
				designer.setSal(rs.getInt("sal"));
				designer.setHire_date(rs.getString("hire_date"));
				designer.setCareer(rs.getInt("career"));
				
				designerList.add(designer);
			}

		} catch (SQLException e) {
			System.out.println("[에러]insertStudent() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return designerList;
	}
	
	public List<DesignerDTO> selectDesignerAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		List<DesignerDTO> designerList = new ArrayList<DesignerDTO>();
		
		try {
			con = getConnection();

			String sql = "select id,pw,birth,name,gender,phone,rank,sal,hire_date,carrer from designer where order by name";
			pstmt = con.prepareStatement(sql);

			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				DesignerDTO designer = new DesignerDTO(); // 필요없는지 확인
				
				designer.setId(rs.getString("id"));
				designer.setPw(rs.getString("pw"));
				designer.setBirth(rs.getString("birth"));
				designer.setName(rs.getString("name"));
				designer.setGender(rs.getString("gender"));
				designer.setPhone(rs.getString("phone"));
				designer.setRank(rs.getString("rank"));
				designer.setSal(rs.getInt("sal"));
				designer.setHire_date(rs.getString("hire_date"));
				designer.setCareer(rs.getInt("career"));
				
				designerList.add(designer);
			}

		} catch (SQLException e) {
			System.out.println("[에러]insertStudent() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return designerList;
	}
}









