package com.nexopay.accounts.service.client;

import com.nexopay.accounts.dto.LoansDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * LoansFeignClient
 *
 * @author pedroneri
 * @date 14/05/25
 */

@FeignClient(name = "loans",fallback = LoansFallback.class)
public interface LoansFeignClient {

    @GetMapping(value = "/api/fetch", consumes = "application/json")
    public ResponseEntity<LoansDto> fetchLoanDetails(@RequestHeader("nexopay-correlation-id") String correlationId,
                                                     @RequestParam String mobileNumber);

}
