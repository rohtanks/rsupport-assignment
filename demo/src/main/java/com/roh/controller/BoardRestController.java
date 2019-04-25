package com.roh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardRestController {

	@RequestMapping("/boards")
	public String home() {
		
		return "Hello";
	}
	
}
