package com.daon.onjung.security.application.usecase;

import com.daon.onjung.core.annotation.bean.UseCase;
import com.daon.onjung.security.info.CustomUserPrincipal;

import java.util.UUID;

@UseCase
public interface AuthenticateJsonWebTokenUseCase {

    CustomUserPrincipal execute(UUID accountId);
}
