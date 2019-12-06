package com.bank.retailbanking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.retailbanking.entity.Customer;

/**
 * @author Bindushree
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	/**
	 * 
	 * @param email
	 * @param mobileNumber
	 * @return
	 */

	Optional<Customer> findByEmailAndMobileNumber(String email, Long mobileNumber);
	
	

}
