package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import service.DepartmentService;

public class DepartmentListController implements Initializable {
	
	private DepartmentService service;
	
	@FXML
	private TableView<Department> tableViewDepartment;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Department, String> tableColumnName;
	
	@FXML
	private Button btNew;
	
	@FXML //atributo serve para carregar os departamentos, pois sao armazenados nessa lista
	private ObservableList<Department> obsList;
	
	@FXML
	public void onBtNewAction() {
		System.out.println("onBtNewAction");
	}
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializeNodes();
	}

//	padrao do javaFX iniciar o comportamento das colunas
	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		//Busca a Janela Inicial
		Stage stage = (Stage) Main.getMainScene().getWindow();
		//Acompanha a janela 
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
		
	}
	
//	Responsavel por acessar o servico carregar os departamentos e adicionar os departamento em obsList
	public void updateTableView() {
		if(service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Department> list = service.findAll();
		//instancia o observableList, adicionando a lista de departamento.
		obsList = FXCollections.observableArrayList(list);
		//carrega os itens (department) na tableView
		tableViewDepartment.setItems(obsList);
	}
	
	

}
