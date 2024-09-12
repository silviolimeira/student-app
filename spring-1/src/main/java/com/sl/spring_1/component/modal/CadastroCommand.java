package com.sl.spring_1.component.modal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class CadastroCommand {

	private static final Logger logger = LogManager.getLogger(CadastroCommand.class);

	public static <T> void createModal(ModalEnum modal, T layout) {
		if (ModalEnum.CAD_CLIENTES == modal) cadClientes(modal, layout);
	}
	
	private static <T> void cadClientes(ModalEnum cadClientes, T layout) {
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
