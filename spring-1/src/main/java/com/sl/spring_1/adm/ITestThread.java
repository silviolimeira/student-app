package com.sl.spring_1.adm;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

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
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;

public class ITestThread {

	private static final Logger logger = LogManager.getLogger(ITestThread.class);

	static ExecutorService executor;
	static LinkedList<Consumer<String>> messageListener;

	static {
		ITestThread.executor = Executors.newSingleThreadExecutor();
		ITestThread.messageListener = new LinkedList<>();
	}

	public static void createUploadSuccess(String message, UI ui) {

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
			notification.setDuration(3000);

			notification.open();

		});

	}

	public static synchronized void task(String message, UI ui) {
		Task task = new Task(message, ui);
		executor.submit(task);
	}

	public static synchronized Registration registerMessage(final Consumer<String> listener) {
		ITestThread.messageListener.add(listener);
		return () -> {
			synchronized (ITestThread.class) {
				ITestThread.messageListener.remove(listener);
			}
		};
	}

}
