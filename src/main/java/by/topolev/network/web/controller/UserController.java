package by.topolev.network.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.topolev.network.domain.User;
import by.topolev.network.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String  showFormRegistration(ModelMap model){
		User user = new User();
		model.put("user", user);
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registrationUser(@Valid final User user, final BindingResult result){
		if (result.hasErrors()){
			System.out.println("error");
			return null;
		}
		userService.create(user,"USER");
		return "index";
	}
}
