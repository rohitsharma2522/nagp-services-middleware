package com.nagarro.assignment.product;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.assignment.order.OrderHttpRequest;

import jakarta.annotation.PostConstruct;

@Component
public class ProductRequest {
	
	private List<OrderHttpRequest> data;

	@PostConstruct
	public void init() {
		 ObjectMapper objectMapper = new ObjectMapper();
	      try {
	    	  data = objectMapper.readValue(new File("src/main/resources/products.json"),  new TypeReference<List<OrderHttpRequest>>() {
	    	  });
	      } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	      }
	}
	public List<OrderHttpRequest> getData() {
		return data;
	}
	
}


