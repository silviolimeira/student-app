package com.sl.admin.view;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.admin.model.Tree;
import com.sl.admin.service.TreeService;
import com.sl.admin.type.TreeTypeBean;
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

@Route("/trees")
@PageTitle("Tree")
public class TreeView extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(TreeView.class);

	@PropertyId("id")
	private TextField id; // Long
	private TextField title;
	private TextField hint;
	private TextField description;
	private TextField width; // Integer
	private TextField height; // Integer
	private ComboBox<TreeTypeBean> type;

	private Button saveButton;
	private Button cancelButton;

	private Tree tree;
	private Binder<Tree> binder;

	//@Autowired
	private TreeService treeService;

	public TreeView(TreeService treeService) {
		this.treeService = treeService;
		add(new Text("Students Trees SSS..."));
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

	public void setTree(Tree tree) {
		this.tree = tree;
		binder.readBean(tree);
	}

	@PostConstruct
	private void initBinder() {
		binder = new BeanValidationBinder<>(Tree.class);
		binder.bindInstanceFields(this);
	}

	@PostConstruct
	private void initComponents() {
		tree = new Tree();

		id = new TextField("Id"); // Long

		TreeTypeBean stb = new TreeTypeBean();
		type = new ComboBox<TreeTypeBean>("Type");
		type.setItems(stb.names());
		type.setItemLabelGenerator(TreeTypeBean::getName);

		title = new TextField("Title");
		hint = new TextField("Hint");
		description = new TextField("Description");
		width = new TextField("Width"); // Integer
		height = new TextField("Height"); // Integer

		cancelButton = new Button("Cancel", event -> {
			try {
				binder.writeBean(tree);
				logger.info("Secition={}", tree);
				getUI().ifPresent(ui -> ui.navigate(TreeView.class));
			} catch (ValidationException e) {
				logger.error(e);
				Notification.show("Validation Error!");
			}
		});

		saveButton = new Button("Save", event -> {
			try {
				binder.writeBean(tree);
				List<Tree> list = treeService.findAll();
				treeService.save(tree);
				getUI().ifPresent(ui -> ui.navigate(TreeView.class));

			} catch (ValidationException e) {
				logger.error(e);
				Notification.show("Validation Error!");
			}
		});

	}

}
