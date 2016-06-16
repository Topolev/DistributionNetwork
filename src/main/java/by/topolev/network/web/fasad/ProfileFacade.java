package by.topolev.network.web.fasad;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import by.topolev.network.web.controller.form.ProfileForm;

public interface ProfileFacade {

	void updateUser(ProfileForm profileForm);
}
