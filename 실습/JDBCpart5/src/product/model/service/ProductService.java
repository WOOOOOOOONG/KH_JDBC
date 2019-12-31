package product.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import product.model.dao.ProductDao;
import product.model.vo.Product;
import product.views.ErrorDialog;

public class ProductService {
	ErrorDialog error = new ErrorDialog();
	
	// 전체 출력
	public ArrayList<Product> selectAll() {
		ArrayList<Product> pList = new ArrayList<Product>();
		Connection c = getConnection();
		ProductDao pdao = new ProductDao();
		pList = pdao.selectAll(c);
		
		close(c);
		
		return pList;
	}

	// 제품 삽입
	public int insertRow(Product pro) {
		Connection c = getConnection();
		ProductDao pdao = new ProductDao();
		int result = pdao.insertRow(c, pro);
		
		if(result > 0) {
			commit(c);
			System.out.println("제품이 삽입되었습니다.");
		}else {
			rollback(c);
			error.errorMessage("제품 삽입을 실패하였습니다.");
		}
		
		close(c);
		
		return result;
	}

	// 제품 수정
	public int updateRow(String pId, int price) {
		Connection c = getConnection();
		ProductDao pdao = new ProductDao();
		int result = pdao.updateRow(c, pId, price);
		
		if(result > 0) {
			commit(c);
			System.out.println("제품의 가격이 변경되었습니다.");
		}else {
			rollback(c);
			error.errorMessage("제품 가격 변경을 실패하였습니다.");
		}
		
		close(c);
		
		return result;
	}

	// 제품 삭제
	public int deleteRow(String pId) {
		Connection c = getConnection();
		ProductDao pdao = new ProductDao();
		int result = pdao.deleteRow(c, pId);
		
		if(result > 0) {
			commit(c);
			System.out.println("제품을 삭제하였습니다.");
		}else {
			rollback(c);
			error.errorMessage("제품 삭제를 실패했습니다.");
		}
		
		close(c);
		
		return result;
	}

	// id로 제품 선택
	public Product selectRow(String pId) {
		Product product = new Product();
		Connection c = getConnection();
		ProductDao pdao = new ProductDao();
		product = pdao.selectRow(c, pId);
		
		close(c);
		
		return product;
	}

	public ArrayList<Product> selectName(String pName) {
		ArrayList<Product> product = new ArrayList<Product>();
		Connection c = getConnection();
		ProductDao pdao = new ProductDao();
		product = pdao.selectName(c, pName);
		
		close(c);
		
		return product;
	}

}
