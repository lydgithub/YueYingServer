package yueying.ui.model;


public class LocationModel {
	private long userId;
	private float xPoint;
	private float yPoint;
	private String cityName;

	public LocationModel() {
		// TODO Auto-generated constructor stub
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
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

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setPlace(String cityName) {
		this.cityName = cityName;
	}

}
