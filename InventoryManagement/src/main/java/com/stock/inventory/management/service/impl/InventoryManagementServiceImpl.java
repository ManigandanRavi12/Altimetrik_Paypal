package com.stock.inventory.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stock.inventory.management.entity.StockInventoryEntity;
import com.stock.inventory.management.model.StockInventoryModel;
import com.stock.inventory.management.repository.InventoryManagementRepository;
import com.stock.inventory.management.service.InventoryManagementService;

@Service
public class InventoryManagementServiceImpl implements InventoryManagementService {

	@Autowired
	private InventoryManagementRepository inventoryManagementRepository;

	@Override
	public ResponseEntity<StockInventoryModel> addStockToInventory(StockInventoryModel stockInventoryModel) {

		StockInventoryEntity entity = new StockInventoryEntity();

		BeanUtils.copyProperties(stockInventoryModel, entity);

		entity = inventoryManagementRepository.save(entity);

		stockInventoryModel = new StockInventoryModel();
		
		BeanUtils.copyProperties(entity,stockInventoryModel);

		return new ResponseEntity<>(stockInventoryModel, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<StockInventoryModel> updateStockToInventory(StockInventoryModel stockInventoryModel) {

		HttpStatus statusCode = HttpStatus.OK;

		StockInventoryEntity entity = new StockInventoryEntity();

		entity = inventoryManagementRepository.findById(stockInventoryModel.getStockNumber()).get();

		if (Optional.of(entity).isPresent()) {

			if (stockInventoryModel.getQuantity() == 0) {

				inventoryManagementRepository.deleteById(stockInventoryModel.getStockNumber());

				statusCode = HttpStatus.NO_CONTENT;

			} else {

				BeanUtils.copyProperties(stockInventoryModel, entity);

				entity = inventoryManagementRepository.save(entity);

				stockInventoryModel = new StockInventoryModel();
				
				BeanUtils.copyProperties(entity, stockInventoryModel);

				statusCode = HttpStatus.OK;
			}

		} else {

			statusCode = HttpStatus.NO_CONTENT;

		}

		return new ResponseEntity<>(stockInventoryModel, statusCode);
	}

	@Override
	public ResponseEntity<List<StockInventoryModel>> showAllStocks() {

		HttpStatus statusCode = HttpStatus.NO_CONTENT;
		
		List<StockInventoryModel> inventoryList = new ArrayList<StockInventoryModel>();

		inventoryList = inventoryManagementRepository.findAll().stream()
				.map(model -> new StockInventoryModel(model.getStockNumber(), model.getStockName(),
						model.getPurchasingPrice(), model.getPurchaseDate(), model.getQuantity()))
				.collect(Collectors.toList());

		if (Optional.of(inventoryList).isPresent()) {
			
			statusCode = HttpStatus.OK;
			
		}

		return new ResponseEntity<>(inventoryList, statusCode);
	}

}
