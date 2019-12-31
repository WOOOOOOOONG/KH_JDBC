package product.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import product.model.vo.Product;
import static common.JDBCTemplate.close;

public class ProductDao {

	public ArrayList<Product> selectAll(Connection c) {
		ArrayList<Product> pList = new ArrayList<Product>();
		Properties prop = new Properties();
		ResultSet rset = null;
		PreparedStatement pstat = null;
		try {
			prop.load(new FileReader("query"));
			String query = prop.getProperty("selectAll");
			
			pstat = c.prepareStatement(query);
			rset = pstat.executeQuery();
			
			while(rset.next()) {
				Product p = new Product();
				
				p.setpId(rset.getString(1));
				p.setpName(rset.getString(2));
				p.setPrice(rset.getInt(3));
				p.setDesc(rset.getString(4));
				
				pList.add(p);
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstat);
			
		}
		
		return pList;
	}

	
	// 새로운 제품 생성
	public int insertRow(Connection c, Product pro) {
		Properties prop = new Properties();
		int result = 0;
		PreparedStatement pstat = null;
		
		try {
			prop.load(new FileReader("query"));
			String query = prop.getProperty("insertRow");
			
			pstat = c.prepareStatement(query);
			
			pstat.setString(1, pro.getpId());
			pstat.setString(2, pro.getpName());
			pstat.setInt(3, pro.getPrice());
			pstat.setString(4, pro.getDesc());
			
			result = pstat.executeUpdate();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstat);
		}
		return result;
	}


	
	// ID로 가격 변경
	public int updateRow(Connection c, String pId, int price) {
		Properties prop = new Properties();
		int result = 0;
		PreparedStatement pstat = null;
		
		try {
			prop.load(new FileReader("query"));
			String query = prop.getProperty("updateRow");
			
			pstat = c.prepareStatement(query);
			
			pstat.setInt(1, price);
			pstat.setString(2, pId);
			
			result = pstat.executeUpdate();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstat);
		}
		
		return result;
	}



	// ID로 삭제
	public int deleteRow(Connection c, String pId) {
		Properties prop = new Properties();
		int result = 0;
		PreparedStatement pstat = null;
		
		try {
			prop.load(new FileReader("query"));
			String query = prop.getProperty("deleteRow");
			
			pstat = c.prepareStatement(query);
			
			pstat.setString(1, pId);
			
			result = pstat.executeUpdate();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstat);
		}
		
		return result;
	}

	// ID로 찾기
	public Product selectRow(Connection c, String pId) {
		Product pro = new Product();
		Properties prop = new Properties();
		ResultSet rset = null;
		PreparedStatement pstat = null;
		
		try {
			prop.load(new FileReader("query"));
			String query = prop.getProperty("selectRow");
			
			pstat = c.prepareStatement(query);
			pstat.setString(1, pId);
			rset = pstat.executeQuery();
			
			if(rset.next()) {
				pro.setpId(rset.getString(1));
				pro.setpName(rset.getString(2));
				pro.setPrice(rset.getInt(3));
				pro.setDesc(rset.getString(4));
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstat);
			
		}
		
		return pro;
	}


	
	// 이름으로 찾기
	public ArrayList<Product> selectName(Connection c, String pName) {
		ArrayList<Product> pro = new ArrayList<Product>();
		Properties prop = new Properties();
		ResultSet rset = null;
		PreparedStatement pstat = null;
		try {
			prop.load(new FileReader("query"));
			String query = prop.getProperty("selectName");
			
			pstat = c.prepareStatement(query);
			pstat.setString(1, pName);
			rset = pstat.executeQuery();
			
			while(rset.next()) {
				Product p = new Product();
				
				p.setpId(rset.getString(1));
				p.setpName(rset.getString(2));
				p.setPrice(rset.getInt(3));
				p.setDesc(rset.getString(4));
			
				pro.add(p);
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstat);
		}
		
		return pro;
	}

}
