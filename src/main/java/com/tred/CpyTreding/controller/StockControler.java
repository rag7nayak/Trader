package com.tred.CpyTreding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tred.CpyTreding.model.Stock;
import com.tred.CpyTreding.service.StockService;

@RestController
@RequestMapping(value="/trading/stock")
public class StockControler {

	@Autowired
	StockService stockService;
	
	@GetMapping(value = "/{symbol}")
	public Stock getStockBySymblol(@PathVariable String symbol) {
		return stockService.getStockBySymbol(symbol);
		
	}
	
	@GetMapping()
	public List<Stock> getAllStocks(){
		return stockService.getAll();
	}
}
