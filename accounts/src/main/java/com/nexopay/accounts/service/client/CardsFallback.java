package com.nexopay.accounts.service.client;

import com.nexopay.accounts.dto.CardsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * FallbackCards
 *
 * @author pedroneri
 * @date 22/05/25
 */
@Component
public class CardsFallback implements CardsFeignClient {
    @Override
    public ResponseEntity<CardsDto> fetchCardDetails(String correlationId, String mobileNumber) {
        return null;
    }
}
