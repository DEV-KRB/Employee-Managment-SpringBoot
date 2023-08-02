package com.eculant.EMPMGMT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eculant.EMPMGMT.dao.EmployeeRepository;
import com.eculant.EMPMGMT.entity.Employee;

@Service
public class EmpServiceImpl implements EmpService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmpServiceImpl(EmployeeRepository theEmployeeRepository) {
		
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Employee> showAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		if(result.isPresent()) {
			return result.get();
		}
		else {
			System.out.println("not found");
		}
		return theEmployee ;
	}

	@Override
	public void save(Employee theEmployee) {
		
		employeeRepository.save(theEmployee);
		
	}

	@Override
	public void deleteEmpById(int theId) {
		
		employeeRepository.deleteById(theId);
		
	}

}
