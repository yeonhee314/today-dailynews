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
// 스프링에서 의존성 주입 방법 중에 생성자 주입을 임의의 코드 없이 자동으로 설정해주는 어노테이션
public class EmailService {
	private final AmazonSimpleEmailService amazonSimpleEmailService;
	
	// 이메일 전송하기
	public void sendMail(String subject, String content, List<String> receivers) {
		// 이메일 정보를 담은 객체
		EmailDTO emailDto = new EmailDTO(receivers, subject,content);
		// EmailDTO를 SendEmailResult 형태로 바꿔준 뒤 이메일 전송
		SendEmailResult sendEmailResult = amazonSimpleEmailService.sendEmail(emailDto.toSendRequestDto());
		
		//메일이 정상적으로 전송된 경우 200 OK를 반환한다.
		if(sendEmailResult.getSdkHttpMetadata().getHttpStatusCode() == 200) {
			log.info("Email을 발송했습니다!");
		}else {
			log.info("Email 발송에 실패했습니다.");
		}
	}
}
