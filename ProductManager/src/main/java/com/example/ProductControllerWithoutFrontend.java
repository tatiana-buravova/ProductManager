package com.example;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
	@RequestMapping("/products")
	public class ProductControllerWithoutFrontend {

	    @Autowired
	    private ProductService service;

	    @GetMapping("")
	    public List<Product> list() {
	        return service.listAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Product> get(@PathVariable Long id) {
	        try {
	            Product product = service.get(id);
	            return new ResponseEntity<Product>(HttpStatus.OK);
	        }
	        catch(NoSuchElementException e) {
	            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	        }
	    }
 
	    @PostMapping("/add")
	    public void add(@RequestBody Product product) {
	        service.save(product);
	    }
	 
	    @PutMapping("/update/{id}")
	    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id) {
	        try {
	            Product existProduct = service.get(id);
	            product.setId(id);
	            service.save(product);
	            return new ResponseEntity<Product>(HttpStatus.OK);
	        }
	        catch (NoSuchElementException e) {
	            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	        }

	    }

	    @DeleteMapping("/delete/{id}")
	    public List<Product> delete(@PathVariable Long id) {
	        service.delete(id);
	        return service.listAll();
	    }
}
