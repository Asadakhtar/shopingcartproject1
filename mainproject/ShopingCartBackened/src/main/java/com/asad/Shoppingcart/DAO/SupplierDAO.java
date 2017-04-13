package com.asad.Shoppingcart.DAO;

import java.util.List;


import com.asad.Shoppingcart.modal.Supplier;

public interface SupplierDAO {
 void addSupplier(Supplier s);
    public List<Supplier> list();
	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete(String suplierId);
	public boolean delete( Supplier supplier);
}
