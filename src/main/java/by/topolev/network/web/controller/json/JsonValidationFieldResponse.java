package by.topolev.network.web.controller.json;

import java.util.ArrayList;
import java.util.List;

public class JsonValidationFieldResponse {
	private List<String> messages = new ArrayList<>();
	private Boolean valid = true;
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	public void addMessage(String message){
		messages.add(message);
	}
}
