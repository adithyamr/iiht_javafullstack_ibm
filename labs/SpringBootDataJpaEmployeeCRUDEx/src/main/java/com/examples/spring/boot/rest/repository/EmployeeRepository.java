package com.examples.spring.boot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.examples.spring.boot.rest.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
