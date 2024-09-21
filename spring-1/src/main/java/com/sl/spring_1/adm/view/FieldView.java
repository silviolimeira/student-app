package com.sl.spring_1.adm.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("/field")
@PageTitle("Field")
public class FieldView extends VerticalLayout implements BeforeEnterObserver {

	private static final long serialVersionUID = 1L;

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		add(new Text("Group fields ..."));
	}

}
