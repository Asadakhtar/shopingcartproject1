package com.asad.Shoppingcart.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asad.Shoppingcart.modal.Authorization;
import com.asad.Shoppingcart.modal.User;
@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	public UserDAOImpl(){}
	@Autowired
private SessionFactory sessionFactory;
	

	public UserDAOImpl(SessionFactory sessionFactory) {
	super();
	this.sessionFactory = sessionFactory;
}


	public void addUser(User u) {
		Session ss=sessionFactory.getCurrentSession();
		Authorization auth=new Authorization();
		auth.setRole("ROLE_USER");
		u.setUid(u.getName());
		auth.setUid(u.getUid());
		u.setEnable(true);
		ss.persist(u);
		ss.persist(auth);
	}

}
