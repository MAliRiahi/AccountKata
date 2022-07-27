package com.kata.sg.enums;

public enum ErrorCodes {
    TRANSACTION_NOT_VALID(1001);

    private int code;
    ErrorCodes(int code){
        this.code=code;
    }
    public int getCodes(){
        return code;
    }
}
