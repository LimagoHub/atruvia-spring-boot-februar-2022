package de.bankenit.dbdemo.repos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.bankenit.dbdemo.repos.entities.Bar;

@Repository
public class BarCustomRepositoryImpl implements BarCustomRepository {

	@Autowired
	private EntityManager em;
	
	@Override
	public List<Bar> tueWas() {
		
		TypedQuery<Bar> query = em.createQuery("select b from Bar b", Bar.class);
		//query.setParameter("barname", "Sonder%");
		query.setFirstResult(10);
		query.setMaxResults(3);
		List<Bar> result = query.getResultList();
		
		return result;
		
	}

	@Override
	public long barCount() {
		TypedQuery<Long> query = em.createQuery("select count(b) from Bar b", Long.class);
		return query.getSingleResult();
	}

}
