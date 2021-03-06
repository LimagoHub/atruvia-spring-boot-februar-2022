package de.bankenit.webapp.restcontrollers.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
	
	
	@NotNull
	@Size(min = 36, max=36)
	private String id;
	
	@NotNull
	@Size(min = 2, max=30)
	private String vorname;
	
	@NotNull
	@Size(min = 2, max=30)
	private String nachname;
	
	
}
