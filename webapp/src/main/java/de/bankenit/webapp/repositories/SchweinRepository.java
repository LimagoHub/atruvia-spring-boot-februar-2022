package de.bankenit.webapp.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import de.bankenit.webapp.repositories.entity.SchweinEntity;

public interface SchweinRepository extends CrudRepository<SchweinEntity, String> {

    @Query("update SchweinEntity s set s.gewicht=:gewicht")
    void neuesGewicht(int gewicht);
}
