package com.sl.spring_1.adm.menu;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;

public abstract class MenuComponent {

	protected String title;

	public abstract <T> T getOption();

	public abstract boolean execute();


}
