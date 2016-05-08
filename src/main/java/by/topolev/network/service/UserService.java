package by.topolev.network.service;

import by.topolev.network.domain.User;

public interface UserService {
	User create(User user, String nameRole);
	User getUserByUsernameOrEmail(String usernameOrEmail);
}
