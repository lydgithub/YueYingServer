package yueying.ui.model;

import java.util.UUID;

public class ActivityModel {
	private UUID id;
	private UUID filmId;
	private UUID cinemaId;
	private int userId;
	private String gentle;
	private String pay;
	private String time;
	private String comment;
	public ActivityModel() {
		// TODO Auto-generated constructor stub
	} 
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getFilmId() {
		return filmId;
	}
	public void setFilmId(UUID filmId) {
		this.filmId = filmId;
	}
	public UUID getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(UUID cinemaId) {
		this.cinemaId = cinemaId;
	}
	public String getGentle() {
		return gentle;
	}
	public void setGentle(String gentle) {
		this.gentle = gentle;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
