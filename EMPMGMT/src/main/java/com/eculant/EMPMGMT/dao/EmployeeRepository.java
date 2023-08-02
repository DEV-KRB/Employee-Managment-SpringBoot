package com.eculant.EMPMGMT.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eculant.EMPMGMT.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
