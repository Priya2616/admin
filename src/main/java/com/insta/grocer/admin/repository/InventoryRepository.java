package com.insta.grocer.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insta.grocer.admin.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{

}
