package com.customer.sb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.sb.entity.Customer;
import com.customer.sb.exception.CustomereIdNotFoundException;
import com.customer.sb.repository.CustomerRepository;
import com.customer.sb.service.CustomerService;

//business logic(CRUD Implementation) of entity Customer
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository erepo;

	@Override
	public Employee addCustomer(Customer customer) {
		
		return erepo.save(customer);
	}

	@Override
	public Customer getCustomerDetail(int cus_id) {
		return erepo.findById(cus_id).
		         orElseThrow(()-> new CustomerIdNotFoundException("Customer Id is not correct"));
	}

	@Override
	public Customer updateCustomerDetail(Customer customer, int cus_id) {
		Customer updatedCustomer = erepo.findById(emp_id).
		         orElseThrow(()-> new CustomerIdNotFoundException("Customer Id is not correct"));

		updatedCustomer.setCus_phone(customer.getCus_phone());
		updatedCustomer.setCus_email(customer.getCus_email());
		
		erepo.save(updatedCustomer); //saving updated details 
			return updatedCustomer; 
		
	}

	@Override
	public void deleteCustomerDetail(int cus_id) {
		erepo.findById(cus_id).
		orElseThrow(()-> new CustomerIdNotFoundException("Customer Id is not correct"));
	    erepo.deleteById(cus_id);
		
	}

}
