package yueying.dto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cinema")
public class Cinema {
	private String id;
	private String name;
	private String address;
	private float latitude;
	private float logitude;
	
	@Id
	@Column(name = "id", nullable = false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "latitude")
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
	@Column(name = "logitude")
	public float getLogitude() {
		return logitude;
	}
	public void setLogitude(float logitude) {
		this.logitude = logitude;
	}
	
	
	

}
