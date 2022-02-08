package de.bankenit.webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import de.bankenit.webapp.repositories.entity.PersonEntity;

public interface PersonenRepository extends CrudRepository<PersonEntity, String> {

}
