package by.topolev.network.convertor;

import org.springframework.stereotype.Component;

import by.topolev.network.domain.User;
import by.topolev.network.web.controller.form.ProfileForm;
@Component
public class ProfileFormConvertor implements Convertor<User, ProfileForm>{

	@Override
	public ProfileForm convert(User source) {
		if (source == null){
			return null;
		}
		ProfileForm target = new ProfileForm();
		target.setFirstname(source.getFirstname());
		target.setLastname(source.getLastname());
		target.setNameOrganization(source.getNameOrganization());
		target.setUsername(source.getUsername());
		target.setUrlAvatar(source.getUrlAvatar());
		return target;
	}

	@Override
	public User reconvert(ProfileForm target) {
		
		return null;
	}

}
