package com.sl.application.views.client;

import com.sl.application.model.Client;
import com.sl.application.services.ClientService;
import com.sl.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import jakarta.annotation.security.PermitAll;
import org.springframework.context.annotation.Scope;

@SpringComponent
@Scope("prototype")
@PermitAll
@Route(value = "/clients", layout = MainLayout.class)
@PageTitle("Clientes | CRM")
public class ListClientView extends VerticalLayout {
    public Grid<Client> grid = new Grid<Client>(Client.class);
    TextField filterText = new TextField();
    //ClientForm form;
    ClientService service;

    public ListClientView(ClientService service) {
        this.service = service;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        //configureForm();

        add(getToolbar(), getContent());
        updateList();
        closeEditor();
    }

    private HorizontalLayout getContent() {
        Span statusLabel = new Span(" Fetching results, please wait...");
        statusLabel.setVisible(false);

        HorizontalLayout content = new HorizontalLayout(grid); //, form);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, statusLabel);
        //content.setFlexGrow(1, form);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }

//    private void configureForm() {
//        form = new ContactForm(service.findAllCompanies(), service.findAllStatuses());
//        form.setWidth("25em");
//        form.addSaveListener(this::saveContact); // <1>
//        form.addDeleteListener(this::deleteContact); // <2>
//        form.addCloseListener(e -> closeEditor()); // <3>
//    }

//    private void save(ClientForm.SaveEvent event) {
//        service.saveContact(event.getContact());
//        updateList();
//        closeEditor();
//    }
//
//    private void deleteContact(ContactForm.DeleteEvent event) {
//        service.deleteContact(event.getContact());
//        updateList();
//        closeEditor();
//    }

    private void configureGrid() {
        grid.addClassNames("contact-grid");
        grid.setSizeFull();
//        grid.addColumn(Client::getId).setHeader("id");
//        grid.addColumn(Client::getCode).setHeader("Código");
//        grid.addColumn(Client::getFullName).setHeader("Nome");
//        grid.addColumn(Client::getEmail).setHeader("email");
//        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(event ->
            edit(event.getValue()));
    }

    private Component getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        grid.setEnabled(false);
        Button addContactButton = new Button("Add contact");
        addContactButton.addClickListener(click -> startFetch());

        var toolbar = new HorizontalLayout(filterText, addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    public void edit(Client client) {
        if (client == null) {
            closeEditor();
        } else {
//            form.setContact(contact);
//            form.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
//        form.setContact(null);
//        form.setVisible(false);
        removeClassName("editing");
    }

    private void addContact() {
//        editContact(new Contact());
//        startFetch();
        final UI ui = getUI().get();
        service.getAllClients(result -> {
            ui.access(() -> {
                grid.setEnabled(true);
                grid.setItems(result);
                //grid.getDataProvider().refreshAll();
            });
        });

    }

    private void startFetch() {
        final UI ui = getUI().get();
        service.getAllClients(result -> {
            ui.access(() -> {
                grid.setEnabled(true);
                grid.setItems(result);
                //grid.getDataProvider().refreshAll();
            });
        });
    }

    private void updateList() {
        //grid.setItems(service.getAllClients());
    }
}
