package com.yeonhee.dailynews.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

@Configuration
public class AwsConfig {
	@Value("${aws.ses.access-key}")
	private String accessKey;
	@Value("${aws.ses.secret-key}")
	private String secretKey;
	@Value("${aws.region}")
	private String region;

	@Bean
	AmazonSimpleEmailService amazonSimpleEmailService() {
		BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKey, secretKey);
		AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(basicAWSCredentials);
		
		return AmazonSimpleEmailServiceClientBuilder.standard()
				.withCredentials(awsStaticCredentialsProvider)
				.withRegion(region)
				.build();
	}
}
