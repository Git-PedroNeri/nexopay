package com.nexopay.accounts.service.client;

import com.nexopay.accounts.dto.LoansDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * FallbackCards
 *
 * @author pedroneri
 * @date 22/05/25
 */
@Component
public class LoansFallback implements LoansFeignClient {
    @Override
    public ResponseEntity<LoansDto> fetchLoanDetails(String correlationId, String mobileNumber) {
        return null;
    }
}
