package by.topolev.network.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.topolev.network.domain.UrlImage;
import by.topolev.network.domain.User;
@Repository
@Transactional
public class UrlImageDaoImpl extends GenericDaoImpl<UrlImage, Long> implements UrlImageDao {

	UrlImageDaoImpl(Class<UrlImage> type) {
		super(type);
	}
	UrlImageDaoImpl(){
		this(UrlImage.class);
	}
	@Override
	public UrlImage findByUrl(String url) {
		TypedQuery<UrlImage> query = em.createQuery("select url from UrlImage url where url.urlImage=:urlImage", UrlImage.class);
		
		UrlImage urlImage;
		try{
			urlImage = query.setParameter("urlImage", url).getSingleResult();
		} catch (NoResultException e){
			return null;
		}
		return urlImage;
	}

}

