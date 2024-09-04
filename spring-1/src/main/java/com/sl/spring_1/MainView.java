package com.sl.spring_1;


import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/ui")
public class MainView extends VerticalLayout{

	private static final Logger logger = LogManager.getLogger(MyController.class);

	public MainView() {
		add(new Label("Hello World from Vaddi and Spring Boot..."));
		add(new Text("This is a text in Vaadin..."));
		add(new Text("This is a another text in Vaadin..."));
		add(new Text("This is the last text in Vaadin..."));
		
		Span span = new Span("This is a text in Vaadin...");
		// we can use HTML and CSS related code to customize
		span.getElement().getStyle().set("font-size", "23px");
		span.getElement().getStyle().set("font-weight", "bold");
		add(span);
		
		Button button = new Button("Click me!", event -> {
			logger.info("Button was been clicked...");
			Span span1 = new Span(new Date().toString());
			add(span1);
		});
		add(button);
	}
}
