package com.sl.spring_1.adm.view.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.sl.spring_1.Command;
import com.sl.spring_1.adm.ITestThread;
import com.sl.spring_1.adm.service.AppService;
import com.sl.spring_1.adm.view.SectionView;
import com.sl.spring_1.adm.view.grid.SectionGrid;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;

public class ModuleSectionCommand implements Command {

	private static final Logger logger = LogManager.getLogger(ModuleSectionCommand.class);
	
	AppService sectionService;
	
	public ModuleSectionCommand(AppService sectionService) {
		this.sectionService = sectionService;
	}
	
	@Override
	public <T> void execute(T layout) {
		SectionGrid sectionGrid = new SectionGrid(sectionService);
		((VerticalLayout) layout).removeAll();
		((HasComponents) layout).add(sectionGrid);
		
	}

}
