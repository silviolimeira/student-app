package com.sl.spring_1.adm.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("/section")
@PageTitle("Section")
public class SectionView extends VerticalLayout {
	public SectionView() {
		add(new Text("Students Sections ..."));
	}

}
