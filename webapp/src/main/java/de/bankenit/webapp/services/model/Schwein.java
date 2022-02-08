package de.bankenit.webapp.services.model;

import javax.persistence.Column;
import javax.persistence.Id;

import de.bankenit.webapp.repositories.entity.SchweinEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Schwein {

	@Setter( AccessLevel.PRIVATE)
	private String id;
	
	
	private String name;
	
	@Setter( AccessLevel.PRIVATE)
	private int gewicht;
	
	public void fressen() {
		setGewicht(getGewicht() + 1);
	}

}
