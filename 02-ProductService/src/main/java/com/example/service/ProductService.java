package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Product;
import com.example.repo.ProductRepository;


@Service
public class ProductService {

//	String url = "jdbc:mysql://localhost:3306/banking_app";
//	String user = "root";
//	String pswd = "Ramu@9988";


	@Autowired
	ProductRepository repo;

	
	public String saveProd(Product p) {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url, user, pswd);
//			String query = "insert into product values (?,?,?)";
//			PreparedStatement st = con.prepareStatement(query);
//			st.setInt(1, p.getId());
//			st.setString(2, p.getProdName());
//			st.setDouble(3, p.getPrice());
//			st.executeUpdate();
//			st.close();
//			con.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		repo.save(p);
		return "accont saved "+p.getId()+ " "+p.getProdName()+" "+p.getPrice(); 
		
	}
	
	public List<Product> getProducts() {
//		List<Product> li = new ArrayList<>();
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url, user, pswd);
//			String query = "select * from product";
//			PreparedStatement st = con.prepareStatement(query);
//			ResultSet rs = st.executeQuery();
//			while(rs.next()) {
//				//System.out.println(rs.getInt(1)+" -> "+rs.getString(2)+" -> "+rs.getString(3));
//				Product p = new Product();
//				p.setId(rs.getInt(1));
//				p.setProdName(rs.getString(2));
//				p.setPrice(rs.getDouble(3));
//				
//				li.add(p);
//			}
//			st.close();
//			con.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return repo.findAll();
	}
	
	public String updateProduct(Integer id, Product p) {
		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url, user, pswd);
//			String query = "update product set productname=?, price=? where id=?";
//			PreparedStatement st = con.prepareStatement(query);
//			
//			st.setString(1, p.getProdName());
//			st.setDouble(2, p.getPrice());
//			st.setInt(3, p.getId());
//			st.executeUpdate();
//			st.close();
//			con.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Product p1 = repo.findById(id).get();
		p.setId(id);
		
		if(p.getProdName().equals(null)) {
			p.setProdName(p1.getProdName());
		}
		if(p.getPrice()==0.0) {
			p.setPrice(p1.getPrice());
		}
		repo.save(p);
		
		return "updated successfully "+p.getProdName()+" -> "+p.getPrice();
	
	}
	
	public String deleteProduct(int id) {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url, user, pswd);
//			String query = "delete from product where id = ?";
//			PreparedStatement st = con.prepareStatement(query);
//			st.setInt(1,id);
//			
//			
//			st.executeUpdate();
//			st.close();
//			con.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		repo.deleteById(id);
		return "deleted successfully";
	}
}
