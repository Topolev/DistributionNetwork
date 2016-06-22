package by.topolev.network.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.topolev.network.dao.UserDao;
import by.topolev.network.domain.User;

@Controller
public class SigninController {
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public String showFormSignin(ModelMap model){
		return "signin";
	}
	@RequestMapping(value="/signin-fail", method=RequestMethod.GET)
	public String showFormSigninFail(ModelMap model){
		model.put("error", true);
		return "signin";
	}
	@RequestMapping(value="/signin-success", method=RequestMethod.GET)
	public String authenticationSuccess(Authentication authentication){
		User user = userDao.findByUsername(authentication.getName());
		user.setLastSignin(new Date());
		userDao.update(user);
		System.out.println("SIGNIN SUCCESS");
		return "redirect:calculate";
	}
}
