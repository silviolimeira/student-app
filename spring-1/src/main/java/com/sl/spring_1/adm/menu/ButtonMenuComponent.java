package com.sl.spring_1.adm.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.spring_1.adm.form.FormEnum;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;

public abstract class ButtonMenuComponent extends MenuComponent {

	private static final Logger logger = LogManager.getLogger(ButtonMenuComponent.class);
	
	Button button;

	public ButtonMenuComponent(FormEnum cadSection, String height, String width) {
		this.title = cadSection.toString();
		this.button = new Button(cadSection.toString());
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
