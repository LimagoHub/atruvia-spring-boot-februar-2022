package de.bankenit.dbdemo.repos.entities;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor


@MappedSuperclass
public class BaseEntity {
	@Id
	private String id;
	
	@Version
	private long version;
}
