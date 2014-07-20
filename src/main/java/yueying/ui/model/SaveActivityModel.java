package yueying.ui.model;

import java.util.UUID;

public class SaveActivityModel {
	private boolean success;
	private long activityId;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public long getId() {
		return activityId;
	}
	public void setRes(long activityId) {
		this.activityId = activityId;
	}
}
