package com.example.bet.user.service;

import com.example.bet.user.dto.CreateUserRequest;
import com.example.bet.user.dto.UserResponse;
import com.example.bet.user.entity.User;
import com.example.bet.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(CreateUserRequest request) {
        User user = new User(
                null,
                request.username(),
                BigDecimal.ZERO,
                LocalDateTime.now()
        );

        User savedUser = userRepository.save(user);

        return toResponse(savedUser);
    }

    public UserResponse getUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return toResponse(user);
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(
                user.id(),
                user.username(),
                user.balance(),
                user.createdAt()
        );
    }
}
