package yueying.ui.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yueying.ui.helper.ApplyActivityHelper;
import yueying.ui.model.AckModel;
import yueying.ui.model.NearbyListModel;

@Controller
@RequestMapping("/apply")
public class ApplyActivityController {
	private ApplyActivityHelper applyActivityHelper;

	public ApplyActivityHelper getApplyActivityHelper() {
		return applyActivityHelper;
	}

	@Autowired
	public void setApplyActivityHelper(ApplyActivityHelper applyActivityHelper) {
		this.applyActivityHelper = applyActivityHelper;
	}
	
	@RequestMapping(value = "/{userid}/{activityid}",method = RequestMethod.GET)
	@ResponseBody
	public AckModel saveApply(@PathVariable long userid,@PathVariable long activityid,HttpServletRequest request){
		System.out.println("enter the apply controller!");
		return this.getApplyActivityHelper().saveApply(userid, activityid);
		
	}

}
