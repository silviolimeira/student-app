package com.sl.spring_1.adm.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("/group")
@PageTitle("Group")
public class GroupView extends VerticalLayout implements BeforeEnterObserver {


	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		add(new Text("Sections groups ..."));
	}

}
