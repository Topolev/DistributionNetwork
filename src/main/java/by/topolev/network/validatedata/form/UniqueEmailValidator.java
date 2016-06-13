package by.topolev.network.validatedata.form;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import by.topolev.network.dao.UserDao;
import by.topolev.network.domain.User;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail,	String> {
	
	@Resource
	private UserDao userDao;
	
	@Override
	public void initialize(UniqueEmail constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		User user = userDao.findByEmail(value);
		if (user != null) {
			System.out.println("Email is excited");
			return false;
		}
		else {
			System.out.println("Email unique");
			return true;
		}
	}

}
