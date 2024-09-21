package com.sl.spring_1.adm.view.menu;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.spring_1.MyController;
import com.sl.spring_1.adm.ITestThread;
import com.sl.spring_1.adm.service.SectionServiceImpl;
import com.sl.spring_1.adm.view.FieldView;
import com.sl.spring_1.adm.view.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.UIDetachedException;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;

public class MenuCommand {

	private static final Logger logger = LogManager.getLogger(MyController.class);

	public <T> MenuComponent regModuleSection(VerticalLayout layout, T service) {
		return new ButtonMenuComponent(MenuEnum.MODULE_SECTION, "100px", "100px", service) {
			@Override
			public <S> boolean execute(S service) {
				logger.info("execute Register Section");
				ViewCommand viewCommand = new ViewCommand();
				viewCommand.createView(MenuEnum.MODULE_SECTION, layout, service);
				
				// layout.add(new RouterLink("Sections", SectionView.class));
				return false;
			}
		};
	}

	public <T> MenuComponent regGroup(VerticalLayout layout, T service) {
		return new RouterLinkMenuComponent(MenuEnum.CAD_GROUP, "100px", "100px", service) {

			@Override
			public <S> boolean execute(S service) {
				// TODO Auto-generated method stub
				return false;
			}

		};
	}

	public <T> MenuComponent regField(VerticalLayout layout, T service) {
		return new RouterLinkMenuComponent(MenuEnum.CAD_FIELD, "100px", "100px", service) {

			@Override
			public <S> boolean execute(S service) {
				logger.info("execute Register Field");
				// FormCommand.createForm(FormEnum.CAD_SECTION, layout);
				layout.add(new FieldView());
				return false;
			}
		};
	}

	public <T> MenuComponent regModuleSection(VerticalLayout layout, T service, UI ui) {
		return new ButtonMenuComponent(MenuEnum.MODULE_SECTION, "100px", "100px", service) {
		    
			@Override
			public <S> boolean execute(S service) {
				
				logger.info("execute Register Section");

				ViewCommand viewCommand = new ViewCommand();
				viewCommand.createView(MenuEnum.MODULE_SECTION, layout, service);
				// layout.add(new RouterLink("Sections", SectionView.class));
				return false;
			}


		};
	}


}
