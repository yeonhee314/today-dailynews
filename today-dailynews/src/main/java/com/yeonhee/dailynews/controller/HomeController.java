package com.yeonhee.dailynews.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yeonhee.dailynews.service.UserService;
import com.yeonhee.dailynews.vo.UserVO;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/daily-news")
	public String index(Model model) {
		int userCount = userService.selectByCount();
		model.addAttribute("userCount", userCount);
		
		return "index.html";
	}
	
	@PostMapping("/subscribe")
	public ResponseEntity<Map<String, String>> subscribe(@ModelAttribute UserVO userVO){
		userService.addToUser(userVO);
		Map<String, String> response = new HashMap<>();
		response.put("message", "구독 완료!");
		
		return ResponseEntity.ok(response);
	}
}
