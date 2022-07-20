package com.crud.api.controller;

import com.crud.api.model.Employee;
import com.crud.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@EnableCaching
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/addEmployee")
    public Employee saveEmployee(@RequestBody Employee employee) {

        return employeeRepository.saveEmployee(employee);
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAllEmployee();
    }

    @GetMapping("/findEmployeeByEmployeeId/{employeeId}")
    @Cacheable(key = "#employeeId",value = "Product")
    public Employee findProduct(@PathVariable int employeeId) {

        return employeeRepository.findEmployeeById(employeeId);
    }
    @DeleteMapping("/deleteEmployee/{employeeId}")
    @CacheEvict(key = "#employeeId", value = "Employee")
    public String remove(@PathVariable int employeeId)   {

        return employeeRepository.deleteEmployee(employeeId);
    }
}
