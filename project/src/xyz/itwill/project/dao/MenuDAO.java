package xyz.itwill.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO extends JdbcDAO {
	private static MenuDAO _dao;
		
	private MenuDAO() {
		// TODO Auto-generated constructor stub
	}
		
	static {
		_dao=new MenuDAO();
	}
		
	public static MenuDAO getDAO() {
		return _dao;
	}
	
	public int insertMenu(MenuDTO menu) {
		Connection con = null;
		PreparedStatement pstmt = null;		
		
		int rows = 0;
		
		try {
			con = getConnection();

			String sql = "insert into menu values(SEQ_MENU.NEXTVAL,?,?,?)";
			pstmt = con.prepareStatement(sql);			
			
//			pstmt.setInt(1, menu.getMno());
			pstmt.setString(1, menu.getValue());
			pstmt.setInt(2, menu.getMtime());
			pstmt.setInt(3, menu.getPrice());			
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertMenu() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	

	public int updateMenu(MenuDTO menu) {
		Connection con = null;
		PreparedStatement pstmt = null;
			
		int rows = 0;
		try {
			con = getConnection();
			
			String sql = "update menu set value=?,mtime=?,price=? where mno=?";
			pstmt = con.prepareStatement(sql);				
			pstmt.setString(1, menu.getValue());
			pstmt.setInt(2, menu.getMtime());
			pstmt.setInt(3, menu.getPrice());
			pstmt.setInt(4, menu.getMno());
						
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateMenu() 메소드의 SQL 오류 = " + e.getMessage());
			} finally {
			close(con, pstmt);
		}
		return rows;
		
	}
	
	public int deleteMenu(int mno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int rows = 0;
		try {
			con = getConnection();

			String sql = "delete from menu where mno=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, mno);

			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]deleteMenu() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}	
	
	public MenuDTO selectMenuByMno(int mno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		MenuDTO menu = null;
		
		try {
			con = getConnection();

			String sql = "select mno,value,mtime,price from menu where mno = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, mno);

			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				menu = new MenuDTO(); 
				
				menu.setMno(rs.getInt("mno"));
				menu.setValue(rs.getString("value"));
				menu.setMtime(rs.getInt("mtime"));
				menu.setPrice(rs.getInt("price"));
						
			}

		} catch (SQLException e) {
			System.out.println("[에러]selectMenuByMno() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return menu;
		
	}
	
	public List<MenuDTO> selectMenuByValue(String value) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		List<MenuDTO> menuList = new ArrayList<MenuDTO>();
		
		try {
			con = getConnection();

			String sql = "select mno,value,mtime,price from menu where value like '%'||?||'%' order by value";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, value);

			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MenuDTO menu = new MenuDTO(); 
				
				menu.setMno(rs.getInt("mno"));
				menu.setValue(rs.getString("value"));
				menu.setMtime(rs.getInt("mtime"));
				menu.setPrice(rs.getInt("price"));
				
				
				menuList.add(menu);
			}

		} catch (SQLException e) {
			System.out.println("[에러]selectMenuByValue() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return menuList;
	}
	
	public List<MenuDTO> selectMenuAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		List<MenuDTO> menuList = new ArrayList<MenuDTO>();
		
		try {
			con = getConnection();

			String sql = "select mno,value,mtime,price from menu order by value";
			pstmt = con.prepareStatement(sql);

			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MenuDTO menu = new MenuDTO();
				
				menu.setMno(rs.getInt("mno"));
				menu.setValue(rs.getString("value"));
				menu.setMtime(rs.getInt("mtime"));
				menu.setPrice(rs.getInt("price"));
				
				
				menuList.add(menu);
			}

		} catch (SQLException e) {
			System.out.println("[에러]selectMenuAll() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return menuList;
	}	
	
}
