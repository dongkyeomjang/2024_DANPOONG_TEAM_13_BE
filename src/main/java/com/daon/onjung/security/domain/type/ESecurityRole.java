package com.daon.onjung.security.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ESecurityRole {

    USER("동참자", "USER", "ROLE_USER"),
    OWNER("소상공인", "OWNER", "ROLE_OWNER")

    ;

    private final String koName;
    private final String enName;
    private final String securityName;

    public static ESecurityRole fromString(String value) {
        return switch (value.toUpperCase()) {
            case "USER" -> USER;
            case "OWNER" -> OWNER;
            default -> throw new IllegalArgumentException("Security Role이 잘못되었습니다.");
        };
    }
}
