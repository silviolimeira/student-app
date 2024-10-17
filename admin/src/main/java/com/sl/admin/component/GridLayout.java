package com.sl.admin.component;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.admin.model.Tree;
import com.sl.admin.view.TreeView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class GridLayout extends VerticalLayout {
	
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(Grid.class);

	private List<Tree> trees;
	private Grid<Tree> grid;
	
	public GridLayout() {
		trees = new ArrayList<>();
		grid = new Grid<>();
		// text field for the user input
		VerticalLayout dialogLayout = createLayout();

		// create the buttons
		Button cancel = new Button("Cancelar", event -> logger.info("cancelar..."));
		Button save = new Button("Salvar", event -> {
			logger.info("salvar...");
		});

		getData();
		add(createLayout());
		add(cancel, save);

	}
	
	private void getData() {
		trees.add(new Tree("Title 1", "Description 1"));
		trees.add(new Tree("Title 2", "Description 2"));
		trees.add(new Tree("Title 3", "Description 3"));
	}
	
	private VerticalLayout createLayout() {
		grid.addColumn(Tree::getTitle);
		grid.addColumn(Tree::getDescription);
		grid.setItems(trees);

		VerticalLayout layout = new VerticalLayout(grid);
		layout.getStyle().set("width", "250px").set("max-width", "100%");
		
		return layout;
	}
}
