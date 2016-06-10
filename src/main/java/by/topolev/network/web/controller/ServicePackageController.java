package by.topolev.network.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServicePackageController {
	
	@RequestMapping(value="user/servicePackages", method=RequestMethod.GET)
	public String showServicePackage(){
		return "";
	}
}
