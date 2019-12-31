package book.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import book.model.vo.Book;

// DAO(Database access object) -> CRUD 수행함
// C : create(insert)
// R : read(select)
// U : update
// D : delete
public class BookDao {
	// 신규 도서 insert용 메소드
	public int insertBook(Connection con, Book b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
//		String query = "insert into book values (seq.nextval, ?, ?, ?, to_date(?, 'rrrr/mm/dd'), ?)";
		
		try {
			// Properties 파일에서 쿼리문 읽어오기
			Properties prop = new Properties();
			prop.load(new FileReader("query.properties"));
			String query = prop.getProperty("insertBook");
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getAuthor());
			pstmt.setString(3, b.getPub());
			pstmt.setString(4, b.getPubDate());
			pstmt.setInt(5, b.getPrice());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 전체 도서 select용 메소드
	public ArrayList<Book> selectAll(Connection con) {
		ArrayList<Book> list = new ArrayList<Book>();
		Statement stmt = null;
		ResultSet rset = null;
		
//		String query = "select * from book";
		
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("query.properties"));
			String query = prop.getProperty("selectAll");
			
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Book b = new Book();
				b.setBid(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPub(rset.getString("publisher"));
				b.setPubDate(rset.getString("publisher_date"));
				b.setPrice(rset.getInt("price"));
				
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	// 도서 정보 update용 메소드
	public int updateBook(Connection con, Book b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		/*String query = "update book set title = ?, author = ?, publisher = ?,"
				+ " publisher_date = to_date(?, 'rrrr/mm/dd'), price = ? where book_id = ?";*/
		
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("query.properties"));
			String query = prop.getProperty("updateBook");
			
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getAuthor());
			pstmt.setString(3, b.getPub());
			pstmt.setString(4, b.getPubDate());
			pstmt.setInt(5, b.getPrice());
			pstmt.setInt(6, b.getBid());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 도서 정보 delete용 메소드
	public int deleteBook(Connection con, int inputBookId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
//		String query = "DELETE FROM BOOK WHERE BOOK_ID = ?";
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("query.properties"));
			String query = prop.getProperty("deleteBook");
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, inputBookId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 도서 정보 search용 메소드
	public int searchBook(Connection con, int inputBookId) {
		PreparedStatement pstmt = null;
		ResultSet result = null;
		int re = 0;
		
//		String query = "SELECT * FROM BOOK WHERE BOOK_ID = ?";
		
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("query.properties"));
			String query = prop.getProperty("searchBook");
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, inputBookId);
			
			result = pstmt.executeQuery();
			
			while(result.next()) {
				System.out.println(
						result.getInt(1) + ", " + 
						result.getString(2) + ", " + 
						result.getString(3) + ", " + 
						result.getString(4) + ", " + 
						result.getDate(5) + ", " + 
						result.getInt(6)
				);
			}
			
			re = 1;
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return re;
	}

	// 도서 정보 책 제목으로 search용 메소드
	public ArrayList<Book> searchBookTitle(Connection con, String inputTitle) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Book> list = new ArrayList<Book>();
		
//		String query = "SELECT * FROM BOOK WHERE TITLE like '%' || ? || '%'";
		
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("query.properties"));
			String query = prop.getProperty("searchBookTitle");
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, inputTitle);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book b = new Book();
				
				b.setBid(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPub(rset.getString("publisher"));
				b.setPubDate(rset.getString("publisher_date"));
				b.setPrice(rset.getInt("price"));
				
				list.add(b);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return list;
	}
	
}