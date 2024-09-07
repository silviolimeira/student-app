package com.sl.spring_1;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
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
		
		List<Person> list = new ArrayList<>();
		list.add(new Person("Adam", 33));
		list.add(new Person("Ana", 26));
		list.add(new Person("Kevin", 14));
		list.add(new Person("Steven", 10));
		
		ComboBox<Person> box = new ComboBox<>("Employee");
		box.setItems(list);
		
		box.setPlaceholder("Select an employee");
		box.setItemLabelGenerator(person -> person.getName() + " / " + person.getAge());
		
		box.addValueChangeListener(event -> {
			logger.info(box.getValue());
		});
		
		add(box);
	}
	
	public void MainView5() {
		CheckboxGroup<String> group = new CheckboxGroup<>();
		group.setLabel("Days");
		group.setItems("Monday", "Tuesday", "Wednesday");
		group.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
		group.addValueChangeListener(event -> {
			logger.info(group.getValue());
		});
		add(group);
	}
	
	
	public void MainView4() {
		Checkbox check = new Checkbox();
		check.setLabel("I agree terms");
		check.addValueChangeListener(event -> {
			logger.info(check.getValue());
		});
		add(check);
	}
	
	public void MainView3() {
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
		Person person = new Person("John", 23);
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
