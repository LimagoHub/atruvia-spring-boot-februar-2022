package de.bankenit.webapp;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile("production")
@Component
public class B implements XYZ {

	@PostConstruct
	@Override
	public void foo() {
		System.out.println("Hier ist B");

	}

}
