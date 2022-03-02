package de.bankenit.dbdemo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import de.bankenit.dbdemo.repos.BarRepository;
import de.bankenit.dbdemo.repos.BarkeeperRepository;
import de.bankenit.dbdemo.repos.entities.Bar;
import de.bankenit.dbdemo.repos.entities.Barkeeper;
import lombok.AllArgsConstructor;

@Component
@Transactional(propagation = Propagation.REQUIRED)
@AllArgsConstructor
public class BarDemo {

	private final BarRepository barRepository;
	private final BarkeeperRepository barkeeperRepository;
	
	
	public void newBarKeeper() {
//		Bar bar = Bar.builder().id(UUID.randomUUID().toString()).barname("Sonderbar").build();
//		
//		Barkeeper jonny = new Barkeeper(UUID.randomUUID().toString(), bar, "Jonny");
//		
//		var retval = barkeeperRepository.save(jonny);
//		
//		retval.getBar().setBarname("Sonderbar");
	}
	
	public void newBar() {
		Bar bar = Bar.builder().id(UUID.randomUUID().toString()).barname("Abschraubbar").build();
		
		Barkeeper jonny = Barkeeper.builder().id(UUID.randomUUID().toString()).keeperName("Jonny").build();
		
		bar.addBarkeeper(jonny);
		
		barRepository.save(bar);
	}
	
	public void populateBarWithKeeper() {
		final String id = "9cffdaa6-264e-4fb5-be16-27458311d388";
		Optional<Bar> optionalBar = barRepository.findById(id);
		if(optionalBar.isPresent()) {
			Bar bar = optionalBar.get();
			Barkeeper fred = Barkeeper.builder().id(UUID.randomUUID().toString()).keeperName("Fred").build();
			Barkeeper jim = Barkeeper.builder().id(UUID.randomUUID().toString()).keeperName("Jim").build();
			Barkeeper anne = Barkeeper.builder().id(UUID.randomUUID().toString()).keeperName("Anne").build();
			bar.addBarkeeper(fred);
			bar.addBarkeeper(jim);
			bar.addBarkeeper(anne);
		}
	}
	
	public void updateJim() {
		final String id = "9cffdaa6-264e-4fb5-be16-27458311d388";
		Optional<Bar> optionalBar = barRepository.findById(id);
		if(optionalBar.isPresent()) {
			Bar bar = optionalBar.get();
			bar.getKeepers().get(1).setKeeperName("Jimmy");
		}
	}
	
	public void removeJim() {
		
		System.out.println(barRepository.tueWas());
		
		final String id = "9cffdaa6-264e-4fb5-be16-27458311d388";
		Optional<Bar> optionalBar = barRepository.findById(id);
		if(optionalBar.isPresent()) {
			Bar bar = optionalBar.get();
			Barkeeper jim = bar.getKeepers().get(1);
			bar.removeBarkeeper(jim);
		}
	}
	
	public List<Bar> findAll() {
		System.out.println(barRepository.tueWas());
		//return Streamable.of(barRepository.findAll()).stream().collect(Collectors.toList());
		return barRepository.findBarsWithBarkeepers();
	}

}
