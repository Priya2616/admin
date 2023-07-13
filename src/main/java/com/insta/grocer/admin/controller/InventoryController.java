package com.insta.grocer.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insta.grocer.admin.entity.Inventory;
import com.insta.grocer.admin.model.CreateResp;
import com.insta.grocer.admin.service.InventoryService;

@RestController
@RequestMapping("admin")
public class InventoryController {

	@Autowired
	private InventoryService service;

	@GetMapping("/items")
	private List<Inventory> findAll() {
		return service.findAll();
	}

	@GetMapping("/item")
	private Inventory one(@RequestParam(name = "itemId") Long id) {
		return service.findOne(id);
	}

	@PostMapping("/items")
	private CreateResp add(@RequestBody Inventory newInventory) {
		return service.add(newInventory);
	}

	@PutMapping("/item")
	private Inventory update(@RequestBody Inventory updateInv) {
		return service.update(updateInv);
	}

	@DeleteMapping("/item/{itemId}")  
	private CreateResp delete(@PathVariable("itemId") Long itemId)   
	{  
		return service.delete(itemId);
	}
}
