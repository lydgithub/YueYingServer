package yueying.dto.entity;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.apache.hadoop.hive.ql.parse.HiveParser.stringLiteralSequence_return;
@Entity
@Table(name = "activity")
public class Activity{
	private UUID id;
	private byte gentle;
	
	private byte style;
	private String expectation;
	private byte status;
	 
	private String cinemaId;
	private String filmId;
	private Timestamp starttime;
	private float ticketPrice;
	
	private long launchUserId;
	private Timestamp launchTime;
	private float launchLat;
	private float launchlog;

	
	private long partnerUserId; 
	
	@Id
	@Column(name = "id", length = 16)
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	@Column(name = "gentle")
	public byte getGentle() {
		return gentle;
	}
	public void setGentle(byte gentle) {
		this.gentle = gentle;
	}
	
	@Column(name = "style")
	public byte getStyle() {
		return style;
	}
	public void setStyle(byte style) {
		this.style = style;
	}
	
	@Column(name = "expectation")
	public String getExpectation() {
		return expectation;
	}
	public void setExpectation(String expectation) {
		this.expectation = expectation;
	}
	
	@Column(name = "status")
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	
	@Column(name = "cinema_id")
	public String getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(String cinemaId) {
		this.cinemaId = cinemaId;
	}
	
	@Column(name = "film_id")
	public String getFilmId() {
		return filmId;
	}
	public void setFilmId(String filmId) {
		this.filmId = filmId;
	}
	
	@Column(name = "start_time")
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	
	@Column(name = "ticket_price")
	public float getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	@Column(name = "launch_userid")
	public long getLaunchUserId() {
		return launchUserId;
	}
	public void setLaunchUserId(long launchUserId) {
		this.launchUserId = launchUserId;
	}
	
	@Column(name = "launch_time")
	public Timestamp getLaunchTime() {
		return launchTime;
	}
	public void setLaunchTime(Timestamp launchTime) {
		this.launchTime = launchTime;
	}
	
	@Column(name = "launch_lat")
	public float getLaunchLat() {
		return launchLat;
	}
	public void setLaunchLat(float launchLat) {
		this.launchLat = launchLat;
	}
	
	@Column(name = "launch_log")
	public float getLaunchlog() {
		return launchlog;
	}
	public void setLaunchlog(float launchlog) {
		this.launchlog = launchlog;
	}
	
	@Column(name = "partner_userid")
	public long getPartnerUserId() {
		return partnerUserId;
	}
	public void setPartnerUserId(long partnerUserId) {
		this.partnerUserId = partnerUserId;
	}
	
	

}
