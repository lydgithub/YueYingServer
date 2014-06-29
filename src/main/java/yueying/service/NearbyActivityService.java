package yueying.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import yueying.dto.entity.Activity;
import yueying.dto.entity.User;
import yueying.util.SessionHelper;

@Component
public class NearbyActivityService {

	private SessionHelper sessionHelper;

	private SessionHelper getSessionHelper() {
		return sessionHelper;
	}

	@Autowired
	private void setSessionHelper(SessionHelper sessionHelper) {
		this.sessionHelper = sessionHelper;
	}
	
	public List<Activity> getAllActivity() {
		Session session = this.getSessionHelper().openSession();

		try {
			Query query = session.createQuery("from Activity");
			List<Activity> list = query.list();
			session.close();
			return list;
		} catch (Exception e) {
			System.out.println("error!!!!!!!");
			// TODO Auto-generated catch block
			session.close();
			e.printStackTrace();
			return null;
		}

	}
	
	//add functions
	
}
