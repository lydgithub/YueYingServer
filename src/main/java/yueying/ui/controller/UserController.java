package yueying.ui.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yueying.ui.helper.UserHelper;
import yueying.ui.model.UserModel;

@Controller
@RequestMapping("/user")
public class UserController {
	private UserHelper userHelper;

	public UserHelper getUserHelper() {
		return userHelper;
	}

	@Autowired
	public void setUserHelper(UserHelper userHelper) {
		this.userHelper = userHelper;
	}
	
	@RequestMapping(value = "/get/{userid}", method = RequestMethod.GET)
	@ResponseBody
	public UserModel get(@PathVariable int userid,HttpServletRequest request){
		
		System.out.println("enter!");
				
		return this.getUserHelper().getUser(userid);
				
		
	}
}
