package com.sl.spring_1.adm.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.spring_1.adm.model.SectionDTO;
import com.sl.spring_1.adm.service.AppService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
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

@Route("/section")
@PageTitle("Section")
public class SectionView extends VerticalLayout {

	private static final Logger logger = LogManager.getLogger(SectionView.class);

	AppService sectionService;

	@PropertyId("id")
	private TextField id; // Long
	private TextField type; // Integer
	private TextField title;
	private TextField hint;
	private TextField description;
	private TextField width; // Integer
	private TextField height; // Integer

	private Button saveButton;
	private Button cancelButton;

	private SectionDTO sectionDTO;
	private Binder<SectionDTO> binder;

	public SectionView(AppService sectionService) {
		this.sectionService = sectionService;
		add(new Text("Students Sections ..."));
		initComponents();
		initBinder();
		addComponents();
	}

	private void addComponents() {

		HorizontalLayout linha = new HorizontalLayout();
		linha.setWidth("400px");
		linha.add(id, type);
		add(linha);

		linha = new HorizontalLayout();
		linha.setWidth("400px");
		linha.add(title, hint);
		add(linha);

		linha = new HorizontalLayout();
		linha.setWidth("400px");
		linha.add(description);
		add(linha);

		linha = new HorizontalLayout();
		linha.setWidth("400px");
		linha.add(width, height);
		add(linha);

		linha = new HorizontalLayout();
		linha.setWidth("420px");
		linha.setPadding(true);
		linha.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
		saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		linha.add(cancelButton, saveButton);
		add(linha);
	}

	public void setSection(SectionDTO sectionDTO) {
		this.sectionDTO = sectionDTO;
		binder.readBean(sectionDTO);
	}

	@PostConstruct
	private void initBinder() {
		binder = new BeanValidationBinder<>(SectionDTO.class);
		binder.bindInstanceFields(this);
	}

	@PostConstruct
	private void initComponents() {
		sectionDTO = new SectionDTO();
		binder = new BeanValidationBinder<>(SectionDTO.class);
		id = new TextField("Id"); // Long
		type = new TextField("Type"); // Integer
		title = new TextField("Title");
		hint = new TextField("Hint");
		description = new TextField("Description");
		width = new TextField("Width"); // Integer
		height = new TextField("Height"); // Integer

		cancelButton = new Button("Cancel", event -> {
			try {
				binder.writeBean(sectionDTO);
				logger.info("Secition={}", sectionDTO);
				getUI().ifPresent(ui -> ui.navigate(MainView.class));
			} catch (ValidationException e) {
				logger.error(e);
				Notification.show("Validation Error!");
			}
		});

		saveButton = new Button("Save", event -> {
			try {
				binder.writeBean(sectionDTO);
				logger.info("Secition={}", sectionDTO);
				sectionService.save(sectionDTO);
				getUI().ifPresent(ui -> ui.navigate(MainView.class));

			} catch (ValidationException e) {
				logger.error(e);
				Notification.show("Validation Error!");
			}
		});

	}

}
