package com.example.springsecuritymasterfilters.dao;

import com.example.springsecuritymasterfilters.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {
}
