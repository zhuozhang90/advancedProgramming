package edu.bu.cs622.concurrency;

public class MyThread extends Thread{ 
	PrintThread printT; 
	MyThread(String name, PrintThread pt){ 
		super(name); 
		this.printT = pt; 
	} 
	@Override 
	public void run() { 
		System.out.printf( "%s starts printing a document\n", Thread.currentThread().getName()); 
		printT.print(); 
	} 
}
