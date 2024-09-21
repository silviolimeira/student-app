package com.sl.spring_1.adm.view.grid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sl.spring_1.adm.view.SectionView;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.grid.HeaderRow.HeaderCell;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("/grid1")
@PageTitle("Sample Grid")
public class SampleGrid extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(SectionView.class);

	
	public void sample() {
		// BEGIN-EXAMPLE: component.grid.filtering
        // Have a filterable container
        IndexedContainer container = exampleDataSource();

        // Create a grid bound to it
        Grid grid = new Grid(container);
        grid.setSelectionMode(SelectionMode.NONE);
        grid.setWidth("500px");
        grid.setHeight("300px");

        // Create a header row to hold column filters
        HeaderRow filterRow = grid.appendHeaderRow();

        // Set up a filter for all columns
        for (Object pid: grid.getContainerDataSource()
                             .getContainerPropertyIds()) {
            HeaderCell cell = filterRow.getCell(pid);

            // Have an input field to use for filter
            TextField filterField = new TextField();
            filterField.setColumns(8);
            filterField.setInputPrompt("Filter");
            filterField.addStyleName(ValoTheme.TEXTFIELD_TINY);

            // Update filter When the filter input is changed
            filterField.addTextChangeListener(change -> {
                // Can't modify filters so need to replace
                container.removeContainerFilters(pid);

                // (Re)create the filter if necessary
                if (! change.getText().isEmpty())
                    container.addContainerFilter(
                        new SimpleStringFilter(pid,
                            change.getText(), true, false));
            });
            cell.setComponent(filterField);
        }

        layout.addComponent(grid);
        // END-EXAMPLE: component.grid.filtering		
	}
}
