package com.kata.sg.services;

import com.kata.sg.enums.ErrorCodes;
import com.kata.sg.enums.TransactionStatus;
import com.kata.sg.exception.TransactionException;
import com.kata.sg.model.Account;
import com.kata.sg.model.Transaction;
import com.kata.sg.enums.TransactionType;
import com.kata.sg.util.DateUtil;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public Account depositService(Account account, Double amount) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Transaction t = new Transaction(timestamp.getTime(), TransactionType.DEPOSIT, TransactionStatus.ACCEPTED, DateUtil.getDateWithTimeUsingFormat(), amount, Double.sum(amount,account.getBalance()));
        account.addTransaction(t);
        account.setBalance(t.getBalance());
        return account;
    }

    @Override
    public Account withdrawalService(Account account, Double amount) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if(account.getBalance()<amount){
            Transaction t = new Transaction(timestamp.getTime(), TransactionType.WITHDRAWAL,TransactionStatus.FAILED, DateUtil.getDateWithTimeUsingFormat(), amount, account.getBalance());
            account.addTransaction(t);
            throw new TransactionException("solde suffisamment pour retirer l'argent", ErrorCodes.TRANSACTION_NOT_VALID);
        }
        Transaction t = new Transaction(timestamp.getTime(), TransactionType.WITHDRAWAL,TransactionStatus.ACCEPTED, DateUtil.getDateWithTimeUsingFormat(), amount, Double.sum(-1*amount,account.getBalance()));
        account.addTransaction(t);
        account.setBalance(t.getBalance());
        return account;
    }

    @Override
    public List<Transaction> checkHistoryService(Account account) {
        return account.getTransactionList();
    }
}
