package by.topolev.network.dao;

import by.topolev.network.domain.UrlImage;

public interface UrlImageDao extends GenericDao<UrlImage, Long>{
	public UrlImage findByUrl(String urlImage);
}
