package com.sl.spring_1.adm.view.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.spring_1.adm.service.AppService;

public class ViewCommand {
	
	private static final Logger logger = LogManager.getLogger(ViewCommand.class);

	public <T> void createView(MenuEnum module, T layout, T service) {
		if (MenuEnum.MODULE_SECTION == module) new ModuleSectionCommand((AppService) service).execute(layout);
	}
}
