package yueying.ui.helper;

import yueying.dto.entity.User;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import yueying.service.UserService;
import yueying.ui.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserHelper {
	private UserService userService;
	private UserService getUserService() {
		return userService;
	}

	@Autowired
	private void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public UserModel getUser(int userid){
		User user=this.getUserService().getUser(userid);
		if(user==null)
			return null;
		UserModel userModel=new UserModel();
		
		userModel.setId(user.getId());
		userModel.setName(user.getName());
		userModel.setPassword(user.getPassword());
		userModel.setGentle(user.getGentle());
		userModel.setBirthday(user.getBirthday());
		userModel.setHeight(user.getHeight());
		userModel.setWeight(user.getWeight());
		userModel.setMonthlyIncome(user.getMonthlyIncome());
		userModel.setProvinceId(user.getProvinceId());
		userModel.setCityId(user.getCityId());
		userModel.setJob(user.getJob());
		userModel.setMarryed(user.getMarryed());
		userModel.setTag(user.getTag());
		userModel.setSignature(user.getSignature());
		
		return userModel;
		
	}
}
