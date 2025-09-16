package org.example.service;

import org.example.payload.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}