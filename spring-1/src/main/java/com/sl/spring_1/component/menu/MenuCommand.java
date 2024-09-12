package com.sl.spring_1.component.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.spring_1.MyController;
import com.sl.spring_1.component.modal.CadastroCommand;
import com.sl.spring_1.component.modal.ModalEnum;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class MenuCommand {

	private static final Logger logger = LogManager.getLogger(MyController.class);

	public static ObjectMenuComponent cadClientes(VerticalLayout layout) {
		return new ButtonMenuComponent("Clientes", "100px", "100px") {
			
			@Override
			public boolean execute() {
				logger.info("execute Cadastro Clientes");
				CadastroCommand.createModal(ModalEnum.CAD_CLIENTES, layout);
				return false;
			}
		};
	}
	
	public static ObjectMenuComponent cadastroFornecedores() {
		return new ButtonMenuComponent("Fornecedores", "100px", "150px") {
			
			@Override
			public boolean execute() {
				logger.info("execute Cadastro Fornecedores");
				return false;
			}
		};
	}
	
	public static ObjectMenuComponent castroFornecedores() {
		return new SpanMenuComponent("Fornecedores") {
			@Override
			public boolean execute() {
				logger.info("execute Cadastro de Fonecedores");
				return false;
			}
		};
	}
	
	public static ObjectMenuComponent filtro() {
		return new CheckboxMenuComponent("Filtro") {
			@Override
			public boolean execute() {
				logger.info("execute Filtro");
				return false;
			}
		};
	}

	
}
