package de.bankenit.dbdemo.repos;

import org.springframework.data.repository.CrudRepository;

import de.bankenit.dbdemo.repos.entities.PersonEntity;

public interface PersonenRepository extends CrudRepository<PersonEntity, String>{

}
