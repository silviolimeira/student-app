package com.sl.spring_1.component.menu;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;

public abstract class ObjectMenuComponent {

	String title;
	
	public abstract <T> T getOption();

	public abstract boolean execute();
	
}
