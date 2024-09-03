package com.sl.spring_1;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonBean {

	@Autowired
	private ObjectFactory<PrototypeBean> prototypeBeanFactory;
	
	public String get() {
		return this.prototypeBeanFactory.getObject().get();
	}
	
	
	
}
