package de.bankenit.webapp.restcontrollers.dtos;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchweinDTO {

	@NotNull
	@Size(min = 36, max=36)
	private String id;
	
	@NotNull
	@Size(min = 2, max=30)
	private String name;
	
	@NotNull
	@DecimalMin("10")
	private int gewicht;

}
