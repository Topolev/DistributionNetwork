package by.topolev.network.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import by.topolev.network.domain.Role;
import by.topolev.network.domain.User;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		User user = userService.getUserByUsernameOrEmail(usernameOrEmail);
		Set<GrantedAuthority> roles = getGrantedAuthorityByString(user);
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(
				user.getUsername(), 
                user.getPassword(), 
                roles);
		return userDetails;
	}
	
	public static Set<GrantedAuthority> getGrantedAuthorityByString(User user){
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for(Role role : user.getRoles()){
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return roles;
	}

}
