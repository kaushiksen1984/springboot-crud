package com.crud.api.repository;

import com.crud.api.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepository.class);
    public static final String HASH_KEY = "Employee";
    @Autowired
    private RedisTemplate redisTemplate;

    public Employee saveEmployee(Employee employee) {
        redisTemplate.opsForHash().put(HASH_KEY, employee.getEmployeeId(), employee);
        return employee;
    }

    public List<Employee> findAllEmployee() {
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Employee findEmployeeById(int employeeId) {
        LOGGER.info("Called findEmployeeById from Database");
        return (Employee) redisTemplate.opsForHash().get(HASH_KEY, employeeId);
    }

    public String deleteEmployee(int employeeId) {
        redisTemplate.opsForHash().delete(HASH_KEY, employeeId);
        return "Employee has been removed";
    }
}
