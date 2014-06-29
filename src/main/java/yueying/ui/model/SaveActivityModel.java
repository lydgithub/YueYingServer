package yueying.ui.model;

import java.util.UUID;

public class SaveActivityModel {
	private boolean success;
	private UUID activityId;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public UUID getId() {
		return activityId;
	}
	public void setRes(UUID activityId) {
		this.activityId = activityId;
	}
}
