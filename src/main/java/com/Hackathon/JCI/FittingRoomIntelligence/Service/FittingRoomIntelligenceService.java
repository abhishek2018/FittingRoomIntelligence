package com.Hackathon.JCI.FittingRoomIntelligence.Service;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.Hackathon.JCI.FittingRoomIntelligence.Model.Product;
import com.Hackathon.JCI.FittingRoomIntelligence.Model.ProductRequest;


public interface FittingRoomIntelligenceService {

	
	public JSONObject getFittingRoomProductInfo(ProductRequest request);
	
	public JSONObject getFittingRoomProductDescription(String productCode);
}
