package com.sl.admin.component;

import java.util.List;

import com.sl.admin.model.EntityDomain;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;

public class GridComponent<T> extends Div {

	private static final long serialVersionUID = 1L;
	TextField title;
	private Grid<T> grid;
	private List<T> list;
	private EntityDomain entity;
//	private static Div hint;
	
	public GridComponent(Grid<T> grid, List<T> list) {
		this.grid = grid;
		this.list = list;
		this.setupFieldForm();
		this.setupGrid();
	}
	
	private void setupFieldForm() {
		title = new TextField("Title");
		Button button = new Button("+");
		button.addClickListener(e -> {
			//TODO call service add entity
			System.out.println("Plus Grid...");
		});
		HorizontalLayout layout = new HorizontalLayout(title, button);
		layout.setFlexGrow(1, title);
		add(layout);
	}
	
	private void setupGrid() {
		grid.setAllRowsVisible(true);
        grid.addColumn(
                new ComponentRenderer<>(Button::new, (button, entity) -> {
                    button.addThemeVariants(ButtonVariant.LUMO_ICON,
                            ButtonVariant.LUMO_ERROR,
                            ButtonVariant.LUMO_TERTIARY);
                    button.addClickListener(e -> {
                    	System.out.println(">>>>>: remove");
                    	this.removeFromGrid(entity);
                    	
                    });
                    button.setIcon(new Icon(VaadinIcon.TRASH));
                })).setHeader("Remover");
        grid.setItems(list);
        
//        hint = new Div();
//        hint.setText("No invitation has been sent");
//        hint.getStyle().set("padding", "var(--lumo-size-l)")
//                .set("text-align", "center").set("font-style", "italic")
//                .set("color", "var(--lumo-contrast-70pct)");        
        
        add(/*hint,*/ grid);
	}
	
	private void refreshGrid() {
        if (list.size() > 0) {
            grid.setVisible(true);
//            hint.setVisible(false);
            grid.getDataProvider().refreshAll();
        } else {
            grid.setVisible(false);
//            hint.setVisible(true);
        }
    }

    private void removeFromGrid(T entity) {
        if (entity == null)
            return;
        list.remove(entity);
        this.refreshGrid();
    }
	

	
}
