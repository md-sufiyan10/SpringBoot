package com.sufi.tech.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sufi.tech.entity.Employee;
import com.sufi.tech.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	// create 
	
	@PostMapping()
	public String createEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "Employee Details Insert Sucsessfully...";	
	}
	
	// read (get details using id and all ---)
	
	@GetMapping()
	
	public ResponseEntity<List<Employee>>  getAllEmployee(){
		List<Employee> list=new ArrayList<Employee>();
		employeeRepository.findAll().forEach(list::add);
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}
	@GetMapping("/{empid}")
	public ResponseEntity<Employee> getEmployeeById( @PathVariable long empid) {
		Optional<Employee> emp=employeeRepository.findById(empid);
			if(emp.isPresent()) {
				return new ResponseEntity<Employee>(emp.get(),HttpStatus.FOUND);
			}else {
				return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
			}
	}
	
	// update
	
	@PutMapping("/{empid}")
	public String  updateEmployee(@PathVariable long empid, @RequestBody Employee employee){
		Optional<Employee> emp = employeeRepository.findById(empid);
		if(emp.isPresent()) {
			   Employee existEmp = emp.get();
			   existEmp.setEmp_name(employee.getEmp_name());
			   existEmp.setEmp_address(employee.getEmp_address());
			   existEmp.setEmp_city(employee.getEmp_city());
			   existEmp.setEmp_salary(employee.getEmp_salary());
			   
			   employeeRepository.save(existEmp);
			   return "Employee Details against ID "+ empid + "updated";
		}else {
		 return "Employee Details does not exist for empid " +empid;
	}
 }
	// delete by id 
		@DeleteMapping("/{empid}")
		
		public String deleteEmployeeByEmpId(@PathVariable long empid) {
			employeeRepository.deleteById(empid);
			return "employee Deleted Successfully by Id:" +empid;
		}
	
	// delete by All Empl 
		@DeleteMapping()
		public String deleteAllEmployee() {
			employeeRepository.deleteAll();
			return "Employee Deleted Successfully..";
		
	}
}
