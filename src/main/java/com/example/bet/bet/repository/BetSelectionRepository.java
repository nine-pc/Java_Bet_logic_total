package com.example.bet.bet.repository;

import com.example.bet.bet.entity.BetSelection;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BetSelectionRepository extends CrudRepository<BetSelection, Long>{
    List<BetSelection> findByOutcomeId(Long outcomeId);
}
