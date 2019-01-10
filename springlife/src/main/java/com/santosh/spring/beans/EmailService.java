package com.santosh.spring.beans;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailService implements InitializingBean , DisposableBean {
	
	private EmailServerOptions options;
	
	private EmailTemplate template;

	@Autowired
	public EmailService(EmailServerOptions options) {
		System.out.println("Constructer called");
		this.options = options;
	}

	@Autowired
	public void setTemplate(EmailTemplate template) {
		System.out.println("Setter called");
		this.template = template;
	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Destroy");
	}

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("After properties Set");
	}
	
	public void initEmailService() {
		System.out.println("initEmailService ...");
	}

	public void destroyEmailService() {
		System.out.println("destroyEmailService ...");
	}
	
	//@PostConstruct
	public void postConstruct() {
		System.out.println("postconstruct...");
	}
}
