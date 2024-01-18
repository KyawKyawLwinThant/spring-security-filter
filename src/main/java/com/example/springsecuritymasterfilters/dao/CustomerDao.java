package com.example.springsecuritymasterfilters.dao;

import com.example.springsecuritymasterfilters.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer,Integer> {
}
