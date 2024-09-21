package com.sl.spring_1.adm.view.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.spring_1.adm.jpa.Section;
import com.sl.spring_1.adm.view.FieldView;
import com.sl.spring_1.adm.view.GroupView;
import com.sl.spring_1.adm.view.SectionView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public abstract class RouterLinkMenuComponent extends MenuComponent {

	private static final Logger logger = LogManager.getLogger(RouterLinkMenuComponent.class);
	
	RouterLink routerLink;

	public <T> RouterLinkMenuComponent(MenuEnum section, String height, String width, T service) {
		switch (section) {
			default:
			case MenuEnum.MODULE_SECTION:
				this.title = "Register Section";
				this.routerLink = new RouterLink(this.title, SectionView.class);
				break;
			case MenuEnum.CAD_GROUP:
				this.title = "Register Group";
				this.routerLink = new RouterLink(this.title, GroupView.class);
				break;
			case MenuEnum.CAD_FIELD:
				this.title = "Register Field";
				this.routerLink = new RouterLink(this.title, FieldView.class);
				break;
		}
		//else if (title.equalsIgnoreCase(FormEnum.CAD_GROUP.toString())) this.routerLink = new RouterLink("Group", GroupView.class);
		//else if (title.equalsIgnoreCase(FormEnum.CAD_FIELD.toString())) this.routerLink = new RouterLink("Field", FieldView.class);
	}
	
	public String getTitle() {
		return title;
	}

	public RouterLink getOption() {
		return this.routerLink;
	}

}
