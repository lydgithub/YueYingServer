package yueying.ui.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yueying.ui.helper.ActivityHelper;
import yueying.ui.helper.NearbyActivityHelper;
import yueying.ui.model.ActivityListModel;
import yueying.ui.model.NearbyListModel;

@Controller
@RequestMapping("/nearby")
public class NearbyActivityController {
	private NearbyActivityHelper nearbyActivityHelper;

	public NearbyActivityHelper getNearbyActivityHelper() {
		return nearbyActivityHelper;
	}

	@Autowired
	public void setNearbyActivityHelper(NearbyActivityHelper nearbyActivityHelper) {
		this.nearbyActivityHelper = nearbyActivityHelper;
	}
	
	@RequestMapping(value = "/getActlist/{xPoint}/{yPoint}/{listid}", method = RequestMethod.GET)
	@ResponseBody
	public NearbyListModel get(@PathVariable float xPoint,@PathVariable float yPoint,@PathVariable int listid,HttpServletRequest request){
		System.out.println("enter!");
		return this.getNearbyActivityHelper().getNearbyActivity(xPoint,yPoint,listid);
	}

	

}
