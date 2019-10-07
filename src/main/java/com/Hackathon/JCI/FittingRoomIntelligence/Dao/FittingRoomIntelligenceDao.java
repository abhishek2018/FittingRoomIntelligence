package com.Hackathon.JCI.FittingRoomIntelligence.Dao;

import java.util.List;

import com.Hackathon.JCI.FittingRoomIntelligence.Model.Product;


public interface FittingRoomIntelligenceDao {

	public List<Product> getFittingRoomArticles(String zoneId, String lastAdded);
	
	public List<Product> getFittingRoomProductDescription(String productCode);
}
