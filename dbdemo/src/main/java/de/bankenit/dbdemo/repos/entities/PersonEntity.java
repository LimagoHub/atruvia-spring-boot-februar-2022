package de.bankenit.dbdemo.repos.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	private int version;
	
	@Builder.Default
	@ElementCollection(fetch = FetchType.EAGER)
	@ToString.Exclude
	List<Kontakt> kontakte = new ArrayList<>();
	
}
