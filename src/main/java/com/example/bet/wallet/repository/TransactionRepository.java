package com.example.bet.wallet.repository;

import com.example.bet.wallet.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long>{
}
