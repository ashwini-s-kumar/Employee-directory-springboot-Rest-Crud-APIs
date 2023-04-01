package com.springboot.restCrudDemo.aop;

import com.springboot.restCrudDemo.entity.Employee;
import com.springboot.restCrudDemo.rest.EmployeeRestController;
import com.springboot.restCrudDemo.service.EmployeeService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class ServiceAspect {
    private static Logger log = Logger.getLogger(ServiceAspect.class.getName());

    @Autowired
    private EmployeeRestController employeeRestController;

    @Around("execution(* com.springboot.restCrudDemo.service.EmployeeServiceImpl.findAll(..))")
    public Object aroundGetEmployeeList(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        log.info("============> Executing @Around on method EmployeeServiceImpl.findAll()");
        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();

        log.info(" ===========> Duration taken to fetch all employees by Service Layer = "+ (end - begin) /1000 +" sec");
        return result;
    }

    @Around("execution(* com.springboot.restCrudDemo.service.EmployeeServiceImpl.findById(..))")
    public Object aroundGetEmployeeById(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        Object result = null;
        log.info("============> Executing @Around on method EmployeeServiceImpl.findById()");
        long begin = System.currentTimeMillis();
        try {
             result = proceedingJoinPoint.proceed();
        }catch (Exception e){
            log.severe("Exception while getting employee by ID in service layer : " + e);
        }
        long end = System.currentTimeMillis();

        log.info(" ===========> Duration taken to fetch all employees by Service Layer = "+ (end - begin) /1000 +" sec");
        return result;
    }
}
