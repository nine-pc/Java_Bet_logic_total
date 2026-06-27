package com.example.bet.common.exception;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException() {
        super("Insufficient balance.");
    }
}
