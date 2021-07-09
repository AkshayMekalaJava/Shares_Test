package com.stock.stockinfo.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stock.stockinfo.model.Quote;
import com.stock.stockinfo.service.StockService;

@RestController
public class StockInfoController {

	@Autowired
	private StockService stockService;
	
	@GetMapping(value = "/getStockInfo")
	public List<Quote> getStockInfo(@RequestParam String stockCode) {
		
		return stockService.getStockDetails(stockCode);

	}
	
	@GetMapping(value = "/addStock")
	public String addStock(@RequestParam String stockCode) {
		
		return stockService.addStock(stockCode);

	}
	
	@GetMapping(value = "/removeStock")
	public String removeStock(@RequestParam String stockCode) {
		
		return stockService.removeStock(stockCode);

	}
	
	@GetMapping(value = "/getAllStocks")
	public List<Quote> getAllStocks() {
		
		return stockService.getAllStocks();

	}
}
