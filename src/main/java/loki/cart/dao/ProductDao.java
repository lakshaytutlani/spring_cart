package loki.cart.dao;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import loki.cart.bean.Product;  

public class ProductDao {

	JdbcTemplate template;  

	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  

	public Product getProductById(String id) throws SQLException{  
	    String sql="select * from Product where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Product>(Product.class));  
	}  
	
	public List<Product> getProduct(){  
	    return template.query("select * from Product",new RowMapper<Product>(){  
	        public Product mapRow(ResultSet rs, int row) throws SQLException {  
	        	Product p=new Product();  
	        	p.setId(rs.getString(1));  
	        	p.setName(rs.getString(2));  
	            p.setPhoto(rs.getString(3));  
	            p.setPrice(rs.getDouble(4));  
	            return p;  
	        }  
	    });  
	}  
	
}
