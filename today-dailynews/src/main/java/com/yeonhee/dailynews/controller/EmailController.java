package com.yeonhee.dailynews.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yeonhee.dailynews.service.EmailService;
import com.yeonhee.dailynews.service.RssService;
import com.yeonhee.dailynews.service.UserService;
import com.yeonhee.dailynews.vo.UserVO;


@Controller
public class EmailController {
	@Autowired
	private EmailService emailService;
	@Autowired
	private UserService userService;
	@Autowired
	private RssService rssService;
	
	
	@GetMapping("news")
	public String news(Model model) {
		model.addAttribute("jtbc", rssService.getJtbcRss("https://news-ex.jtbc.co.kr/v1/get/rss/issue"));	// 이슈 Top10
		
		return "news";
	}
	
	
	// 이메일 전송 API
	@GetMapping("api/sendEmail")
	public String sendEmail() {
		List<UserVO> users = userService.selectByUsers();
		List<String> receivers = new ArrayList<>();
		for(int i = 0; i < users.size(); i++) {
			receivers.add(users.get(i).getEmail());
		}
		
		String subject = "[매일매일 오늘의 뉴스] " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")) + " 주요 소식";
		String content = "이메일 전송 테스트입니다.<hr>";
		emailService.sendMail(subject, content, receivers);
		return "true";
	}
}
