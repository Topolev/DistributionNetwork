package by.topolev.network.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import by.topolev.network.convertor.Convertor;
import by.topolev.network.dao.PermitionDao;
import by.topolev.network.dao.ServicePackageDao;
import by.topolev.network.domain.Permition;
import by.topolev.network.domain.ServicePackage;
import by.topolev.network.domain.User;
import by.topolev.network.web.controller.form.ServicePackageForm;
@Service
public class ServicePackageServiceImpl implements ServicePackageService{
	@Autowired
	private ServicePackageDao servicePackageDao;
	

	
	@Autowired
	private UserService userService;
	
	@Resource(name="servicePackageFormConvertor")
	private Convertor convertor;
	
	
	
	@Override
	public List<ServicePackageForm> findAllServicePackage(){
		List<ServicePackage> servicePackages = servicePackageDao.findAll();
		List<ServicePackageForm> packagesForm = new ArrayList<>();
		for (ServicePackage servicePackage : servicePackages){
			packagesForm.add((ServicePackageForm)convertor.convert(servicePackage));
		}
		return packagesForm;
	}
	
	@Override
	public Boolean changeServicePackageForCurrentUser(Long idServicePackage){
		String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.getUserByUsernameOrEmail(currentUsername);
		if (user != null){
			ServicePackage servicePackage = servicePackageDao.findById(idServicePackage);
			if (servicePackage != null) {
				user.setServicePackage(servicePackage);
				userService.updateUser(user);
				return true;
			} 
			return false;
		}
		return false;
	}
	
	@Override
	public Boolean isFreeServicePackage(Long idServicePackage){
		if (idServicePackage == 1) return true;
		return false;
	}
	

}
