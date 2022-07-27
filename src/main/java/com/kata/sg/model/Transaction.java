package com.kata.sg.model;

import com.kata.sg.enums.TransactionStatus;
import com.kata.sg.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class Transaction implements Serializable {

    @GeneratedValue( strategy=GenerationType.AUTO )
    private Long txId;
    private TransactionType txType;
    private TransactionStatus txStatus;
    @Temporal(TemporalType.TIMESTAMP)
    private Date txDate;
    private Double txAmount;
    private Double balance;

}
