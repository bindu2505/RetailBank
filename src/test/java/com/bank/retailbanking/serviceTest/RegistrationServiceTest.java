package com.bank.retailbanking.serviceTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.bank.retailbanking.dto.RegistrationRequestDto;
import com.bank.retailbanking.dto.RegistrationResponseDto;
import com.bank.retailbanking.entity.Customer;
import com.bank.retailbanking.exception.AgeException;
import com.bank.retailbanking.exception.GeneralException;
import com.bank.retailbanking.exception.InvalidRegistrationException;
import com.bank.retailbanking.repository.CustomerAccountDetailsRepository;
import com.bank.retailbanking.repository.CustomerRepository;
import com.bank.retailbanking.service.RegistrationServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest {

	@InjectMocks
	RegistrationServiceImpl registrationServiceImpl;

	@Mock
	CustomerAccountDetailsRepository customerAccountDetailsRepository;

	@Mock
	CustomerRepository customerRepository;

	RegistrationRequestDto registrationRequestDto = null;
	RegistrationResponseDto registrationResponseDto = null;

	@Before
	public void before() {
		registrationRequestDto = new RegistrationRequestDto();
		registrationRequestDto.setEmail("bindu@gmail.com");
		registrationRequestDto.setDateOfBirth(LocalDate.of(1997, 10, 2));
		registrationRequestDto.setFirstName("Bind");
		registrationRequestDto.setLastName("shree");
		registrationRequestDto.setGender("female");
		registrationRequestDto.setMobileNumber(2653871738L);
		registrationRequestDto.setAmount(5000.00);

		registrationResponseDto = new RegistrationResponseDto();
		registrationResponseDto.setCustomerId(1878L);
		registrationResponseDto.setMessage("success");
		registrationResponseDto.setPassword("BS4668");
		registrationResponseDto.setStatusCode(200);
	}

	@Test
	public void registerCustomerTestForSuccess()
			throws GeneralException, AgeException, InvalidRegistrationException {
		RegistrationResponseDto response = registrationServiceImpl.registerCustomer(registrationRequestDto);
		assertNotNull(response);

	}

	@Test(expected = InvalidRegistrationException.class)
	public void registerCustomerTestForInvalidRegistration()
			throws GeneralException, AgeException, InvalidRegistrationException {

		Customer customer = new Customer();
		customer.setEmail("bindu@gmail.com");
		Mockito.when(customerRepository.findByEmailAndMobileNumber(registrationRequestDto.getEmail(),registrationRequestDto.getMobileNumber()))
				.thenReturn(Optional.of(customer));
		RegistrationResponseDto response = registrationServiceImpl.registerCustomer(registrationRequestDto);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, response);
	}

	@Test(expected = AgeException.class)
	public void registerCustomerTestForInvalidAge()
			throws GeneralException, AgeException, InvalidRegistrationException {

		Customer customer = new Customer();
		customer.setEmail("bindusri@gmail.com");
		registrationRequestDto.setDateOfBirth(LocalDate.of(2010, 10, 2));
		RegistrationResponseDto response = registrationServiceImpl.registerCustomer(registrationRequestDto);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, response);

	}

	@Test(expected = GeneralException.class)
	public void registerCustomerTestForInvalidMobileNumber()
			throws GeneralException, AgeException, InvalidRegistrationException {
		registrationRequestDto.setDateOfBirth(LocalDate.of(1997, 10, 2));
		registrationRequestDto.setMobileNumber(26538718L);
		RegistrationResponseDto response = registrationServiceImpl.registerCustomer(registrationRequestDto);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, response);
	}
	
	@Test(expected = GeneralException.class)
	public void registerCustomerTestForInvalidOpeningBalance()
			throws GeneralException, AgeException, InvalidRegistrationException {
		registrationRequestDto.setMobileNumber(1234567890L);
		registrationRequestDto.setAmount(500.00);
		RegistrationResponseDto response = registrationServiceImpl.registerCustomer(registrationRequestDto);
		assertEquals(HttpStatus.NOT_ACCEPTABLE, response);
	}

}
