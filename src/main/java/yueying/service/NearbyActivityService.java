package yueying.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	
	@SuppressWarnings("unchecked")
	//maybe include an id which represent the sequence of pages
	public List getAllActivity(double xPoint,double yPoint,int listid) {
		Session session = this.getSessionHelper().openSession();
		int sumOfPage = 5;
		List list = new ArrayList();
		
		try {
			session.beginTransaction();
			
			String hql = "select act,u,c "
					+ "from Activity act,User u,Cinema c "
					+ "where act.launchUserId = u.id and act.cinemaId = c.id ";
					
			/*
			String hql = "from Activity act,User u,Cinema c "
					+ "where act.launchUserId = u.id and act.cinemaId = c.id ";
					*/
			Query query = session.createQuery(hql);
			query.setFirstResult((listid - 1) * sumOfPage);
			query.setMaxResults(sumOfPage);
			
			list = query.list();
			
			session.getTransaction().commit();
			session.close();
			return list;
		} catch (Exception e) {
			System.out.println("error!!!!!!!");
			// TODO Auto-generated catch block
			session.getTransaction().rollback();
			session.close();
			e.printStackTrace();
			return null;
		}

	}
	public List getCount(long activityId,int flag){
		
		Session session = this.getSessionHelper().openSession();
		
		List list = new ArrayList();
		
		try {
			session.beginTransaction();
			
			String hql = "select count(apply)"
					+ "from ApplyActivity as apply "
					+ "where apply.activityId= :id and apply.applyStatus = :status ";
					
			/*
			String hql = "from Activity act,User u,Cinema c "
					+ "where act.launchUserId = u.id and act.cinemaId = c.id ";
					*/
			Query query = session.createQuery(hql);
			query.setString("id", new Long(activityId).toString());
			query.setString("status", new Integer(flag).toString());
			
			list = query.list();
			
			session.getTransaction().commit();
			session.close();
			return list;
		} catch (Exception e) {
			System.out.println("error!!!!!!!");
			// TODO Auto-generated catch block
			session.getTransaction().rollback();
			session.close();
			e.printStackTrace();
			return null;
		}
	}
	
	//add functions
	
}
