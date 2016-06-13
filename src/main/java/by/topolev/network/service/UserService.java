package by.topolev.network.service;

import by.topolev.network.domain.User;
import by.topolev.network.web.controller.form.ProfileForm;

public interface UserService {
	User create(User user, String nameRole);
	User getUserByUsernameOrEmail(String usernameOrEmail);
	void updateUser(User user);
	User getAuthorizedUser();
	ProfileForm showFieldUser();
	
	
}
