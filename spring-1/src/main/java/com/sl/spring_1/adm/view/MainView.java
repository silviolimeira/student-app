package com.sl.spring_1.adm.view;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.sl.spring_1.adm.ITestThread;
import com.sl.spring_1.adm.service.SectionServiceImpl;
import com.sl.spring_1.adm.view.menu.AdminMenuLayout;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/ui")
public class MainView extends VerticalLayout {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LogManager.getLogger(MainView.class);

	@Autowired SectionServiceImpl sectionService;
	
	private UI ui;
	
	@Override
	protected void onAttach(AttachEvent attachEvent) {
		super.onAttach(attachEvent);
		ui = UI.getCurrent();
	}
	
	public MainView() {
		this.ui = UI.getCurrent();
		var aml = new AdminMenuLayout("100%", "100%", "Forms", 3, this);
		aml.createOptions(Arrays.asList(aml.getMenuCommand().regModuleSection(this, sectionService, ui),
			aml.getMenuCommand().regGroup(this, sectionService), 
			aml.getMenuCommand().regField(this, sectionService)));
		
		ITestThread.task("Teste ...", this.ui);
	}

		

	/*
	 * public void MainView11() {
	 * 
	 * MenuComponent mc1 = new MenuComponent("50%", "100%",
	 * "Menu Opções de Cadastros", 3, this);
	 * mc1.createOptions(Arrays.asList(MenuCommand.cadClientes(this),
	 * MenuCommand.cadastroFornecedores(), MenuCommand.castroFornecedores(),
	 * MenuCommand.filtro())); add(mc1);
	 * 
	 * 
	 * }
	 * 
	 * 
	 * public void MainView11() { TextField firstName = new
	 * TextField("First Name:"); TextField lastName = new TextField("Last Name:");
	 * TextField userName = new TextField("Username:"); PasswordField password = new
	 * PasswordField("Password"); PasswordField confirm = new
	 * PasswordField("Password");
	 * 
	 * // setResponsiveSteps(new ResponsiveStep("0px", 1), new
	 * ResponsiveStep("800px", 2)); // // setColspan(userName, 2);
	 * 
	 * add(firstName, lastName, userName, password, confirm); }
	 * 
	 * public void MainView10() { add(new Button("Button 1")); add(new
	 * Button("Button 2")); add(new Button("Button 3")); add(new
	 * Button("Button 4"));
	 * 
	 * setHeight("100%");
	 * //setJustifyContentMode(FlexComponent.JustifyContentMode.EVENLY); }
	 * 
	 * public void MainView9() { // Sample use Menu Component // MenuComponent mc1 =
	 * new MenuComponent("50%", "100%", "Menu Opções de Cadastros", 3); //
	 * mc1.createOptions(Arrays.asList(MenuCommand.cadastroClientes(this),
	 * MenuCommand.cadastroFornecedores(this), // MenuCommand.castroFornecedores(),
	 * MenuCommand.filtro())); // add(mc1); }
	 * 
	 * public void MainView8() {
	 * 
	 * Tab tab1 = new Tab(VaadinIcon.BELL.create(), new Span("Orders")); Tab tab2 =
	 * new Tab(VaadinIcon.COG.create(), new Span("Payments")); Tab tab3 = new
	 * Tab(VaadinIcon.USER.create(), new Span("Services"));
	 * 
	 * tab1.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
	 * tab2.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
	 * tab3.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
	 * 
	 * Tabs mainTab = new Tabs(tab1, tab2, tab3); mainTab.setSelectedTab(tab2);
	 * mainTab.addThemeVariants(TabsVariant.LUMO_EQUAL_WIDTH_TABS);
	 * mainTab.setWidth("100%");
	 * 
	 * add(mainTab); }
	 * 
	 * public void MainView7() {
	 * 
	 * List<Person> employees = new ArrayList<>(); employees.add(new Person("Adam",
	 * "adam@gmail.com", 35)); employees.add(new Person("Ana", "ana@gmail.com",
	 * 18)); employees.add(new Person("Kevin", "kevin@gmail.com", 20));
	 * employees.add(new Person("Steven", "steven@gmail.com", 24));
	 * employees.add(new Person("Daniel", "daniel@gmail.com", 28));
	 * employees.add(new Person("Michael", "michael@gmail.com", 50));
	 * 
	 * Grid<Person> grid = new Grid<>(Person.class, false);
	 * grid.addColumn(Person::getName).setHeader("Name").setSortable(true).
	 * setTextAlign(ColumnTextAlign.CENTER);
	 * grid.addColumn(Person::getEmail).setHeader("Email").setSortable(true).
	 * setTextAlign(ColumnTextAlign.CENTER);
	 * grid.addColumn(Person::getAge).setHeader("Age").setSortable(true).
	 * setTextAlign(ColumnTextAlign.CENTER);
	 * 
	 * grid.setAllRowsVisible(true);
	 * 
	 * grid.setItems(employees);
	 * grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
	 * grid.setSelectionMode(Grid.SelectionMode.MULTI);
	 * 
	 * Button button = new Button("Remove"); button.addClickListener(event -> {
	 * employees.removeAll(grid.getSelectedItems());
	 * grid.getDataProvider().refreshAll(); logger.info(grid.getSelectedItems());
	 * });
	 * 
	 * add(button); add(grid);
	 * 
	 * }
	 * 
	 * public void MainView6() {
	 * 
	 * List<Person> list = new ArrayList<>(); list.add(new Person("Adam", 33));
	 * list.add(new Person("Ana", 26)); list.add(new Person("Kevin", 14));
	 * list.add(new Person("Steven", 10));
	 * 
	 * ComboBox<Person> box = new ComboBox<>("Employee"); box.setItems(list);
	 * 
	 * box.setPlaceholder("Select an employee"); box.setItemLabelGenerator(person ->
	 * person.getName() + " / " + person.getAge());
	 * 
	 * box.addValueChangeListener(event -> { logger.info(box.getValue()); });
	 * 
	 * add(box); }
	 * 
	 * public void MainView5() { CheckboxGroup<String> group = new
	 * CheckboxGroup<>(); group.setLabel("Days"); group.setItems("Monday",
	 * "Tuesday", "Wednesday");
	 * group.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
	 * group.addValueChangeListener(event -> { logger.info(group.getValue()); });
	 * add(group); }
	 * 
	 * public void MainView4() { Checkbox check = new Checkbox();
	 * check.setLabel("I agree terms"); check.addValueChangeListener(event -> {
	 * logger.info(check.getValue()); }); add(check); }
	 * 
	 * public void MainView3() { TextArea textArea = new TextArea();
	 * textArea.setLabel("Description"); textArea.
	 * setValue("This is going to be a very long text just for demonstration purpose..."
	 * ); textArea.setHeight("200px"); textArea.setWidth("200px");
	 * textArea.setMaxLength(10);
	 * textArea.setValueChangeMode(ValueChangeMode.EAGER);
	 * textArea.addValueChangeListener(event -> {
	 * logger.info("Something has been changed"); }); add(textArea);
	 * 
	 * }
	 * 
	 * public void MainView2() { add(new
	 * Label("Hello World from Vaddi and Spring Boot...")); add(new
	 * Text("This is a text in Vaadin...")); add(new
	 * Text("This is a another text in Vaadin...")); add(new
	 * Text("This is the last text in Vaadin..."));
	 * 
	 * Span span = new Span("This is a text in Vaadin..."); // we can use HTML and
	 * CSS related code to customize span.getElement().getStyle().set("font-size",
	 * "23px"); span.getElement().getStyle().set("font-weight", "bold");
	 * 
	 * TextField nameField = new TextField("Name: "); nameField.setMinLength(3);
	 * nameField.setMaxLength(10); nameField.addValueChangeListener(event -> {
	 * logger.info("Value has been changed ..."); }); Person person = new
	 * Person("John", 23); Binder<Person> binder = new Binder<>(Person.class);
	 * binder.bind(nameField, Person::getName, Person::setName);
	 * 
	 * Button button = new Button("Save", event -> { try { binder.writeBean(person);
	 * } catch (ValidationException e) { logger.error(e); }
	 * logger.info("Button was been clicked..."); Span span1 = new Span(new
	 * Date().toString()); add(span1); Span span2 = new Span(person.toString());
	 * add(span2); });
	 * 
	 * add(span); add(nameField); add(button); }
	 */
}
