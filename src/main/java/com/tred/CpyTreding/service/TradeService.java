package com.tred.CpyTreding.service;

import java.util.List;

import com.tred.CpyTreding.dto.AddMoneyTraderDTO;
import com.tred.CpyTreding.dto.UpdateTraderDto;
import com.tred.CpyTreding.model.Trader;

public interface TradeService {

	void registerTrader(Trader trader);

	void addMoney(AddMoneyTraderDTO trader);
	
	void updateTrader(UpdateTraderDto trader);
	
	//void addMoney
	
	void deleteByEmail(String email);
	void deleteById(Long id);
	
	Trader getTraderByEmail(String email);
	Trader getTraderById(Long id);
	List<Trader> getAllTrader();

}
