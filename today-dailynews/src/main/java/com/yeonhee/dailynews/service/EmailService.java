package com.yeonhee.dailynews.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.SendEmailResult;
import com.yeonhee.dailynews.vo.EmailDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor 
@Slf4j
public class EmailService {
	private final AmazonSimpleEmailService amazonSimpleEmailService;
	// 이메일 전송
	public void sendMail(String subject, String content, List<String> receivers) {
		EmailDTO emailDto = new EmailDTO(receivers, subject,content);
		SendEmailResult sendEmailResult = amazonSimpleEmailService.sendEmail(emailDto.toSendRequestDto());

		if(sendEmailResult.getSdkHttpMetadata().getHttpStatusCode() == 200) {
			log.info("Email을 발송했습니다!");
		}else {
			log.info("Email 발송에 실패했습니다.");
		}
	}
}
