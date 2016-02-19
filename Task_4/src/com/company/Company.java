package com.company;

import java.math.BigDecimal;

/**
 * Created by ASUS on 03.02.2016.
 */
public class Company {
    String name;
    Integer account;
    BigDecimal balance;

    public Company(String name, Integer account, BigDecimal balance) {
        this.name = name;
        this.account = account;
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public Integer getAccount() {
        return account;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
