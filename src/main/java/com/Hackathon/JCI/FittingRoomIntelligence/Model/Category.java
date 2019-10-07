package com.Hackathon.JCI.FittingRoomIntelligence.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {

	 @JsonProperty("Name")
     private String	Name;
	 @JsonProperty("Order")
     private String Order;
	 @JsonProperty("RecommendedProducts")
     private List<Product> RecommendedProducts = new ArrayList<>();
     
     
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getOrder() {
			return Order;
		}
		public void setOrder(String order) {
			Order = order;
		}
		public List<Product> getRecommendedProducts() {
			return RecommendedProducts;
		}
		public void setRecommendedProducts(List<Product> recommendedProducts) {
			RecommendedProducts = recommendedProducts;
		}
   
}
