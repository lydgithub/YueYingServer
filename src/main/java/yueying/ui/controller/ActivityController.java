package yueying.ui.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yueying.ui.helper.ActivityHelper;
import yueying.ui.model.ActivityListModel;
import yueying.ui.model.ActivityModel;
import yueying.ui.model.CinemaListModel;
import yueying.ui.model.FilmBriefListModel;
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


    /*
	@RequestMapping(value = "/getAct/{xPoint}/{yPoint}", method = RequestMethod.GET)
	@ResponseBody
	public ActivityListModel get(@PathVariable float xPoint,@PathVariable float yPoint,HttpServletRequest request){
		float res=xPoint+yPoint;
		ActivityListModel activityListModel=new ActivityListModel();
		activityListModel.setPoint(res);
		return activityListModel;
	}
	*/

	@RequestMapping(value = "/putAct/{activityId}", method = RequestMethod.POST)
	@ResponseBody
	public SaveActivityModel post(HttpServletRequest request,@PathVariable long activityId,

			ActivityModel activityModel){
		Integer userId=(Integer) request.getSession().getAttribute("userid");
		return this.getActivityHelper().saveActivity(activityId,activityModel,userId);

	}
	/*@RequestMapping(value = "/getFilm/", method = RequestMethod.POST)
	@ResponseBody
	public FilmModel postLocation(@RequestBody LocationModel locationModel ) {

		FilmModel filmModel=new FilmModel();
		filmModel.setId("0");
		System.out.println("yes!go!");
		return this.getActivityHelper().getFilm(locationModel);

	}*/
	@RequestMapping(value = "/getFilm/{cityName}", method = RequestMethod.GET)
	@ResponseBody
	public FilmBriefListModel postLocation(HttpServletRequest request,@PathVariable String cityName) {

		return this.getActivityHelper().getFilm(cityName);

	}

	
/*	@RequestMapping(value = "/getFilm", method = RequestMethod.POST)
	public @ResponseBody
	FilmBriefListModel postLocation(@RequestBody  LocationModel lm ) {

		System.out.println(lm.getxPoint());
		return this.getActivityHelper().getFilm(lm);

	}*/
	
	@RequestMapping(value = "/getCinema/{movieId}/{cityName}/{xPoint}/{yPoint}", method = RequestMethod.GET)
	@ResponseBody
	public CinemaListModel getCinemas(HttpServletRequest request,@PathVariable double xPoint,@PathVariable double yPoint,@PathVariable String movieId,@PathVariable String cityName) {
		System.out.println(yPoint);
		System.out.println("!!!!!!!!!!!!");
		return this.getActivityHelper().getCinemas(xPoint,yPoint,cityName,movieId);

	}

}