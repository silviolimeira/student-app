package com.sl.app.rest.ui;

import com.sl.app.model.Status;
import com.sl.app.model.Student;
import com.sl.app.rest.data.AsyncStatusService;
import com.sl.app.rest.data.RestClientService1;
import com.sl.app.rest.data.StatusDTO;
import com.sl.app.views.LogoLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@PageTitle(value = "Home")
@Route(value = "")
public class HomeView extends VerticalLayout {

    private LogoLayout logoLayout;
    private Grid<Student> grid;
    private Button button;
    private Button buttonPost;
    private final AsyncStatusService service;
    private final RestClientService1 restClient;


    public HomeView(@Autowired AsyncStatusService service, @Autowired RestClientService1 restClient) {
        this.service = service;
        this.restClient = restClient;

        setSizeFull();
        setAlignItems(Alignment.CENTER);
        createFieldVariables();
        configureGrid();
        add(logoLayout, grid);
        add(new Span("Teste"));
        loadStudents();

        final Button fetchComments = new Button("Fetch all comments", e -> startFetch());
        final Button buttonPost = new Button("Post", e -> startPost());
        final Button buttonGet = new Button("Get", e -> startGet());
        fetchComments.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(fetchComments, buttonPost, buttonGet);

    }

    private void startFetch() {

        // In this method we ask our service to start fetching the results from REST,
        // and wait for the result.

        // These are run immediately, to give the user feedback that we are doing
        // something
        //statusLabel.setVisible(true);
        //commentsGrid.setEnabled(false);

        final UI ui = getUI().get();

        // Calling the service to start the op. The callback e provide is called when
        // the results are available.
        service.getAllStatusAsync(result -> {

            // We now have the results. But, because this call might happen outside normal
            // Vaadin calls, we need to make sure the HTTP Session data of this app isn't
            // violated. For this we use UI#access()
            ui.access(() -> {

                // Finally, we can modify the UI state. These changes are sent to the users
                // browser immediately, because we have enable Websocket Server Push (@Push
                // annotation in MainLayout).
//                statusLabel.setVisible(false);
//                commentsGrid.setEnabled(true);
//                commentsGrid.setItems(result);
                System.out.println(result);
            });
        });
    }

    public Mono<StatusDTO> postStatus(StatusDTO status) {
        WebClient webClient = WebClient.create();
        Mono<StatusDTO> statusDTOMono = webClient.post()
                .uri("http://localhost:8091/v1/status")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(status), StatusDTO.class)
                .retrieve()
                .bodyToMono(StatusDTO.class);
        return statusDTOMono;
    }

    private void startPost() {

        StatusDTO status = new StatusDTO();
        status.setId(1);
        status.setName("STARTING");
        status.setTitle("Starting");

        final UI ui = getUI().get();

        this.postStatus(status)
            .subscribe(
                createdStatus -> {
                    System.out.println("Status created: " + createdStatus);
                    ui.access(() -> {
                        add(new Span("Status created: " + createdStatus));
                    });
                },
                error -> {
                    System.err.println("Error creating status: " + error.getMessage());
                });
    }

    public void startGet() {
        WebClient webClient = WebClient.create();
        Disposable statusDTOMono = webClient.get()
            .uri("http://localhost:8091/v1/status")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .toEntityList(StatusDTO.class)
            .subscribe(result -> {
                // This code block is run whenever the results are back
                // get results as usual
                final List<StatusDTO> statusList = result.getBody();
                final UI ui = getUI().get();
                ui.access(() -> {
                    add(new Span("Status created: " + statusList));
                });
            });

    }


    private void configureGrid() {
        grid.setSizeFull();
        grid.setColumns("country", "zipCode");
        grid.addColumn(s -> s.getName()).setHeader("Name");
        grid.addColumn(s -> s.getAge()).setHeader("Age");
        grid.addComponentColumn(s -> {
            Icon icon;
            if (s.getStatus().getName().equals("ACTIVE")) {
                icon = VaadinIcon.CIRCLE.create();
                icon.setColor("green");
            } else if (s.getStatus().getName().equals("INACTIVE")) {
                icon = VaadinIcon.CLOSE_CIRCLE.create();
                icon.setColor("red");
            } else {
                icon = VaadinIcon.CHECK_CIRCLE.create();
                icon.setColor("orange");
            }

            return icon;
        }).setHeader("Status");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void loadStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Silvio", 50, 17100, "Brasil", new Status("ACTIVE",
                "Ativo")));
        students.add(new Student("Kevin", 50, 17100, "UK", new Status("INACTIVE",
                "Inativo")));
        students.add(new Student("Emily", 50, 17100, "Italy", new Status("ABSOLVED",
                "Absorvido")));
        grid.setItems(students);
    }

    private void createFieldVariables() {
        logoLayout = new LogoLayout();
        grid = new Grid<>(Student.class);
        button = new Button();
    }
}
