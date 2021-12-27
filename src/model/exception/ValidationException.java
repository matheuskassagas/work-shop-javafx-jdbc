package model.exception;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	
	//carrega uma colecao de errors, contendo todos os erros possiveis
	private Map<String, String> errors = new HashMap<>();
	
	public ValidationException (String msg) {
		super(msg);
	}
	
	public Map<String, String> getErrors(){
		return errors;
	}
	
	public void addError(String fieldName, String errorMessage) {
		errors.put(fieldName, errorMessage);
	}

}
