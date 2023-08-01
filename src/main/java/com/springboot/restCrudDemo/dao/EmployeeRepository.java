package com.springboot.restCrudDemo.dao;

import com.springboot.restCrudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//use JpaRepository - instead of creating the DAOs for each entity
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //no need to write any code
}
