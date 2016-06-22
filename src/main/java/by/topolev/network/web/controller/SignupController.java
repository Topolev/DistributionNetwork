package by.topolev.network.web.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import by.topolev.network.convertor.Convertor;
import by.topolev.network.domain.User;
import by.topolev.network.service.UserService;
import by.topolev.network.validatedata.field.NotSupportTypeValidator;
import by.topolev.network.validatedata.field.NotValidException;
import by.topolev.network.validatedata.field.ValidatorField;
import by.topolev.network.validatedata.field.ValidatorFieldStrategy;
import by.topolev.network.web.controller.form.SignupForm;
import by.topolev.network.web.controller.json.ErrorMessage;
import by.topolev.network.web.controller.json.JsonValidationFieldRequest;
import by.topolev.network.web.controller.json.JsonValidationFieldResponse;

@Controller
public class SignupController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ValidatorFieldStrategy validatorFieldStrategy;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Resource(name="userSignupFormConvertor")
	private Convertor convertor;
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String  showFormRegistration(ModelMap model){
		SignupForm signupForm = new SignupForm();
		model.put("signupForm", signupForm);
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String registrationUser(@Valid SignupForm signupForm, final BindingResult result){
		
		if (result.hasErrors()){
			return "signup";
		}
		
		User user =(User)convertor.reconvert(signupForm);
		user.setDateCreateUser(new Date());
		user.setLastSignin(new Date());
		userService.create(user,"ROLE_USER");
		
		/*Authenntication user after registration*/
		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
		Authentication authentication = new UsernamePasswordAuthenticationToken(
				userDetails,
				user.getPassword(),
				userDetails.getAuthorities()
				);
		/*Authentication authentication = new UsernamePasswordAuthenticationToken(userDetailsService.loadUserByUsername(user.getUsername()), user.getPassword());*/
		System.out.println(authentication.getName());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return "redirect:user/servicePackages";
	}
	
	
	
	@RequestMapping(value="signup/validateField", method =RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> validateField(@RequestBody JsonValidationFieldRequest jsonRequest){
		String type = jsonRequest.getType();
		String value = jsonRequest.getValue();
		JsonValidationFieldResponse jsonResponse = new JsonValidationFieldResponse();
		try {
			List<ValidatorField> validatorFields = validatorFieldStrategy.find(type);
			for (ValidatorField validatorField : validatorFields){
				try {
					validatorField.validate(value);
				} catch (NotValidException e) {
					jsonResponse.setValid(false);
					ErrorMessage errorMessage = new ErrorMessage();
					errorMessage.setNameField(type);
					errorMessage.setMessage(e.getMessage());
					jsonResponse.addErrorMessage(errorMessage);
				}
			}
			ResponseEntity<JsonValidationFieldResponse> response = new ResponseEntity<JsonValidationFieldResponse>(jsonResponse, HttpStatus.OK);
			return response;
		} catch (NotSupportTypeValidator e) {
			return new ResponseEntity<String>(String.format("The validation for field '%s' is not supported.", jsonRequest.getType()), HttpStatus.BAD_REQUEST);
		}
	}	
}
