package com.Hackathon.JCI.FittingRoomIntelligence.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Product pr = new Product();
		
		pr.setProductCode(rs.getString("productCode"));
		pr.setBrand(rs.getString("Brand"));
		pr.setPrice(rs.getString("price"));
		pr.setZoneName(rs.getString("zoneName"));
		return pr;
	}

}
