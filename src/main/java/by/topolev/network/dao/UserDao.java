package by.topolev.network.dao;

import by.topolev.network.domain.User;

public interface UserDao extends GenericDao <User, Long>{
	public User findByUsername(String username);
}
