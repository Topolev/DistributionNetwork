package by.topolev.network.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.topolev.network.dao.UserDao;
import by.topolev.network.domain.User;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String  showFormRegistration(ModelMap model){
		User user = new User();
		model.put("user", user);
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registrationUser(User user, BindingResult result){
		userDao.create(user);
		System.out.println(user.getUsername());
		return null;
	}
}
