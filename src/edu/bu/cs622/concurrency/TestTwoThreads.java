package edu.bu.cs622.concurrency;

public class TestTwoThreads { 
	public static void main(String[] args) { 
		FirstThread firstT = new FirstThread(); 
		Thread a = new Thread(firstT); 
		SecondThread secondT = new SecondThread(); 
		Thread b = new Thread(secondT); 
		a.start(); 
		b.start(); 
		} 
	}