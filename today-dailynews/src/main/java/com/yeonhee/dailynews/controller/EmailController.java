package com.yeonhee.dailynews.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yeonhee.dailynews.service.EmailService;
import com.yeonhee.dailynews.service.UserService;
import com.yeonhee.dailynews.vo.UserVO;


@Controller
public class EmailController {
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserService userService;
	
	// 이메일 전송 API
	@GetMapping("/api/sendEmail")
	public String sendEmail() {
		List<UserVO> users = userService.selectByUsers();
		List<String> receivers = new ArrayList<>();
		for(int i = 0; i < users.size(); i++) {
			receivers.add(users.get(i).getEmail());
		}
		String subject = "AWS SES 전송 테스트 ";
		String content = "이메일 전송 테스트입니다.<hr>";
		emailService.sendMail(subject, content, receivers);
		return "true";
	}
}
