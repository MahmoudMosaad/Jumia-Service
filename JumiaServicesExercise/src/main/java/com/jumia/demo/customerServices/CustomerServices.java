package com.jumia.demo.customerServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jumia.demo.customerRepository.CustomerRepo;
import com.jumia.demo.models.Customer;

@Service
public class CustomerServices {
  
	@Autowired
	private CustomerRepo repo;
	
	public List<Customer> findAll() {
		
		return repo.findAll();
	}
	
	public List<Customer> findByStartWith(String value){
		
		return repo.findByvalue(value);
	}
	
public List<Customer> findByStartWith(String value , int PageNo, int pageSize){
		
	    Pageable pageable = PageRequest.of(PageNo-1, pageSize);
		return repo.findByvalue(value,pageable);
	}
	
	
	public Page<Customer> findPaginated(int PageNo, int pageSize) {
		Pageable pageable = PageRequest.of(PageNo-1, pageSize);
		
		return repo.findAll(pageable);
	}
	

}
