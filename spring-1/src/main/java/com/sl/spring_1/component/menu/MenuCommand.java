package com.sl.spring_1.component.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.common.returnsreceiver.qual.This;

import com.sl.spring_1.MyController;

public class MenuCommand {

	private static final Logger logger = LogManager.getLogger(MyController.class);

	public static ObjectMenuComponent cadastroClientes() {
		return new ButtonMenuComponent("Clientes", "100px", "100px") {
			
			@Override
			public boolean execute() {
				logger.info("execute Cadastro Clientes");
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
