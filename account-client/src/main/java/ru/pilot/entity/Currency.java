package ru.pilot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    @Column(name = "currency_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "currency_code", nullable = false, length = 5)
    private String currencyCode;

    public Currency(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Currency() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}