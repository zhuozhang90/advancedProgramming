package edu.bu.cs622.concurrency;

class Counter { 
	private int c = 0; 
	public void increment() { 
		System.out.println("Thread Id: " + Thread.currentThread().getId()); 
		c = c + 1; 
	} 
	
	public int getvalue() {return c;} 
	
}