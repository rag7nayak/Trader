package com.tred.CpyTreding.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.tred.CpyTreding.model.Stock;

public interface StockRepository extends JpaRepository<Stock, String>{

}
