package by.topolev.network.web.controller;

import java.io.IOException;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import by.topolev.network.service.ImageService;
import by.topolev.network.service.UserService;
import by.topolev.network.web.controller.form.ProfileForm;
import by.topolev.network.web.fasad.ProfileFacade;

@Controller
public class ProfileUserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileUserController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private ImageService imageService;
	@Autowired
	private ProfileFacade profileFasad;
	
	@RequestMapping(value="/user/profile", method = RequestMethod.GET)
	public ModelAndView showProfile(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("profile");
		ProfileForm profileForm = userService.showFieldUser();
		modelAndView.addObject("profileForm", profileForm);
		return modelAndView;
	}
	
	@RequestMapping(value="/user/profileUpdate", method = RequestMethod.POST)
	public String updateProfile(@ModelAttribute ProfileForm profileForm){
		profileFasad.updateUser(profileForm);
		return "redirect:/user/profile";
	}

	
	@RequestMapping(value="/user/photo", method = RequestMethod.GET)
	@ResponseBody
	public byte[] getImage(@RequestParam("fileName") String fileName){
		byte[] image = null;
		try {
			image = imageService.getImage(fileName);
		} catch (IOException e) {
			LOGGER.info(String.format("Can not get image with name \"%s\"",fileName));
		}
		return image;
	}
	
	@RequestMapping(value="/user/uploadPhoto", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> uploadPhoto(MultipartHttpServletRequest request){
		Iterator<String> itr =  request.getFileNames();
	    String fileNameImg = null;
	    ResponseEntity<String> response = null;
		try {
			fileNameImg = imageService.uploadPhoto(request.getFile(itr.next()));
		} catch (Exception e) {
			LOGGER.warn("Problem with upload image", e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(fileNameImg, HttpStatus.OK);
	}

	
	
	@RequestMapping(value="/user/cropPhoto",method = RequestMethod.GET)
	public @ResponseBody String cropPhoto(
			@RequestParam("fileName") String fileName,
			@RequestParam("x1") int x1,
			@RequestParam("y1") int y1,
			@RequestParam("width") int width,
			@RequestParam("height") int height,
			@RequestParam("widthScaleImg") int widthScaleImg
			){
		
		String fileCropName = null;
		try {
			fileCropName = imageService.cropPhoto(fileName, x1, y1, width, height, widthScaleImg);
		} catch (IOException e) {
			LOGGER.info("Unabe to crop image");
		}
		return fileCropName;
		
	}
}
