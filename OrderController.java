package com.nt.order.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import con.nt.entity.Orders;
import jakarta.validation.Valid;


@RestController
public class OrderController {

	List<Orders> orders = new ArrayList<>();
	@GetMapping("/order") // HTTP method+path = REST API endpoint
	public Integer getOrder(@RequestParam("item") String item) {
		System.out.println(item);
		return 1;
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleValidationExceptions(MethodArgumentNotValidException ex){
		Map<String,String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) ->{
			
			String fieldName = ((FieldError) error).getField();
		String errorMessage = error.getDefaultMessage();
		errors.put(fieldName, errorMessage);
		});
		return errors;
		}
		
	
	@PostMapping("/order")
	public List createOrder(@RequestBody @Valid Orders order) {

		orders.add(order);
		System.out.println(orders);
		return orders;
	}

}
