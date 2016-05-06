package by.topolev.network.dao;

import by.topolev.network.domain.Role;

public interface RoleDao extends GenericDao<Role, Long>{
	Role findByRole(String role);
}
