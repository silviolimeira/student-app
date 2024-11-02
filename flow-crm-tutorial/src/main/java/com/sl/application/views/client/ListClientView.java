package com.sl.application.views.client;

import com.sl.application.model.Client;
import com.sl.application.services.ClientService;
import com.sl.application.views.MainLayout;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import jakarta.annotation.security.PermitAll;
import org.springframework.context.annotation.Scope;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@SpringComponent
@Scope("prototype")
@PermitAll
@Route(value = "/clients", layout = MainLayout.class)
@PageTitle("Clientes | CRM")
public class ListClientView extends VerticalLayout {
    List<Client> clients;
    public Grid<Client> grid = new Grid<>();
    TextField filterText = new TextField();
    //ClientForm form;
    ClientService service;

    public ListClientView(ClientService service) {
        this.service = service;
        clients = new ArrayList<>();
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        //configureForm();

        add(getToolbar(), getContent());
        //updateList();
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
        // First example uses a Data Transfer Object (DTO) class that we've created. The
        // Vaadin Grid works well with entity classes, so this is quite straightforward:
        grid = new Grid<Client>(Client.class);
        // Button for fetching all entities and showing them
        //grid.setItems(getAllClients());
        startFetch();
    }

    private Component getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        grid.setEnabled(false);
        Button addContactButton = new Button("Add contact");
        addContactButton.addClickListener(click -> {
            startFetch();
        });
        Button refreshContactButton = new Button("Refresh contact");
        refreshContactButton.addClickListener(click -> {
            grid.setItems(clients);
        });
        final Button fetchAllClients = new Button("Fetch all comments",
            e -> grid.setItems(service.getAllClients())
        );

        var toolbar = new HorizontalLayout(filterText, addContactButton, refreshContactButton, fetchAllClients);
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
        //final UI ui = getUI().get();
        //service.getAllClients(result -> grid.setItems(result));
        /*
        service.getAllClients(result -> {
            ui.access(() -> {
                grid.setEnabled(true);
                grid.setItems(result);
                grid.setItems()
                grid.getDataProvider().refreshAll();
            });
        });
        */

    }

    private void updateList() {
        grid.setItems(service.getAllClients());
    }

    private void startFetch() {

        // Calling the service to start the op. The callback e provide is called when
        // the results are available.
        service.getAllClientsAsync(result -> {

            // We now have the results. But, because this call might happen outside normal
            // Vaadin calls, we need to make sure the HTTP Session data of this app isn't
            // violated. For this we use UI#access()
            getUI().ifPresent(ui -> {
                ui.access(() -> {
                    // Finally, we can modify the UI state. These changes are sent to the users
                    // browser immediately, because we have enable Websocket Server Push (@Push
                    // annotation in MainLayout).
                    grid.setItems(result);
                });
            });
        });
    }

}
