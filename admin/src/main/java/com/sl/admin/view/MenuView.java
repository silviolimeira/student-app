package com.sl.admin.view;

import com.sl.admin.component.GridLayout;
import com.sl.admin.component.TreeDialog;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("/ui")
@PageTitle("Menu")
public class MenuView extends VerticalLayout {

	public MenuView() {
		Button button = new Button("Show TreeDialog", event -> {
			TreeDialog dialog = new TreeDialog();
			dialog.open();
		});
		add(button);

		add(new GridLayout());
		
	}
	
}
