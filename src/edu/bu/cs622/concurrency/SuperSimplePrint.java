package edu.bu.cs622.concurrency;

public class SuperSimplePrint implements Runnable{ 
	@Override public void run() { 
		for (int i=0; i<10; i++) { 
			System.out.println("i is:"+i); 
			} 
		} 
public static void main(String[] args) { 
	Thread t = new Thread(new SuperSimplePrint()); 
	Thread t1 = new Thread(new SuperSimplePrint()); 
	t.start(); 
	t1.start(); 
	} 
}