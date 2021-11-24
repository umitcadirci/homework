package com.example.umit.cadirci.homework.dto;

public class TokenResponse {

    private String token;
    private String status;

    public TokenResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
