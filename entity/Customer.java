package com.customer.sb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CustomerInfo")

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	private int emp_id;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Customer first Name cannot be blank")
	private String cus_fname;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Customer last Name cannot be blank")
	private String cus_lname;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Customer address cannot be blank")
	private String cus_addr;
	
	@Column(length=11, nullable = false, unique=true)
	@NotNull(message = "Phone number cannot be null")
	private long cus_phone;
	
	@Column(length=20, nullable = false, unique = true)
	@NotBlank(message = "Customer Email ID cannot be blank")
	@Email(message="Email id is not proper")
	private String cus_email;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Customer role cannot be blank")
	private String cus_role;
	
	@Column(length=25, nullable = false)
	@NotNull(message = "Customer salary cannot be blank")
	private int cus_sal;
	
	@ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="CusID", referencedColumnName = "cus_id")
	@JsonBackReference
	private Bank bank;
}
