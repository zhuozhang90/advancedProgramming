package edu.bu.cs622.concurrency;

public class TestThread { 
	public static void main(String args[]) { 
		PrintThread PD = new PrintThread(); 
		MyThread t1 = new MyThread("Thread - 1 ", PD); 
		MyThread t2 = new MyThread("Thread - 2 ", PD); 
		MyThread t3 = new MyThread("Thread - 3 ", PD); 
		MyThread t4 = new MyThread("Thread - 4 ", PD); 
		t1.start(); t2.start(); t3.start(); t4.start(); 
	} 
}