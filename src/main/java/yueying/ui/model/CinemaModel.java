package yueying.ui.model;

import java.util.List;

public class CinemaModel {
	
	private String id;
	private String name;
	private String address;
	private double latitude;
	private double logitude;
	private String distance;
	
	private List<BroadcastModel> broadcast;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLogitude() {
		return logitude;
	}
	public void setLogitude(double logitude) {
		this.logitude = logitude;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public List<BroadcastModel> getBroadcast() {
		return broadcast;
	}
	public void setBroadcast(List<BroadcastModel> broadcast) {
		this.broadcast = broadcast;
	}

}
