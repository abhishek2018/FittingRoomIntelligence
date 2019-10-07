package com.Hackathon.JCI.FittingRoomIntelligence.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Recommendation {

	@JsonProperty("productcode")
	private String productcode;
	@JsonProperty("support")
    private double support;
	@JsonProperty("confidence")
    private double confidence;
	@JsonProperty("lift")
    private double lift;
	@JsonProperty("conviction")
    private double conviction;
    
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	public double getSupport() {
		return support;
	}
	public void setSupport(double support) {
		this.support = support;
	}
	public double getConfidence() {
		return confidence;
	}
	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}
	public double getLift() {
		return lift;
	}
	public void setLift(double lift) {
		this.lift = lift;
	}
	public double getConviction() {
		return conviction;
	}
	public void setConviction(double conviction) {
		this.conviction = conviction;
	}
	
	
	
	
}
