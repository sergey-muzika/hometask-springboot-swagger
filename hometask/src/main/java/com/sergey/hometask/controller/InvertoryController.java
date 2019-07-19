package com.sergey.hometask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sergey.hometask.model.Item;
import com.sergey.hometask.service.ItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags = "Invertory Application")
@RestController
@RequestMapping("/items")
public class InvertoryController {
	


	@Autowired
	private ItemService service;
	
	
	@PostMapping("/addItem")
	@ApiOperation(value = "Add Item", notes = "Add new item to database")
	public String addItem(@RequestBody Item item) {
		return service.addItem(item);	

	}
	@PostMapping("/Deposit/")
	@ApiOperation(value = "Deposit amount", notes = "Deposit amount to specific Item")
	public String deposit(@RequestParam(value = "id") int item_number, @RequestParam(value = "amount to add") int amount) {
		return service.depositAmount(item_number, amount);	

	}
	
	@PostMapping("/Withwraw/")
	@ApiOperation(value = "Withdraw form Item", notes = "Withdraw some amount from pecific Item")
	public String withdraw(@RequestParam(value = "id") int item_number, @RequestParam(value = "amount to add") int amount) {
		return service.withdrawAmount(item_number, amount);	

	}
	
	@GetMapping("")
	@ApiOperation(value = "Show all Items", notes = "Show all items in database, try iy out!")
	public List<Item> showAll() {
		return service.showall();
	}
	
	@GetMapping("/searchItem/{id}")
	@ApiOperation(value = "Search item by id", notes = "Search item by id")
	public Item getItem(@PathVariable(value = "id") int item_number) {
		return service.getItem(item_number);
	}
	
	@DeleteMapping("/deleteItem/{id}")
	@ApiOperation(value = "Delete item by id", notes = "Delete item form database by id")
	public List<Item> deleteItem(@PathVariable(value = "id") int item_number){
		return service.deleteItem(item_number);
	}
	
}
