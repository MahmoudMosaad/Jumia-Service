package com.jumia.demo.customerRepository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jumia.demo.models.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	@Query(value = "select * from customer c where c.phone like :value%", nativeQuery = true )
	public List<Customer> findByvalue(@Param("value") String value);
	
	@Query(value = "select * from customer c where c.phone like :value%", nativeQuery = true )
	public List<Customer> findByvalue(@Param("value") String value,Pageable page);

}
