package com.daon.onjung.security.application.service;

import com.daon.onjung.security.application.usecase.LogoutUseCase;
import com.daon.onjung.security.info.CustomUserPrincipal;
import com.daon.onjung.security.repository.redis.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutUseCase {

    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    @Transactional
    public void execute(CustomUserPrincipal principal) {
        UUID accountId = principal.getId();

        refreshTokenRepository.deleteById(accountId);
    }
}
