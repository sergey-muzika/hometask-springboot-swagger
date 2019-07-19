package com.sergey.hometask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergey.hometask.dao.ItemRepository;
import com.sergey.hometask.model.Item;


@Service
public class ItemService {
	
	@Autowired
	private ItemRepository repository; 

	
	public String addItem(Item item) {
		repository.save(item);
		return "Item " + item.getName() + " added";
		
	}
	
	public Item getItem(Integer item_number) {
		return repository.getOne(item_number);	
	}
	
	public String depositAmount(int item_number, int amount) {
		Item itemToUpdate = repository.getOne(item_number);
		itemToUpdate.deposit(amount);
		repository.save(itemToUpdate);
		return "Amount of " + amount + " added to id: "+ repository.getOne(item_number).getItem_number();
	}
	
	public String withdrawAmount(int item_number, int amount) {
		Item itemToUpdate = repository.getOne(item_number);
		itemToUpdate.withdrawAmount(amount);
		repository.save(itemToUpdate);
		return "Amount of " + amount + " withdraw form id: "+ repository.getOne(item_number).getItem_number();
	}
	
	
	
	public List<Item> deleteItem(int item_number) {
		repository.deleteById(item_number);
		return repository.findAll();
	}
	
	public List<Item> showall(){
		return repository.findAll();
	}
}