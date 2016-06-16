package by.topolev.network.convertor;

import org.springframework.stereotype.Component;

import by.topolev.network.domain.ServicePackage;
import by.topolev.network.web.controller.form.ServicePackageForm;

@Component
public class ServicePackageFormConvertor implements Convertor<ServicePackage, ServicePackageForm>{

	@Override
	public ServicePackageForm convert(ServicePackage source) {
		ServicePackageForm result = new ServicePackageForm();
		result.setName(source.getName());
		result.setDescription(source.getDescription());
		result.setPermitions(source.getPermitions());
		result.setId(source.getId());
		return result;
	}

	@Override
	public ServicePackage reconvert(ServicePackageForm target) {
		// TODO Auto-generated method stub
		return null;
	}



}
