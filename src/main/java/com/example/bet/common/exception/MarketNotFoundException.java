package com.example.bet.common.exception;

public class MarketNotFoundException extends RuntimeException{

    public MarketNotFoundException(Long marketId) {
        super("Market not found. id=" + marketId);
    }
}
