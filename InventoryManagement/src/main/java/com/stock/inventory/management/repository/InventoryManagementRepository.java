package com.stock.inventory.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.inventory.management.entity.StockInventoryEntity;

@Repository
public interface InventoryManagementRepository extends JpaRepository<StockInventoryEntity, Integer> {
	
}
