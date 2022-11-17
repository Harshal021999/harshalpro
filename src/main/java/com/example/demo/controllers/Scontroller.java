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

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repo.Cservice;


@CrossOrigin(origins="http://localhost:8080")

@RestController
@RequestMapping("/api")
public class Scontroller {

	
	@Autowired
	private Sservice r3;
	
	@Autowired
	private Cservice z2;
	
	@GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllEmployees(
                        @RequestParam(defaultValue = "0") Integer page, 
                        @RequestParam(defaultValue = "5") Integer pageSize)
               
    {
        List<Category> list = z2.getAllEmployees(page, pageSize);
 
        return new ResponseEntity<List<Category>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
	
	

	
	
	@GetMapping("/categories/{di}")
	public Category get(@PathVariable Integer id)
	{
		return r3.get(id);
	}
	
	@PostMapping("/categories")
		public String add(@RequestBody Category s1)
		{
		r3.save(s1);
		return "save";
		}
	
	@PutMapping("/categories/{di}")
	  public ResponseEntity<Category> updateTutorial(@PathVariable Integer di, @RequestBody Category s1 ){
	    
	    Category s2 = r3.get(di);
	    
	    s2.setName(s1.getName());
	    
	   
	    
	      
	      
	   Category s3 = r3.save(s2);
	    
	    
	     return ResponseEntity.ok().body(s3);
	     
	  }
	
	
	@DeleteMapping("/categories/{di}")
	public void delete(@PathVariable Integer di)
	{
		r3.delete(di);
	}
	
	
}
