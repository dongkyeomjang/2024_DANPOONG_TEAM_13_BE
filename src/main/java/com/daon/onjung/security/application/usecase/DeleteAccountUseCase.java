package com.daon.onjung.security.application.usecase;

import com.daon.onjung.core.annotation.bean.UseCase;

import java.util.UUID;

@UseCase
public interface DeleteAccountUseCase {

    /**
     * 계정 탈퇴
     * @param accountId 계정 ID
     */
    void execute(UUID accountId);
}