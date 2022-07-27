package com.kata.sg.exception;

import com.kata.sg.enums.ErrorCodes;
import lombok.Getter;

import java.util.List;

public class TransactionException extends RuntimeException {
    @Getter
    private ErrorCodes errorCode;
    @Getter
    private List<String> errors;

    public TransactionException(String message){
        super(message);
    }
    public TransactionException(String message, Throwable cause){
        super(message, cause);
    }

    public TransactionException(String message, Throwable cause, ErrorCodes errorCode){
        super(message, cause);
        this.errorCode=errorCode;
    }

    public TransactionException(String message, ErrorCodes errorCode){
        super(message);
        this.errorCode=errorCode;
    }

    public TransactionException(String message, ErrorCodes errorCode,List<String> errors ){
        super(message);
        this.errorCode=errorCode;
        this.errors=errors;
    }
}
