package com.Hackathon.JCI.FittingRoomIntelligence.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Hackathon.JCI.FittingRoomIntelligence.Model.Product;
import com.Hackathon.JCI.FittingRoomIntelligence.Model.ProductMapper;
import com.Hackathon.JCI.FittingRoomIntelligence.Model.ProductRowMapper;

@Transactional
@Repository
public class FittingRoomIntelligenceDaoImpl implements FittingRoomIntelligenceDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Product> getFittingRoomArticles(String zoneId, String lastAdded) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT ecc.NAME AS category ")
		  .append(",ec.epc_cls_code  AS productCode ")
		  .append(",ecx.attr001 AS color ")
		  .append(",ecx.attr002 AS size ")
		  .append(",ecx.attr003 AS Brand ")
		  .append("FROM epc_location el ")
		  .append("INNER JOIN epc_cls ec ON el.epc_cls_id = ec.epc_Cls_id ")
		  .append("INNER JOIN epc_cls_extended ecx ON ec.epc_cls_id = ecx.epc_Cls_id ")
		  .append("LEFT OUTER JOIN epc_cls_cat ecc ON ec.epc_cls_cat_id = ecc.epc_cls_cat_id ")
		  .append("WHERE zone_id = "+zoneId+" and last_added > '"+lastAdded+"'");
		
		List<Product> productList = jdbcTemplate.query(sb.toString(), new ProductMapper());
		
		return productList;
	}
	
	public List<Product> getFittingRoomProductDescription(String productCode) {
	
        StringBuilder sb = new StringBuilder();
        
		sb.append("select ecc.name AS category, a.epc_cls_code AS productCode,ecx.attr010 AS color ")
		 .append(",ecx.attr016 AS price ")
		 .append(",ecx.attr017 AS Brand, ")
		 .append("d.alias zoneName from epc_cls a join epc b on a.epc_cls_id = b.epc_cls_id ")
		 .append("join epc_location c on c.epc_id = b.epc_id and c.is_removed = 0 ")
		 .append("INNER JOIN epc_cls_extended ecx ON a.epc_cls_id = ecx.epc_Cls_id ")
		 .append("LEFT OUTER JOIN epc_cls_cat ecc ON a.epc_cls_cat_id = ecc.epc_cls_cat_id ")
		 .append("join zone d on c.zone_id = d.zone_id and d.is_inventory = 1 and d.deleted_time is null ")
	     .append("where a.epc_cls_code in ("+productCode+") ")
		 .append("group by ecc.name,a.epc_cls_code,ecx.attr010,ecx.attr016,ecx.attr017,d.alias,ecx.attr018 order by attr018 asc");
		
         List<Product> productList = jdbcTemplate.query(sb.toString(), new ProductRowMapper());
		
		return productList;
	}
}
