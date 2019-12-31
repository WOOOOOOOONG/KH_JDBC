package book.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import book.model.dao.BookDao;
import book.model.vo.Book;

// 싱글톤으로 작성된 클래스 import시에는 static 키워드 사용해야 함
import static common.JDBCTemplate.*;
// service : 1. 컨트롤러로부터 매개변수로 정보를 전달 받는다.
//           2. Connection 객체를 생성한다.
//           3. 생성한 Connection 객체와 전달받은 매개변수를 DAO 클래스의 메소드로 전달한다.
//           4. 수행 결과에 따른 트랜잭션을 관리한다.
public class BookService {

	public int insertBook(Book b) {
		Connection con = getConnection();
		BookDao bd = new BookDao();
		int result = bd.insertBook(con, b);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	// 모든 도서 리스트 검색용 메소드
	public ArrayList<Book> seletAll() {
		Connection con = getConnection();
		BookDao bd = new BookDao();
		ArrayList<Book> list = bd.selectAll(con);
		
		close(con);
		
		return list;
	}

	// 도서 정보 수정용 메소드
	public int updateBook(Book b) {
		Connection con = getConnection();
		BookDao bd = new BookDao();
		
		int result = bd.updateBook(con, b);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	// 도서 정보 삭제 메소드
	public int deleteBook(int inputBookId) {
		Connection con = getConnection();
		BookDao bd = new BookDao();
		
		int result = bd.deleteBook(con, inputBookId);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}

	public int searchBook(int inputBookId) {
		Connection con = getConnection();
		BookDao bd = new BookDao();
		
		int result = bd.searchBook(con, inputBookId);
		return result;
	}

	public ArrayList<Book> searchBookTitle(String inputTitle) {
		Connection con = getConnection();
		BookDao bd = new BookDao();
		ArrayList<Book> list = bd.searchBookTitle(con, inputTitle);
		
		close(con);
		
		return list;
	}
}
