package com.yeonhee.dailynews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/daily-news")
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/subscription")
	public String subscription() {
		return "subscription.html";
	}
}
