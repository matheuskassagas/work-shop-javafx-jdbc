package util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Utils {
	
	//Recebe um evento (click) e retorna um stagem uma janela 
	public static Stage currentStage (ActionEvent event) {
		return (Stage) ((Node) event.getSource()).getScene().getWindow();
	}

}