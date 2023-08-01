package com.eculant.EMPMGMT.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eculant.EMPMGMT.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	//define field for Entity Manager
	private EntityManager entityManager;
	
	//setup constructor injection
	@Autowired
	public EmployeeDaoImpl(EntityManager theEntityManager) {
		
		entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public List<Employee> showAll() {
		
		//get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create the query
		Query<Employee> theQuery =
				currentSession.createQuery("from Employee", Employee.class);
		
		//execute the query and get result list
		List<Employee> theEmployees = theQuery.getResultList();
		
		//return the results
		return theEmployees;
	}

}
