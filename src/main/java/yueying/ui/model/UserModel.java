package yueying.ui.model;

import java.util.Date;

//@XmlRootElement(name = "user")
public class UserModel {

	private long id;
	private String name;
	private String password;
	private byte gentle;
	private Date birthday;
	private float height;
	private float weight;
	private float monthlyIncome;
	private int provinceId;
	private int cityId;
	private String job;
	private byte marryed;
	private String tag;
	private String signature;
	private String photoUrl;
	//private Blob photo;
	
//	@XmlElement
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	@XmlElement
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
//	@XmlElement
	public byte getGentle() {
		return gentle;
	}

	public void setGentle(byte gentle) {
		this.gentle = gentle;
	}

//	@XmlElement
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

//	@XmlElement
	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

//	@XmlElement
	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

//	@XmlElement
	public float getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(float monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

//	@XmlElement
	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

//	@XmlElement
	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

//	@XmlElement
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

//	@XmlElement
	public byte getMarryed() {
		return marryed;
	}

	public void setMarryed(byte marryed) {
		this.marryed = marryed;
	}

//	@XmlElement
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

//	@XmlElement
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	

	/*
	@Column(name = "user_photo")
	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	*/

}
