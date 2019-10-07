package com.Hackathon.JCI.FittingRoomIntelligence.Model;

import java.util.List;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResponse {

	@JsonProperty("product") 
	private String product;
	
	@JsonProperty("recomendedProducts") 
	private List<String> recomendedProducts;

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public List<String> getRecomendedProducts() {
		return recomendedProducts;
	}

	public void setRecomendedProducts(List<String> recomendedProducts) {
		this.recomendedProducts = recomendedProducts;
	} 
	
	
}
