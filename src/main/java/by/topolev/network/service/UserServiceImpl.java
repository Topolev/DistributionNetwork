package by.topolev.network.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.Service;

import by.topolev.network.dao.RoleDao;
import by.topolev.network.dao.UserDao;
import by.topolev.network.domain.Role;
import by.topolev.network.domain.User;

@Service

public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public User create(User user, String nameRole) {
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		Role role = roleDao.findByRole(nameRole);
		user.setRole(role);
		return userDao.create(user);
	}

	@Override
	public User getUserByUsernameOrEmail(String usernameOrEmail) {
		User user = userDao.findByUsernameOrEmail(usernameOrEmail);
		return user;
	}

}
