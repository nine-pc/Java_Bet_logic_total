package com.example.bet.wallet.service;

import com.example.bet.user.entity.User;
import com.example.bet.user.repository.UserRepository;
import com.example.bet.wallet.dto.DepositRequest;
import com.example.bet.wallet.dto.DepositResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WalletService {

    private final UserRepository userRepository;

    public WalletService(UserRepository userRepository) {
        this.userRepository = userRepository;
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

        return new DepositResponse(
                savedUser.id(),
                savedUser.balance()
        );
    }
}
