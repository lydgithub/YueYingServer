package yueying.service;




import java.util.HashSet;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import yueying.dto.entity.Activity;
import yueying.dto.entity.User;
import yueying.ui.model.ActivityModel;
import yueying.util.SessionHelper;
@Component
public class ActivityService {
	private SessionHelper sessionHelper;

	private SessionHelper getSessionHelper() {
		return sessionHelper;
	}

	@Autowired
	private void setSessionHelper(SessionHelper sessionHelper) {
		this.sessionHelper = sessionHelper;
	}
	public boolean saveActivity(UUID activityId,ActivityModel activityModel, long userId) {
		
		Session session = this.getSessionHelper().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			User user = (User) session.get(User.class, userId);
			Activity activity = (Activity) session.get(Activity.class, activityId);
			if (activity == null) {
				activity = new Activity();
				/*
				activity.setId(activityModel.getId());
				activity.setFilmId(activityModel.getFilmId());
				activity.setCinemaId(activityModel.getCinemaId());
				activity.setGentle(activityModel.getGentle());
				activity.setPay(activityModel.getPay());
				activity.setTime(activityModel.getTime());
				activity.setUser(user);
				session.save(activity);
				*/
				
			} 
			else{
				activity.setId(activityModel.getId());
				/*
				activity.setFilmId(activityModel.getFilmId());
				activity.setCinemaId(activityModel.getCinemaId());
				activity.setGentle(activityModel.getGentle());
				activity.setPay(activityModel.getPay());
				activity.setTime(activityModel.getTime());
				*/
			}

			
			session.merge(activity);
			
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			if (session != null)
				session.close();
		}
		
	}

}
