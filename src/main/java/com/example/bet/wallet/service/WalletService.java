package com.example.bet.wallet.service;

import com.example.bet.common.enums.TransactionType;
import com.example.bet.user.entity.User;
import com.example.bet.user.repository.UserRepository;
import com.example.bet.wallet.dto.DepositRequest;
import com.example.bet.wallet.dto.DepositResponse;
import com.example.bet.wallet.dto.TransactionResponse;
import com.example.bet.wallet.entity.Transaction;
import com.example.bet.wallet.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WalletService {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    public WalletService(UserRepository userRepository, TransactionRepository transactionRepository) {

        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;

    }

    @Transactional
    public DepositResponse deposit(DepositRequest request) {
        if(request.amount().signum() <= 0) {
            throw new RuntimeException("Deposit amount must be positive");
        }

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        User updatedUser = new User(
                user.id(),
                user.username(),
                user.balance().add(request.amount()),
                user.createdAt()
        );

        User savedUser = userRepository.save(updatedUser);

        Transaction transaction = new Transaction(
                null,
                user.id(),
                request.amount(),
                TransactionType.DEPOSIT,
                LocalDateTime.now()
        );

        transactionRepository.save(transaction);

        return new DepositResponse(
                savedUser.id(),
                savedUser.balance()
        );
    }

    @Transactional
    public List<TransactionResponse> getTransactions(Long userId) {

        if(userId == null) {
            throw new RuntimeException("userId is required");
        }

        return transactionRepository.findByUserId(userId)
                .stream()
                .map(transaction -> new TransactionResponse(
                        transaction.id(),
                        transaction.amount(),
                        transaction.type(),
                        transaction.createdAt()
                ))
                .toList();
    }
}
