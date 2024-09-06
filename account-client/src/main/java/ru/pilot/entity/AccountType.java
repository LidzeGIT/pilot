package ru.pilot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "account_types")
public class AccountType {
    @Id
    @Column(name = "account_type_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "account_type", nullable = false, length = 50)
    private String accountType;

    public AccountType(String accountType) {
        this.accountType = accountType;
    }

    public AccountType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

}