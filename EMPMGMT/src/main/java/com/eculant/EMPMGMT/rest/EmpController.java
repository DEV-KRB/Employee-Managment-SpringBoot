package com.eculant.EMPMGMT.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eculant.EMPMGMT.entity.Employee;
import com.eculant.EMPMGMT.service.EmpService;

@RestController
@RequestMapping("/api")
public class EmpController {
	
	@GetMapping("/")
	public String HelloEmp() {
		
		return "Hello Employee";
	}
	
	//inject employee dao
	private EmpService empService;
	
	//constructor injection
	@Autowired
	public EmpController(EmpService theEmpService) {
		
		empService = theEmpService;
	}
	
	//expose /employees and return list of employee
	@GetMapping("/employees")
	public List<Employee> showAll(){
		return empService.showAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = empService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee not available");
		}
		
		return theEmployee;
	}
}
