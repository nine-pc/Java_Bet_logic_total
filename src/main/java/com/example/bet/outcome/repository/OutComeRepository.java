package com.example.bet.outcome.repository;

import com.example.bet.outcome.entity.Outcome;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutComeRepository extends CrudRepository<Outcome, Long>{

    List<Outcome> findByMarketId(Long marketId);
}
