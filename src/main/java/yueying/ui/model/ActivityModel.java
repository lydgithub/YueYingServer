package yueying.ui.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import yueying.util.TimestampAdapter;

@XmlRootElement(name = "activity")
public class ActivityModel {
	private UUID id;
	private byte gentle;
	
	private byte style;
	private String expectation;
	private byte status;
	 
	private String cinemaId;
	private String filmId;
	
	//@XmlJavaTypeAdapter( TimestampAdapter.class)
	private Timestamp starttime;
	private float ticketPrice;
	
	private long launchUserId;
	
	//@XmlJavaTypeAdapter( TimestampAdapter.class)
	private Timestamp launchTime;
	private float launchLat;
	private float launchlog;
	
	private long partnerUserId; 
	
	@XmlElement
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	@XmlElement
	public byte getGentle() {
		return gentle;
	}
	public void setGentle(byte gentle) {
		this.gentle = gentle;
	}
	
	@XmlElement
	public byte getStyle() {
		return style;
	}
	public void setStyle(byte style) {
		this.style = style;
	}
	
	@XmlElement
	public String getExpectation() {
		return expectation;
	}
	public void setExpectation(String expectation) {
		this.expectation = expectation;
	}
	
	@XmlElement
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	
	@XmlElement
	public String getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(String cinemaId) {
		this.cinemaId = cinemaId;
	}
	
	@XmlElement
	public String getFilmId() {
		return filmId;
	}
	public void setFilmId(String filmId) {
		this.filmId = filmId;
	}
	
	@XmlElement
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	
	@XmlElement
	public float getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	@XmlElement
	public long getLaunchUserId() {
		return launchUserId;
	}
	public void setLaunchUserId(long launchUserId) {
		this.launchUserId = launchUserId;
	}
	
	@XmlElement
	public Timestamp getLaunchTime() {
		return launchTime;
	}
	public void setLaunchTime(Timestamp launchTime) {
		this.launchTime = launchTime;
	}
	
	@XmlElement
	public float getLaunchLat() {
		return launchLat;
	}
	public void setLaunchLat(float launchLat) {
		this.launchLat = launchLat;
	}
	
	@XmlElement
	public float getLaunchlog() {
		return launchlog;
	}
	public void setLaunchlog(float launchlog) {
		this.launchlog = launchlog;
	}
	
	@XmlElement
	public long getPartnerUserId() {
		return partnerUserId;
	}
	public void setPartnerUserId(long partnerUserId) {
		this.partnerUserId = partnerUserId;
	}
}
