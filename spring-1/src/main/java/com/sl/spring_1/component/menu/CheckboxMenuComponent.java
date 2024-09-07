package com.sl.spring_1.component.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Span;

public abstract class CheckboxMenuComponent extends ObjectMenuComponent {

	private static final Logger logger = LogManager.getLogger(CheckboxMenuComponent.class);

	Checkbox checkbox;

	public CheckboxMenuComponent(String title) {
		this.title = title;
		this.checkbox = new Checkbox(title);

		this.checkbox.addClickListener(event -> {
			this.execute();
		});
	}

	public String getTitle() {
		return title;
	}

	public Checkbox getOption() {
		return this.checkbox;
	}

}
