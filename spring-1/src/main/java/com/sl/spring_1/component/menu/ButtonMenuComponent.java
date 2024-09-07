package com.sl.spring_1.component.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;

public abstract class ButtonMenuComponent extends ObjectMenuComponent {

	private static final Logger logger = LogManager.getLogger(ButtonMenuComponent.class);
	
	Button button;

	public ButtonMenuComponent(String title, String height, String width) {
		this.title = title;
		this.button = new Button(title);
		this.button.setHeight(height);
		this.button.setWidth(width);
		this.button.addClickListener(event -> {
			this.execute();
		});
	}
	
	public String getTitle() {
		return title;
	}

	public Button getOption() {
		return this.button;
	}

}
