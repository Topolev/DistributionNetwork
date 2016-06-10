package by.topolev.network.validatedata.field;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class UsernameValidator implements ValidatorField<String>{

	@Override
	public void validate(String arg) throws NotValidException {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]+$");
		System.out.println(pattern.matcher(arg).matches());
		if (!pattern.matcher(arg).matches()) throw new NotValidException("Username must consist only latin simbols and simbol '_'");
	}

}