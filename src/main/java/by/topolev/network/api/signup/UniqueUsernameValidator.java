package by.topolev.network.api.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import by.topolev.network.dao.UserDao;
import by.topolev.network.domain.User;

@Component
public class UniqueUsernameValidator implements Validator<String>{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void validate(String arg) throws NotValidException {
		User user = userDao.findByUsername(arg);
		if (user != null) throw new NotValidException("Username is excited");
	}

}
