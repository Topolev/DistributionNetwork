package by.topolev.network.web.fasad;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.topolev.network.config.ConfigClass;
import by.topolev.network.convertor.Convertor;
import by.topolev.network.dao.UrlImageDao;
import by.topolev.network.domain.UrlImage;
import by.topolev.network.domain.User;
import by.topolev.network.service.ImageService;
import by.topolev.network.service.UserService;
import by.topolev.network.web.controller.form.ProfileForm;

@Component
public class ProfileFasadImpl implements ProfileFacade {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileFasadImpl.class);

	private String directorySaveImage = ConfigClass.DEFAULT_PATH_RESOURCES + "upload/";

	@Autowired
	private UserService userService;

	

	@Autowired
	private ImageService imageService;
	
	@Resource(name = "profileFormConvertor")
	private Convertor convertor;

	@Override
	public void updateUser(ProfileForm profileForm) {
		User user = userService.getAuthorizedUser();
		if (user != null) {
			LOGGER.debug(String.format("User with id=%d is updating personal data", user.getId()));
			String oldUrlImage = user.getUrlAvatar();
			user.setLastname(profileForm.getLastname());
			user.setUrlAvatar(profileForm.getUrlAvatar());
			user.setNameOrganization(profileForm.getNameOrganization());
			try {
				userService.updateUser(user);
			} catch (Exception e) {
				LOGGER.warn(String.format("User with id=%d hasn't update data", user.getId()), e);
			}
			LOGGER.debug(String.format("User with id=%d has updated personal data successfully", user.getId()));
		} else {
			LOGGER.warn("Cannot update user profile, because user is not authorized.");
		}
	}

}
