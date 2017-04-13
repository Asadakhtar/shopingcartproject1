package com.asad.Shoppingcart.DAO;

import java.util.List;


import com.asad.Shoppingcart.modal.Product;

public interface ProductDAO {
	void addProduct(Product p);
	public List<Product> list();
	public boolean save(Product product);
	public boolean update(Product product);
	public boolean delete(String pid);
	public boolean delete( Product product);
	//public Product getproductByID(String pid);
	
}
