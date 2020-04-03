package com.tred.CpyTreding.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.tred.CpyTreding.dto.AddMoneyTraderDTO;
import com.tred.CpyTreding.dto.UpdateTraderDto;
import com.tred.CpyTreding.exception.RecordAlreadyPresent;
import com.tred.CpyTreding.exception.ResourceNotFoundException;
import com.tred.CpyTreding.model.Trader;
import com.tred.CpyTreding.repository.TradeRepository;

@Service("tradeService")
@Transactional
public class TradeServiceImpl implements TradeService {

	@Autowired
	TradeRepository tradeRepository;

	@Override
	public void registerTrader(Trader trader) {
		String email = trader.getEmail();
		Optional<Trader> existingTrader = tradeRepository.findByEmail(email);
		if (!existingTrader.isPresent()) {
			tradeRepository.save(trader);
		} else {
			throw new RecordAlreadyPresent("email id already present " + email);
		}

	}

	@Override
	public void updateTrader(UpdateTraderDto trader) {

		Optional<Trader> traderOptional = tradeRepository.findByEmail(trader.getEmail());
		if (traderOptional.isPresent()) {
			Trader existingTrader = traderOptional.get();
			existingTrader.setName(trader.getName());
			existingTrader.setModificationTime(new Timestamp(System.currentTimeMillis()));
			tradeRepository.save(existingTrader);
		} else {
			throw new ResourceNotFoundException("Resource not found ");
		}
	}

	@Override
	public void deleteByEmail(String email) {
		Optional<Trader> traderOptional = tradeRepository.findByEmail(email);
		if (traderOptional.isPresent()) {
			tradeRepository.deleteByEmail(email);
		} else {
			throw new ResourceNotFoundException("Resource not found ");
		}
	}

	@Override
	public Trader getTraderByEmail(String email) {
		Optional<Trader> traderOptional = tradeRepository.findByEmail(email);
		if (traderOptional.isPresent()) {
			return traderOptional.get();
		} else {
			throw new ResourceNotFoundException("Resource not found ");
		}

	}

	@Override
	public List<Trader> getAllTrader() {
		return tradeRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		Optional<Trader> traderOptional = tradeRepository.findById(id);
		if (traderOptional.isPresent()) {
			tradeRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Resource not found ");
		}

	}

	@Override
	public Trader getTraderById(Long id) {
		Optional<Trader> traderOptional = tradeRepository.findById(id);
		if (traderOptional.isPresent()) {
			return traderOptional.get();
		} else {
			throw new ResourceNotFoundException("Resource not found ");
		}
	}

	@Override
	public void addMoney(AddMoneyTraderDTO trader) {
		String email = trader.getEmail();
		float balance = trader.getBalance();
		Optional<Trader> trade = tradeRepository.findByEmail(email);
		if (trade.isPresent()) {
			Trader existingTrader = trade.get();
			existingTrader.setBalance(balance + existingTrader.getBalance());
			tradeRepository.save(existingTrader);
		} else {
			throw new ResourceNotFoundException("Resource not found ");
		}
	}

	/*
	 * public String getCurrentDateAndTime(){
	 * 
	 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss");
	 * 
	 * Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	 * 
	 * return sdf.format(timestamp); }
	 */
}
