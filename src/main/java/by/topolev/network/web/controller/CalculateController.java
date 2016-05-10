package by.topolev.network.web.controller;

import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class CalculateController {
	@RequestMapping(value="/calculate", method=RequestMethod.GET)
	public String showFormInputData(){
		return "calculate";
	}
	
	
	/*The tutorial see in http://blog.netgloo.com/2015/02/08/spring-boot-file-upload-with-ajax/*/
	@RequestMapping(value="/calculate/download", method = RequestMethod.POST)
	public @ResponseBody String downloadCatalog(@RequestParam("file") MultipartFile file){
		System.out.println("DOWNLOAD");
		System.out.println(file.getOriginalFilename());
		return null;
	}
}
