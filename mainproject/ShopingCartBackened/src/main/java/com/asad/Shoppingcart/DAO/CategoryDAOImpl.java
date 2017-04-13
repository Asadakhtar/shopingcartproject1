package com.asad.Shoppingcart.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asad.Shoppingcart.modal.Category;



@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO  {
	public CategoryDAOImpl(){}
	@Autowired
	private SessionFactory sessionFactory;
		
		public CategoryDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
		public List<Category> list() {
			
		return	sessionFactory.getCurrentSession().createQuery("from Category").list();	
		}
		public boolean update(Category category) {
			try {
				sessionFactory.getCurrentSession().update(category);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
				
			}
		}
		public boolean delete(String categoryId) {
			try {
				sessionFactory.getCurrentSession().delete(getCategoryByID(categoryId));
				return true;
			} catch (Exception e) {
				
				e.printStackTrace();
				return false;
			}	
		}
		public boolean delete(Category category) {
			try {
				sessionFactory.getCurrentSession().delete(category);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;	
			}
		}
		public Category getCategoryByID(String categoryId) {
			  
		  return  (Category) sessionFactory.getCurrentSession().get(Category.class,categoryId);
		}

		public void addCategory(Category c) {
			Session cc=sessionFactory.getCurrentSession();
			c.setCategoryId(c.getCategoryName());
			cc.persist(c);
		}
		
}
