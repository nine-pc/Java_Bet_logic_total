package com.example.bet.market.repository;

import com.example.bet.market.entity.Market;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketRepository extends CrudRepository<Market, Long>{

    List<Market> findByEventId(Long eventId);
}
