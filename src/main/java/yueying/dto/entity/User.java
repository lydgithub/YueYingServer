package yueying.dto.entity;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mysql.jdbc.Blob;

@Entity
@Table(name = "user")
public class User {
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name", unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "gentle")
	public byte getGentle() {
		return gentle;
	}

	public void setGentle(byte gentle) {
		this.gentle = gentle;
	}

	@Column(name = "birthday")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "height")
	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	@Column(name = "weight")
	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Column(name = "monthly_income")
	public float getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(float monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	@Column(name = "province_id")
	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	@Column(name = "city_id")
	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	@Column(name = "job")
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name = "ismarry")
	public byte getMarryed() {
		return marryed;
	}

	public void setMarryed(byte marryed) {
		this.marryed = marryed;
	}

	@Column(name = "user_tag")
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Column(name = "signature")
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	
	@Column(name = "user_photo")
	public String getPhoto() {
		return photoUrl;
	}

	public void setPhoto(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	

	
	//private Set<Activity> promotedActivities;

	/*
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	public Set<Activity> getPromotedActivities() {
		return promotedActivities;
	}

	public void setPromotedActivities(Set<Activity> promotedActivities) {
		this.promotedActivities = promotedActivities;
	}
	*/

}
