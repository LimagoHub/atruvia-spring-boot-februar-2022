package de.bankenit.dbdemo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import de.bankenit.dbdemo.repos.entities.Bar;

public interface BarRepository extends CrudRepository<Bar, String>, BarCustomRepository {

	@Query("select distinct b from Bar b left join fetch b.keepers k ")
	List<Bar> findBarsWithBarkeepers() ;
}
