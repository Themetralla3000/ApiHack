package com.example.plantilla_hack.model;

import java.util.Date;

public class Consum {

    private Date date;
    private int ducha;
    private int grifo;
    private int lavadora;
    private int cisterna;
    private int lavaplatos;
    private int total;
    private int userId;

    public Consum(Date date, int ducha, int grifo, int lavadora, int cisterna, int lavaplatos,int userId) {
        this.date = date;
        this.ducha = ducha;
        this.grifo = grifo;
        this.lavadora = lavadora;
        this.cisterna = cisterna;
        this.lavaplatos = lavaplatos;
        this.total = calculateTotal();
        this.userId=userId;
    }

    public int getDucha() {
        return ducha;
    }

    public void setDucha(int ducha) {
        this.ducha = ducha;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getGrifo() {
        return grifo;
    }

    public void setGrifo(int grifo) {
        this.grifo = grifo;
    }

    public int getCisterna() {
        return cisterna;
    }

    public void setCisterna(int cisterna) {
        this.cisterna = cisterna;
    }

    public int getLavadora() {
        return lavadora;
    }

    public void setLavadora(int lavadora) {
        this.lavadora = lavadora;
    }

    public int getLavaplatos() {
        return lavaplatos;
    }

    public void setLavaplatos(int lavaplatos) {
        this.lavaplatos = lavaplatos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private int calculateTotal() {
        return ducha + grifo + lavadora + cisterna + lavaplatos;
    }
}
