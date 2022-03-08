package com.example.sharks.service;

import java.util.List;

public interface ServiceMethods <T>{
	
		//create
		T create(T shark);
		
		//read all
		List<T> readAll();
		
		//read by id
		T readById(long id);
		
		//update
		T update(long id, T shark);
		
		//delete
		boolean delete(long id);

}
