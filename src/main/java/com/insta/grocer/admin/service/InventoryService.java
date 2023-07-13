package com.insta.grocer.admin.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insta.grocer.admin.entity.Inventory;
import com.insta.grocer.admin.model.CreateResp;
import com.insta.grocer.admin.repository.InventoryRepository;

@Service
public class InventoryService{
	
	@Autowired
	private InventoryRepository repository;
	
	public List<Inventory> findAll() {
		List<Inventory> inventories = new ArrayList<>();  
		repository.findAll().forEach(inv -> inventories.add(inv));  
		return inventories;
	}

	public Inventory findOne(Long id) {
		return repository.findById(id).get();
	}

	public CreateResp add(Inventory newInventory) {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
		String date = sdf.format(new Date());
		newInventory.setQuantityDate(date);
		newInventory.setStatus("added");
		Inventory res = repository.save(newInventory);
		CreateResp resp = new CreateResp();
		resp.setItemId(res.getItemId());
		resp.setTitle(res.getTitle());
		resp.setStatus(res.getStatus());
		return resp;
	}

	public Inventory update(Inventory updateInv) {
		updateInv.setStatus("updated");
		return repository.save(updateInv);
	}

	public CreateResp delete(Long itemId)   
	{  
		CreateResp resp = new CreateResp();
		try {
			Inventory dbRes = repository.findById(itemId).get();
			repository.deleteById(itemId);
			dbRes.setStatus("deleted");
			repository.save(dbRes);
			resp.setItemId(dbRes.getItemId());
			resp.setTitle(dbRes.getTitle());
			resp.setStatus(dbRes.getStatus());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
	}

}
