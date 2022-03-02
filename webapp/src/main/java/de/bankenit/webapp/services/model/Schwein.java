package de.bankenit.webapp.services.model;

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
	
	@Setter( AccessLevel.PRIVATE)
	private String name;
	
	@Setter( AccessLevel.PRIVATE)
	private int gewicht;
	
	public void fressen() {
		setGewicht(getGewicht() + 1);
	}

	public void taufen(String neuerName) {
		if("Elsa".equalsIgnoreCase(neuerName)) throw new IllegalArgumentException("Hä?");
		setName(neuerName);
	}

}
