package com.sl.spring_1.adm.form;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.spring_1.Command;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.login.LoginI18n.Form;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class CadSectionCommand implements Command {

	private static final Logger logger = LogManager.getLogger(CadSectionCommand.class);
	
	@Override
	public <T> void execute(T layout) {
		
		FormLayout form = new FormLayout();
		//form.setHeaderTitle("Cadastro de Form");
		TextField titleField = new TextField("Title");
		TextField hintField = new TextField("Hint");
		
		Button cancel = new Button("Cancela", event -> {
			logger.info("Cadastro de Clientes");
			form.removeAll();
		});
		Button save = new Button("Save", event -> {
			logger.info("Cadastro de Clientes");
		});
		
		form.add(titleField, hintField, cancel, save);

		save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		//dialog.getFooter().add(cancel);
		//dialog.getFooter().add(save);
		
		((VerticalLayout) layout).removeAll();
		((VerticalLayout) layout).add(form);
		//dialog.open();
		
	}

}
