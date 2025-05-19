package com.nexopay.accounts.service.impl;

import com.nexopay.accounts.dto.AccountsDto;
import com.nexopay.accounts.dto.CardsDto;
import com.nexopay.accounts.dto.CustomerDetailsDto;
import com.nexopay.accounts.dto.LoansDto;
import com.nexopay.accounts.entity.Accounts;
import com.nexopay.accounts.entity.Customer;
import com.nexopay.accounts.exception.ResourceNotFoundException;
import com.nexopay.accounts.mapper.AccountsMapper;
import com.nexopay.accounts.mapper.CustomerMapper;
import com.nexopay.accounts.repository.AccountsRepository;
import com.nexopay.accounts.repository.CustomerRepository;
import com.nexopay.accounts.service.ICustomersService;
import com.nexopay.accounts.service.client.CardsFeignClient;
import com.nexopay.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * CustomerServiceImpl
 *
 * @author pedroneri
 * @date 16/05/25
 */
@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomersService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber,String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId,mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId,mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;

    }
}

