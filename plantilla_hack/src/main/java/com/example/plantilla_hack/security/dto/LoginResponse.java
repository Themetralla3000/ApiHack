package com.example.plantilla_hack.security.dto;

public class LoginResponse {


    String response;

    public LoginResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}