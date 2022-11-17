package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.repo.Pservice;
import com.example.demo.repo.Repo;

@CrossOrigin(origins="http://localhost:8080")

@RestController
@RequestMapping("/api")

public class keyController {

	@Autowired
	private service r1;
	
	@Autowired
	private Pservice w3;
	
	
	@GetMapping("/products/{di}")
	public Product get(@PathVariable Integer di)
	{
		return r1.get(di);
	}
	
	@PostMapping("/products")
		public String add(@RequestBody Product p1)
		{
		r1.save(p1);
		return "save";
		}
	
	
	@PutMapping("/products/{di}")
	  public ResponseEntity<Product> updateTutorial(@PathVariable Integer di, @RequestBody Product p1) {
	    Product p2 = r1.get(di);
	    
	  
	   p2.setName(p1.getName());
	   p2.setNumber(p1.getNumber());
	      
	      
	   Product f3 = r1.save(p2);
	    
	    
	     return ResponseEntity.ok().body(f3);
	     
	  }
	
	@DeleteMapping("/products/{di}")
	public void delete(@PathVariable Integer di)
	{
		r1.delete(di);
	}
	
	@GetMapping("/products")
    public ResponseEntity<List<Product>> getAllEmployees(
                        @RequestParam(defaultValue = "1") Integer page, 
                        @RequestParam(defaultValue = "5") Integer pageSize)
               
    {
        List<Product> list = w3.getAllEmployees(page, pageSize);
 
        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
	

}
