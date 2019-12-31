package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.dto.Employee;

public class EmployeeModel {

	public void selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM EMPLOYEE";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				System.out.println(
						rset.getString("emp_id") + ", " + 
						rset.getString("emp_name") + ", " + 
						rset.getString("emp_no") + ", " + 
						rset.getString("email") + ", " + 
						rset.getString("phone") + ", " + 
						rset.getDate("hire_date") + ", " + 
						rset.getString("job_id") + ", " + 
						rset.getInt("salary") + ", " + 
						rset.getInt("bonus_pct") + ", " + 
						rset.getString("marriage") + ", " + 
						rset.getString("mgr_id") + ", " + 
						rset.getString("dept_id")
				);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	

	public void selectOne(int empNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, empNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				System.out.println(
						rset.getString("emp_id") + ", " + 
						rset.getString("emp_name") + ", " + 
						rset.getString("emp_no") + ", " + 
						rset.getString("email") + ", " + 
						rset.getString("phone") + ", " + 
						rset.getDate("hire_date") + ", " + 
						rset.getString("job_id") + ", " + 
						rset.getInt("salary") + ", " + 
						rset.getInt("bonus_pct") + ", " + 
						rset.getString("marriage") + ", " + 
						rset.getString("mgr_id") + ", " + 
						rset.getString("dept_id")
				);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	public void insertEmployee(Employee e) {
		Connection c = null;
		PreparedStatement p = null;
		int result = 0;
		
		String query = "INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, HIRE_DATE, JOB_ID, SALARY, BONUS_PCT, MARRIAGE, MGR_ID, DEPT_ID) "
				+ "VALUES (?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
		
			p = c.prepareStatement(query);
			
			p.setString(1, e.getEmp_id());
			p.setString(2, e.getEmp_name());
			p.setString(3, e.getEmp_no());
			p.setString(4, e.getEmail());
			p.setString(5, e.getPhone());
			p.setString(6, e.getJob_id());
			p.setInt(7, e.getSalary());
			p.setInt(8, e.getBonus_pct());
			p.setString(9, e.getMarriage());
			p.setString(10, e.getMgr_id());
			p.setString(11, e.getDept_id());
			
			result = p.executeUpdate();
			System.out.println(result + "개의 행이 추가되었습니다.");
			
			if(result > 0) {
				c.commit();
			}else {
				c.rollback();
			}
		} catch (ClassNotFoundException | SQLException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} finally {
			try {
				p.close();
				c.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	public void updateEmployee(Employee m) {
		Connection c = null;
		PreparedStatement p = null;
		int result = 0;
		
		String query = "UPDATE EMPLOYEE SET JOB_ID = ?, SALARY = ?, BONUS_PCT = ?, DEPT_ID = ? WHERE EMP_ID = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			
			p = c.prepareStatement(query);
			
			p.setString(1, m.getJob_id());
			p.setInt(2, m.getSalary());
			p.setInt(3,  m.getBonus_pct());
			p.setString(4, m.getDept_id());
			p.setString(5, m.getEmp_id());
			
			p.executeUpdate();
			
			System.out.println(result + "개의 행이 업데이트되었습니다.");
			
			if(result > 0) {
				c.commit();
			}else {
				c.rollback();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				p.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	public void deleteEmployee(int empId) {
		Connection c = null;
		PreparedStatement p = null;
		int result;
		
		String query = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			
			p = c.prepareStatement(query);
			
			p.setInt(1, empId);
			
			result = p.executeUpdate();
			
			System.out.println(result + "개의 행이 삭제되었습니다.");
			
			if(result > 0) {
				c.commit();
			}else {
				c.rollback();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				p.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
