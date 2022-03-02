package de.bankenit.dbdemo.repos;

import java.util.List;

import de.bankenit.dbdemo.repos.entities.Bar;

public interface BarCustomRepository {
	
	public List<Bar> tueWas();
	public long barCount();

}
