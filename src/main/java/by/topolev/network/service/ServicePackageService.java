package by.topolev.network.service;

import java.util.List;

import by.topolev.network.dao.ServicePackageDao;
import by.topolev.network.web.controller.form.ServicePackageForm;

public interface ServicePackageService {
	List<ServicePackageForm> findAllServicePackage();
	Boolean changeServicePackageForCurrentUser(Long idServicePackage);
	Boolean isFreeServicePackage(Long idServicePackage);
}
