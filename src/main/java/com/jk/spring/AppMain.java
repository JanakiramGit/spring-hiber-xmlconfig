package com.jk.spring;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.jk.spring.configuration.AppConfig;
import com.jk.spring.model.Employee;
import com.jk.spring.service.EmployeeService;

public class AppMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		 
        EmployeeService service = (EmployeeService) context.getBean("employeeService");
 
        /*
         * Create Employee1
         */
        Employee employee1 = new Employee();
        employee1.setName("Test User1");
        employee1.setJoiningDate(new LocalDate(2010, 10, 10));
        employee1.setSalary(new BigDecimal(10000));
        employee1.setSsn("SSN001");
 
        /*
         * Create Employee2
         */
        Employee employee2 = new Employee();
        employee2.setName("Test User2");
        employee2.setJoiningDate(new LocalDate(2012, 11, 11));
        employee2.setSalary(new BigDecimal(20000));
        employee2.setSsn("SSN002");
 
        /*
         * Persist both Employees
         */
        service.saveEmployee(employee1);
        service.saveEmployee(employee2);
 
        /*
         * Get all employees list from database
         */
        List<Employee> employees = service.findAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp);
        }      
 
        /*
         * update an employee
         */
// 
//        Employee employee = service.findBySsn("SSN001");
//        employee.setSalary(new BigDecimal(50000));
//        service.updateEmployee(employee);
 
        /*
         * delete an employee
         */
        service.deleteEmployeeBySsn("SSN001");
        service.deleteEmployeeBySsn("SSN002");
        
        /*
         * Get all employees list from database
         */
        List<Employee> employeeList = service.findAllEmployees();
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
 
        ((ConfigurableApplicationContext)context).close();

	}

}
