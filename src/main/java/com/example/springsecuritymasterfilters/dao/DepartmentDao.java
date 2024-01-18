package com.example.springsecuritymasterfilters.dao;

import com.example.springsecuritymasterfilters.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentDao extends CrudRepository<Department,Integer> {
}
