package com.Hackathon.JCI.FittingRoomIntelligence.Model;

import java.util.List;

public class ProductRequest {

	private String requestType;
	private String userName;
	private String zoneId;
	private String timeStamp;
	private String[] productCodes;
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String[] getProductCodes() {
		return productCodes;
	}
	public void setProductCodes(String[] productCodes) {
		this.productCodes = productCodes;
	}
	
	
	
}
