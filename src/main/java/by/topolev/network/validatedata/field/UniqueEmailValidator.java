package by.topolev.network.validatedata.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.topolev.network.dao.UserDao;
import by.topolev.network.domain.User;

@Component
public class UniqueEmailValidator implements ValidatorField<String>{
	@Autowired
	private UserDao userDao;
	
	@Override
	public void validate(String arg) throws NotValidException {
		User user = userDao.findByEmail(arg);
		if (user != null) throw new NotValidException("Email is excited");
	}

}
