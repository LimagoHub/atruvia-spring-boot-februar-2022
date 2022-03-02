package de.bankenit.asyncdemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hallo");
		
		ExecutorService service = Executors.newCachedThreadPool();
//		service.execute(new MyWorker());
//		service.execute(this::doIt);
		Future<Integer> f1 = service.submit(new MyOtherWorker());
		Future<Integer> f2 = service.submit(new MyOtherWorker());
		service.shutdown();
		
		System.out.println(f1.get());
		System.out.println(f2.get());
		
//		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

		System.out.println("Done");
	}
	private void doIt() {
		try {
			Thread.sleep(1000);
			
			System.out.println(Thread.currentThread().getId() + " Fertig");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
 	
	class MyWorker implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
				
				System.out.println(Thread.currentThread().getId() + " Fertig");
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
	
	class MyOtherWorker implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			int result = (int)(Math.random() * 2000);
			try {
				Thread.sleep(result);
				
				System.out.println(Thread.currentThread().getId() + " Sinn des lebens ist berechnet");
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			return result;
		}
		
	}

}
