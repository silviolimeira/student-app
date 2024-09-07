package com.sl.spring_1.component.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;

public abstract class SpanMenuComponent extends ObjectMenuComponent {

	private static final Logger logger = LogManager.getLogger(SpanMenuComponent.class);

	Span span;

	public SpanMenuComponent(String title) {
		this.title = title;
		this.span = new Span(title);

		this.span.addClickListener(event -> {
			this.execute();
		});
	}

	public String getTitle() {
		return title;
	}

	public Span getOption() {
		return this.span;
	}

}
