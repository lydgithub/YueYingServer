package yueying.ui.helper;

import java.util.UUID;

import org.apache.hadoop.hive.ql.parse.HiveParser.booleanValue_return;
import org.jboss.netty.channel.SucceededChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import yueying.dto.entity.Activity;
import yueying.service.ActivityService;
import yueying.ui.model.ActivityModel;
import yueying.ui.model.SaveActivityModel;
@Component
public class ActivityHelper {
	private ActivityService activityService;
	public ActivityService getActivityService() {
		return activityService;
	}

	@Autowired
	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}
	
	public SaveActivityModel saveActivity(UUID activityId,ActivityModel activityModel,
			int userId) {
		/*Activity activity=new Activity();
		activity.setId(activityModel.getId());
		activity.setFilmId(activityModel.getFilmId());
		activity.setCinemaId(activityModel.getCinemaId());
		activity.setGentle(activityModel.getGentle());
		activity.setPay(activityModel.getPay());
		activity.setTime(activityModel.getTime());
		activity.setUser(null);*/
		boolean success=false;
		if(userId!=activityModel.getUserId())
			success=false;
		else{
			success=this.getActivityService().saveActivity(activityId,activityModel,userId);
		}
		SaveActivityModel saveActivityModel=new SaveActivityModel();
		saveActivityModel.setSuccess(success);
		if(success){
			saveActivityModel.setRes(activityId);
		}
		return saveActivityModel;
	}


	

}
