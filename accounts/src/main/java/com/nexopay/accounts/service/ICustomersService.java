package com.nexopay.accounts.service;

import com.nexopay.accounts.dto.CustomerDetailsDto;

/**
 * ICustomerService
 *
 * @author pedroneri
 * @date 16/05/25
 */
public interface ICustomersService {
    /**
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId);
}
