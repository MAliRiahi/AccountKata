package com.kata.sg.services;

import com.kata.sg.model.Account;
import com.kata.sg.model.Transaction;

import java.util.List;

public interface AccountService {
    Account depositService (Account account, Double amount);
    Account withdrawalService (Account account, Double amount);
    List<Transaction> checkHistoryService(Account account);
}
