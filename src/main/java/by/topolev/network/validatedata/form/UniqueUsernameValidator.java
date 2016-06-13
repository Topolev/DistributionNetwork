package by.topolev.network.validatedata.form;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import by.topolev.network.dao.UserDao;
import by.topolev.network.domain.User;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	@Resource
	private UserDao userDao;

	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		User user = userDao.findByUsername(value);
		
		if (user != null) {
			System.out.println("User is excited");
			return false;
		}
		else {
			System.out.println("User unique");
			return true;
		}
	}

}
