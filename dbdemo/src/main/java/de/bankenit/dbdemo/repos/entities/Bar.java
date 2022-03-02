package de.bankenit.dbdemo.repos.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.mapping.Collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tbl_bars")
public class Bar extends BaseEntity{
	
	private String barname;

	@Builder.Default
	@ToString.Exclude
	@OneToMany(cascade  = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH, CascadeType.REMOVE}, mappedBy = "bar")
	private List<Barkeeper> keepers = new ArrayList<>();
	
	public List<Barkeeper> getKeepers() {
		return Collections.unmodifiableList(keepers);
	}
	
	public void addBarkeeper(Barkeeper barkeeper) {
		barkeeper.setBar(this);
		keepers.add(barkeeper);
	}
	
	public void removeBarkeeper(Barkeeper barkeeper) {
		
		keepers.remove(barkeeper);
		//barkeeper.setBar(null);
	}
	
	

}	
