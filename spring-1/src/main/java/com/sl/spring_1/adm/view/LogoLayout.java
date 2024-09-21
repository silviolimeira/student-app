package com.sl.spring_1.adm.view;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class LogoLayout extends HorizontalLayout {
	
	private Image image;
	
	public LogoLayout() {
		image = new Image("images/logo.png", "My Logo");
		setJustifyContentMode(JustifyContentMode.CENTER);
		add(image);
	}
}
