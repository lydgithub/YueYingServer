package yueying.dto.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "apply")
public class ApplyActivity {
	private long id;
	private UUID activityId;
	private long userId;
	private byte applyStatus; //1 ±¨Ãû£»2 ÊÕ²Ø
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "activity_id", nullable = false)
	public UUID getActivityId() {
		return activityId;
	}
	public void setActivityId(UUID activityId) {
		this.activityId = activityId;
	}
	
	@Column(name = "user_id", nullable = false)
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	@Column(name = "apply_status", nullable = false)
	public byte getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(byte applyStatus) {
		this.applyStatus = applyStatus;
	}

}
