package by.topolev.network.convertor;

import org.springframework.stereotype.Component;

import com.sun.xml.internal.ws.developer.UsesJAXBContext;

import by.topolev.network.domain.User;
import by.topolev.network.web.controller.form.SignupForm;
@Component
public class UserSignupFormConvertor implements Convertor<User, SignupForm>{

	@Override
	public SignupForm convert(User source) {
		SignupForm result = new SignupForm();
		result.setUsername(source.getUsername());
		result.setEmail(source.getEmail());
		result.setPassword(source.getPassword());
		return result;
	}

	@Override
	public User reconvert(SignupForm target) {
		User user = new User();
		user.setUsername(target.getUsername());
		user.setEmail(target.getEmail());
		user.setPassword(target.getPassword());
		return user;
	}

}
