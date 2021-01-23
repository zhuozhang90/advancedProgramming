package edu.bu.cs622.hw7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomGenome {
	
	/**
	 * generates 100 random genome sequences that's 10 char long
	 */
	public static void bruteForceGenerator() {
		// given 4 chars to randomly choose from
		List<String> chars = Arrays.asList("A", "T", "G", "C");
	    Random rand = new Random();
	    for (int i = 0; i < 100; i++) {
	    	// construct 100 random strings
	    	List<String> sequence = new ArrayList<>();
	    	for (int j = 0; j < 100; j++) {
	    		// randomly get a char from given array
	 		    String nextChar = chars.get(rand.nextInt(chars.size()));
	 		    sequence.add(nextChar);
	    	}
//	    	System.out.println(String.join("", sequence)); // make strings
	    }
	}
	
	/**
	 * nested class for concurrency
	 * generate 100 genome sequences with 10 threads
	 */
	public static class ConcurrentGenerator implements Runnable {
		
		// implement the threads for generating genomes
		@Override
		public void run() {
			// given 4 chars to randomly choose from
			List<String> chars = Arrays.asList("A", "T", "G", "C");
		    Random rand = new Random();
		    for (int i = 0; i < 20; i++) {
		    	// construct 20 random strings for each thread
		    	List<String> sequence = new ArrayList<>();
		    	for (int j = 0; j < 10; j++) {
		    		// randomly get a char from given array
		 		    String nextChar = chars.get(rand.nextInt(chars.size()));
		 		    sequence.add(nextChar);
		    	}
//		    	System.out.println(String.join("", sequence)); // make strings
		    }
		}
	}

	public static void main(String[] args) throws InterruptedException {
		
		// calculate time in nanosecs with brute force
		long startTime = System.nanoTime();
		bruteForceGenerator();
		long endTime = System.nanoTime();
		 
	    long durationInNano = (endTime - startTime);  //Total execution time in nano seconds
	    
	    System.out.println("brute force execution time: " + durationInNano);
		
		// calculate time in nanosecs with concurrency
		List<Thread> threads = new ArrayList<>(); // create a list of threads to reduce overhead
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(new ConcurrentGenerator()); 
			threads.add(t); // to keep track of all threads
		}
		
		long startTime1 = System.nanoTime();
		// start and join all threads to wait for all to finish
		for (Thread t : threads) {
			t.start();
			t.join();
		}
		
		long endTime1 = System.nanoTime();
		
		long durationInNano1 = (endTime1 - startTime1);  //Total execution time in nano seconds
	    
	    System.out.println("concurrent execution time: " + durationInNano1);
		
	}

}
