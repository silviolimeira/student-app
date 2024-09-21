package com.sl.spring_1.adm;

import java.time.LocalDateTime;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.spring_1.adm.view.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Task<T> implements Runnable {
	
	private static final Logger logger = LogManager.getLogger(MainView.class);

	private String command;
	private UI ui;
	private T view;

	public Task(String s) {
		this.view = view;
	}

	public Task(String message, UI ui) {
		this.command = message;
		this.ui = ui;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
		processCommand(command);
		System.out.println(Thread.currentThread().getName() + " End.");
	}

	private <T> void processCommand(String command) {
		int i = 600;
		try {

			while (i > 0) {
				logger.info("Server Clock: {}", LocalDateTime.now().toString());
				if (i % 10 == 0) {
					//ITestThread.createUploadSuccess(command, ui);
					ui.access(() -> {
						// Notification.show(LocalDateTime.now().toString(), 10000,
						// Notification.Position.MIDDLE);
						Icon icon = VaadinIcon.CHECK_CIRCLE.create();
						icon.setColor("var(--lumo-success-color)");

						Div uploadSuccessful = new Div(new Text("Upload successful"));
						uploadSuccessful.getStyle().set("font-weight", "600").setColor("var(--lumo-success-text-color)");

						Span fileName = new Span("Financials.xlsx");
						fileName.getStyle().set("font-size", "var(--lumo-font-size-s)").set("font-weight", "600");

						Div info = new Div(uploadSuccessful,
								new Div(fileName, new Text(" is now available in "), new Anchor("#", "Documents")));

						info.getStyle().set("font-size", "var(--lumo-font-size-s)").setColor("var(--lumo-secondary-text-color)");

						VerticalLayout layout = new VerticalLayout();
						layout.setAlignItems(FlexComponent.Alignment.CENTER);
						layout.add(uploadSuccessful, info);

						Notification notification = new Notification(layout);
						notification.setDuration(10000);

						notification.open();

					});
					
					
				}
				Thread.sleep(1000);
				i--;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return this.command;
	}
}
