package com.bank.retailbanking.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description- Entity class for storing the customer details.
 * @author Bindushree
 * 
 */

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@SequenceGenerator(name = "customerIdSequencer", initialValue = 1001, allocationSize = 1)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerIdSequencer")
	private Long customerId;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateOfBirth;
	private String gender;
	private Long mobileNumber;


}
