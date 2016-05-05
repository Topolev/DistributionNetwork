package by.topolev.network.convertor;

import java.util.Collection;

import by.topolev.network.data.UserData;
import by.topolev.network.domain.User;

public class UserConvertor implements Convertor<User, UserData> {
	private Collection<Convertor<User, UserData>> convertors;

	@Override
	public void convert(User source, UserData target) {
		target.setId(source.getId());
		target.setEmail(source.getEmail());
		for (Convertor<User, UserData> convertor : convertors) {
			convertor.convert(source, target);
		}

	}

}
