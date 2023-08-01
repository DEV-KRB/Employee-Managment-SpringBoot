package com.eculant.EMPMGMT.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.eculant.EMPMGMT.dao.EmployeeDao;
import com.eculant.EMPMGMT.entity.Employee;

public class EmpServiceImpl implements EmpService {

	private EmployeeDao employeeDao;
	
	public EmpServiceImpl(EmployeeDao theEmployeeDao) {
		
		employeeDao = theEmployeeDao;
	}
	
	@Override
	@Transactional
	public List<Employee> showAll() {
		// TODO Auto-generated method stub
		return employeeDao.showAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDao.findEmpById(theId);
	}

}
