package com.sl.spring_1.adm.view.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;

public abstract class ButtonMenuComponent extends MenuComponent {

	private static final Logger logger = LogManager.getLogger(ButtonMenuComponent.class);
	
	Button button;

	protected <T> ButtonMenuComponent(MenuEnum cadSection, String height, String width, T service) {
		this.title = cadSection.toString();
		this.button = new Button(cadSection.toString());
		this.button.setHeight(height);
		this.button.setWidth(width);
		this.button.addClickListener(event -> {
			this.execute(service);
		});
	}

	public String getTitle() {
		return title;
	}

	public Button getOption() {
		return this.button;
	}

}
