package yueying.ui.model;

import java.util.UUID;

public class LocationModel {
	private UUID userId;
	private float xPoint;
	private float yPoint;
	private String cityName;
	public LocationModel() {
		// TODO Auto-generated constructor stub
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public float getxPoint() {
		return xPoint;
	}
	public void setxPoint(float xPoint) {
		this.xPoint = xPoint;
	}
	public float getyPoint() {
		return yPoint;
	}
	public void setyPoint(float yPoint) {
		this.yPoint = yPoint;
	}
	public String getPlace() {
		return cityName;
	}
	public void setPlace(String cityName) {
		this.cityName = cityName;
	} 
	
}
