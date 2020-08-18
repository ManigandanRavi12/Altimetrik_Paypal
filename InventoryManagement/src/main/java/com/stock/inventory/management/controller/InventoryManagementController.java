package com.stock.inventory.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.inventory.management.model.StockInventoryModel;
import com.stock.inventory.management.service.InventoryManagementService;


@CrossOrigin("*")
@RestController
@RequestMapping("/stock/inventory")
public class InventoryManagementController {
	
	
	@Autowired
	private InventoryManagementService inventoryManagementService;
	
	@PostMapping("/add")
	public ResponseEntity<StockInventoryModel> addNewStocks(@RequestBody StockInventoryModel stockInventoryModel)
	{
		return inventoryManagementService.addStockToInventory(stockInventoryModel);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<StockInventoryModel> updateStocksInventory(@RequestBody StockInventoryModel stockInventoryModel)
	{
		return inventoryManagementService.updateStockToInventory(stockInventoryModel);	
	} 
	
	@GetMapping("/show/all")
	public ResponseEntity<List<StockInventoryModel>> displayAllStocks()
	{
		return inventoryManagementService.showAllStocks();
	}

}
