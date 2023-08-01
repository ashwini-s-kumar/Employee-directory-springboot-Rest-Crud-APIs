package com.springboot.restCrudDemo.service;

import com.springboot.restCrudDemo.dao.EmployeeRepository;
import com.springboot.restCrudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    // efficient - supports all the entities with less code
    EmployeeRepository employeeRepository;

    // not efficient - need DAO code implementation for each entity
    // So, switched from EmployeeDao to EmployeeService


    static final Logger log = Logger.getLogger("EmployeeServiceImpl.class.getName()");

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e) {
            log.severe("Exception in EmployeeServiceImpl.findById : " + e);
        }
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e) {
            log.severe("Exception in EmployeeServiceImpl.findById : " + e);
        }
        Optional<Employee> result =  employeeRepository.findById(id);
        Employee employee = null;
        if(result.isPresent()){
            employee = result.get();
        }else {
            throw new RuntimeException("Employee Id not found - "+ id);
        }
        return employee;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
