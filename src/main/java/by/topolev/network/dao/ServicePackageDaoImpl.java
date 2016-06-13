package by.topolev.network.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.topolev.network.domain.ServicePackage;
import by.topolev.network.domain.User;

@Repository(value="servicePackageDao")
@Transactional
public class ServicePackageDaoImpl extends GenericDaoImpl<ServicePackage, Long> implements ServicePackageDao{
	ServicePackageDaoImpl(){
		this(ServicePackage.class);
	}
	ServicePackageDaoImpl(Class<ServicePackage> type) {
		super(type);
	}
}
