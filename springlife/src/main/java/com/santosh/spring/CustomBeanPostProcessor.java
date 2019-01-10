/**
 * 
 */
package com.santosh.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 *
 * THis effects every Beans created in the application via Spring
 * 
 * @author Santosh_Chavva
 *
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("CustomBeanPostProcessor postProcessAfterInitialization "+beanName);
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("CustomBeanPostProcessor postProcessBeforeInitialization "+beanName);
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

}
