package de.bankenit.asyncdemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class MyAsyncDemo {

	@Async
	public CompletableFuture<Integer> sinnDesLebens() {
		// Berechne
		return CompletableFuture.completedFuture(42);
	}
}
