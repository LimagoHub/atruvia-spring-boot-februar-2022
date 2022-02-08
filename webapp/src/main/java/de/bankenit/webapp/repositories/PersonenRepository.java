package de.bankenit.webapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import de.bankenit.webapp.repositories.entity.PersonEntity;
import de.bankenit.webapp.repositories.entity.TinyPerson;

public interface PersonenRepository extends CrudRepository<PersonEntity, String> {
	
	
	Iterable<PersonEntity> findByVorname(String vorname);

	@Query("update PersonEntity set vorname=:vorname where id=:id")
	void updateVorname(String id, String vorname);
	
	@Query("select new de.bankenit.webapp.repositories.entity.TinyPerson(p.id, p.nachname) from PersonEntity p")
	Iterable<TinyPerson> findAllTinyPersons();
}
