package by.topolev.network.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import by.topolev.network.api.signup.NotSupportTypeValidator;
import by.topolev.network.api.signup.NotValidException;
import by.topolev.network.api.signup.Validator;
import by.topolev.network.api.signup.ValidatorStrategy;
import by.topolev.network.domain.User;
import by.topolev.network.service.UserService;
import by.topolev.network.web.controller.json.JsonValidateFieldRequest;
import by.topolev.network.web.controller.json.JsonValidationFieldResponse;

@Controller
public class SignupController {
	@Autowired
	private UserService userService;
	
	@Resource(name="signupValidatorStrategy")
	private ValidatorStrategy validatorStrategy;
	
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
	
	@RequestMapping(value="signup/validate", method =RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> validateField(@RequestBody JsonValidateFieldRequest jsonRequest){
		String type = jsonRequest.getType();
		String value = jsonRequest.getValue();
		JsonValidationFieldResponse jsonResponse = new JsonValidationFieldResponse();
		try {
			List<Validator> validators = validatorStrategy.find(type);
			for (Validator validator : validators){
				try {
					validator.validate(value);
				} catch (NotValidException e) {
					jsonResponse.setValid(false);
					jsonResponse.addMessage(e.getMessage());
				}
			}
			ResponseEntity<JsonValidationFieldResponse> response = new ResponseEntity<JsonValidationFieldResponse>(jsonResponse, HttpStatus.OK);
			return response;
		} catch (NotSupportTypeValidator e) {
			return new ResponseEntity<String>(String.format("The validation for field '%s' is not supported.", jsonRequest.getType()), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	public Boolean isExciteUsernameOrEmail(String usernameOrEmail){
		try{
			User user = userService.getUserByUsernameOrEmail(usernameOrEmail);
		} catch(EmptyResultDataAccessException x){
			return false;
		}
		return true;
	}
	

	
	@ResponseBody
	@RequestMapping(value="/signup/validUsername", method=RequestMethod.GET)
	public String validUsername(@RequestParam("usernameOrEmail") String usernameOrEmail){
		return isExciteUsernameOrEmail(usernameOrEmail).toString();	
	}
}
