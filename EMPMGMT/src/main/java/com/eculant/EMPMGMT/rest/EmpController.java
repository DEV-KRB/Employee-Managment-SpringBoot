package com.eculant.EMPMGMT.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eculant.EMPMGMT.dao.EmployeeDao;
import com.eculant.EMPMGMT.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmpController {
	
	@GetMapping("/")
	public String HelloEmp() {
		
		return "Hello Employee";
	}
	
	//inject employee dao
	private EmployeeDao employeeDao;
	
	//constructor injection
	@Autowired
	public EmpController(EmployeeDao theEmployeeDao) {
		
		employeeDao = theEmployeeDao;
	}
	
	//expose /employees and return list of employee
	@GetMapping("/employees")
	public List<Employee> showAll(){
		return employeeDao.showAll();
	}
}
