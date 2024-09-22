package com.sl.bookstore.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.bookstore.domain.entity.User;
import com.sl.bookstore.domain.repository.UserRepository;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/hello")
public class HelloApp extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(HelloApp.class);

	private UI ui;

	@Override
	protected void onAttach(AttachEvent attachEvent) {
		super.onAttach(attachEvent);
		ui = UI.getCurrent();
	}

	public HelloApp() {
		this.ui = UI.getCurrent();
		add(new Text(UserRepository.filter().toString()));
		
		
	}
}
