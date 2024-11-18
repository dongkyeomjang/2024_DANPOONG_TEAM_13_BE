package com.daon.onjung.security.domain.service;

import com.daon.onjung.security.domain.redis.RefreshToken;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RefreshTokenService {
    public RefreshToken createRefreshToken(UUID accountId, String refreshToken) {
        return RefreshToken.builder()
                .accountId(accountId)
                .value(refreshToken)
                .build();
    }
}