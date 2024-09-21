package com.sl.spring_1.adm.view.grid;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.spring_1.Student;
import com.sl.spring_1.adm.model.SectionDTO;
import com.sl.spring_1.adm.service.AppService;
import com.sl.spring_1.adm.view.LogoLayout;
import com.sl.spring_1.adm.view.MainView;
import com.sl.spring_1.adm.view.SectionView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.PropertyId;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import jakarta.annotation.PostConstruct;

@Route("/section-grid")
@PageTitle("Section")
public class SectionGrid extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(SectionView.class);

	private AppService sectionService;
	private LogoLayout logoLayout;
	private Grid<SectionDTO> grid;

	public SectionGrid(AppService sectionService) {
		
		createFieldsVariables();
		configure();
		
		add(logoLayout, grid);
		
		loadData();
	}


	private void configure() {
		setAlignItems(Alignment.CENTER);
		setSizeFull();
		//grid.addColumn(s -> s.getTitle()).setHeader("Title");
		//grid.addColumn(s -> s.getHint()).setHeader("Hint");
		
	}
	
	private void loadData() {
		List<SectionDTO> sections = new ArrayList<>();
		sections.add(new SectionDTO());
		grid.setItems(sections);
	}

	private void createFieldsVariables() {
		logoLayout = new LogoLayout();
		grid = new Grid<>(SectionDTO.class);
	}

	

}
