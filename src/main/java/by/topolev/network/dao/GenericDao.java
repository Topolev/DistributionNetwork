package by.topolev.network.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

public interface GenericDao<T, PK extends Serializable> {
	public T create(T persistance);
	public T update(T persistance);
	public Boolean delete(T pesistance);
	public T findById(Long id);
	public List<T> findAll();
}
