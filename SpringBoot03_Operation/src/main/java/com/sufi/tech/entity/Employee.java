package com.sufi.tech.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="empl")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Long empid;
	
	@Column
	private String emp_name;
	@Column
	private String emp_address;
	@Column
	
	private String emp_city;
	@Column
	private float emp_salary;
	
	
	public Long getId() {
		return empid;
	}
	public void setId(Long empid) {
		this.empid = empid;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_address() {
		return emp_address;
	}
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
	public String getEmp_city() {
		return emp_city;
	}
	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}
	public float getEmp_salary() {
		return emp_salary;
	}
	public void setEmp_salary(float emp_salary) {
		this.emp_salary = emp_salary;
	}
	
	

}
