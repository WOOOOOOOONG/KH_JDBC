package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.Employee;

// dao(data access object)

public class JDBCModel {
	public JDBCModel() { }
	
	public void testJDBC() {
		// // 모든 사원정보 조회
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			// 1. 해당 데이터베이스에 대한 라이브러리 등록 작업
			// Class.forName("클래스명"); -> ClassNotFoundException 처리 필요
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 데이터베이스와 결합
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
			
			System.out.println(conn);
			
			// 3. 쿼리문 가지고 DB에 가서 쿼리문 실행 시키고 결과를 가저올 객체 생성
			String query = "SELECT * FROM EMP";
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				System.out.println(rset.getInt("empno") + ", "
									+ rset.getString("ename") + ", "
									+ rset.getString("job") + ", "
									+ rset.getInt("mgr") + ", "
									+ rset.getDate("hireDate") + ", "
									+ rset.getInt("sal") + ", "
									+ rset.getInt("comm") + ", "
									+ rset.getInt("deptno"));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// DB와 관련된 객체는 반드시 close 해야 함
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
	
	public void testJDBC2(int empNo) {
		// 사번을 전달받아 직원 정보 조회
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
			
			/*
  			String query = "SELECT * FROM EMP WHERE EMPNO = " + empNo;
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
 			*/
			
			String query = "SELECT * FROM EMP WHERE EMPNO = ?";
			
			pstmt = conn.prepareStatement(query);
			// 객체 생성 후 쿼리문을 완성시킴
			// 객체명.set자료형(?순번, 적용할 값)
			pstmt.setInt(1, empNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				System.out.println(rset.getInt(1) + ", "
									+ rset.getString(2) + ", "
									+ rset.getString(3) + ", "
									+ rset.getInt(4) + ", "
									+ rset.getDate(5) + ", "
									+ rset.getInt(6) + ", "
									+ rset.getInt(7) + ", "
									+ rset.getInt(8));
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
				// stmt.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void testInsert(Employee e) {
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		/*String query = "insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno)"
						+ "values ('" + e.getEmpNo() + "', '" + e.getEmpName() + "', '" + e.getJob() + "', "
						+ e.getMgr() + ", sysdate, " + e.getSal() + ", " + e.getComm() + ", " + e.getDeptNo() + ")";*/
		String query = "insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno)" + " values (?,?,?,?,sysdate,?,?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			
//			stmt = conn.createStatement();
//			result = pstmt.executeUpdate(query);
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1,  e.getEmpNo());
			pstmt.setString(2,  e.getEmpName());
			pstmt.setString(3,  e.getJob());
			pstmt.setInt(4,  e.getMgr());
			pstmt.setInt(5,  e.getSal());
			pstmt.setInt(6,  e.getComm());
			pstmt.setInt(7,  e.getDeptNo());
			
			result = pstmt.executeUpdate();
			
			System.out.println(result + "개의 행이 추가되었습니다.");
			
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	public void testUpdate(Employee e) {
		// 직원 정보 수정
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
//		String query = "update emp set job = '" + e.getJob() + "', sal = " + e.getSal() + 
//						", comm = " + e.getComm() + " where empno = " + e.getEmpNo();
		String query = "update emp set job = ?, sal = ?, comm = ? where empno = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
			
//			stmt = conn.createStatement();
//			result = stmt.executeUpdate(query);
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, e.getJob());
			pstmt.setInt(2, e.getSal());
			pstmt.setInt(3, e.getComm());
			pstmt.setInt(4, e.getEmpNo());
			
			result = pstmt.executeUpdate();
			// 준비 -> 설정 -> 실행
			System.out.println(result + "개의 행이 수정되었습니다.");
			
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
//				stmt.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	public void testDelete(int empNo) {
		// 사번을 전달받아 해당 직원 정보 삭제
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
//		String query = "DELETE FROM EMP WHERE EMPNO = " + empNo;
		String query = "DELETE FROM EMP WHERE EMPNO = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			
//			stmt = conn.createStatement();
//			result = stmt.executeUpdate(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, empNo);
			result = pstmt.executeUpdate();
			
			System.out.println(result + "개의 행이 삭제되었습니다.");
			
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
//				stmt.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
