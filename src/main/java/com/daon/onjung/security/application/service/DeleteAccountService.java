package com.daon.onjung.security.application.service;

import com.daon.onjung.security.application.usecase.DeleteAccountUseCase;
import com.daon.onjung.security.repository.mysql.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteAccountService implements DeleteAccountUseCase {

    private final AccountRepository accountRepository;

    @Override
    public void execute(UUID accountId) {
        accountRepository.deleteById(accountId);
    }
}
