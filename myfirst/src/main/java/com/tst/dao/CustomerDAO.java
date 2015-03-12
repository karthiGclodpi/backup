package com.tst.dao;

import com.tst.model.Customer;

public interface CustomerDAO {
	
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);

}
