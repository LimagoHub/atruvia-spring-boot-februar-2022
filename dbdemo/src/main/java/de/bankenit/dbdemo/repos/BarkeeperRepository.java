package de.bankenit.dbdemo.repos;

import org.springframework.data.repository.CrudRepository;

import de.bankenit.dbdemo.repos.entities.Barkeeper;

public interface BarkeeperRepository extends CrudRepository<Barkeeper, String>{

}
