package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Product;
import com.example.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService prodService;

	@GetMapping("/getproducts")
	public List<Product> getProducts() {
		return prodService.getProducts();
		
	}
	
	@PostMapping("/save")
	public String saveProduct(@RequestBody Product p) {
		return prodService.saveProd(p);
	}
	
	@PutMapping("/update")
	public String updateProd(@RequestParam Integer id, @RequestBody Product p) {
		return prodService.updateProduct(id,p);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProd(@PathVariable int id) {
		return prodService.deleteProduct(id);
	}
	
}
