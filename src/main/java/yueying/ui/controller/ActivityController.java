package yueying.ui.controller;

import java.util.UUID;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.zookeeper.server.SessionTracker.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import yueying.ui.helper.ActivityHelper;
import yueying.ui.model.ActivityListModel;
import yueying.ui.model.ActivityModel;
import yueying.ui.model.FilmModel;
import yueying.ui.model.LocationModel;
import yueying.ui.model.SaveActivityModel;
@Controller
@RequestMapping("/activity")
public class ActivityController {
	private ActivityHelper activityHelper;

	private ActivityHelper getActivityHelper() {
		return activityHelper;
	}

	@Autowired
	private void setActivityHelper(ActivityHelper activityHelper) {
		this.activityHelper = activityHelper;
	}
	
	
	
	@RequestMapping(value = "/getAct/{xPoint}/{yPoint}", method = RequestMethod.GET)
	@ResponseBody
	public ActivityListModel get(@PathVariable float xPoint,@PathVariable float yPoint,HttpServletRequest request){
		float res=xPoint+yPoint;
		ActivityListModel activityListModel=new ActivityListModel();
		activityListModel.setPoint(res);
		return activityListModel;
	}
	
	@RequestMapping(value = "/putAct/{activityId}", method = RequestMethod.POST)
	@ResponseBody
	public SaveActivityModel post(HttpServletRequest request,@PathVariable UUID activityId,
			
			ActivityModel activityModel){
		Integer userId=(Integer) request.getSession().getAttribute("userid");
		return this.getActivityHelper().saveActivity(activityId,activityModel,userId);
		
	}
	@RequestMapping(value = "/getFilm/", method = RequestMethod.POST)
	@ResponseBody
	public FilmModel postLocation(@RequestBody LocationModel locationModel ) {
		
		//System.out.println(locationModel.getxPoint());
		//System.out.println(locationModel.getyPoint());
		//return am.getXpoint() + am.getYpoint();
		FilmModel filmModel=new FilmModel();
		//filmModel.setRes(0);
		return filmModel;
		
	}

}
