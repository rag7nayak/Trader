package com.tred.CpyTreding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tred.CpyTreding.model.Stock;
import com.tred.CpyTreding.repository.StockRepository;

@Service("stockService")
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository;
	
	@Override
	public Stock getStockBySymbol(String symbol) {
		return stockRepository.findById(symbol).get();
	}

	@Override
	public List<Stock> getAll() {
		return stockRepository.findAll();
	}

}
