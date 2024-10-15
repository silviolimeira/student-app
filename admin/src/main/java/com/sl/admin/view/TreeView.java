package com.sl.admin.view;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.admin.model.Section;
import com.sl.admin.service.SectionService;
import com.sl.admin.type.SectionTypeBean;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
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

@Route("/sections")
@PageTitle("Section")
public class SectionView extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(SectionView.class);

	//AppService sectionService;

	@PropertyId("id")
	private TextField id; // Long
	private TextField title;
	private TextField hint;
	private TextField description;
	private TextField width; // Integer
	private TextField height; // Integer
	private ComboBox<SectionTypeBean> type; // SectionTypeEnum

	private Button saveButton;
	private Button cancelButton;

	private Section section;
	private Binder<Section> binder;

	//@Autowired
	private SectionService sectionService;

	public SectionView(SectionService sectionService) {
		this.sectionService = sectionService;
		add(new Text("Students Sections SSS..."));
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

	public void setSection(Section section) {
		this.section = section;
		binder.readBean(section);
	}

	@PostConstruct
	private void initBinder() {
		binder = new BeanValidationBinder<>(Section.class);
		binder.bindInstanceFields(this);
	}

	@PostConstruct
	private void initComponents() {
		section = new Section();

		id = new TextField("Id"); // Long
		
		SectionTypeBean stb = new SectionTypeBean();
		type = new ComboBox<SectionTypeBean>("Type"); // SectionType
		type.setItems(stb.names());
		type.setItemLabelGenerator(SectionTypeBean::getName);

		title = new TextField("Title");
		hint = new TextField("Hint");
		description = new TextField("Description");
		width = new TextField("Width"); // Integer
		height = new TextField("Height"); // Integer

		cancelButton = new Button("Cancel", event -> {
			try {
				binder.writeBean(section);
				logger.info("Secition={}", section);
				getUI().ifPresent(ui -> ui.navigate(SectionView.class));
			} catch (ValidationException e) {
				logger.error(e);
				Notification.show("Validation Error!");
			}
		});

		saveButton = new Button("Save", event -> {
			try {
				binder.writeBean(section);
				//sectionService.save(sectionDTO);
				List<Section> list = sectionService.findAll();
				sectionService.save(section);
				//logger.info("List<Section>={}", dto);
				getUI().ifPresent(ui -> ui.navigate(SectionView.class));

			} catch (ValidationException e) {
				logger.error(e);
				Notification.show("Validation Error!");
			}
		});

	}

}
