package com.stock.stockinfo.model;

import java.util.List;

import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.quotes.stock.StockDividend;
import yahoofinance.quotes.stock.StockQuote;
import yahoofinance.quotes.stock.StockStats;

public class Stock {

	private String symbol;
    private String name;
    private String currency;
    private String stockExchange;
    
    private StockQuote quote;
    private StockStats stats;
    private StockDividend dividend;
    
    private List<HistoricalQuote> history;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public StockQuote getQuote() {
		return quote;
	}

	public void setQuote(StockQuote quote) {
		this.quote = quote;
	}

	public StockStats getStats() {
		return stats;
	}

	public void setStats(StockStats stats) {
		this.stats = stats;
	}

	public StockDividend getDividend() {
		return dividend;
	}

	public void setDividend(StockDividend dividend) {
		this.dividend = dividend;
	}

	public List<HistoricalQuote> getHistory() {
		return history;
	}

	public void setHistory(List<HistoricalQuote> history) {
		this.history = history;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
    
	
}
