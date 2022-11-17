package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repo.Crepository;
import com.example.demo.repo.Cservice;
import com.example.demo.repo.Repo;
import com.example.demo.repo.Srepo;

@Service
public class Sservice implements Cservice{

	@Autowired
	private Srepo r3;
	
	@Autowired
	private Crepository z1;
	
	
	public List<Category> listAll()
	{
		return r3.findAll();
	}
	
	public Category save(Category f1)
	{
		return r3.save(f1);
		
	}
	
	public Category get(Integer id)
	{
		return r3.findById(id).get();
		
	}
	
	public void delete(Integer id)
	{
		r3.deleteById(id);
	}
	public void update(Category c1,Integer id)
	{
		r3.save(c1);
	}
	
	public List<Category> getAllEmployees(Integer pageNo, Integer pageSize)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize);
 
        Page<Category> pagedResult = z1.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Category>();
        }
    }
	
	
	
	
}
