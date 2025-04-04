package com.example.plantilla_hack.adapter.out.persistance;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name="consum")
public class ConsumJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idConsum;

    @Column(name="ConsumDate")
    private Date date;
    private int ducha;
    private int grifo;
    private int lavadora;
    private int cisterna;
    private int lavaplatos;
    private int total;

    @ManyToOne
    @JoinColumn(name="users")
    private UserJPA userJPA;

    public ConsumJPA() {
    }

    public ConsumJPA(Date date, int ducha, int grifo, int lavadora, int cisterna, int lavaplatos, int total, UserJPA userJPA) {
        this.date = date;
        this.ducha = ducha;
        this.grifo = grifo;
        this.lavadora = lavadora;
        this.cisterna = cisterna;
        this.lavaplatos = lavaplatos;
        this.total = total;
        this.userJPA=userJPA;
    }

    public long getIdConsum() {
        return idConsum;
    }

    public void setIdConsum(long idConsum) {
        this.idConsum = idConsum;
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

    public int getLavadora() {
        return lavadora;
    }

    public void setLavadora(int lavadora) {
        this.lavadora = lavadora;
    }

    public int getCisterna() {
        return cisterna;
    }

    public void setCisterna(int cisterna) {
        this.cisterna = cisterna;
    }

    public int getDucha() {
        return ducha;
    }

    public void setDucha(int ducha) {
        this.ducha = ducha;
    }
}
