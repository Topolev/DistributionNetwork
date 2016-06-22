package by.topolev.network.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import by.topolev.network.convertor.Convertor;
import by.topolev.network.dao.RoleDao;
import by.topolev.network.dao.UserDao;
import by.topolev.network.domain.Role;
import by.topolev.network.domain.User;
import by.topolev.network.web.controller.form.ProfileForm;

@Service

public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Resource(name="profileFormConvertor")
	private Convertor profileFormConvertor;
	
	private final static long TIME_IDENTITY_USER_NOT_SIGNIN_LONG = 60*60*1000; 
	
	public List<User> findUserNotSigninLong(){
		List<User> list;
		return null;
	}
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
	
	@Override
	public void updateUser(User user){
		userDao.update(user);
	}
	
	@Override
	public User getAuthorizedUser(){
		String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = getUserByUsernameOrEmail(currentUsername);
		return user;
	}
	
	@Override
	public ProfileForm showFieldUser(){
		User user = getAuthorizedUser();
		return (ProfileForm) profileFormConvertor.convert(user);
	}
	
	

}
