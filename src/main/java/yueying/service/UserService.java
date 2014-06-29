package yueying.service;

import yueying.dto.entity.User;
import yueying.util.SessionHelper;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	private SessionHelper sessionHelper;

	private SessionHelper getSessionHelper() {
		return sessionHelper;
	}

	@Autowired
	private void setSessionHelper(SessionHelper sessionHelper) {
		this.sessionHelper = sessionHelper;
	}
	
	public User getUser(int userid) {
		Session session = this.getSessionHelper().openSession();
		try {
			User user = (User) session.get(User.class, userid);
			if (user == null)
				return null;
			else
				return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null)
				session.close();
		}
	}
}
