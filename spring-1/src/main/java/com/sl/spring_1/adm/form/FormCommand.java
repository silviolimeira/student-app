package com.sl.spring_1.adm.form;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.spring_1.component.modal.CadClienteCommand;
import com.sl.spring_1.component.modal.CadastroCommand;
import com.sl.spring_1.component.modal.ModalEnum;

public class FormCommand {
	
	private static final Logger logger = LogManager.getLogger(FormCommand.class);

	public static <T> void createForm(FormEnum form, T layout) {
		if (FormEnum.CAD_SECTION == form) new CadSectionCommand().execute(layout);
	}
}
