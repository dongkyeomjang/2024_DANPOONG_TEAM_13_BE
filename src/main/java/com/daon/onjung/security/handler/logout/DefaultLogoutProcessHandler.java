package com.daon.onjung.security.handler.logout;

import com.daon.onjung.security.application.usecase.LogoutUseCase;
import com.daon.onjung.security.info.CustomUserPrincipal;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultLogoutProcessHandler implements LogoutHandler {

    private final LogoutUseCase logoutUseCase;

    @Override
    public void logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) {
        if (authentication == null) {
            return;
        }

        CustomUserPrincipal principal = (CustomUserPrincipal) authentication.getPrincipal();

        logoutUseCase.execute(principal);
    }
}
