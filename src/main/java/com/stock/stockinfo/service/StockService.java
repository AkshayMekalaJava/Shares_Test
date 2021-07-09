package com.stock.stockinfo.service;

import java.util.List;

import com.stock.stockinfo.model.Quote;

public interface StockService {

	List<Quote> getStockDetails(String stockSymbol);

	String addStock(String stockCode);

	String removeStock(String stockCode);

	List<Quote> getAllStocks();


}
