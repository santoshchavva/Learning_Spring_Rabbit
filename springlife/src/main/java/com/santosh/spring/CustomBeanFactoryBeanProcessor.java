/**
 * 
 */
package com.santosh.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 
 * https://www.youtube.com/watch?v=XWEyAN9LHLQ
 * @author Santosh_Chavva
 *
 */
public class CustomBeanFactoryBeanProcessor implements BeanFactoryPostProcessor {

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition emailbeanDefinition = beanFactory.getBeanDefinition("getEmailService");
		MutablePropertyValues propertyValues = emailbeanDefinition.getPropertyValues();
		propertyValues.add("template", null);
		System.out.println("Email Service template is set to null ");
	}

}
