package com.daon.onjung.security.application.service;

import com.daon.onjung.security.application.usecase.AuthenticateUserNameUseCase;
import com.daon.onjung.security.domain.mysql.Account;
import com.daon.onjung.security.domain.service.AccountService;
import com.daon.onjung.security.domain.type.ESecurityProvider;
import com.daon.onjung.security.repository.mysql.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateUserNameService implements AuthenticateUserNameUseCase {

    private final AccountRepository accountRepository;
    private final AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String serialId) throws UsernameNotFoundException {
        Account account = accountRepository.findBySerialIdAndProvider(serialId, ESecurityProvider.DEFAULT)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with serialId: " + serialId));

        return accountService.createCustomUserPrincipalByAccount(account);
    }
}
