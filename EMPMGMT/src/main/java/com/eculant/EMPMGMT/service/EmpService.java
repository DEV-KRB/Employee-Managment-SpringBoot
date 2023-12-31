package com.eculant.EMPMGMT.service;

import java.util.List;

import com.eculant.EMPMGMT.entity.Employee;

public interface EmpService {

	public List<Employee> showAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteEmpById(int theId);
}
