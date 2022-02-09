package de.bankenit.webapp.repositories.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tbl_personen")
public class PersonEntity {
	
	@Id
	@Column(length = 36, nullable = false)
	private String id;
	
	@Column(length = 30, nullable = false)
	private String vorname;
	
	@Column(length = 30, nullable = false)
	private String nachname;
	
	@Version
	private LocalDateTime version;
}
