package yueying.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import yueying.dto.entity.ApplyActivity;
import yueying.util.SessionHelper;

@Component
public class ApplyActivityService {

	private SessionHelper sessionHelper;

	private SessionHelper getSessionHelper() {
		return sessionHelper;
	}

	@Autowired
	private void setSessionHelper(SessionHelper sessionHelper) {
		this.sessionHelper = sessionHelper;
	}
	
public boolean saveApply(long userId,long activityId){
	Session session = this.getSessionHelper().openSession();
	
	ApplyActivity applyActivity = new ApplyActivity();
	applyActivity.setUserId(userId);
	applyActivity.setActivityId(activityId);
	applyActivity.setApplyStatus((byte)1);
	
	//get the current time
	System.out.print(System.currentTimeMillis());
	applyActivity.setApplyTime(new Timestamp(System.currentTimeMillis()));
	
	try {
		session.beginTransaction();
		
		session.save(applyActivity);
		
		session.getTransaction().commit();
		session.close();
		return true;
		} catch (Exception e) {
		System.out.println("error!!!!!!!");
		// TODO Auto-generated catch block
		session.getTransaction().rollback();
		session.close();
		e.printStackTrace();
		return false;
		}

	}
}
