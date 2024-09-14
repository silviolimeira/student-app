package com.sl.spring_1.component.modal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.spring_1.Command;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class CadClienteCommand implements Command {

	private static final Logger logger = LogManager.getLogger(CadClienteCommand.class);
	
	@Override
	public <T> void execute(T layout) {
		
		Dialog dialog = new Dialog();
		dialog.setHeaderTitle("Cadastro de Clientes");
		VerticalLayout dialogLayout = new VerticalLayout();
		TextField nameField = new TextField("Nome");
		TextField ageField = new TextField("Idade");
		dialogLayout.add(nameField, ageField);
		dialog.add(dialogLayout);
		
		Button cancel = new Button("Cancela", event -> dialog.close());
		Button save = new Button("Save", event -> {
			logger.info("Cadastro de Clientes");
		});
		save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		dialog.getFooter().add(cancel);
		dialog.getFooter().add(save);
		((VerticalLayout) layout).add(dialog);
		dialog.open();
		
	}

}
