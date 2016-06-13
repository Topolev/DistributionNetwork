package by.topolev.network.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.topolev.network.domain.User;



@Repository(value="userDao")
@Transactional
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao{

	UserDaoImpl(){
		this(User.class);
	}
	UserDaoImpl(Class<User> type) {
		super(type);
	}
	@Override
	public User findByUsername(String username) {
		TypedQuery<User> query = em.createQuery("select u from User u where u.username=:username", User.class);
		User user;
		try{
			user = query.setParameter("username", username).getSingleResult();
		} catch (NoResultException e){
			return null;
		}
		return user;
	}
	
	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createQuery("select u from User u where u.email=:email", User.class);
		User user;
		try{
			user = query.setParameter("email", email).getSingleResult();
		} catch (NoResultException e){
			return null;
		}
			return user;
	}
	
	@Override
	public User findByUsernameOrEmail(String usernameOrEmail) {
		TypedQuery<User> query = em.createQuery("select u from User u where u.username=:username or u.email=:email", User.class);
		User user;
		try{
			user = query.setParameter("username", usernameOrEmail).setParameter("email", usernameOrEmail).getSingleResult();
		}catch (NoResultException e){
			return null;
		}
			return user;
	}

	

}
