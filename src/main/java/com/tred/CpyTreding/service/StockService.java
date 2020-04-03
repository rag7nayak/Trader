package com.tred.CpyTreding.service;

import java.util.List;

import com.tred.CpyTreding.model.Stock;

public interface StockService {
 Stock getStockBySymbol(String symbol);
 List<Stock> getAll();

}
