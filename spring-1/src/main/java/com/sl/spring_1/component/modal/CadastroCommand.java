package com.sl.spring_1.component.modal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.spring_1.Command;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class CadastroCommand {

	private static final Logger logger = LogManager.getLogger(CadastroCommand.class);

	public static <T> void createModal(ModalEnum modal, T layout) {
		if (ModalEnum.CAD_CLIENTES == modal) new CadClienteCommand().execute(layout);
	}
	
}
