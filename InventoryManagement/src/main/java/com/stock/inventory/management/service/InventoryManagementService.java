package com.stock.inventory.management.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stock.inventory.management.model.StockInventoryModel;

@Service
public interface InventoryManagementService {
	
	public ResponseEntity<StockInventoryModel> addStockToInventory(StockInventoryModel stockInventoryModel);
	
	public ResponseEntity<StockInventoryModel> updateStockToInventory(StockInventoryModel stockInventoryModel);
	
	public ResponseEntity<List<StockInventoryModel>> showAllStocks();
	
}
