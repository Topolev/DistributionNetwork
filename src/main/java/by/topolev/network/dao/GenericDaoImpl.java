package by.topolev.network.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED)
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
	@PersistenceContext
	protected EntityManager em;
	protected Class<T> type;

	GenericDaoImpl(Class<T> type) {
		this.type = type;
	};

	@Override
	public T create(T persistance) {
		em.persist(persistance);
		em.flush();
		return persistance;
	}

	@Override
	public T update(T persistance) {
		return em.merge(persistance);
	}

	@Override
	public Boolean delete(T pesistance) {

		em.remove(pesistance);

		return true;
	}

	@Override
	public T findById(Long id) {
		return em.find(type, id);
	}

	@Override
	public List<T> findAll() {
		System.out.println(type.getSimpleName());
		return em.createQuery("select c from " + type.getSimpleName() + " c").getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
