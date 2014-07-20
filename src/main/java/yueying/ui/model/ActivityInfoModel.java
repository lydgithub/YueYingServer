package yueying.ui.model;

import java.util.UUID;


public class ActivityInfoModel {
	//user info
	private long launchUserId;
	private String photoUrl;
	private String name;
	private byte gentle;
	private int age;
	private String tag;
	
	//activity info
	private long id;
	private byte partnerGentle;
	private byte style;
	private String expectation;
	private String startTime;
	
	
	//cinema info
	private String cinemaId;
	private String cinemaName;
	private String cinemaAddress;
	private int distance;
	
	//fime info
	private String filmId;
	private String filmName;
	private String filmType;
	private String country;
	private float score;
	private int playMinutes;
	private String showTime;
	private String filmUrl;
	
	

	

	public long getLaunchUserId() {
		return launchUserId;
	}

	public void setLaunchUserId(long launchUserId) {
		this.launchUserId = launchUserId;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getGentle() {
		return gentle;
	}

	public void setGentle(byte gentle) {
		this.gentle = gentle;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte getPartnerGentle() {
		return partnerGentle;
	}

	public void setPartnerGentle(byte partnerGentle) {
		this.partnerGentle = partnerGentle;
	}

	public byte getStyle() {
		return style;
	}

	public void setStyle(byte style) {
		this.style = style;
	}

	public String getExpectation() {
		return expectation;
	}

	public void setExpectation(String expectation) {
		this.expectation = expectation;
	}
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(String cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getCinemaAddress() {
		return cinemaAddress;
	}

	public void setCinemaAddress(String cinemaAddress) {
		this.cinemaAddress = cinemaAddress;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}



	public String getFilmId() {
		return filmId;
	}

	public void setFilmId(String filmId) {
		this.filmId = filmId;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getFilmType() {
		return filmType;
	}

	public void setFilmType(String filmType) {
		this.filmType = filmType;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getPlayMinutes() {
		return playMinutes;
	}

	public void setPlayMinutes(int playMinutes) {
		this.playMinutes = playMinutes;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	
	public String getFilmUrl() {
		return filmUrl;
	}

	public void setFilmUrl(String filmUrl) {
		this.filmUrl = filmUrl;
	}
	
	
}
