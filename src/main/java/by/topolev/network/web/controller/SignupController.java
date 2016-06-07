package by.topolev.network.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.topolev.network.domain.User;
import by.topolev.network.service.UserService;

@Controller
public class SignupController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String  showFormRegistration(ModelMap model){
		User user = new User();
		model.put("user", user);
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String registrationUser(@Valid final User user, final BindingResult result){
		if (result.hasErrors()){
			System.out.println("error");
			return null;
		}
		userService.create(user,"ROLE_USER");
		
		/*Authenntication user after registration*/
		Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "calculate";
	}
}
