package by.topolev.network.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.topolev.network.domain.Permition;
import by.topolev.network.domain.User;
@Repository
@Transactional
public class PermitionDaoImpl extends GenericDaoImpl<Permition, Long> implements PermitionDao{

	PermitionDaoImpl(Class<Permition> type) {
		super(type);
	}
	PermitionDaoImpl(){
		this(Permition.class);
	}

}
