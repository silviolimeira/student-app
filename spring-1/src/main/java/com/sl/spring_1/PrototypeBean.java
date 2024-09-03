package com.sl.spring_1;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {

	private static final Logger logger = LogManager.getLogger(PrototypeBean.class);

	private String s;
	
	public PrototypeBean() {
		logger.info("Prototype created");
		this.s = new Date().toString();
	}
	
	public String get() {
		return this.s;
	}
	
}
