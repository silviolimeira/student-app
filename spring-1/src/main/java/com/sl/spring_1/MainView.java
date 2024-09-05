package com.sl.spring_1;


import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route("/ui")
public class MainView extends VerticalLayout{

	private static final Logger logger = LogManager.getLogger(MyController.class);

	public MainView() {
		TextArea textArea = new TextArea();
		textArea.setLabel("Description");
		textArea.setValue("This is going to be a very long text just for demonstration purpose...");
		textArea.setHeight("200px");
		textArea.setWidth("200px");
		textArea.setMaxLength(10);
		textArea.setValueChangeMode(ValueChangeMode.EAGER);
		textArea.addValueChangeListener(event -> {
			logger.info("Something has been changed");
		});
		add(textArea);
		
	}
	
	public void MainView2() {
		add(new Label("Hello World from Vaddi and Spring Boot..."));
		add(new Text("This is a text in Vaadin..."));
		add(new Text("This is a another text in Vaadin..."));
		add(new Text("This is the last text in Vaadin..."));
		
		Span span = new Span("This is a text in Vaadin...");
		// we can use HTML and CSS related code to customize
		span.getElement().getStyle().set("font-size", "23px");
		span.getElement().getStyle().set("font-weight", "bold");
		
		
		TextField nameField = new TextField("Name: ");
		nameField.setMinLength(3);
		nameField.setMaxLength(10);
		nameField.addValueChangeListener(event -> {
			logger.info("Value has been changed ...");
		});
		Person person = new Person();
		Binder<Person> binder = new Binder<>(Person.class);
		binder.bind(nameField, Person::getName, Person::setName);
		
		Button button = new Button("Save", event -> {
			try {
				binder.writeBean(person);
			} catch (ValidationException e) {
				logger.error(e);
			}
			logger.info("Button was been clicked...");
			Span span1 = new Span(new Date().toString());
			add(span1);
			Span span2 = new Span(person.toString());
			add(span2);
		});
		
		add(span);
		add(nameField);
		add(button);
	}
}
