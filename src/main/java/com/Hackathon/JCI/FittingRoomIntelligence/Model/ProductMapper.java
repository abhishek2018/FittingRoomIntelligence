package com.Hackathon.JCI.FittingRoomIntelligence.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Product pr = new Product();
		
		pr.setProductCode(rs.getString("productCode"));
		pr.setBrand(rs.getString("Brand"));
		
		return pr;
	}

}
