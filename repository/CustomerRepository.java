package com.customer.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.customer.sb.entity.Customer;

//Jpa repository for CRUD method
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
