package com.santosh.spring.config;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.santosh.spring.CustomBeanFactoryBeanProcessor;
import com.santosh.spring.CustomBeanPostProcessor;
import com.santosh.spring.aware.Triangle;
import com.santosh.spring.beans.EmailServerOptions;
import com.santosh.spring.beans.EmailService;
import com.santosh.spring.beans.EmailTemplate;

@Configuration
public class EmailConfiguration {

	@Bean
	public EmailServerOptions getEmailOptions() {
		return new EmailServerOptions(); 
	}
	
	@Bean
	public EmailTemplate getEmailTemplate() {
		return new EmailTemplate(); 
	}
	
	@Bean(initMethod="initEmailService", destroyMethod="destroyEmailService")
	public EmailService getEmailService(EmailServerOptions options) {
		return new EmailService(options);
	}
	
	@Bean
	public static BeanPostProcessor getBeanProcessor() {
		return new CustomBeanPostProcessor();
	}
	
	@Bean
	public static BeanFactoryPostProcessor getBeanFactoryPostProcessor() {
		return new CustomBeanFactoryBeanProcessor();
	}
	
	@Bean
	public Triangle getTriangle() {
		Triangle triangle = new Triangle();
		triangle.setType("Type");
		return triangle;
	}
}
