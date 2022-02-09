package de.bankenit.webapp.services.model;

import java.time.LocalDateTime;

import de.bankenit.webapp.restcontrollers.dtos.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private String id;
	private String vorname;
	private String nachname;
	private LocalDateTime version;
}
