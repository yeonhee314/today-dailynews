package com.yeonhee.dailynews.vo;

import java.util.List;

import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {
	static final String FROM_EMAIL ="mouse97_@naver.com";	// 보낸 사람 이메일
	private List<String> receivers;	// 받는 사람
	private String subject; // 제목
	private String content; // 내용
	
	// SendEmailRequest 객체 형태로 맞춰 준다.
	public SendEmailRequest toSendRequestDto() {
		// 받는 사람 설정
		Destination destination = new Destination().withToAddresses(this.receivers);
		// 제목, 본문 설정
		Message message = new Message().withSubject(createContent(this.subject))
						  .withBody(new Body().withHtml(createContent(this.content)));
		return new SendEmailRequest().withSource(FROM_EMAIL).withDestination(destination).withMessage(message);
	}
	
	// 본문 형식 설정
	private Content createContent(String text) {
		return new Content().withCharset("UTF-8").withData(text);
	}
}