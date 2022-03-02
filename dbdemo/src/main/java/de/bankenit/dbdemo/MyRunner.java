package de.bankenit.dbdemo;



import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import de.bankenit.dbdemo.repos.entities.Bar;
import de.bankenit.dbdemo.repos.entities.Barkeeper;
import lombok.AllArgsConstructor;


@Component
@AllArgsConstructor
public class MyRunner implements CommandLineRunner {
	
	//private final DbDemo demo;

	private final BarDemo demo;
	
	@Override
	public void run(String... args) throws Exception {
		
////		PersonEntity fritz = demo.save();
////		
////		// fritz ist persistent, detached
////		fritz.setVorname("Erika");
//		
//		PersonEntity p = demo.findDemo();
//		System.out.println(p);
//		System.out.println(p.getKontakte());
//		//demo.renameAll();
		
		//demo.newBarKeeper();
		//demo.newBar();
		//demo.populateBarWithKeeper();
		//demo.updateJim();
		//demo.removeJim();
		
		List<Bar> bars = demo.findAll();
		System.out.println(bars.size());
		for(Bar b : bars) {
			for(Barkeeper k : b.getKeepers()) {
				System.out.println(k.getKeeperName());
			}
		}
		
	}

}
