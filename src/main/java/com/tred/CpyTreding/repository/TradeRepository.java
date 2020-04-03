package com.tred.CpyTreding.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tred.CpyTreding.model.Trader;

public interface TradeRepository extends JpaRepository<Trader, Long> {

	Optional<Trader> findByEmail(String email);
	
	Long deleteByEmail(String email);
	
}
