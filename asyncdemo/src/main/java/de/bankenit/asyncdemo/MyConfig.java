package de.bankenit.asyncdemo;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class MyConfig {
	
	@Bean(name ="demo")
	public Executor create() {
		return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}

}
