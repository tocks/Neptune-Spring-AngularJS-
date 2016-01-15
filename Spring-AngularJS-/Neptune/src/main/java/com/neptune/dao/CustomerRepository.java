package com.neptune.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neptune.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("select c from Customer c where c.owner=:x")
	public List<Customer> getCustmerByOwner(@Param("x")String ownerId);
	
	
	
}
