package com.sl.spring_1;


import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/ui")
public class MainView extends VerticalLayout{

	public MainView() {
		add(new Label("Hello World from Vaddi and Spring Boot..."));
	}
}
