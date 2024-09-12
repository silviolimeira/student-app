package com.sl.spring_1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class DialogView extends Dialog {

	private static final Logger logger = LogManager.getLogger(MyController.class);

	private TextField nameField;
	private TextField ageField;
	
	public DialogView() {
		
		//Dialog dialog = new Dialog();
		//dialog.
		setHeaderTitle("Add New Student");

		// text fields for the user input
		VerticalLayout dialogLayout = createDialogLayout();
		add(dialogLayout);
		
		// create the buttons
		Button cancel = new Button("Cancel", event -> close());
		Button save = new Button("Save", event -> {
			logger.info(nameField.getValue() + " - " + ageField.getValue());
		});
		
		// add the buttons to the bottom of the dialog
		getFooter().add(cancel);
		getFooter().add(save);

		// button to showing the dialog
		//Button button = new Button("Show dialog", event -> dialog.open());
		
		// add the components
		//add(dialog, button);
		//add(dialog);
		
	}
	
	private VerticalLayout createDialogLayout() {
		
		TextField nameField = new TextField("Student Name");
		TextField ageField = new TextField("Student Age");
		
		VerticalLayout layout = new VerticalLayout();
		
		layout.getStyle().set("width", "250px").set("max-width", "100%");
		
		layout.add(nameField);
		layout.add(ageField);
		
		return layout;
		
	}
	
}
