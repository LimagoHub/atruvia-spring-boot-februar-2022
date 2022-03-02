package de.bankenit.dbdemo;

import java.util.UUID;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import de.bankenit.dbdemo.repos.entities.PersonEntity;
import lombok.AllArgsConstructor;

@Component
//@Transactional(propagation = Propagation.REQUIRED)
@AllArgsConstructor
public class JpaDemo {

	private final EntityManager em;
	
	public void save( ) {
		
		em.getTransaction().begin();
		PersonEntity p = PersonEntity
				.builder()
				.id(UUID.randomUUID().toString())
				.vorname("Max")
				.nachname("M")
				
				.build();
		em.persist(p);
		em.getTransaction().commit();
	}
	
}
