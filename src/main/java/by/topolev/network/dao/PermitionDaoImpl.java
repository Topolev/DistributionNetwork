package by.topolev.network.dao;

import by.topolev.network.domain.Permition;
import by.topolev.network.domain.User;

public class PermitionDaoImpl extends GenericDaoImpl<Permition, Long> implements PermitionDao{

	PermitionDaoImpl(Class<Permition> type) {
		super(type);
	}
	PermitionDaoImpl(){
		this(Permition.class);
	}

}
