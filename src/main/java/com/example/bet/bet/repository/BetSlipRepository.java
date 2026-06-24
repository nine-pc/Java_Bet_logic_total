package com.example.bet.bet.repository;

import com.example.bet.bet.entity.BetSlip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BetSlipRepository extends CrudRepository<BetSlip, Long>{

    List<BetSlip> findByUserId(Long userId);

}
