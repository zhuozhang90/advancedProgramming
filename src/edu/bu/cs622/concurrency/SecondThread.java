package edu.bu.cs622.concurrency;

public class SecondThread implements Runnable{ 
	@Override public void run() { 
		for (int j =0; j<100 ; j++) { 
			System.out.println("-from SecondThread: j:"+j); 
			} 
		} 
	}