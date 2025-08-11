package com.nexopay.accounts.dto;

/**
 * AccountsMsgDto
 *
 * @author pedroneri
 * @date 10/08/25
 */
public record AccountsMsgDto(
        Long accountNumber, String name, String email, String mobileNumber
) {
}
