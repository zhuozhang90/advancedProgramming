package edu.bu.cs622.concurrency;

import java.util.concurrent.Callable; 
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 

public class ExecutorEx { 
	public static void main(String[] args) {
		System.out.println("Inside : " + Thread.currentThread().getName()); 
		
		System.out.println("Creating Executor Service..."); 
		ExecutorService executorService = Executors.newSingleThreadExecutor(); 
		System.out.println("Creating a Runnable..."); 
		Runnable runnable = () -> { 
			System.out.println("Inside : " + Thread.currentThread().getName()); 
			}; 
		Callable callable = Executors.callable(runnable); 
		System.out.print("---Callable output:"+ callable.getClass().getSimpleName()); 
		System.out.println("Submit the task specified by the runnable to the executor service."); 
		executorService.submit(runnable); 
		executorService.shutdown();
	} 
}
