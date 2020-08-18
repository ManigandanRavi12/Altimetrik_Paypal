package com.stock.inventory.management.model;

import java.util.Date;

public class StockInventoryModel {
	
	private Integer stockNumber; 
	private String stockName;
	private Double purchasingPrice;
	private Date purchaseDate;
	private Integer quantity;
	
	public Integer getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(Integer stockNumber) {
		this.stockNumber = stockNumber;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public Double getPurchasingPrice() {
		return purchasingPrice;
	}
	public void setPurchasingPrice(Double purchasingPrice) {
		this.purchasingPrice = purchasingPrice;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	public StockInventoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StockInventoryModel(Integer stockNumber, String stockName, Double purchasingPrice, Date purchaseDate,
			Integer quantity) {
		super();
		this.stockNumber = stockNumber;
		this.stockName = stockName;
		this.purchasingPrice = purchasingPrice;
		this.purchaseDate = purchaseDate;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "StockInventoryModel [stockNumber=" + stockNumber + ", stockName=" + stockName + ", purchasingPrice="
				+ purchasingPrice + ", purchaseDate=" + purchaseDate + ", quantity=" + quantity + "]";
	}
	
}
