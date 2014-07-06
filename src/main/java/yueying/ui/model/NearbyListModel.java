package yueying.ui.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class NearbyListModel {
	private List<ActivityInfoModel> nearbylist;

	
	public List<ActivityInfoModel> getNearbylist() {
		return nearbylist;
	}

	public void setNearbylist(List<ActivityInfoModel> nearbylist) {
		this.nearbylist = nearbylist;
	}

}
