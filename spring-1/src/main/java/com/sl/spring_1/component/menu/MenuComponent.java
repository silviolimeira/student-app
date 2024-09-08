package com.sl.spring_1.component.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class MenuComponent extends VerticalLayout {

	private static final Logger logger = LogManager.getLogger(MenuComponent.class);
	
	String width;
	String height;
	String header;
	int colunas;

	public void createOptions(List<ObjectMenuComponent> menus) {
		if (!this.header.isEmpty()) {
			Span header = new Span(this.header);
			add(header);
		}
		HorizontalLayout opcoes = new HorizontalLayout();
		int c = 0;
		for (ObjectMenuComponent o : menus) {
			c++;
			if (c > colunas) {
				add(opcoes);
				opcoes = new HorizontalLayout();
				c = 0;
			}
			if (o.getOption().getClass().equals(Button.class)) {
				String str = String.format("%d%s", (100 / menus.size()), "%");
				//((HasSize) o.getOption()).setHeight(str);
				opcoes.add((Button) o.getOption());
			} else if (o.getOption().getClass().equals(Span.class)) {
				opcoes.add((Span) o.getOption());
			} else if (o.getOption().getClass().equals(Checkbox.class)) {
				opcoes.add((Checkbox) o.getOption());
			}
		}
		add(opcoes);
		setAlignItems(FlexComponent.Alignment.STRETCH);
	}

	public MenuComponent() { }

	public MenuComponent(String width, String height, String header, int colunas) {
		this();
		this.setWidth(width);
		this.setHeight(height);
		this.header = header;
		this.colunas = colunas;
	}
}
