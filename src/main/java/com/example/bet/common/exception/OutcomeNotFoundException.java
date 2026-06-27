package com.example.bet.common.exception;

public class OutcomeNotFoundException extends RuntimeException{

    public OutcomeNotFoundException(Long outcomeId) {
        super("Outcome not found. id=" + outcomeId);
    }
}
