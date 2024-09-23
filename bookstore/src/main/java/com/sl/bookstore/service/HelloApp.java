package com.sl.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.bookstore.domain.entity.User;
import com.sl.bookstore.domain.entity.UserId;
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
		
		ArrayList<User> users = new ArrayList<>();
		users.add(new User(new UserId("1"), "silvio", "silvio@gmail.com"));
		users.add(new User(new UserId("1"), "silvio", "silvio@gmail.com"));
		users.add(new User(new UserId("2"), "cesar", "cesar@gmail.com"));
		users.add(new User(new UserId("2"), "cesar", "cesar@gmail.com"));
		users.add(new User(new UserId("3"), "marqui", "marqui@gmail.com"));
		users.add(new User(new UserId("3"), "marqui", "marqui@gmail.com"));
		users.add(new User(new UserId("4"), "limeira", "limeira@gmail.com"));
		users.add(new User(new UserId("4"), "limeira", "limeira@gmail.com"));
		users.add(new User(new UserId("4"), "limeira", "limeira@gmail.com"));
		users.add(new User(new UserId("4"), "limeira", "limeira@gmail.com"));
		
		List<String> names = users.stream()
			    .map(User::getName)
			    .distinct()
			    .collect(Collectors.toList());
		
		names.remove(3);
		names.remove(2);

		logger.info(names);
		
		logger.info("========== list of users before ==============");
		for (User user : users) {
			logger.info(user);
		}
		
		
		List<User> selected = users.stream()
				.filter(u -> names.contains(u.getName()))
				.map(u -> u)
			    .distinct()
				.collect(Collectors.toList());

		logger.info("========== list of users ==============");
		for (User user : selected) {
			logger.info(user);
		}
		
		
	}
}
