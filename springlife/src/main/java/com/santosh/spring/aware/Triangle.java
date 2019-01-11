/**
 * 
 */
package com.santosh.spring.aware;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Santosh_Chavva
 *
 */
public class Triangle implements ApplicationContextAware, BeanNameAware {
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBeanName() {
		return beanName;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	private String type;
	
	private String beanName;
	
	private ApplicationContext applicationContext;

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.String)
	 */
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		this.beanName = name;
	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = arg0;
	}
	
	public String draw() {
		System.out.println(this.applicationContext.getBean(beanName));
		return "type"+this.type;
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println(this.draw());
	}

}
