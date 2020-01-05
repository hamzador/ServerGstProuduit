package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.service.ICrudService;


public class CrudController<T, ID> {
	
	@Autowired
	private ICrudService<T, ID> service;
	
	@GetMapping                         
	public  List<T> getAll(){
		return service.getAll();
	}
	
	@PostMapping
	public void add(@RequestBody T entety) {
		service.add(entety);
	}
	
	@PutMapping
	public void update(@RequestBody T entety) {
		service.update(entety);
		
	}
	
	@DeleteMapping("/{id}")
	public void delet(@PathVariable ID id) {
	
		service.delet(id);
		
	}
}
