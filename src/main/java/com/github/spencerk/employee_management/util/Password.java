package com.github.spencerk.employee_management.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

public class Password {
    private static final int STRENGTH = 10;
    private static final BCryptPasswordEncoder
                            passwordEncoder = new BCryptPasswordEncoder(STRENGTH, new SecureRandom());

    public static String encodePassword(String plainPW) {
        return passwordEncoder.encode(plainPW);
    }

    public static boolean validatePassword(String plainText, String hash) {
        return passwordEncoder.matches(plainText, hash);
    }
}
