package com.bank.sb.service;


import com.bank.sb.entity.Bank;

//abstract method for performing CRUD on Customer entity
public interface EmployeeService {
	
	Customer addCustomer(Customer customer);
	
	Customer getCustomerDetail(int cus_id);
	
	Customer updateCustomerDetailCustomer book, int cus_id);
	
	void deleteCustomerDetail(int cus_id);

}
