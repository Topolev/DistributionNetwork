package by.topolev.network.web.controller.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import by.topolev.network.validatedata.form.UniqueEmail;
import by.topolev.network.validatedata.form.UniqueUsername;
import by.topolev.network.validatedata.form.Username;

public class SignupForm {
	
	@UniqueUsername
	@Username
	private String username;
	
	@NotEmpty
	@UniqueEmail
	@Email
	private String email;
	
	@NotEmpty
	private String password;
	public String getUsername() {
		return username;
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
