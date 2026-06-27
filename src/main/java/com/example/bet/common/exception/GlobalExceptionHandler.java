package com.example.bet.common.exception;

import com.example.bet.common.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFound(
            UserNotFoundException ex
    ) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiError(
                        404,
                        "USER_NOT_FOUND",
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(BetNotFoundException.class)
    public ResponseEntity<ApiError> handleBetNotFound(
            BetNotFoundException ex
    ) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiError(
                        404,
                        "BET_NOT_FOUND",
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(OutcomeNotFoundException.class)
    public ResponseEntity<ApiError> handleOutcomeNotFound(
            OutcomeNotFoundException ex
    ) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiError(
                        404,
                        "OUTCOME_NOT_FOUND",
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<ApiError> handleEventNotFound(
            EventNotFoundException ex
    ) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiError(
                        404,
                        "EVENT_NOT_FOUND",
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(MarketNotFoundException.class)
    public ResponseEntity<ApiError> handleMarketNotFound(
            MarketNotFoundException ex
    ) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiError(
                        404,
                        "MARKET_NOT_FOUND",
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<ApiError> handleInsufficientBalance(
            InsufficientBalanceException ex
    ) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiError(
                        400,
                        "INSUFFICIENT_BALANCE",
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleUnknown(
            Exception ex
    ) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiError(
                        500,
                        "INTERNAL_SERVER_ERROR",
                        ex.getMessage()
                ));
    }
}
