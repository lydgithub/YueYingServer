package yueying.ui.helper;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import yueying.service.ApplyActivityService;
import yueying.ui.model.AckModel;

@Component
public class ApplyActivityHelper {
	private ApplyActivityService applyActivityService;

	public ApplyActivityService getApplyActivityService() {
		return applyActivityService;
	}

	@Autowired
	public void setApplyActivityService(ApplyActivityService applyActivityService) {
		this.applyActivityService = applyActivityService;
	}
	
	public AckModel saveApply(long userId,long activityId){
		AckModel ackModel = new AckModel();
		if(applyActivityService.saveApply(userId, activityId))
			ackModel.setStatus(200);
		else
			ackModel.setStatus(400);
		
		return ackModel;
		
	}
	
}
