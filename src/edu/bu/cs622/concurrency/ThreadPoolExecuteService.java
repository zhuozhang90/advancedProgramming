package edu.bu.cs622.concurrency;

import java.util.concurrent.*; 
public class ThreadPoolExecuteService { 
	public static void main(String[] args) throws InterruptedException { 
		Counter sharedcounter = new Counter(); 
		ExecutorService ex = Executors.newCachedThreadPool(); 
		ex.execute(new First(1, sharedcounter)); 
		ex.execute(new First(2, sharedcounter)); 
		ex.execute(new First(3, sharedcounter)); 
		ex.shutdown(); // ex.awaitTermination(50, TimeUnit.MILLISECONDS); 
		
		while (!ex.isTerminated()) System.out.println("Final count = " + sharedcounter.getvalue()); 
	}
}