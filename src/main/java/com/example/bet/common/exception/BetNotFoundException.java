package com.example.bet.common.exception;

public class BetNotFoundException extends RuntimeException{

    public BetNotFoundException(Long betId) {
        super("Bet not found. id=" + betId);
    }
}
