package xyz.itwill.project.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO extends JdbcDAO {
	private static CustomerDAO _dao;
	
	private CustomerDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new CustomerDAO();
	}
	
	public static CustomerDAO getDAO() {
		return _dao;
	}
	
	public int insertCustomer(CustomerDTO customer) {
		Connection con = null;
		PreparedStatement pstmt = null;		
		
		int rows = 0;
		
		try {
			con = getConnection();

			String sql = "insert into customer values(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);			
			
			pstmt.setString(1, customer.getId());
			pstmt.setString(2, customer.getPw());
			pstmt.setString(3, customer.getBirth());
			pstmt.setString(4, customer.getName());
			pstmt.setString(5, customer.getGender());
			pstmt.setString(6, customer.getPhone());
			pstmt.setString(7, customer.getJoin_date());
			pstmt.setInt(8, customer.getUsed_count());
			pstmt.setString(9, customer.getMemo());
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertCustomer() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	public int updateCustomer(CustomerDTO customer) {
		Connection con = null;
		PreparedStatement pstmt = null;
			
		int rows = 0;
		try {
			con = getConnection();
			
			String sql = "update customer set pw=?,birth=?,name=?,gender=?,phone=?,join_date=?,used_count=?,memo=? where id=?";
			pstmt = con.prepareStatement(sql);				
			pstmt.setString(1, customer.getPw());
			pstmt.setString(2, customer.getBirth());
			pstmt.setString(3, customer.getName());
			pstmt.setString(4, customer.getGender());
			pstmt.setString(5, customer.getPhone());
			pstmt.setString(6, customer.getJoin_date());
			pstmt.setInt(7, customer.getUsed_count());
			pstmt.setString(8, customer.getMemo());
			pstmt.setString(9, customer.getId());
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateCustomer() 메소드의 SQL 오류 = " + e.getMessage());
			} finally {
			close(con, pstmt);
		}
		return rows;
		
	}
	public int deleteCustomer(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int rows = 0;
		try {
			con = getConnection();

			String sql = "delete from customer where id=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]deleteCustomer() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}	

	public CustomerDTO selectCustomerByID(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		CustomerDTO customer = null;
		
		try {
			con = getConnection();

			String sql = "select id,pw,birth,name,gender,phone,join_date,used_count,memo from customer where id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);

			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				customer = new CustomerDTO(); 
				
				customer.setId(rs.getString("id"));
				customer.setPw(rs.getString("pw"));
				customer.setBirth(rs.getString("birth"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setPhone(rs.getString("phone"));
				customer.setJoin_date(rs.getString("join_date"));
				customer.setUsed_count(rs.getInt("used_count"));
				customer.setMemo(rs.getString("memo"));				
			}

		} catch (SQLException e) {
			System.out.println("[에러]selectCustomerByID() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return customer;
		
	}
	
	public List<CustomerDTO> selectCustomerByName(String name) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();
		
		try {
			con = getConnection();

			String sql = "select id,pw,birth,name,gender,phone,join_date,used_count,memo from customer where name like '%'||?||'%' order by name";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);

			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				CustomerDTO customer = new CustomerDTO(); 
				
				customer.setId(rs.getString("id"));
				customer.setPw(rs.getString("pw"));
				customer.setBirth(rs.getString("birth"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setPhone(rs.getString("phone"));
				customer.setJoin_date(rs.getString("join_date"));
				customer.setUsed_count(rs.getInt("used_count"));
				customer.setMemo(rs.getString("memo"));
				
				
				customerList.add(customer);
			}

		} catch (SQLException e) {
			System.out.println("[에러]selectCustomerByName() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return customerList;
	}
	
	public List<CustomerDTO> selectCustomerAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();
		
		try {
			con = getConnection();

			String sql = "select id,pw,birth,name,gender,phone,join_date,used_count,memo from customer order by name";
			pstmt = con.prepareStatement(sql);

			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				CustomerDTO customer = new CustomerDTO();
				
				customer.setId(rs.getString("id"));
				customer.setPw(rs.getString("pw"));
				customer.setBirth(rs.getString("birth"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setPhone(rs.getString("phone"));
				customer.setJoin_date(rs.getString("join_date"));
				customer.setUsed_count(rs.getInt("used_count"));
				customer.setMemo(rs.getString("memo"));
				
				customerList.add(customer);
			}

		} catch (SQLException e) {
			System.out.println("[에러]selectCustomerAll() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return customerList;
	}
}