package com.example.plantilla_hack.model;

import com.example.plantilla_hack.adapter.out.persistance.ConsumJPA;

import java.util.List;

public class User {

    private String email;
    private String password;
    private String fullName;
    private String poblacio;

    private int racha=0;

    private List<ConsumJPA> consums;

    public User(String email, String password, String fullName, String poblacio) {
        this.poblacio = poblacio;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }
}
