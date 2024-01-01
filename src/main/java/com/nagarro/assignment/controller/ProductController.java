package com.nagarro.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.assignment.order.OrderHttpRequest;
import com.nagarro.assignment.service.ProductService;


@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	
	@PostMapping(value = "/placeorder", consumes = {"application/json"})
	
	public ResponseEntity<String> placeOrder(@RequestBody OrderHttpRequest req) {
		
		ResponseEntity<String> res = null;
		try {
			String resp = productService.placeOrder(req);
			res = ResponseEntity.ok(resp);
		} catch (Exception e) {
			res=  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing JSON: " + e.getMessage());
		}
		return res;
	}
	 @PutMapping(value ="/updateorder/{id}",consumes = {"application/json"})
	    public ResponseEntity<String> updateResource(@PathVariable Long id, @RequestBody OrderHttpRequest req) {
	        // Your logic to update the resource with the given ID using the updatedData
	        // For example, you might update a database record or perform other business logic
		 ResponseEntity<String> res = null;
			try {
				String resp = productService.updateOrder(id.toString(), req);
				res = ResponseEntity.ok(resp);
			} catch (Exception e) {
				res=  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing JSON: " + e);
			}
			return res;
	        // Assuming the update was successful, return a success response
	    }
}
