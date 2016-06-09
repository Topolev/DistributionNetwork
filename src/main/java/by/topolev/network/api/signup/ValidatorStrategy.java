package by.topolev.network.api.signup;

import java.util.List;

public interface ValidatorStrategy {
	List<Validator> find (String type) throws NotSupportTypeValidator;
}
