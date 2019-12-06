package com.bank.retailbanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.retailbanking.entity.CustomerAccountDetails;

/**
 * @author Bindushree
 *
 */

@Repository
public interface CustomerAccountDetailsRepository extends JpaRepository<CustomerAccountDetails, Long> {

}
