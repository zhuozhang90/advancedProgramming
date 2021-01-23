package edu.bu.cs622.concurrency;

import java.util.concurrent.locks.Lock; 
import java.util.concurrent.locks.ReentrantLock; 

public class PrintThread { 
	private final Lock queueLock = new ReentrantLock(); 
	public void print() { 
		queueLock.lock(); 
		try { 
			Long duration = (long) (Math.random() * 1000); 
			// Play with this duration to show lock changes 
			System.out.println(Thread.currentThread().getName() + " Time Taken " + (duration) + " milisecs."); 
			Thread.sleep(duration); 
		} catch (InterruptedException e) { 
			e.printStackTrace(); 
		} finally { 
			System.out.printf( "%s printed the document successfully.\n", Thread.currentThread().getName()); 
			queueLock.unlock(); 
		} 
	} 
}
