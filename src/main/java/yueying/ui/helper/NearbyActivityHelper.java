package yueying.ui.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import yueying.dto.entity.Activity;
import yueying.service.NearbyActivityService;
import yueying.ui.model.NearbyActivityModel;
import yueying.ui.model.NearbyListModel;

@Component
public class NearbyActivityHelper {
	
	private NearbyActivityService nearbyActivityService;
	
	public NearbyActivityService getNearbyActivityService() {
		return nearbyActivityService;
	}

	@Autowired
	public void setNearbyActivityService(NearbyActivityService nearbyActivityService) {
		this.nearbyActivityService = nearbyActivityService;
	}


	public NearbyListModel getNearbyActivity(float xPoint,float yPoint){
		//getNearbyActivity
		List<Activity> list = this.getNearbyActivityService().getAllActivity();
		if(list==null)
    		return null;
		
		NearbyListModel nearbyListModel = new NearbyListModel();
		List<NearbyActivityModel> nearbyActivityList = new ArrayList<NearbyActivityModel>();
		for(Activity activity:list){
			//get the corresbonding user info
			//cinema info
			//film info
			//the sum of apply and collecting person
			//combine above info into NearbyActivity model
			//return the nearbyList
			NearbyActivityModel nearbyActivityModel = new NearbyActivityModel();
			nearbyActivityList.add(nearbyActivityModel);
		}
		
		nearbyListModel.setNearbylist(nearbyActivityList);
    	return nearbyListModel;
    }

}
