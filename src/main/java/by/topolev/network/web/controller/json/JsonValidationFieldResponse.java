package by.topolev.network.web.controller.json;

import java.util.ArrayList;
import java.util.List;

public class JsonValidationFieldResponse {
	private List<ErrorMessage> errorMessages = new ArrayList<>();
	private Boolean valid = true;
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public List<ErrorMessage> getMessages() {
		return errorMessages;
	}
	public void setMessages(List<ErrorMessage> errorMessages) {
		this.errorMessages = errorMessages;
	}
	public void addErrorMessage(ErrorMessage errorMessage){
		errorMessages.add(errorMessage);
	}
}
