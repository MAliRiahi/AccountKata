package com.kata.sg.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Account implements Serializable {

    private Long accountId;
    private Double balance;
    private List<Transaction> transactionList;

    public Account(Long accountId, Double balance) {
        this.accountId = accountId;
        this.balance = balance;
        this.transactionList = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction){
        this.transactionList.add(transaction);
    }
}
