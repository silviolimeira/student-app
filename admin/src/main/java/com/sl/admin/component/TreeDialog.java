package com.sl.admin.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.admin.view.TreeView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class TreeDialog extends Dialog {
	
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(TreeDialog.class);

	private TextField nameField;
	private TextField ageField;

	public TreeDialog() {
		
		// text field for the user input
		VerticalLayout dialogLayout = createDialogLayout();

		// create the buttons
		Button cancel = new Button("Cancelar", event -> this.close());
		Button save = new Button("Salvar", event -> {
			logger.info("{} - {}", nameField.getValue(), ageField.getValue());
			this.close();
		});
		
		// add the buttons to the bottoms of the dialog
		this.getFooter().add(cancel, save);

		add(createDialogLayout());

	}
	
	private VerticalLayout createDialogLayout() {
		nameField = new TextField("Student Name");
		ageField = new TextField("Student Age");
		
		VerticalLayout layout = new VerticalLayout(nameField, ageField);
		layout.getStyle().set("width", "250px").set("max-width", "100%");
		
		return layout;
	}
}
