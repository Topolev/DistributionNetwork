package by.topolev.network.web.controller;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.topolev.network.service.ServicePackageService;
import by.topolev.network.web.controller.form.ServicePackageForm;

@Controller
public class ServicePackageController {
	
	private final static Long DEFAULT_ID_SERVICE_PACKAGE = 1l;
	@Autowired
	private ServicePackageService servicePackageService;
	
	@RequestMapping(value="/user/servicePackages", method=RequestMethod.GET)
	public ModelAndView showServicePackage(){
		List<ServicePackageForm> servicePackages;
		servicePackages = servicePackageService.findAllServicePackage();
		ModelAndView model = new ModelAndView();
		model.setViewName("servicePackage");
		model.addObject("servicePackages", servicePackages);
		model.addObject("activeServicePackage", DEFAULT_ID_SERVICE_PACKAGE);
		return model;
	}
	
	@RequestMapping(value="/user/servicePackages/change", method=RequestMethod.GET)
	public String changeServicePackage(@RequestParam Long idServicePackage){
		System.out.println(idServicePackage);
		if (servicePackageService.isFreeServicePackage(idServicePackage)){
			if (servicePackageService.changeServicePackageForCurrentUser(idServicePackage)){
				return "redirect:/calculate";
			} else{
				return "redirect:/signin";
			}
		} else {
			return "redirect:/notSupportFunctionality";
		}
	}
	@RequestMapping(value="/user/servicePackages/show")
	public String showServicePackageForUser(){
		return null;
	}
}
