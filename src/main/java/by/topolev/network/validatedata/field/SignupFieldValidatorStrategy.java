package by.topolev.network.validatedata.field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
@Component
public class SignupFieldValidatorStrategy implements ValidatorFieldStrategy {

	private List<ValidatorField> emailValidators;
	
	@Resource
	private EmailValidator emailValidator;
	@Resource
	private UniqueEmailValidator uniqueEmailValidator;
	@Resource
	private UsernameValidator usernameValidator;
	@Resource
	private UniqueUsernameValidator uniqueUsernameValidator;
	@Resource
	private PasswordValidator passwordValidator;

	@Override
	public List<ValidatorField> find(String type) throws NotSupportTypeValidator {
		ArrayList<ValidatorField> arrayList = new ArrayList<>();
		if (type.equals("email")) {
			arrayList.addAll(Arrays.asList(emailValidator,uniqueEmailValidator));
			return arrayList;
		} 
		if (type.equals("username")) {
			arrayList.addAll(Arrays.asList(usernameValidator, uniqueUsernameValidator));
			return arrayList;
		}
		if (type.equals("password")) {
			arrayList.addAll(Arrays.asList(passwordValidator));
			return arrayList;
		}
		throw new NotSupportTypeValidator();
	}

}
