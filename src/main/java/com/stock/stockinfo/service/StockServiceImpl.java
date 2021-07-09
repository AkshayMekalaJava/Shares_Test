package com.stock.stockinfo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.stock.stockinfo.model.Quote;

import yahoofinance.YahooFinance;

@Service
public class StockServiceImpl implements StockService{
	
	private static Set<String> stockList = new LinkedHashSet<>();
	@Override
	public List<Quote> getStockDetails(String stockSymbol) {
		try {

			List<String> quotes = new ArrayList<String>();
			quotes.add(stockSymbol);
			return getStockQuote(quotes);
		} catch (Exception e) {
			
		}
		return null;
	}

	private List<Quote> getStockQuote(Collection<String> quotes) {
		return quotes
		        .stream()
		        .map(quote -> {
		        	yahoofinance.Stock stock = getStockPrice(quote);
		            return new Quote(quote, stock.getQuote().getPrice());
		        })
		        .collect(Collectors.toList());
	}

    private yahoofinance.Stock getStockPrice(String quote) {
        try {
            return YahooFinance.get(quote);
        } catch (IOException e) {
            return null;
        }
    }


	@Override
	public String addStock(String stockCode) {
		try {
            yahoofinance.Stock stock = YahooFinance.get(stockCode);
            if(null != stock && stock.getQuote().getPrice() != null) {
        		stockList.add(stockCode.toUpperCase());
        		return  "Stock Added sucessfully ";
            }else {
            	return "Enter valid symbol";
            }
        } catch (IOException e) {
        }
		return "Enter valid symbol";
	}



	@Override
	public String removeStock(String stockCode) {
		return stockList.remove(stockCode) ?  "Deleted sucessfully" : "Please enter valid symbol";
	}
	
	@Override
	public List<Quote> getAllStocks() {
		return getStockQuote(stockList);
	}

}
