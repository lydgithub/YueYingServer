package yueying.dto.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "activity")
public class Activity{
	private UUID id;
	private UUID filmId;
	private UUID cinemaId;
	private String gentle;
	private String pay;
	private User user;
	private String time;
	
	@Id
	@Column(name = "id", length = 16)
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	@Column(name = "cinemaId", length = 16)
	public UUID getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(UUID cinemaId) {
		this.cinemaId = cinemaId;
	}
	@Column(name = "filmId", length = 16)
	public UUID getFilmId() {
		return filmId;
	}
	public void setFilmId(UUID filmId) {
		this.filmId = filmId;
	}
	@Column(name = "gentle")
	public String getGentle() {
		return gentle;
	}
	public void setGentle(String gentle) {
		this.gentle = gentle;
	}
	@Column(name = "pay")
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	
	@ManyToOne
	@JoinColumn(name="user_id",referencedColumnName="id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Column(name = "time")
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
