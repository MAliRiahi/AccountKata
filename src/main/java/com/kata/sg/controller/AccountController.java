package com.kata.sg.controller;

import com.kata.sg.model.Account;
import com.kata.sg.model.Transaction;
import com.kata.sg.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private static Account account = new Account((long) 1, 0.0);


    @PostMapping("/depositService")
    public ResponseEntity<Account> depositService(@RequestParam Double amount) {
        return ResponseEntity.ok(accountService.depositService(account,amount));
    }

    @PostMapping("/withdrawalService")
    public ResponseEntity<Account> withdrawalService(@RequestParam Double amount) {
        return ResponseEntity.ok(accountService.withdrawalService(account,amount));
    }

    @GetMapping("/checkHistoryService")
    public ResponseEntity<List<Transaction>> checkHistoryService() {
        return ResponseEntity.ok(accountService.checkHistoryService(account));
    }
}
