package com.Hackathon.JCI.FittingRoomIntelligence.Model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

	    @JsonProperty("Category")
		private String Category;
	    @JsonProperty("ProductCode")
		private String ProductCode;
	    @JsonProperty("Brand")
		private String Brand;
	    @JsonProperty("Size")
		private String Size;
	    @JsonProperty("ImageUrl")
		private String ImageUrl;
	    @JsonProperty("ZoneName")
		private String ZoneName;
	    @JsonProperty("Price")
		private String Price;
	    @JsonProperty("Color")
		private String Color;
	    @JsonProperty("timeStamp")
		private String timeStamp;
	    @JsonProperty("RecommendedCategories")
		private List<Category> RecommendedCategories;
		
		public String getCategory() {
			return Category;
		}
		public void setCategory(String category) {
			Category = category;
		}
		public String getProductCode() {
			return ProductCode;
		}
		public void setProductCode(String productCode) {
			ProductCode = productCode;
		}
		public String getBrand() {
			return Brand;
		}
		public void setBrand(String brand) {
			Brand = brand;
		}
		public String getSize() {
			return Size;
		}
		public void setSize(String size) {
			Size = size;
		}
		public String getImageUrl() {
			return ImageUrl;
		}
		public void setImageUrl(String imageUrl) {
			ImageUrl = imageUrl;
		}
		public String getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(String timeStamp) {
			this.timeStamp = timeStamp;
		}
		
		public String getZoneName() {
			return ZoneName;
		}
		public void setZoneName(String zoneName) {
			ZoneName = zoneName;
		}
		public String getPrice() {
			return Price;
		}
		public void setPrice(String price) {
			Price = price;
		}
		public String getColor() {
			return Color;
		}
		public void setColor(String color) {
			Color = color;
		}
		public List<Category> getRecommendedCategories() {
			return RecommendedCategories;
		}
		public void setRecommendedCategories(List<Category> recommendedCategories) {
			RecommendedCategories = recommendedCategories;
		}
	
}
