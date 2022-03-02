package de.bankenit.asyncdemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

	@Autowired
	private MyAsyncDemo demo;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hallo");
		
	
		Future<Integer> result = demo.sinnDesLebens();
		System.out.println(result.get());
	}
	

}
