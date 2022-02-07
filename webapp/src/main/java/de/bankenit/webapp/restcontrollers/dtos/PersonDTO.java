package de.bankenit.webapp.restcontrollers.dtos;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class PersonDTO {
	
	private String id;
	private String vorname;
	private String nachname;

}
