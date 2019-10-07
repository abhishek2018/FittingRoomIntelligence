package com.Hackathon.JCI.FittingRoomIntelligence.Model;

import java.util.List;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FittingRoomProductResponse {

	
	@JsonProperty("recomendedProducts") 
	private JSONObject fittingRoomProducts;

	
	public JSONObject getRecomendedProducts() {
		return fittingRoomProducts;
	}

	public void setRecomendedProducts(JSONObject fittingRoomProducts) {
		this.fittingRoomProducts = fittingRoomProducts;
	} 
	
	
}
