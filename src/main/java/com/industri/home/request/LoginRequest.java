package com.industri.home.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
