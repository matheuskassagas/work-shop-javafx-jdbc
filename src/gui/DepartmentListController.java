package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import entity.Department;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DepartmentListController implements Initializable {
	
	@FXML
	private TableView<Department> tableViewDepartment;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Department, String> tableColumnName;
	
	@FXML
	private Button btNew;
	
	@FXML
	public void onBtNewAction() {
		System.out.println("onBtNewAction");
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
	
	

}
