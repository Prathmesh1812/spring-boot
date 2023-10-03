package com.customer.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.customer.sb.entity.Employee;
import com.customer.sb.service.EmployeeService;

import jakarta.validation.Valid;

//handle all incoming request of Employee Entity
@RestController
public class CustomerController {
	
	@Autowired
	CustomerService es;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Customer customer){
		return new ResponseEntity<Customer>(es.addCustomer(customer),
				HttpStatus.CREATED);
	}
	
	@GetMapping("/getCustomer/{cus_id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("cus_id") int cus_id){
		return new ResponseEntity<Customer>(es.getCustomerDetail(cus_id),HttpStatus.OK);
	}
	
	@PutMapping("/editCustomer/{cus_id}")
	public ResponseEntity<Customer> editCustomer(@Valid @PathVariable("cus_id") int cus_id, @RequestBody Customer customer){
		return new ResponseEntity<Customer>(es.updateCustomerDetail(customer, cus_id), HttpStatus.OK);
	}
	
	@DeleteMapping("/removeCustomer/{cus_id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("cus_id") int cus_id){
		es.deleteCustomerDetail(emp_id);
		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
	}

}
