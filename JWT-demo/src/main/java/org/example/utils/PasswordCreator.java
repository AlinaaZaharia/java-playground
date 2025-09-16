package org.example.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordCreator {
    public static void main(String[] args) {
        String encoded = new BCryptPasswordEncoder().encode("54321");
        System.out.println(encoded);
    }
}