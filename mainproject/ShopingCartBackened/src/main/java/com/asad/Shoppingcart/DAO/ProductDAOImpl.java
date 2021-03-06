package com.asad.Shoppingcart.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asad.Shoppingcart.modal.Category;
import com.asad.Shoppingcart.modal.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	public ProductDAOImpl(){}
	@Autowired
	private SessionFactory sessionFactory;
		
		public ProductDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
		public List<Product> list() {
			
			return	sessionFactory.getCurrentSession().createQuery("from Product").list();
				
			}
		public boolean save(Product product) {
			try
			{
			sessionFactory.getCurrentSession().save(product);
			return true;
			} catch(Exception e)
			{
				e.printStackTrace(); //it will print the error in the console - similar to SOP
				          //package, class, method line number from which place you are calling
				return false;
			}
			
		}
		public boolean update(Product product) {
			try {
				sessionFactory.getCurrentSession().update(product);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
				
			}
		}
		public boolean delete(String pid) {
			try {
				sessionFactory.getCurrentSession().delete(getProductByID(pid));
				return true;
			} catch (Exception e) {
				
				e.printStackTrace();
				return false;
			}
			
		}
		public boolean delete(Product product) {
			try {
				sessionFactory.getCurrentSession().delete(product);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
				
			}
		}
		public Product getProductByID(String pid) {
			
		  
		  return  (Product) sessionFactory.getCurrentSession().createQuery("from Product where id = '"+pid + "'").uniqueResult();
			
		}

		


		public void addProduct(Product p) {
			Session pp=sessionFactory.getCurrentSession();
			pp.persist(p);
			
		
		}


		
}
