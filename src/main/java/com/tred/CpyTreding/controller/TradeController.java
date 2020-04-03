package com.tred.CpyTreding.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tred.CpyTreding.dto.AddMoneyTraderDTO;
import com.tred.CpyTreding.dto.TraderDTO;
import com.tred.CpyTreding.dto.UpdateTraderDto;
import com.tred.CpyTreding.model.Trader;
import com.tred.CpyTreding.service.TradeService;

@RestController
@RequestMapping(value = "/trading/traders")
public class TradeController {

	@Autowired
	TradeService tradeService;

	@PostMapping(value = "/register")
	@ResponseStatus(HttpStatus.CREATED)
	public void registerTraders(@RequestBody @Valid Trader trader) {
		tradeService.registerTrader(trader);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void updateTraders(@RequestBody @Valid UpdateTraderDto trader) {
		tradeService.updateTrader(trader);
	}

	@PutMapping("/add")
	@ResponseStatus(HttpStatus.OK)
	public void addMoneyToTrader(@RequestBody @Valid AddMoneyTraderDTO trader) {
		tradeService.addMoney(trader);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteById(@PathVariable Long id) {
		tradeService.deleteById(id);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deleteByEmail(@RequestParam String email) {
		tradeService.deleteByEmail(email);
	}

	@GetMapping("/{id}")
	public TraderDTO getById(@PathVariable Long id) {
		return new TraderDTO(tradeService.getTraderById(id));
	}

	@GetMapping
	public TraderDTO getByEmail(@RequestParam String email) {
		return new TraderDTO(tradeService.getTraderByEmail(email));
	}

	@GetMapping("/all")
	public List<TraderDTO> getAllTraders() {

		List<Trader> allTrader = tradeService.getAllTrader();

		// List<Trader> sortedList =
		// allTrader.stream().sorted().collect(Collectors.toList());

		return allTrader.stream().map(TraderDTO::new).collect(Collectors.toList());
	}

}
