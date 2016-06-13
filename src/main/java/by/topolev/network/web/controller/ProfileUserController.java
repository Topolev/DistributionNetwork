package by.topolev.network.web.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import by.topolev.network.config.ConfigClass;
import by.topolev.network.service.UserService;
import by.topolev.network.web.controller.form.ProfileForm;
import by.topolev.network.web.fasad.ProfileFasad;

@Controller
public class ProfileUserController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProfileFasad profileFasad;
	
	@RequestMapping(value="/user/profile", method = RequestMethod.GET)
	public ModelAndView showProfile(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("profile");
		ProfileForm profileForm = userService.showFieldUser();
		modelAndView.addObject("profile", profileForm);
		return modelAndView;
	}
	@RequestMapping(value="/user/profile")
	public ModelAndView saveProfile(){
		return null;
	}
	
	@RequestMapping(value="/user/photo", method = RequestMethod.GET)
	@ResponseBody
	public byte[] getImage(@RequestParam("fileName") String fileName){
		byte[] image = null;
		try {
			image = profileFasad.getImage(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	@RequestMapping(value="/user/uploadPhoto", method=RequestMethod.POST)
	public @ResponseBody String uploadPhoto(MultipartHttpServletRequest request){
		Iterator<String> itr =  request.getFileNames();
	    String fileNameImg = null;
		try {
			fileNameImg = profileFasad.uploadPhoto(request.getFile(itr.next()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileNameImg;
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
			fileCropName = profileFasad.cropPhoto(fileName, x1, y1, width, height, widthScaleImg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileCropName;
		
	}
}
