package by.topolev.network.validatedata.form;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<Username, String>{

	@Override
	public void initialize(Username constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]+$");
		return pattern.matcher(value).matches();
	}

}
