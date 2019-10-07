package com.Hackathon.JCI.FittingRoomIntelligence.Contoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Hackathon.JCI.FittingRoomIntelligence.Model.FittingRoomProductResponse;
import com.Hackathon.JCI.FittingRoomIntelligence.Model.Product;
import com.Hackathon.JCI.FittingRoomIntelligence.Model.ProductRequest;
import com.Hackathon.JCI.FittingRoomIntelligence.Model.ProductResponse;
import com.Hackathon.JCI.FittingRoomIntelligence.Service.FittingRoomIntelligenceService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@RestController
@JsonSerialize
public class FittingRoomIntelligenceController {

	@Autowired
	FittingRoomIntelligenceService fittingRoomIntelligenceServiceImpl;
	
	
	@RequestMapping(value = "/getFittingRoomProductRecommendations", method=RequestMethod.POST)
	public String getFittingRoomProductInfo(@RequestBody ProductRequest request) {
		
		if(request == null)
			return null;
		
		JSONObject obj = fittingRoomIntelligenceServiceImpl.getFittingRoomProductInfo(request);
		Map<String, JSONObject> map = new HashMap<>(); 
		map.put("Data", obj);
		
		FittingRoomProductResponse response = new FittingRoomProductResponse();
		response.setRecomendedProducts(obj);
		
		return obj.toString();
	}
		
	@RequestMapping(value="/getFittingRoomProductDescription", method=RequestMethod.POST)
	public String getFittingRoomProductRecommendations(@RequestBody ProductRequest request) {
		String productCode="";
		for(String s : request.getProductCodes()) {
			productCode = productCode + s+", ";
		}
		
		return fittingRoomIntelligenceServiceImpl.getFittingRoomProductDescription(productCode.substring(0, productCode.length()-2)).toString();
	}
	
}
