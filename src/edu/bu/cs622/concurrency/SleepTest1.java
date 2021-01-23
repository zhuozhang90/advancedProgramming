package edu.bu.cs622.concurrency;

public class SleepTest1 { 
	public static void main(String args[]) throws InterruptedException { 
		String importantInfo[] = { "msg 1", "msg 2", "msg 3", "msg 4" }; 
		for (int i = 0; i < importantInfo.length; i++) { 
			// Pause for 1 seconds 
			Thread.sleep(2000); 
			// Print a message 
			System.out.println(importantInfo[i]); 
		} 
	} 
}
