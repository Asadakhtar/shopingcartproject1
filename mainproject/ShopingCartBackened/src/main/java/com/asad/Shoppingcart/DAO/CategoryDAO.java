package com.asad.Shoppingcart.DAO;

import java.util.List;

import com.asad.Shoppingcart.modal.Category;

public interface CategoryDAO {
	void addCategory(Category c);
	public List<Category>list();
	public boolean update(Category category);
	public boolean delete(String categoryId);
	public boolean delete(Category category);
	public Category getCategoryByID(String categoryId);
	
	
}
