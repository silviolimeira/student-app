package com.sl.spring_1.adm.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.spring_1.MyController;
import com.sl.spring_1.adm.form.CadSectionCommand;
import com.sl.spring_1.adm.form.FormCommand;
import com.sl.spring_1.adm.form.FormEnum;
import com.sl.spring_1.adm.jpa.Section;
import com.sl.spring_1.adm.view.FieldView;
import com.sl.spring_1.adm.view.GroupView;
import com.sl.spring_1.adm.view.SectionView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class MenuCommand {

	private static final Logger logger = LogManager.getLogger(MyController.class);

	public static MenuComponent regSection(VerticalLayout layout) {
		return new ButtonMenuComponent(FormEnum.CAD_SECTION, "100px", "100px") {
			
			@Override
			public boolean execute() {
				logger.info("execute Register Section");
				FormCommand.createForm(FormEnum.CAD_SECTION, layout);
				//layout.add(new RouterLink("Sections", SectionView.class));
				return false;
			}
		};
	}

	public static MenuComponent regGroup(VerticalLayout layout) {
		return new RouterLinkMenuComponent(FormEnum.CAD_GROUP, "100px", "100px") {
			
			@Override
			public boolean execute() {
				logger.info("execute Register Groups");
				//FormCommand.createForm(FormEnum.CAD_SECTION, layout);
				return false;
			}
		};
	}

	public static MenuComponent regField(VerticalLayout layout) {
		return new RouterLinkMenuComponent(FormEnum.CAD_FIELD, "100px", "100px") {
			
			@Override
			public boolean execute() {
				logger.info("execute Register Field");
				//FormCommand.createForm(FormEnum.CAD_SECTION, layout);
				layout.add(new FieldView()); 
				return false;
			}
		};
	}
	

	
}
