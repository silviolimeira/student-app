package com.sl.front.controller;

import java.time.LocalDateTime;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;

@Route(value = "hello")
public class HelloController extends Div implements HasUrlParameter<String>  {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LogManager.getLogger(HelloController.class);

	private UI ui;
	int width;
	int height;
	String title;
	VerticalLayout vl;
	Button component;
	Span span;

	public HelloController() {
		this.ui = UI.getCurrent();
		this.vl = new VerticalLayout();
		this.vl.setWidthFull();
		//vl.add(new Span("Hello World!"));
		add(vl);
	}

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
        setText(String.format("Hello, %s!", parameter));
        if (parameter.contains("l123")) {
        	//TODO buscar do banco o layout
        	initialize(200,50,"hello");
        }
    }
    
	public void initialize(int width, int height, String title) {
		this.title = title;
		this.component = new Button(title);
		this.component.setWidth(Integer.toString(width));
		this.component.setHeight(Integer.toString(width));
    	command();
		vl.add(component);
		add(vl);
	}
	
	public void command() {
		if (this.component.getClass().equals(Button.class)) {
			this.component.addClickListener(event -> {
				if (span != null) remove(span);
				span = new Span(LocalDateTime.now().toString()); 
				add(span);
				logger.info("Clicked!");
			});
		}
	}
	
	
	@Override
	protected void onAttach(AttachEvent attachEvent) {
		super.onAttach(attachEvent);
		ui = UI.getCurrent();
	}
}
