package edu.bu.cs622.concurrency;

public class TestThreadJoin { 
	public static void main(String[] args) throws InterruptedException { 
		Thread t1 = new Thread() { 
			public void run() { 
				for (int j=0 ; j<20; j++) { 
					System.out.println("t1"); 
					} 
				} 
			}; 
		Thread t2 = new Thread() { 
			public void run() { 
				for (int j=0 ; j<20; j++) { 
					System.out.println("t2"); 
					} 
				} 
			}; 
		t1.start(); 
		t1.join();

		t2.start(); // Lets comment and uncomment t2.join and see the differences. 

		t2.join(1000); 
		System.out.println("End"); 
	}
}